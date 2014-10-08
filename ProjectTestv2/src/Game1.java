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
	//private int games = 0;
	
	public Game1(){
		Test2.addText("Initial stick amount:(10-100)\n");
		String str = Main.input();
		numError(str, 10, 100);
	}
	
	public void gameStart(){
		
		while(total>0 && repeat==true){
			if(player==2){
				player = 1;
				Test2.addText("Player1: How many do you choose?(1-"+ MAX +")\n");
				Test2.addText("Remaining:" + total + "\n");
				String str1 = Main.input();
				inputError(str1,1,MAX);
				
			}
			else{
				player = 2;
				Test2.addText("Player2: How many do you choose?(1-" + MAX + ")\n");
				Test2.addText("Remaining:" + total + "\n");
				String str1 = Main.input();
				inputError(str1,1,MAX);
			}
		}
		if(repeat==true){
		Test2.addText("Player" + player + " loses\n\n");
		//games++;
		//Test2.addText("games: " + games + "\n\n");
		player = (int)(Math.random()*2+1);
		restart();
		}
	}
	
	public void numError(String temp, int min, int max){
		if(Main.isInteger(temp)){
			int num = Integer.parseInt(temp);
			if(num>=min && num<=max){
				total = num;
				initial = num;
				Test2.addText("\n");
				gameStart();
			}
			else{
				Test2.addText("error: input int not within range of "+ min + " and " + max + "\n");
				numError(Main.input(),min,max);
			}
		}
		else if(Main.checkInput(temp)){
			Test2.addText("error: input not an int\n");
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
				Test2.addText("Player" + player + " chose " + num + " sticks\n\n");
			}
			else{
				Test2.addText("error: input int not within range of "+ min + " and " + max + "\n");
				inputError(Main.input(),min,max);
			}
		}
		else if(checkInput(temp)){
			Test2.addText("error: input not an int\n");
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
		Test2.addText("Play again?(0-1)\n");
		restartError(Main.input(),0,1);
	}
	
	public void restartError(String num, int min, int max){
		if(Main.isInteger(num)){
			int num2 = Integer.parseInt(num);
			if(num2>=min && num2<=max){
				if(num2==0){
					Test2.addText("Game1 ended" + "\n\n");
					repeat = false;
				}
				else{
					total = initial;
					Test2.addText("\n");
				}
			}
			else{
				Test2.addText("error: input int not within range of "+ min + " and " + max + "\n");
				restartError(Main.input(),min,max);
			}
		}
		else if(Main.checkInput(num)){
			Test2.addText("error: input not an int\n");
			restartError(Main.input(),min,max);
		}
		else{
			repeat = false;
		}
	}
	
	public static boolean checkInput(String str){
		if(str.toUpperCase().equals("ENDGAME")){
			Test2.addText("Game1 ended" + "\n\n");
			return false;
		}
		else{
			return true;
		}
	}
}
