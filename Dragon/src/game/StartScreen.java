package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class StartScreen extends BasicGameState {
    private StateBasedGame sbg;     // Member variable to store the StateBasedGame object
    private GameContainer gc;       // Member variable to store the GameContainer object

    public StartScreen(int state, GameContainer gc2, StateBasedGame sbg) throws SlickException {
    	super();
    	init(gc2, sbg);
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.gc = gc;    // Store the GameContainer object
        this.sbg = sbg;  // Store the StateBasedGame object
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        // Render the start screen UI
        g.drawString("Press Enter to Start", 100, 100);
        g.drawString("Press Esc to Exit", 100, 150);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
    }

    public void keyPressed(int key, char c) {
        if (key == Input.KEY_ENTER) {
            // Start button pressed, switch to the main game screen
            sbg.enterState(GameApp.MAIN_GAME_SCREEN_ID);
        }else if (key == Input.KEY_ESCAPE) {
            // Exit button pressed, close the game
            gc.exit();
        }
    }

    public int getID() {
        return GameApp.START_SCREEN_ID;
    }
}
