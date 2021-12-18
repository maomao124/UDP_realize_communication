/**
 * Project name(项目名称)：UDP实现通信
 * Package(包名): PACKAGE_NAME
 * Class(类名): Student
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/18
 * Time(创建时间)： 19:07
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Student
{
    public static void main(String[] args)
    {
        new Thread(new UDPSender("127.0.0.1", 8888)).start();
        new Thread(new UDPReceiver(7777, "老师")).start();
    }
}
