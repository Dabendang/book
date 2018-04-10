import java.io.UnsupportedEncodingException;
/**
 * url转码、解码
 *
 * @author qyw
 * @date 2015-3-17 下午04:09:35
 */
public class URLUtil {
    private final static String ENCODE = "UTF-8";
    /**
     * URL 解码
     *
     * @return String
     * @author qyw
     * @date 2015-3-17 下午04:09:51
     */
    public static String getURLDecoderString(String str) {
        String result = "";
        if (null == str) {
            return result;
        }
        try {
            result = java.net.URLDecoder.decode(str, ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * URL 转码
     *
     * @return String
     * @author qyw
     * @date 2015-3-17 下午04:10:28
     */
    public static String getURLEncoderString(String str) {
        String result = "";
        if (null == str) {
            return result;
        }
        try {
            result = java.net.URLEncoder.encode(str, ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) {
        String str = "测试1";
        System.out.println("%E5%BC%A0%E4%BC%9F");
        System.out.println(getURLEncoderString(str));
        System.out.println(getURLDecoderString(str));

    }

}