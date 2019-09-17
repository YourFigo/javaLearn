package demo.test;
import demo.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    @Before
    public void init(){
        System.out.println("init ... ");
    }

    @After
    public void close(){
        System.out.println("close ... ");
    }

    @Test
    public void testAdd(){
        System.out.println("testAdd");
        Calculator c = new Calculator();
        int result = c.add(1,2);
        Assert.assertEquals(3,result);
    }

    @Test
    public void testSub(){
        System.out.println("testSub");
        Calculator c = new Calculator();
        int result = c.sub(5,3);
        Assert.assertEquals(2,result);
    }

}
