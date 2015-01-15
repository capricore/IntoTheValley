package String;

import java.util.ArrayList;

public class RestoreIPAddress {
	public ArrayList<String> restoreIPAddress(String s)
	{
		ArrayList<String> res = new ArrayList<String>();
		String ip = "";
		parseIPAddress(s, 0, 0, ip, res);
		return res;
	}
	
	public void parseIPAddress(String s, int start, int part, String ip, ArrayList<String> res)
	{
		if ((s.length() - start) > (4 - part)*3) {
			return;
		}
		
		if ((s.length() - start) < (4 - part)) {
			return;
		}
		
		if (s.length() == start && part == 4) {
			res.add(ip);
			return;
		}
		int num = 0;
		for (int i = start; i < Math.min(start + 3, s.length()); i++) {
			num = num * 10 + s.charAt(i) - '0';
			if (num < 256) {
				ip += s.charAt(i); 
				parseIPAddress(s, i + 1, part + 1, part < 3 ? ip +'.' : ip , res);//只能够用part < 3 ? ip +'.' : ip来避免最后一个点被加上
			}
			if (num == 0) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		String string = "1011212";
		RestoreIPAddress restoreIPAddress = new RestoreIPAddress();
		ArrayList<String> res = restoreIPAddress.restoreIPAddress(string);
		System.out.println(res);
	}
}
