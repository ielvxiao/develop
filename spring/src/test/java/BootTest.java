import com.lvxiao.spring.boot.SpringBootDemo;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hongqi
 * @date 2021/12/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDemo.class)
public class BootTest {

    @Autowired
    ApplicationContext context;


    @Test
    public void testImport() {
        assertThatBeanExists("testString", String.class);
    }

    private void assertThatBeanExists(String beanName, Class<?> beanClass) {
        Assertions.assertTrue(context.containsBean(beanName));
        Assertions.assertNotNull(context.getBean(beanClass));
    }
}
