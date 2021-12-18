import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Project name(项目名称)：UDP实现通信
 * Package(包名): PACKAGE_NAME
 * Class(类名): UDPSender
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/18
 * Time(创建时间)： 18:50
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class UDPSender implements Runnable
{

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                String message = bufferedReader.readLine();
                byte[] buffer = message.getBytes();
                InetAddress inetAddress = InetAddress.getByName(ip);
                DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length,inetAddress,port);
                datagramSocket.send(datagramPacket);
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
        try
        {
            datagramSocket.close();
            bufferedReader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    DatagramSocket datagramSocket = null;
    BufferedReader bufferedReader = null;
    private String ip;
    private int port;

    public UDPSender(String ip, int port)
    {
        this.ip = ip;
        this.port = port;
        try
        {
            datagramSocket = new DatagramSocket();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }
}
