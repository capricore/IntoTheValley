package String;

public class PrintPar {
	public void printPar(int l, int r, char[] str, int count)
	{
		if (l < 0 || r < l) {
			return;
		}
		if (l == 0 && r == 0) {
			System.out.println(str);
		}else {
			if (l > 0) {
				str[count] = '(';
				printPar(l-1, r, str, count+1);
			}
			if (r > l) {
				str[count] = ')';
				printPar(l, r-1, str, count+1);
			}
		}
	}
	
	public static void main(String[] args) {
		char[]  str = new char[20];
		PrintPar printPar = new PrintPar();
		printPar.printPar(10, 10, str, 0);
	}
}
