package kafka;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.TopicPartition;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author lvxiao
 * @date 2019/5/6
 */
@Log4j2
public class KafkaTest {

    private static String topic = "demo1";

    private Producer<String, String> producer;

    private Consumer<String, String> consumer;

    @Before
    public void init() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "35.220.148.221:9092");
                /*ack 配置项用来控制producer要求leader确认多少消息后返回调用成功。
        当值为0时producer不需要等待任何确认消息。
        当值为1时只需要等待leader确认。
        当值为-1或all时需要全部ISR集合返回确认才可以返回成功。
        */
        properties.put("acks", "all");
        //当 retries > 0 时，如果发送失败，会自动尝试重新发送数据。发送次数为retries设置的值。
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<>(properties);
    }

    @Test
    public void Produce() {
        for (int i = 0; i < 10; i++) {
            String msg = "这是消息" + i;
            //send方法是异步的。当它被调用时，它会将消息记录添加到待发送缓冲区并立即返回。
            //使用这种方式可以使生产者聚集一批消息记录后一起发送，从而提高效率。
            Future<RecordMetadata> future = producer.send(new ProducerRecord<String, String>(topic, msg));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                log.info(i + "的offsert是" + future.get().offset());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void consumerAutoCommit() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "35.220.148.221:9092");
        properties.put("group.id", "group-1");
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("auto.offset.reset", "earliest");
        properties.put("session.timeout.ms", "30000");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList(topic));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {
                log.error("offset = %d, value = %s", record.offset(), record.value());
            }
        }
    }

    @Test
    public void consumerManualCommit() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "35.220.148.221:9092");
        properties.put("group.id", "group-1");
        properties.put("enable.auto.commit", "false");
        properties.put("session.timeout.ms", "30000");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList(topic));
        final int minBatchSize = 200;
        List<ConsumerRecord<String, String>> buffer = new ArrayList<>();
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10));
            for (ConsumerRecord<String, String> record : records) {
                buffer.add(record);
            }
            if (buffer.size() >= minBatchSize) {
                insertIntoDb(buffer);
                ConsumerRecord<String, String> record = buffer.get(buffer.size() - 1);
                consumer.commitSync(Collections.singletonMap(new TopicPartition(record.topic(), record.partition()), new OffsetAndMetadata(record.offset() + 1)));
                buffer.clear();
            }
        }
    }

    private void insertIntoDb(List<ConsumerRecord<String, String>> buffer) {
        for (ConsumerRecord<String, String> record : buffer) {
            log.error("插入数据库:offset ={}, key = {}, value = {}", record.offset(), record.key(), record.value());
        }
    }
}
