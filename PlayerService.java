package cricket.team;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PlayerService {
	static int count=0;
	static int overseas_count=0;
	Scanner sc;
	@SuppressWarnings("unchecked")
	public ArrayList<Player> addPlayer(){
		sc = new Scanner(System.in);
		ArrayList<Player> al_ipl = new ArrayList<Player>();
		boolean choice=true;
		while(choice){
			al_ipl= (ArrayList)addSinglePlayer(al_ipl);
			System.out.println("Do you want to add more player(yes/no) ?");
			if(sc.next().equalsIgnoreCase("yes"))
				choice=true;
			else
				choice=false;
		}
		return al_ipl;
	}
	public List<Player> removePlayer(int id,List<Player> al_ipl){
		Player pp = new Player();
		Iterator<Player> itr = al_ipl.iterator();
		while(itr.hasNext()){
			Player p = itr.next();
			if(p.id==id){
				pp = p;
			}
		}
		if(!pp.getCountry().equalsIgnoreCase("india"))
		{
			overseas_count--;
		}
		count--;
		al_ipl.remove(pp);
		return al_ipl;
	}
	public List<Player> selectPlayer(int id,List<Player> ll){
		Iterator<Player> itr = ll.iterator();
		if(count==11){
			System.out.println("11 completed you cant select more.");
		}
		else{
			while(itr.hasNext()){
				Player p = itr.next();
				if(p.isSelected==true){
					System.out.println("Already Selected that player");
				}
				else{
					if(p.id==id){
						if(!p.country.equals("india")){
							overseas_count++;
							if(overseas_count<=4){
								p.isSelected=true;
								count++;
							}else{
								System.out.println("cant add more than 4 foreign players");
							}
						}else{
							p.isSelected=true;
							count++;
						}		
					}

				}
			}						
		}
		return ll;
	}
	public List<Player> addSinglePlayer(List<Player> ll){
		Player p = new Player();
		sc = new Scanner(System.in);
		System.out.println("Enter the name of the player");
		p.setName(sc.nextLine());
		System.out.println("Enter the name of the country");
		p.setCountry(sc.nextLine());
		System.out.println("Enter player id");
		p.setId(sc.nextInt());
		p.setSelected(false);
		ll.add(p);
		return ll;
	}
	public void viewPlayer(List<Player> ll) {
		if(ll.isEmpty())
		{
			System.out.println("List is empty");
		}
		else
		{
			System.out.println("List of all the players\n_________________________________________________");
			Iterator<Player> itr = ll.iterator();
			System.out.println("Id\tName\tCountry\tSelected_Status");
			while(itr.hasNext()){
				Player p = itr.next();
				System.out.println(p.id+"\t"+p.getName()+"\t"+p.getCountry()+"\t"+p.isSelected);
			}
		}
	}
	//to view a selected player
	public void viewSelectedPlayer(List<Player> ll) {
		if(ll.isEmpty())
		{
			System.out.println("List is empty");
		}
		else if (count == 0)
		{
			System.out.println("No player is Selected");
		}
		else
		{
			System.out.println("Selected Players List\n_________________________________________________");
			Iterator<Player> itr = ll.iterator();
			System.out.println("Id\tName\tCountry\tSelected Status");
			while(itr.hasNext()){
				Player p = itr.next();
				if(p.isSelected==true)
					System.out.println(p.id+"\t"+p.getName()+"\t"+p.getCountry()+"\t"+p.isSelected);
			}
		}
	}
}
