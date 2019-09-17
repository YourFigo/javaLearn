package demo.jdbcTest;

import org.junit.Test;
import org.junit.Assert;

import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DruidTestDemo {
    @Test
    public void testDruid() throws Exception {
        //加载配置文件
        Properties pro = new Properties();
        //通过类类加载器来获取 druid.properties，并通过 getResourceAsStream() 将该配置文件以输入流的方式获取
        InputStream is = DruidTestDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        //获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }

    @Test
    public void testJDBCUtilsByDruid(){
        /**
         * 实现 通过Druid数据库连接池获取的连接对象给account表添加一条记录
         */
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = JDBCUtilsByDruid.getConnection();
            String sql = "insert into account values(null,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,"wangwu");
            pstm.setDouble(2,3000);
            int count = pstm.executeUpdate();
            System.out.println(count);
            Assert.assertEquals(1,count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtilsByDruid.close(pstm,conn);
        }
    }
}
