package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class GameApp extends StateBasedGame {
    public static final int START_SCREEN_ID = 1;
    public  static final int MAIN_GAME_SCREEN_ID = 2;
    public static final int LOADING_SCREEN_ID = 3;

    private boolean isLoadingComplete = false;

    public GameApp() {
        super("Game Title");
    }

    public static void main(String[] args) {
        try {
            GameApp app = new GameApp();
            AppGameContainer container = new AppGameContainer(app);
            container.setDisplayMode(1200, 650, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        
        addState(new LoadingScreen(gc, null));
		// Enter the main game screen
		enterState(LOADING_SCREEN_ID);
		
		
  
    }
    
    


   
}
