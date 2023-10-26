package networking;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NetScanner {
    private Scanner scanner;
    private InetAddress localhost;

    public NetScanner() {
        this.scanner = new Scanner(System.in);
        try {
            this.localhost = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            System.out.println("no localhost found.");
        }
    }

    public void scanNetwork() {
        System.out.println("Escribe 'netscan -a' para escanear la red:");
        String command = scanner.nextLine();

        if (command.equals("netscan -a")) {
            try {
                byte[] ip = localhost.getAddress();

                for (int i = 1; i <= 254; i++) {
                    ip[3] = (byte) i;
                    InetAddress address = InetAddress.getByAddress(ip);
                    if (address.isReachable(1000)) {
                        System.out.println(address + " está en la red");
                    }
                }
            } catch (Exception ex) {
                System.out.println("Ocurrió un error: " + ex.getMessage());
            }
        } else {
            System.out.println("Comando desconocido");
        }
    }

    public static void main(String[] args) {
        NetScanner netScanner = new NetScanner();
        netScanner.scanNetwork();
    }
}