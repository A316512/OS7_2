import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class OS72 {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();

                if (!networkInterface.isUp() || networkInterface.isLoopback() || networkInterface.isVirtual()) {
                    continue;
                }

                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();

                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    System.out.println("Interface: " + networkInterface.getDisplayName());
                    System.out.println("IP Address: " + inetAddress.getHostAddress());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
