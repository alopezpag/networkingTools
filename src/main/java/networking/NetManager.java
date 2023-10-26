package networking;

import java.util.*;
import java.net.*;

public class NetManager {
    public List<String> getIPAddresses() throws SocketException {
        List<String> ipAddresses = new ArrayList<>();
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface iface = interfaces.nextElement();
            Enumeration<InetAddress> addresses = iface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress addr = addresses.nextElement();
                if (addr instanceof Inet4Address && !addr.isLoopbackAddress()) {
                    ipAddresses.add(addr.getHostAddress());
                }
            }
        }
        return ipAddresses;
    }
}
