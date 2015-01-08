package String;

public class PrintInterleavings {
	public void printInterleavings(String s1, String s2)
	{
		printInterleavings(s1, s2, "");
	}
	
	public void printInterleavings(String s1, String s2, String res)
	{
		if ((s1 == null || s1.length() == 0) && (s2 == null || s2.length() == 0)) {
			return;
		}
		
		if (s1 == null || s1.length() == 0) {//s1Ϊ�գ��������s2�����
			res += s2;
			System.out.println(res);
			return;
		}
		
		if (s2 == null || s2.length() == 0) {//s2Ϊ�գ��������s1�����
			res += s1;
			System.out.println(res);
			return;
		}
		//����s1��һ���ַ�
		printInterleavings(s1.substring(1), s2, res + s1.charAt(0));
		//����s2��һ���ַ�
		printInterleavings(s1, s2.substring(1), res + s2.charAt(0));
	}
}
