

//API : http://mabe02.github.io/lanterna/apidocs/2.1/
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
	public static void main(String[] args) {

		Terminal terminal = TerminalFacade.createTextTerminal();
		terminal.enterPrivateMode();

		TerminalSize size = terminal.getTerminalSize();
		terminal.setCursorVisible(false);

		boolean running = true;

		long tStart = System.currentTimeMillis();
		long lastSecond = 0;

        Player a = new Player("bob",10,5);           //Creates player
    Grid b = new Grid(a);
		//b.getTile(12,13).setTile(new Stairs());          //TESTING STAIRS
    for(int i = 0; i < 27; i++){
      for (int z = 0; z < 27; z++){
        if (b.getTile(z, i).isPassable()){
          terminal.moveCursor(z,i);
					terminal.putCharacter(' ');
        }
	//			if (b.getTile(z, i).isStairs()){
	//				terminal.applyBackgroundColor(Terminal.Color.GREEN);
	//				terminal.moveCursor(z,i);
	//				terminal.putCharacter(' ');
	//				terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
	//			}
        else{
          terminal.moveCursor(z,i);
			terminal.applyBackgroundColor(Terminal.Color.WHITE);
			terminal.putCharacter(' ');
			terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
        }
      }
    }

    int x = 13;
		int y = 13;

//NEW STUFF
    terminal.moveCursor(12,13);
		terminal.applyBackgroundColor(Terminal.Color.GREEN);
		terminal.putCharacter(' ');
    b.getTile(12,13).setTile(new Stairs());
//NEW STUFF STAIRS TEST

		while(running){

			terminal.moveCursor(x,y);  //STARTING POSITION OF CURSOR? You can change them up there^^^
			terminal.applyBackgroundColor(Terminal.Color.WHITE);
			terminal.applyForegroundColor(Terminal.Color.BLACK);
			//applySGR(a,b) for multiple modifiers (bold,blink) etc.
			//terminal.applySGR(Terminal.SGR.ENTER_UNDERLINE);
			terminal.putCharacter('O');
			//terminal.putCharacter(' ');
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

        if (key.getKind() == Key.Kind.ArrowLeft) {

          if (b.getTile(x-1,y).isPassable()) { //checks if the thing's passable

					terminal.moveCursor(x,y);
					terminal.putCharacter(' ');
					x--;

          }
       }

				if (key.getKind() == Key.Kind.ArrowRight) {

					///NEW STUFF
										if (b.getTile(x+1,y).isStairs()){ //DETECT STAIRS
											b = new Grid(a);
									    for(int i = 0; i < 27; i++){
									      for (int z = 0; z < 27; z++){
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
									      }
									    }
										}
					  //NEW STUFF

          if (b.getTile(x+1,y).isPassable()) {

					terminal.moveCursor(x,y);
					terminal.putCharacter(' ');
					x++;

          }

				}

				if (key.getKind() == Key.Kind.ArrowUp) {
					if (b.getTile(x,y-1).isPassable()) {
					terminal.moveCursor(x,y);
					terminal.putCharacter(' ');
					y--;
          }
				}

				if (key.getKind() == Key.Kind.ArrowDown) {
          if (b.getTile(x,y+1).isPassable()) {
					terminal.moveCursor(x,y);
					terminal.putCharacter(' ');
					y++;
			  	}
        }
			}

			putString(1,30,terminal,"Health "+a.getHP() + " Attack "+ a.getAtk() + " Experience "+ a.getExp()); //Player UI: Health, Attack, Exp



		}
	}
}
