package Jun20;

import java.util.Arrays;

public class CheckIP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(validIPAddress("172.16.254.1"));
		System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
		System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
		System.out.println(validIPAddress("1.1.1.1."));
		System.out.println(validIPAddress("2001:0db8:85a3:01:-0:8A2E:0370:7334"));


	}

	static String validIPAddress(String IP) {
		if (checkIpV4(IP))
			return "IPv4";
		if (checkIpV6(IP))
			return "IPv6";
		else
			return "Neither";
	}

	static boolean checkIpV4(String IP) {
		try {
			if(IP.contains("-")) return false;

			if (IP.lastIndexOf(".") == IP.length() - 1)
				return false;
			if (IP.indexOf(".") == IP.length() - 1)
				return false;
			String[] str = IP.split("[.]");

			if (str.length != 4)
				return false;

			for (String string : str) {
				Integer i = Integer.parseInt(string);
				if (i > 255 || i < 0) {
					return false;
				}
				if (i < 10 && string.length() > 1) {
					return false;
				}
				if (i < 100 && string.length() > 2) {
					return false;
				}
				if (i < 255 && string.length() > 3) {
					return false;
				}
				continue;
			}

			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	static boolean checkIpV6(String IP) {
		try {
			if(IP.contains("-")) return false;

			if (IP.lastIndexOf(":") == IP.length() - 1)
				return false;
			if (IP.indexOf(":") == IP.length() - 1)
				return false;
			String[] str = IP.split(":");

			if (str.length != 8)
				return false;

			for (String string : str) {
				int num = Integer.parseInt(string, 16);
				if (num < 0)
					return false;
			}
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

}
