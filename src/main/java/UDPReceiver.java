import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Project name(项目名称)：UDP实现通信
 * Package(包名): PACKAGE_NAME
 * Class(类名): UDPReceiver
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/18
 * Time(创建时间)： 18:50
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class UDPReceiver implements Runnable
{
    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                byte[] buffer = new byte[1024 * 8];
                DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);
                datagramSocket.receive(datagramPacket);
                String message = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                System.out.println(msg + ":" + message);
                if (message.equals("再见"))
                {
                    break;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        datagramSocket.close();
    }

    DatagramSocket datagramSocket = null;
    private int port;
    private String msg;

    public UDPReceiver(int port, String msg)
    {
        this.port = port;
        this.msg = msg;
        try
        {
            datagramSocket = new DatagramSocket(port);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
