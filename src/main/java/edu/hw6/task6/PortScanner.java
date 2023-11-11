package edu.hw6.task6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

public class PortScanner {
    private static final int MIN_PORT = 0;
    private static final int MAX_PORT = 49151;
    private static final String LOCAL_HOST = "localhost";

    private PortScanner() {
    }

    private static final String[] KNOWN_PORTS = {
        "135: EPMAP",
        "137: NetBIOS Name Service",
        "138: NetBIOS Datagram Service",
        "139: NetBIOS Session Service",
        "445: Microsoft-DS Active Directory",
        "843: Adobe Flash",
        "1900: Simple Service Discovery Protocol (SSDP)",
        "3702: Dynamic Host Configuration Protocol (DHCP)",
        "5040: Reserved",
        "5050: Multicast DNS (mDNS)",
        "5353: Link-Local Multicast Name Resolution (LLMNR)",
        "5355: Link-Local Multicast Name Resolution (LLMNR)",
        "5939: TeamViewer",
        "6463: Discord",
        "6942: Unreal Tournament",
        "17500: Dropbox LAN Sync",
        "27017: MongoDB",
        "42420: Signal"
    };

    public static Map<String, String> scanOccupiedPort() {
        Map<String, String> map = new HashMap<>();
        for (int port = MIN_PORT; port <= MAX_PORT; port++) {
            try {
                ServerSocket serverSocket = new ServerSocket(port, 1, InetAddress.getByName(LOCAL_HOST));
                serverSocket.close();
            } catch (IOException e) {
                String serviceName = getServiceName(port);
                map.put("TCP " + port, serviceName);
            }

            try {
                DatagramSocket datagramSocket = new DatagramSocket(port, InetAddress.getByName(LOCAL_HOST));
                datagramSocket.close();
            } catch (IOException e) {
                String serviceName = getServiceName(port);
                map.put("UDP " + port, serviceName);
            }
        }
        return map;
    }

    private static String getServiceName(int port) {
        for (String knownPort : KNOWN_PORTS) {
            String[] parts = knownPort.split(": ");
            int knownPortNumber = Integer.parseInt(parts[0]);
            if (knownPortNumber == port) {
                return parts[1];
            }
        }
        return "Occupied";
    }
}
