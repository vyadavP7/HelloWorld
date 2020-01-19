package cricket.team;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FormTeam {
	public static void main(String[] args) {
		PlayerService ps = new PlayerService();
		System.out.println("Enter Details of All Players You have");
		List<Player> ll = new ArrayList<Player>();
		ll = ps.addPlayer();
		ps.viewPlayer(ll);
		while (true) {
			System.out.println("Options are:");
			System.out.println("1.select a player");
			System.out.println("2.remove a player");
			System.out.println("3.add a player");
			System.out.println("4.view all Players");
			System.out.println("5.view Selected Players");
			System.out.print("Select an option:");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the id of the player to be selected");
				ll = ps.selectPlayer(sc.nextInt(), ll);
				break;
			case 2:
				System.out.println("Enter the id of the player to be removed");
				ll = ps.removePlayer(sc.nextInt(), ll);
				break;
			case 3:
				ll = ps.addSinglePlayer(ll);
				break;
			case 4:
				ps.viewPlayer(ll);
				break;
			case 5:
				ps.viewSelectedPlayer(ll);
				break;
			default:
				System.out.println("Wrong Selection");
				break;
			}
			System.out.println("If you dont want to continue CRUD then enter NO");
			if (sc.next().equalsIgnoreCase("no"))
			{
				System.out.println("Good Bye!Sucessfully Exited");
				break;
			}
		}
	}
}