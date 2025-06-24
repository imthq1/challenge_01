import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MyBigNumberTest {

    @Test   
    public void testSumNormal() {
        MyBigNumber test = new MyBigNumber();
        String result = test.sum("1234", "897");
        assertEquals("2131", result);
    }

}
