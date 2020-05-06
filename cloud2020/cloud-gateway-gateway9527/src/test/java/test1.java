import java.time.ZonedDateTime;

/**
 * @Auther: wdq
 * @Date: 2020/5/6 12:55
 * @Description:
 */
public class test1 {
    public static void main(String[] args) {
        //得到当前时区的时间
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        //2020-05-06T12:56:26.330+08:00[Asia/Shanghai]
    }
}
