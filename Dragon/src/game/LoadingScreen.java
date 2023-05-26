package game;



/*public class LoadingScreen extends BasicGameState {

    private float rectangleX;
    private float rectangleY;
    private float rectangleSpeed;

    @Override
    public void init(GameContainer gc, StateBasedGame game) throws SlickException {
        rectangleX = gc.getWidth() / 2;
        rectangleY = gc.getHeight() / 2;
        rectangleSpeed = 0.5f; // Adjust the speed of the animation
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        // Render the animation (in this case, a moving rectangle)
        g.setColor(Color.red);
        g.fillRect(rectangleX, rectangleY, 50, 50);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
        // Update the animation
        rectangleX += rectangleSpeed * delta;

        // Reverse the direction when the rectangle reaches the screen edges
        if (rectangleX < 0 || rectangleX + 50 > gc.getWidth()) {
            rectangleSpeed = -rectangleSpeed;
        }
    }

    @Override
    public int getID() {
        return GameApp.LOADING_SCREEN_ID; // Replace with your loading screen state ID
    }
}*/

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class LoadingScreen extends BasicGameState {

    private GameContainer mainContainer;
    private StateBasedGame game;
    private Thread loadingThread;
    int i = 0;
    private float rectangleX;
    private float rectangleY;
    private float rectangleSpeed;

    public LoadingScreen(GameContainer container, StateBasedGame game) {
        this.mainContainer = container;
        this.game = game;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame game) throws SlickException {
        // Initialize any required resources or variables
    	this.game = game;
    	rectangleX = gc.getWidth() / 2;
        rectangleY = gc.getHeight() / 2;
        rectangleSpeed = 0.5f; // Adjust the speed of the animation
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
    	
        // Render the loading screen UI
    	
    	g.setColor(Color.white);
    	java.awt.Font awtFont = new java.awt.Font("Arial", java.awt.Font.BOLD, 20); // Replace "Arial" with your desired font name
    	TrueTypeFont font = new TrueTypeFont(awtFont, true);

    	g.setFont(font);
        g.drawString("Loading...", 500, 300);
        g.setColor(Color.red);
        //g.fillRect(rectangleX, rectangleY, 50, 50);
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
    	if(i == 0) {
        	MainScreen main = new MainScreen(GameApp.MAIN_GAME_SCREEN_ID, gc);
    		game.addState(main);
    		StartScreen start = new StartScreen(GameApp.START_SCREEN_ID, gc, game);
    		game.addState(start);
    		game.enterState(GameApp.START_SCREEN_ID);
        }
        
     
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        super.enter(container, game);
    }

    @Override
    public int getID() {
        return GameApp.LOADING_SCREEN_ID; // Replace with your loading screen state ID
    }
}

