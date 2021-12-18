/**
 * Project name(项目名称)：UDP实现通信
 * Package(包名): PACKAGE_NAME
 * Class(类名): Teacher
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/18
 * Time(创建时间)： 19:08
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Teacher
{
    public static void main(String[] args)
    {
        new Thread(new UDPSender("127.0.0.1", 7777)).start();
        new Thread(new UDPReceiver(8888, "学生")).start();
    }
}
