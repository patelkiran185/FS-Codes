/*
Write a program that takes an IP address and subnet mask (in CIDR notation, 
e.g., 192.168.1.1/24) as input and calculates the network and broadcast addresses.

Input Format:
---------------
A String, IPAddress
An integer, CIDR

Output Format:
---------------
Space separated IP addresses, network IP and broadcast IP.


Sample Input-1:
-----------------
192.168.1.10
24

Sample Output-1:
------------------
192.168.1.0 192.168.1.255


Sample Input-2:
-----------------
192.0.2.1
24

Sample Output-2:
------------------
192.0.2.0 192.0.2.255

*/


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Subnet2 {
    
    public static int cidrToSubnetMask(int cidr) {
        return (0xFFFFFFFF << (32 - cidr));
    }

    public static int ipToUint32(String ip) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName(ip);
        byte[] bytes = inetAddress.getAddress();
        int result = 0;
        for (byte b : bytes) {
            result = (result << 8) | (b & 0xFF);
        }
        return result;
    }
    public static String uint32ToIp(int ip) throws UnknownHostException {
        return InetAddress.getByAddress(new byte[] {
            (byte) (ip >> 24 & 0xFF),
            (byte) (ip >> 16 & 0xFF),
            (byte) (ip >> 8 & 0xFF),
            (byte) (ip & 0xFF)
        }).getHostAddress();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String ipStr = scanner.next();
    
        int cidr = scanner.nextInt();

        try {
            int ip = ipToUint32(ipStr);
            int subnetMask = cidrToSubnetMask(cidr);
            int networkIp = ip & subnetMask;
            int broadcastIp = networkIp | ~subnetMask;

            String networkIpStr = uint32ToIp(networkIp);
            String broadcastIpStr = uint32ToIp(broadcastIp);

            System.out.println(networkIpStr);
            System.out.println(broadcastIpStr);
        } catch (UnknownHostException e) {
            System.err.println("Invalid IP address");
        }

        scanner.close();
    }
}