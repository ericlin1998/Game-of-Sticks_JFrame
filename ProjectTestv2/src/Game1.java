/**
 * 	author Eric Lin
 * 	Completed
 * 		Player vs Player
 */

public class Game1 {
	private final int MAX = 4;
	private int initial;
	private int total;
	private int player = 2;
	private boolean repeat = true;
	//testing variable
	private int games = 0;
	
	public Game1(){
		System.out.println("Initial stick amount:(10-100)");
		String str = Main.input();
		numError(str, 10, 100);
	}
	
	public void gameStart(){
		
		while(total>0 && repeat==true){
			if(player==2){
				player = 1;
				System.out.println("Player1: How many do you choose?(1-"+ MAX +")");
				System.out.println("Remaining:" + total);
				String str1 = Main.input();
				inputError(str1,1,MAX);
				
			}
			else{
				player = 2;
				System.out.println("Player2: How many do you choose?(1-" + MAX + ")");
				System.out.println("Remaining:" + total);
				String str1 = Main.input();
				inputError(str1,1,MAX);
			}
		}
		if(repeat==true){
		System.out.println("Player" + player + " loses");
		games++;
		System.out.println("games: " + games);
		player = 2;
		restart();
		}
	}
	
	public void numError(String temp, int min, int max){
		if(Main.isInteger(temp)){
			int num = Integer.parseInt(temp);
			if(num>=min && num<=max){
				total = num;
				initial = num;
				System.out.println();
				gameStart();
			}
			else{
				System.out.println("error: input int not within range of "+ min + " and " + max);
				numError(Main.input(),min,max);
			}
		}
		else if(Main.checkInput(temp)){
			System.out.println("error: input not an int");
			numError(Main.input(),min,max);
		}
		else{
			repeat = false;
		}
	}
	
	public void inputError(String temp, int min, int max){
		if(Main.isInteger(temp)){
			int num = Integer.parseInt(temp);
			if(num>=min && num<=max){
				total -= num;
				System.out.println("Player" + player + " chose " + num + " sticks\n");
			}
			else{
				System.out.println("error: input int not within range of "+ min + " and " + max);
				inputError(Main.input(),min,max);
			}
		}
		else if(checkInput(temp)){
			System.out.println("error: input not an int");
			inputError(Main.input(),min,max);
			
		}
		else{
			repeat = false;
		}
	}
	
	public boolean getRepeat(){
		return repeat;
	}
	
	public void restart(){
		System.out.println("Play again?(0-1)");
		restartError(Main.input(),0,1);
	}
	
	public void restartError(String num, int min, int max){
		if(Main.isInteger(num)){
			int num2 = Integer.parseInt(num);
			if(num2>=min && num2<=max){
				if(num2==0){
					System.out.println("Game1 ended\n");
					repeat = false;
				}
				else{
					total = initial;
					System.out.println();
				}
			}
			else{
				System.out.println("error: input int not within range of "+ min + " and " + max);
				restartError(Main.input(),min,max);
			}
		}
		else if(Main.checkInput(num)){
			System.out.println("error: input not an int");
			restartError(Main.input(),min,max);
		}
		else{
			repeat = false;
		}
	}
	
	public static boolean checkInput(String str){
		if(str.toUpperCase().equals("ENDGAME")){
			System.out.println("Game1 ended\n");
			return false;
		}
		else{
			return true;
		}
	}
}
