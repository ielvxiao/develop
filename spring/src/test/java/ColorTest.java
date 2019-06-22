import com.lvxiao.spring.aware.AwareBean;
import com.lvxiao.spring.config.AwareConfig;
import com.lvxiao.spring.config.ColorConfig;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**¡
 * @author lvxiao
 * @version V1.0
 * @date 2019-06-02 12:16
 */
@Log4j2
public class ColorTest {

    private AnnotationConfigApplicationContext context;

    @Test
    public void test1() {
        context = new AnnotationConfigApplicationContext(ColorConfig.class);
        Object o = context.getBean("color");
        log.error(o.getClass());
        context.close();
    }

    @Test
    public void testAware() {
        context = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareBean bean = context.getBean(AwareBean.class);
        bean.run();
        context.close();
    }
}
