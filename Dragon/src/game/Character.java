package game;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

public class Character {
    private Image image;
    public boolean isCharacterWindowOpen;
    private float x;
    private Map map;
    public float getX() {
		return x;
	}


	public void setX(float x) {
		this.x = x;
	}


	public float getY() {
		return y;
	}


	public void setY(float y) {
		this.y = y;
	}
	private float y;
    private Circle lastCircle;
	private Rectangle boundingBox;
	private List<Item> backpack;
	private List<Item> backpackshop;
	private String name;
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	CharacterWindow characterWindow;
	
	int main_power;
	int effects_power;
	Weapon main_Weapon;
	Weapon None;
	
	int gold;
	
	public void setDescription(String description) {
		this.description = description;
	}
	String description;
	private boolean isDragging;
	private float offsetX;
	private float offsetY;
	
	int overAllPower() {
		return main_power + getMainWeaponPower() + effects_power;
	}

    public Character(Image image, String name, float x, float y, int width, int height,Map map) throws SlickException {
    	this.map = map;
        this.image = image;
        this.name = name;
        this.main_power =2;
        this.main_Weapon = null;
        this.effects_power = 0;
        this.gold = 3;
        this.x = x;
        this.y = y;
        this.lastCircle = null;
        this.image = image.getScaledCopy(width, height);
        this.boundingBox = new Rectangle(x, y, image.getWidth(), image.getHeight());
        this.backpack = new ArrayList<Item>();
        this.backpackshop = new ArrayList<Item>();
        this.None = new Weapon("None");
        this.main_Weapon = None;
        this.backpack.add(None);
        this.backpackshop.add(None);
        this.isDragging = false;
        this.offsetX = 0;
        this.offsetY = 0;
        characterWindow = new CharacterWindow(this, map);
        
    }
    
    public Character(String name, Map map) throws SlickException {
    	this.map = map;
        this.image = new Image(MainScreen.getMonsterPath(name));
        this.name = name;
        this.main_power =MainScreen.getMonsterPower(name);
        this.main_Weapon = null;
        this.effects_power = 0;
        this.gold = 3;
        this.x = 0;
        this.y = 0;
        this.lastCircle = null;
        this.image = image.getScaledCopy(getCharacterWidth(name), getCharacterHeight(name));
        this.boundingBox = new Rectangle(x, y, image.getWidth(), image.getHeight());
        this.backpack = new ArrayList<Item>();
        this.backpackshop = new ArrayList<Item>();
        this.None = new Weapon("None");
        this.main_Weapon = None;
        this.backpack.add(None);
        this.backpackshop.add(None);
        this.isDragging = false;
        this.offsetX = 0;
        this.offsetY = 0;
        characterWindow = new CharacterWindow(this, map);
        
    }
    
    public Character(String name, Map map, float x, float y) throws SlickException {
    	this.map = map;
    	
            	this.image = new Image(MainScreen.getMonsterPath(name));
            
        
        this.name = name;
        this.main_power =MainScreen.getMonsterPower(name);
        this.main_Weapon = null;
        this.effects_power = 0;
        this.gold = 3;
        this.x = x - getCharacterWidth(name) / 2;
        this.y = y - getCharacterHeight(name) /2;
        this.lastCircle = null;
        
            this.image = image.getScaledCopy(getCharacterWidth(name), getCharacterHeight(name));
            this.boundingBox = new Rectangle(x, y, image.getWidth(), image.getHeight());
        
        
        this.backpack = new ArrayList<Item>();
        this.backpackshop = new ArrayList<Item>();
        this.None = new Weapon("None");
        this.main_Weapon = None;
        this.backpack.add(None);
        this.backpackshop.add(None);
        this.isDragging = false;
        this.offsetX = 0;
        this.offsetY = 0;
        characterWindow = new CharacterWindow(this, map);
        
    }
    
    /*public Character(Image image, String name, int power, float x, float y, int width, int height,Map map) throws SlickException {
        this.image = image;
        this.name = name;
        this.main_power =power;
        this.main_Weapon = null;
        this.effects_power = 0;
        this.gold = 3;
        this.x = x;
        this.y = y;
        this.lastCircle = null;
        this.image = image.getScaledCopy(width, height);
        this.boundingBox = new Rectangle(x, y, image.getWidth(), image.getHeight());
        this.backpack = new ArrayList<Item>();
        this.None = new Weapon("None");
        this.main_Weapon = None;
        this.backpack.add(None);
        this.backpackshop.add(None);
        
        
        this.isDragging = false;
        this.offsetX = 0;
        this.offsetY = 0;
    }*/

    public void addItemToBackpack(Item item) {
        backpack.add(item);
    }
    
    
    
    public CharacterWindow getCharacterWindow() {
    	return characterWindow;
    }

    public void removeItemFromBackpack(Item item) {
        backpack.remove(item);
    }

    public void render(Graphics g, Input input) {
    	if(image != null) {
    		g.drawImage(image, x, y);
        
        if (input.getMouseX() >= x && input.getMouseX() <= x + image.getWidth()
                && input.getMouseY() >= y && input.getMouseY() <= y + image.getHeight()) {
            // Display character's name and items
            g.setColor(Color.white);
            g.drawString(name, x, y - 20);
            String itemText = "power: "+this.overAllPower();
            
            g.drawString(itemText, x, y );
            
            if (input.isKeyPressed(Input.KEY_E)) {
                //characterWindow.open();
            	if(characterWindow == null)
            		characterWindow = new CharacterWindow(this, map);
            	characterWindow.open();
            }else if(/*input.isKeyPressed(Input.KEY_LCONTROL) && */ input.isKeyPressed(Input.KEY_D)) {
            	MainScreen.removeById(this);
            }
        }
    	}
    }

    public Circle getLastCircle() {
        return lastCircle;
    }
    
    public Image getImage() {
    	return image;
    }
    
    public void updateBoundingBox() {
        boundingBox.setBounds((int) x, (int) y, image.getWidth(), image.getHeight());
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
        boundingBox.setX(x);
        boundingBox.setY(y);
        //updateBoundingBox();
        
    }
    
    public boolean containsPoint(int x, int y) {
        // Check if the given point (x, y) is within the bounds of the character
        return boundingBox.contains(x, y);
    }
    
    public List<Item> getItems(){
    	return backpack;
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


	public Number getMainPower() {
		// TODO Auto-generated method stub
		return main_power;
	}


	public int getMainWeaponPower() {
		// TODO Auto-generated method stub
		if(main_Weapon != null)
			return main_Weapon.getPower();
		else return 0;
	}


	public Number getEffectsPower() {
		// TODO Auto-generated method stub
		return effects_power;
	}


	public int getGold() {
		// TODO Auto-generated method stub
		return gold;
	}


	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}


	public void setMainPower(int value) {
		// TODO Auto-generated method stub
		main_power = value;
	}


	public void setMainWeaponPower(int value) {
		// TODO Auto-generated method stub
		main_Weapon.setPower(value);
	}


	public void setEffectsPower(int value) {
		// TODO Auto-generated method stub
		effects_power = value;
	}


	public void setGold(int value) {
		// TODO Auto-generated method stub
		gold = value;
	}
	
	public void addItemToBackpack(Weapon weapon) {
        backpack.add(weapon);
    }

    public void removeItemFromBackpack(Weapon weapon) {
        backpack.remove(weapon);
    }
    
    public List<String> getWeaponNames() {
        List<String> weaponNames = new ArrayList<>();
        for (Item item : Allbackpack()) {
            if (item instanceof Weapon) {
                Weapon weapon = (Weapon) item;
                weaponNames.add(weapon.getName());
            }
        }
        return weaponNames;
    }
    
   //In the Map class

   //Add a method to retrieve a weapon by its name
   public Weapon getWeaponByName(String name) {
     for (Item item : Allbackpack()) {
         if (item instanceof Weapon && item.getName().equals(name)) {
             return (Weapon) item;
         }
     }
     return null; // Return null if the weapon with the specified name is not found
   }


public List<String> getItemNames() {
	List<String> weaponNames = new ArrayList<>();
    for (Item item : Allbackpack()) {
        
        Weapon weapon = (Weapon) item;
        weaponNames.add(weapon.getName());
        
    }
    return weaponNames;
}

public List<String> getItemNamesmap() {
	List<String> weaponNames = new ArrayList<>();
    for (Item item : backpack) {
        
        Weapon weapon = (Weapon) item;
        weaponNames.add(weapon.getName());
        
    }
    return weaponNames;
}
public List<String> getItemNamesshop() {
	List<String> weaponNames = new ArrayList<>();
    for (Item item : backpackshop) {
        
        Weapon weapon = (Weapon) item;
        weaponNames.add(weapon.getName());
        
    }
    return weaponNames;
}


public Item getItemByName(String selectedItemName) {
	for (Item item : Allbackpack()) {
        if (item.getName().equals(selectedItemName)) {
            return item;
        }
    }
    return null;
}

public Item getItemByNameshop(String selectedItemName) {
	for (Item item : backpackshop) {
        if (item.getName().equals(selectedItemName)) {
            return item;
        }
    }
    return null;
}

public Item getItemByNamemap(String selectedItemName) {
	for (Item item : backpack) {
        if (item.getName().equals(selectedItemName)) {
            return item;
        }
    }
    return null;
}


public void removeItem(Item selectedItem) {

	backpack.remove(selectedItem);
	
}


public void addItemToBackpackShop(Weapon selectedWeapon) {
	
	backpackshop.add(selectedWeapon);
	
}

public void removeItemshop(Item selectedItem) {

	backpackshop.remove(selectedItem);
	
}

   public List<Item> Allbackpack(){
	   List<Item> list =  Stream.concat(backpack.stream(), backpackshop.stream())
               .collect(Collectors.toList());
	   list.remove(None);
	   list.remove(None);
	   list.add(None);
	   return list;
   }
    
   private int getCharacterWidth(String name) {
	   if(name.equals(MainScreen.skeleton_name) || name.equals(MainScreen.goblin_name) || name.equals(MainScreen.slime_name) || name.equals(MainScreen.wolf_name))
			return 50;
		if(name.equals(MainScreen.hydra_name) || name.equals(MainScreen.golem_name))
			return 70;
		if(name.equals(MainScreen.dragon_name))
			return 90;
		return 90;
   }
   private int getCharacterHeight(String name) {
	   if(name.equals(MainScreen.skeleton_name) || name.equals(MainScreen.goblin_name) || name.equals(MainScreen.slime_name) || name.equals(MainScreen.wolf_name))
			return 50;
		if(name.equals(MainScreen.hydra_name) || name.equals(MainScreen.golem_name))
			return 70;
		if(name.equals(MainScreen.dragon_name))
			return 90;
		return 90;
   }
    
}
