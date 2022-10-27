import com.linxx.recommend.recommendOnlineApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: Linxx
 * @Package: test.java
 * @Time: 2022-10-27 16:45
 * @Description: TODO
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {recommendOnlineApplication.class})
public class recommendOnlineApplicationTest {

    Logger logger = LoggerFactory.getLogger(recommendOnlineApplicationTest.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
        DataSource dataSource = (DataSource)applicationContext.getBean("dataSource");
        logger.info(dataSource.toString());
        System.out.println(dataSource.toString());
        try {
            Connection connection = dataSource.getConnection();
            int holdability = connection.getHoldability();
            System.out.println(holdability);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
