package com.lvxiao.mysql.sharding;

import lombok.SneakyThrows;
import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlShardingDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author lvxiao
 * @date 2020/4/23
 */
public class TestShading {

    @SneakyThrows
    public static void main(String[] args) {
        String filePath = TestShading.class.getResource("/sharding.yaml").getFile();
        DataSource dataSource = YamlShardingDataSourceFactory.createDataSource(new File(filePath));
        String sql = "SELECT i.* FROM t_order o JOIN t_order_item i ON o.order_id=i.order_id WHERE o.user_id=? AND o.order_id=?";
        String test = "INSERT INTO t_order VALUES(?, ?, 'init');";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(test)) {
            preparedStatement.setInt(1, 1101);
            preparedStatement.setInt(2, 11);
            preparedStatement.executeUpdate();
        }
    }
}
