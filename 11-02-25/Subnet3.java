/*
Given two IP addresses IP1 and IP2, and a subnet mask, your task is to check 
whether IP-1 and IP-2 belongs to same host range or not.

Input Format:
---------------
Two space separated strings, IP1 and IP2.
An integer, CIDR (subnet mask).

Output Format:
---------------
A boolean result.


Sample Input-1:
-----------------
192.168.1.10 192.168.1.20
24

Sample Output-1:
------------------
true


Sample Input-2:
-----------------
192.0.2.1 192.0.3.253
24

Sample Output-2:
------------------
false


*/


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Subnet3 {
    // Function to convert CIDR to subnet mask
    public static int cidrToSubnetMask(int cidr) {
        return (0xFFFFFFFF << (32 - cidr));
    }

    // Function to convert IP address string to int
    public static int ipToUint32(String ip) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName(ip);
        byte[] bytes = inetAddress.getAddress();
        int result = 0;
        for (byte b : bytes) {
            result = (result << 8) | (b & 0xFF);
        }
        return result;
    }

    // Function to check if two IP addresses belong to the same subnet
    public static boolean sameSubnet(String ip1, String ip2, int cidr) throws UnknownHostException {
        int subnetMask = cidrToSubnetMask(cidr);
        int ip1Uint = ipToUint32(ip1);
        int ip2Uint = ipToUint32(ip2);
        int networkIp1 = ip1Uint & subnetMask;
        int networkIp2 = ip2Uint & subnetMask;
        return networkIp1 == networkIp2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter IP1: ");
        String ip1 = scanner.next();
        System.out.print("Enter IP2: ");
        String ip2 = scanner.next();
        System.out.print("Enter CIDR notation: ");
        int cidr = scanner.nextInt();

        try {
            boolean result = sameSubnet(ip1, ip2, cidr);
            System.out.println(result ? "true" : "false");
        } catch (UnknownHostException e) {
            System.err.println("Invalid IP address");
        }

        scanner.close();
    }
}