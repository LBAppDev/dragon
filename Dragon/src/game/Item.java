package game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

import javax.imageio.ImageIO;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.opengl.DeferredTexture;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Item {
    private String name;
    private String description;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private Image image;
    private float x;
    private float y;
    private boolean isDragging;
    private float offsetX;
    private float offsetY;
	public static int width = 50;
	public static int height = 50;
	BufferedImage bufferedImage;

    public Item(String name, String description, Image image, float x, float y) {
        this.name = name;

        this.description = description;
        this.image = image.getScaledCopy(width, height);
        this.x = x;
        this.y = y;
        this.isDragging = false;
        this.offsetX = 0;
        this.offsetY = 0;
    }
    
    public Item(String name, String description) {
        this.name = name;

        this.description = description;
        //this.image = image.getScaledCopy(width, height);
        this.x = 50;
        this.y = 50;
        this.isDragging = false;
        this.offsetX = 0;
        this.offsetY = 0;
    }
    
    public Item(String name, float x, float y) throws SlickException {
        this.name = name;
        this.description = MainScreen.getWeaponDescripton(name);
        image = new Image(MainScreen.getWeaponPath(name)).getScaledCopy(width, height);;           
        this.x = x;
        this.y = y;
        this.isDragging = false;
        this.offsetX = 0;
        this.offsetY = 0;
    }
    
    public Item(String name) {
        this.name = name;
        this.description = MainScreen.getWeaponDescripton(name);
        this.x = 50;
        this.y = 50;
        this.isDragging = false;
        this.offsetX = 0;
        this.offsetY = 0;
    }

    public void render(Graphics g, Input input) {
    	//if(image == null)
    		//image = new Image(bufferedImage)
    	if(image != null) {
    		g.drawImage(image, x, y);
        if (input.getMouseX() >= x && input.getMouseX() <= x + image.getWidth()
        && input.getMouseY() >= y && input.getMouseY() <= y + image.getHeight()) {
        	// Display character's name and items
        	g.setColor(Color.white);
        	g.drawString(name, x, y - 20);
        }
    	}
    }

    public void update(Input input, int delta) {
    	if(image != null) {
        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            float mouseX = input.getMouseX();
            float mouseY = input.getMouseY();
            Rectangle itemBounds = new Rectangle(x, y, image.getWidth(), image.getHeight());

            if (itemBounds.contains(mouseX, mouseY) && MainScreen.drag == false) {
            	MainScreen.drag = true;
                isDragging = true;
                offsetX = mouseX - x;
                offsetY = mouseY - y;
            }
        } else {
            isDragging = false;
            MainScreen.drag = false;
        }

        if (isDragging) {
            x = input.getMouseX() - offsetX;
            y = input.getMouseY() - offsetY;
        }
    	}
    }

	public String special() {
		// TODO Auto-generated method stub
		return name + description;
	}

    
    

    
}


