package demo.jdbcTest;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JdbcTemplateTest {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtilsByDruid.getDataSource());

    @Test
    public void testBase(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtilsByDruid.getDataSource());
        String sql = "update account set balance = 5000 where id = ?";
        int count = template.update(sql, 3);
        Assert.assertEquals(1,count);
        System.out.println(count);
    }

    @Test
    public void testUpdate(){
        /**
         * 1. 修改1号数据的 salary 为 10000
         */
        String sql = "update emp set salary = 10000 where id = 1001";
        int count = template.update(sql);
        Assert.assertEquals(1,count);
        System.out.println(count);
    }

    @Test
    public void testInsert(){
        /**
         * 2. 添加一条记录
         */
        String sql = "insert into emp(id,ename,dept_id) values(?,?,?)";
        int count = template.update(sql, 1015, "tom", 10);
        System.out.println(count);
    }

    @Test
    public void testDelete(){
        /**
         * 3.删除刚才添加的记录
         */
        String sql = "delete from emp where id = ?";
        int count = template.update(sql, 1015);
        System.out.println(count);
    }

    @Test
    public void testOneToMap(){
        /**
         * 4.查询id为1001的记录，将其封装为Map集合
         * 注意：这个方法查询的结果集长度只能是1
         */
        String sql = "select * from emp where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        //String sql = "select * from emp where id = ? or id = ?";
        //Map<String, Object> map = template.queryForMap(sql, 1001,1002);
        System.out.println(map);
        //{id=1001, ename=孙悟空, job_id=4, mgr=1004, joindate=2000-12-17, salary=10000.00, bonus=null, dept_id=20}
    }

    @Test
    public void testAllToList(){
        /**
         * 5. 查询所有记录，将其封装为List
         */
        String sql = "select * from emp";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
        Assert.assertEquals(14,list.size());
        System.out.println(list.size());
    }

    @Test
    public void testAllToBean1(){
        /**
         * 6. 查询所有记录，将其封装为Emp对象的List集合，不用这种方法，用下面的那种
         */
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp();
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                return emp;
            }
        });
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    @Test
    public void testAllToBean2(){
        /**
         * 6. 查询所有记录，将其封装为Emp对象的List集合
         */
        String sql = "select * from emp";
        //这里因为我们的数据中有空值的情况，转换为Bean后，null不能作为基本数据类型的默认值
        // org.springframework.beans.TypeMismatchException: Failed to convert property value of type 'null'
        // to required type 'double' for property 'bonus';
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    @Test
    public void testCount(){
        /**
         * 7. 查询总记录数
         */
        String sql = "select count(id) from emp";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }

}
