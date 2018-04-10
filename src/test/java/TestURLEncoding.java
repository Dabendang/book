import org.junit.Test;

/**
 * @author qyw
 * @create 2017-07-06 12:11
 **/
public class TestURLEncoding {


    @Test
    public  void test1()throws Exception{
        String testStr="邱勇伟";
        System.out.println(  URLUtil.getURLEncoderString(testStr));
        System.out.println(URLUtil.getURLDecoderString(testStr));
    }
}
