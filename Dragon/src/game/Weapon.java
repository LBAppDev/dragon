package game;

import org.newdawn.slick.SlickException;

public class Weapon extends Item{
	
    private int power;
    private int price;


    public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	/*public Weapon(String name, int power, int price, String description, String imagePath, float x, float y) throws SlickException {
        super(name, description,new Image(imagePath),x,y);
        this.power = power;
        this.price = price;
    }
    
    public Weapon(String name, int power, int price, String description) throws SlickException {
        super(name, description);
        this.power = power;
        this.price = price;
    }*/
    
    public Weapon(String name) throws SlickException {
        super(name);
        this.power = MainScreen.getWeaponPower(name);
        this.price = MainScreen.getWeaponPrice(name);
    }
    
    public Weapon(String name, float x, float y) throws SlickException {
        super(name, x, y);
        this.power = MainScreen.getWeaponPower(name);
        this.price = MainScreen.getWeaponPrice(name);
    }


    public int getPower() {
        return power;
    }


	@Override
	public String special() {
		return getName() + "(" + power +")";
	}


	public void setPower(int value) {
		// TODO Auto-generated method stub
		power = value;
	}
    
    

    
}

