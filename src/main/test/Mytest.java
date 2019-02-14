import com.test.MyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.junit.Test;
/**
 * @author N
 * @create 2019/2/14 -- 14:09
 * @email 554197854@qq.com
 */

public class Mytest {
    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Object person = context.getBean("person");
        System.out.println(person);
    }
}
