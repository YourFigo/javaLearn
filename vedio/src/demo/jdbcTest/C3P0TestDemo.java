package demo.jdbcTest;

import org.junit.Test;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0TestDemo {
    @Test
    public void testDefault() throws SQLException {
        DataSource ds1 = new ComboPooledDataSource();
        //默认配置中我们设置了 maxPoolSize 为10，因此可以取10个连接
        for (int i = 1; i <= 10 ; i++) {
            Connection conn = ds1.getConnection();
            System.out.println(conn);
        }
    }
    @Test
    public void testOther() throws SQLException {
        DataSource ds1 = new ComboPooledDataSource("other");
        //other的配置中我们设置了 maxPoolSize 为8，因此可以取10个连接会出错
        for (int i = 1; i <= 10 ; i++) {
            Connection conn = ds1.getConnection();
            System.out.println(conn);
        }
    }
}
