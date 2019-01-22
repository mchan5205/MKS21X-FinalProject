import java.util.Random;
import com.googlecode.lanterna.terminal.Terminal.SGR;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.LanternaException;
import com.googlecode.lanterna.input.CharacterPattern;
import com.googlecode.lanterna.input.InputDecoder;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.KeyMappingProfile;


public class thing {

	public static void putString(int r, int c,Terminal t, String s){
		t.moveCursor(r,c);
		for(int i = 0; i < s.length();i++){
			t.putCharacter(s.charAt(i));
		}
	}

  public static int randomStairsX(){ //chooses random stairs coordinates
    Random rng = new Random();       //stairs will always be in the middle of
    if (rng.nextInt()%3 == 0){       //each room
      return 7;
    }
    if (rng.nextInt()%3 == 1){
      return 22;
    }
    else{
      return 37;
    }
  }

  public static int randomStairsY(){
    Random rng = new Random();
    if (rng.nextInt()%3 == 0){
      return 4;
    }
    if (rng.nextInt()%3 == 1){
      return 13;
    }
    else{
      return 22;
    }
  }

	public static void main(String[] args) {

		Terminal terminal = TerminalFacade.createTextTerminal();
		terminal.enterPrivateMode();

		TerminalSize size = terminal.getTerminalSize();
		terminal.setCursorVisible(false);

		boolean running = true;

    int stairsX = 37;//starting stairs coordinates
    int stairsY = 13;

    Player a = new Player("bob",10,5);           //Creates player
    Grid b = new Grid(a);                        //Creates grid
    for(int i = 0; i < 27; i++){
      for (int z = 0; z < 45; z++){             //scans grid to change blocks
        if (b.getTile(z, i).isPassable()){      //passable blocks are made blank
          terminal.moveCursor(z,i);
					terminal.putCharacter(' ');
        }
        else{
          terminal.moveCursor(z,i);              //non passable are white
					terminal.applyBackgroundColor(Terminal.Color.WHITE);
					terminal.putCharacter(' ');
					terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
        }
				if (b.getTile(z,i).isMonster()){        //monsters are red xs
					terminal.moveCursor(z,i);
					terminal.applyBackgroundColor(Terminal.Color.RED);
					terminal.putCharacter('x');
					terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
				}
        if (b.getTile(z,i).isPotion()){          //potions are blue ps
          terminal.moveCursor(z,i);
			    terminal.applyBackgroundColor(Terminal.Color.BLUE);
          terminal.putCharacter('P');
			    terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
        }
      }
    }
    terminal.moveCursor(stairsX, stairsY);      //stairs are green
    terminal.applyBackgroundColor(Terminal.Color.GREEN);
		terminal.putCharacter(' ');
		terminal.applyBackgroundColor(Terminal.Color.DEFAULT);

    int x = 22;
		int y = 13;

		while(running){

			terminal.moveCursor(x,y);  
			terminal.applyBackgroundColor(Terminal.Color.YELLOW);
			terminal.applyForegroundColor(Terminal.Color.BLACK);
			terminal.putCharacter('O');                         //player is a yellow o
			terminal.applyBackgroundColor(Terminal.Color.WHITE);
			terminal.applyForegroundColor(Terminal.Color.DEFAULT);
			terminal.applySGR(Terminal.SGR.RESET_ALL);


Key key = terminal.readInput();

			if (key != null)
			{

				if (key.getKind() == Key.Kind.Escape) {

					terminal.exitPrivateMode();
					running = false;
				}

        if (key.getKind() == Key.Kind.Backspace){ //press backspace
          if (a.getPots() > 0){ //pots are greater than 0
            a.losePot(); //lose one potion
            a.maxHeal(); //gain health
          }
        }

        if (key.getKind() == Key.Kind.ArrowLeft) {
					if (a.getHP() <= 0){             //exits when you die
						terminal.exitPrivateMode();
						running = false;
					}
					if (b.getTile(x-1,y).isMonster()){  
						a.attack(b.getTile(x-1,y).getMonster());
						if (b.getTile(x-1,y).getMonster().getHP() < 0){
							a.gainExp(b.getTile(x-1,y).getMonster().getExp());
							b.setTile(x-1, y, new Tile(true));
						}
						else{
							b.getTile(x-1,y).getMonster().attack(a);
							if (a.getHP() <= 0){
								terminal.applyBackgroundColor(Terminal.Color.BLACK);
								putString(20,13,terminal, "You died");
							}
						}
					}
          if (b.getTile(x-1,y).isPotion()){ //detects potion
            a.gainPot();                    //gain potion
          }
          ///STAIRS STUFFvvv
          if (x-1 == stairsX && y == stairsY){
            b = new Grid(a);
            for(int i = 0; i < 27; i++){
              for (int z = 0; z < 45; z++){
                if (b.getTile(z, i).isPassable()){
                  terminal.moveCursor(z,i);
					        terminal.putCharacter(' ');
                }
                else{
                   terminal.moveCursor(z,i);
				        	 terminal.applyBackgroundColor(Terminal.Color.WHITE);
					         terminal.putCharacter(' ');
					         terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
                }
				        if (b.getTile(z,i).isMonster()){
					        terminal.moveCursor(z,i);
					        terminal.applyBackgroundColor(Terminal.Color.RED);
					        terminal.putCharacter('x');
					        terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
				        }
                if (b.getTile(z,i).isPotion()){
                  terminal.moveCursor(z,i);
			            terminal.applyBackgroundColor(Terminal.Color.BLUE);
                  terminal.putCharacter('P');
			            terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
                }
              }
            }
          stairsX = randomStairsX();
          stairsY = randomStairsY();
          terminal.moveCursor(stairsX, stairsY);
          terminal.applyBackgroundColor(Terminal.Color.GREEN);
		      terminal.putCharacter(' ');
		      terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
        }///STAIRS STUFF^^^
        else{
          if (b.getTile(x-1,y).isPassable() && ! b.getTile(x-1,y).isMonster()) { //checks if the thing's passable
					  terminal.moveCursor(x,y);
					  terminal.putCharacter(' ');
					  x--;
          }
        }
       }
			  if (key.getKind() == Key.Kind.ArrowRight) {
					if (a.getHP() <= 0){
						terminal.exitPrivateMode();
						running = false;
					}
				  if (b.getTile(x+1,y).isMonster()){
				  	a.attack(b.getTile(x+1,y).getMonster());
				  	if (b.getTile(x+1,y).getMonster().getHP() < 0){
						  a.gainExp(b.getTile(x+1,y).getMonster().getExp());
					  	b.setTile(x+1, y, new Tile(true));
            }
						else{
							b.getTile(x+1,y).getMonster().attack(a);
							if (a.getHP() <= 0){
								terminal.applyBackgroundColor(Terminal.Color.BLACK);
								putString(20,13,terminal, "You died");
							}
						}
			  	}
          if (b.getTile(x+1,y).isPotion()){
            a.gainPot();
          }
        ///STAIRS STUFFvvv
          if (x+1 == stairsX && y == stairsY){
            b = new Grid(a);
              for(int i = 0; i < 27; i++){
              for (int z = 0; z < 45; z++){
                if (b.getTile(z, i).isPassable()){
                  terminal.moveCursor(z,i);
					        terminal.putCharacter(' ');
                }
                else{
                  terminal.moveCursor(z,i);
					        terminal.applyBackgroundColor(Terminal.Color.WHITE);
					        terminal.putCharacter(' ');
					        terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
                }
				        if (b.getTile(z,i).isMonster()){
					        terminal.moveCursor(z,i);
					        terminal.applyBackgroundColor(Terminal.Color.RED);
					        terminal.putCharacter('x');
					        terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
				        }
                if (b.getTile(z,i).isPotion()){
                  terminal.moveCursor(z,i);
			            terminal.applyBackgroundColor(Terminal.Color.BLUE);
                  terminal.putCharacter('P');
			            terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
                }
              }
            }
          stairsX = randomStairsX();
          stairsY = randomStairsY();
          terminal.moveCursor(stairsX, stairsY);
          terminal.applyBackgroundColor(Terminal.Color.GREEN);
		      terminal.putCharacter(' ');
		      terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
        }///STAIRS STUFF^^^
        else{
         if (b.getTile(x+1,y).isPassable() && ! b.getTile(x+1,y).isMonster()) { //checks if the thing's passable
					  terminal.moveCursor(x,y);
					  terminal.putCharacter(' ');
					  x++;
          }
        }

				}
				if (key.getKind() == Key.Kind.ArrowUp) {
					if (a.getHP() <= 0){
						terminal.exitPrivateMode();
						running = false;
					}
					if (b.getTile(x,y-1).isMonster()){
						a.attack(b.getTile(x,y-1).getMonster());
						if (b.getTile(x,y-1).getMonster().getHP() < 0){
							a.gainExp(b.getTile(x,y-1).getMonster().getExp());
							b.setTile(x, y-1, new Tile(true));
						}
						else{
							b.getTile(x,y-1).getMonster().attack(a);
							if (a.getHP() <= 0){
								terminal.applyBackgroundColor(Terminal.Color.BLACK);
								putString(20,13,terminal, "You died");
							}
						}
					}
          if (b.getTile(x,y-1).isPotion()){
            a.gainPot();
          }
          ///STAIRS STUFFvvv
          if (x == stairsX && y-1 == stairsY){
            b = new Grid(a);
            for(int i = 0; i < 27; i++){
              for (int z = 0; z < 45; z++){
                if (b.getTile(z, i).isPassable()){
                  terminal.moveCursor(z,i);
					        terminal.putCharacter(' ');
                }
                else{
                  terminal.moveCursor(z,i);
					        terminal.applyBackgroundColor(Terminal.Color.WHITE);
					        terminal.putCharacter(' ');
					        terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
                }
				        if (b.getTile(z,i).isMonster()){
					        terminal.moveCursor(z,i);
					        terminal.applyBackgroundColor(Terminal.Color.RED);
					        terminal.putCharacter('x');
					        terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
				        }
                if (b.getTile(z,i).isPotion()){
                  terminal.moveCursor(z,i);
			            terminal.applyBackgroundColor(Terminal.Color.BLUE);
                  terminal.putCharacter('P');
			            terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
                }
              }
            }
          stairsX = randomStairsX();
          stairsY = randomStairsY();
          terminal.moveCursor(stairsX, stairsY);
          terminal.applyBackgroundColor(Terminal.Color.GREEN);
		      terminal.putCharacter(' ');
		      terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
        }///STAIRS STUFF^^^
          else{
          if (b.getTile(x,y-1).isPassable() && ! b.getTile(x,y-1).isMonster()) { //checks if the thing's passable
					  terminal.moveCursor(x,y);
					  terminal.putCharacter(' ');
					  y--;
          }
          }
				}
				if (key.getKind() == Key.Kind.ArrowDown) {
					if (a.getHP() <= 0){
						terminal.exitPrivateMode();
						running = false;
					}
					if (b.getTile(x,y+1).isMonster()){
						a.attack(b.getTile(x,y+1).getMonster());
						if (b.getTile(x,y+1).getMonster().getHP() < 0){
							a.gainExp(b.getTile(x,y+1).getMonster().getExp());
							b.setTile(x, y+1, new Tile(true));
						}
						else{
							b.getTile(x,y+1).getMonster().attack(a);
							if (a.getHP() <= 0){
								terminal.applyBackgroundColor(Terminal.Color.BLACK);
								putString(20,13,terminal, "You died");
							}
						}
					}
          if (b.getTile(x,y+1).isPotion()){
            a.gainPot();
          }
          ///STAIRS STUFFvvv
          if (x == stairsX && y+1 == stairsY){
            b = new Grid(a);
            for(int i = 0; i < 27; i++){
              for (int z = 0; z < 45; z++){
                if (b.getTile(z, i).isPassable()){
                  terminal.moveCursor(z,i);
					        terminal.putCharacter(' ');
                }
                else{
                  terminal.moveCursor(z,i);
					        terminal.applyBackgroundColor(Terminal.Color.WHITE);
					        terminal.putCharacter(' ');
					        terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
                }
				        if (b.getTile(z,i).isMonster()){
					        terminal.moveCursor(z,i);
					        terminal.applyBackgroundColor(Terminal.Color.RED);
					        terminal.putCharacter('x');
					        terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
				        }
                if (b.getTile(z,i).isPotion()){
                  terminal.moveCursor(z,i);
			            terminal.applyBackgroundColor(Terminal.Color.BLUE);
                  terminal.putCharacter('P');
			            terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
                }
              }
            }
          stairsX = randomStairsX();
          stairsY = randomStairsY();
          terminal.moveCursor(stairsX, stairsY);
          terminal.applyBackgroundColor(Terminal.Color.GREEN);
		      terminal.putCharacter(' ');
		      terminal.applyBackgroundColor(Terminal.Color.DEFAULT);

        }///STAIRS STUFF^^^
          else{
          if (b.getTile(x,y+1).isPassable() && ! b.getTile(x,y+1).isMonster()) { //checks if the thing's passable

					terminal.moveCursor(x,y);
					terminal.putCharacter(' ');
					y++;

          }
          }
        }
			}
			putString(1,30,terminal,"Health "+a.getHP() + " Attack "+ a.getAtk() + " Experience "+ a.getExp() + " Potions " + a.getPots() + "        ");
      //Player UI: Health, Attack, Exp, number of potions
      putString(1,31,terminal,"Player Lv. "+ a.getLevel()); //player level
		}
	}
}
