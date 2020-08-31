package ttt;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		HumanGame hm = new HumanGame();
		BotGame bm = new BotGame();
		boolean flag = true;

		while(flag) {

			System.out.println("Please choose your option : ");
			System.out.println("1. Human v/s Human..");
			System.out.println("2. Human v/s Bot..");
			
				String input = scan.next();
				switch (Integer.parseInt(input)) {
				case 1:   
					hm.humanMode();
					flag = false;
					break ;
				case 2:
					bm.botMode();
					flag = false;
					break ;
				default : 
					System.out.println("Please enter correct option");
					System.out.println();
				}
		}
	}
}
