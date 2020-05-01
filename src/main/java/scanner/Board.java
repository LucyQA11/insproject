package scanner;

import java.util.Scanner;

public class Board {
	public static final String MYSQL_URL ="jdbc:mysql://34.89.103.5/Bags"; 
	public static final Scanner SCANNER = new Scanner(System.in); 
	
	private Board() {
		
	}
	
	public static String input() {
		return SCANNER.nextLine();
	}
	public static int input2() {
		return SCANNER.nextInt();
		}

}
