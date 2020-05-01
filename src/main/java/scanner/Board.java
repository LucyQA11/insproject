package scanner;

import java.util.Scanner;

public class Board {
//	public static final String MYSQL_URL ="jdbc:mysql://34.8/Bags"; 
	public static final Scanner SCANNER = new Scanner(System.in); 
	public static final String MYSQL_URL ="jdbc:mysql://10.9.224.3/Bags";
	private Board() {
		
	}
	
	public static String input() {
		return SCANNER.nextLine();
	}
	public static int input2() {
		return SCANNER.nextInt();
		}

}
