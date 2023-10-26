
import networking.NetScanner;

import java.net.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SocketException {
        NetScanner scanner = new NetScanner();
        List<String> ipAddresses = scanner.getIPAddresses();
        System.out.println("IP addresses on your network:");
        for (String ipAddress : ipAddresses) {
            System.out.println("    " + ipAddress);
        }
    }
}