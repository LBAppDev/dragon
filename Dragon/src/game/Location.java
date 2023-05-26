package game;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

public class Location extends Circle {
    private static final long serialVersionUID = 1L;
	private String name;
	private float textOffsetY = -10.0f;
	private float textOffsetX = 15.0f;
	private List<Character> characters;
    private float offset = 5;
    private List<Item> items;
    private List<Character> monsters;
    private Wheel wheel;

    public Wheel getWheel() {
		return wheel;
	}

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

	public Location(float centerX, float centerY, float radius, String name) {
        super(centerX, centerY, radius);
        this.name = name;
        this.characters = new ArrayList<Character>();
        this.monsters = new ArrayList<Character>();
        this.items = new ArrayList<Item>();
    }

    public String getName() {
        return name;
    }
    
    public List<Character> getCharacters() {
        return characters;
    }
    
    public void addCharacter(Character character) {
        characters.add(character);
    }

    public void removeCharacter(Character character) {
        characters.remove(character);
    }
    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
    
    public void addMonster(Character monster) {
        monsters.add(monster);
    }

    public void removeMonster(Character monster) {
        monsters.remove(monster);
    }

    public void render(Graphics g) {
        // Render the circle
    	float x = getX() - offset;
        float y = getY() - offset;

       
        g.setColor(Color.blue);
        g.fill(this);

        // Render the name
        g.setColor(Color.white);
        g.drawString(name, x - g.getFont().getWidth(name) / 2 + textOffsetX, y - radius - textOffsetY);
    }
}


