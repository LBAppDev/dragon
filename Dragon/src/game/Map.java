package game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<Location> locations;
    public List<Item> items;

    public static String village = "Village", the_shadow_forest = "the shadow forest", the_deep_of_the_SF = "the deep of the SF", the_shadow_realm = "the shadow realm",
    		deep_in_the_SR = "deep in the SR", the_road = "the road", monsters_forest_I = "monsters forest I", monsters_forest_II = "monsters forest II",
    		monsters_forest_III = "monsters forest III", deep_of_the_MF = "deep of the MF", the_cave = "the cave", the_swamp = "the swamp",
    		the_abandond_village = "the abandond village", the_dragon_nest = "the dragon's nest", the_tower = "the Tower";
    
    public Map() {
        locations = new ArrayList<Location>();
        items = new ArrayList<>();

        // Create the locations
        createLocations();
        try {
			Weapon w1 = new Weapon(MainScreen.shadow_sword_name, getLocation(the_shadow_realm).getCenterX() - Item.width, getLocation(the_shadow_realm).getCenterY() - Item.height/2);
			Weapon w2 = new Weapon(MainScreen.stick_name, getLocation(the_deep_of_the_SF).getCenterX() - Item.width, getLocation(the_deep_of_the_SF).getCenterY() - Item.height/2);
			Weapon w3 = new Weapon(MainScreen.stick_name, getLocation(monsters_forest_I).getCenterX() - Item.width, getLocation(monsters_forest_I).getCenterY() - Item.height/2);
			Weapon w4 = new Weapon(MainScreen.bow_name, getLocation(monsters_forest_III).getCenterX() - Item.width, getLocation(monsters_forest_III).getCenterY() - Item.height/2);
			
			items.add(w1);
			items.add(w2);
			items.add(w3);
			items.add(w4);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

	private void createLocations() {
		float radius = 50.0f; // Adjust the radius as needed
        float spacingX = 220.0f; // Adjust the spacing between circles as needed
        float spacingY = 180.0f;

        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 5; col++) {
                float x = col * spacingX;
                float y = row * spacingY;
                String name = "Location " + row + "-" + col;
                if(name.equals("Location 1-1")) {
                	name = village;
                }else if(name.equals("Location 1-2")) {
                	name = the_shadow_forest;
                }else if(name.equals("Location 1-3")) {
                	name = the_deep_of_the_SF;
                }else if(name.equals("Location 1-4")) {
                	name = the_shadow_realm;
                }else if(name.equals("Location 1-5")) {
                	name = deep_in_the_SR;
                }else if(name.equals("Location 2-1")) {
                	name = the_road;
                }else if(name.equals("Location 2-2")) {
                	name = monsters_forest_I;
                }else if(name.equals("Location 2-3")) {
                	name = monsters_forest_II;
                }else if(name.equals("Location 2-4")) {
                	name = monsters_forest_III;
                }else if(name.equals("Location 2-5")) {
                	name = deep_of_the_MF;
                }else if(name.equals("Location 3-1")) {
                	name = the_cave;
                }else if(name.equals("Location 3-2")) {
                	name = the_swamp;
                }else if(name.equals("Location 3-3")) {
                	name = the_abandond_village;
                }else if(name.equals("Location 3-4")) {
                	name = the_dragon_nest;
                }else if(name.equals("Location 3-5")) {
                	name = the_tower;
                }

                Location location = new Location(x, y, radius, name);
                locations.add(location);
            }
        }
	}

    public void render(Graphics g, Input input) {
        for (Location location : locations) {
            location.render(g);
        }
        for (Item item : items) {
            item.render(g, input);
        }
        drawArrow(g,monsters_forest_I, the_shadow_forest, true);
        drawArrow(g,monsters_forest_II, the_deep_of_the_SF, true);
        drawArrow(g,the_deep_of_the_SF, the_shadow_realm, true);
        drawArrow(g,the_abandond_village, the_dragon_nest, true);
        drawArrow(g,the_dragon_nest, the_tower, true);
        
        drawArrow(g,village, the_shadow_forest, false);
        drawArrow(g,the_shadow_forest, the_deep_of_the_SF, false);
        drawArrow(g,the_deep_of_the_SF, deep_of_the_MF, false);
        drawArrow(g,village, the_road, false);
        drawArrow(g,the_road, monsters_forest_I, false);
        drawArrow(g,monsters_forest_I, monsters_forest_II, false);
        drawArrow(g,monsters_forest_II, monsters_forest_III, false);
        drawArrow(g,monsters_forest_III, deep_of_the_MF, false);
        drawArrow(g,the_road, the_cave, false);
        drawArrow(g,the_cave, the_swamp, false);
        drawArrow(g,the_swamp, monsters_forest_I, false);
        drawArrow(g,the_swamp, monsters_forest_II, false);
        drawArrow(g,the_swamp, the_abandond_village, false);
        
        
        
    }
    
    public List<Location> getLocations(){
    	return locations;
    }
    
    public void drawArrow(Graphics g, String start, String end, boolean oneway) {
    	Location startL = getLocation(start);
    	Location endL = getLocation(end);
    	drawArrow(g, startL.getCenterX(), startL.getCenterY(), endL.getCenterX(), endL.getCenterY(), oneway);
    	if(!oneway)
    		drawArrow(g, endL.getCenterX(), endL.getCenterY(), startL.getCenterX(), startL.getCenterY(), oneway);
    }
    
    public void drawArrow(Graphics g, float x1, float y1, float x2, float y2, boolean oneway) {
        // Calculate the angle between the two points
        float angle = (float) Math.atan2(y2 - y1, x2 - x1);

        // Set the color and line width for the arrow
        g.setColor(Color.cyan);
        g.setLineWidth(2.0f);

        // Calculate the coordinates of the arrow tip
        float tipX = x2 - (float) Math.cos(angle) * 10.0f;
        float tipY = y2 - (float) Math.sin(angle) * 10.0f;

        // Draw the arrow body as a line segment
        g.drawLine(x1, y1, tipX, tipY);

        // Create the arrow tip as a filled triangle
        Polygon arrowTip = new Polygon();
        arrowTip.addPoint(tipX, tipY);
        arrowTip.addPoint(tipX - 8.0f, tipY - 4.0f);
        arrowTip.addPoint(tipX - 8.0f, tipY + 4.0f);

        // Draw and fill the arrow tip triangle
        if(oneway) {
        	g.setColor(Color.red);
        }
        
        g.fill(arrowTip);
    }

    public void update(Input input, int delta) {
        for (Item item : items) {
            item.update(input, delta);
        }
    }

    
    public Location getLocation(String name) {
    	for(Location location: locations) {
    		if(location.getName().equals(name)) {
    			return location;
    		}
    	}
    	return null;
    }
    
    public void addItem(Item item) {
        items.add(item);
    }
    
    public void removeItem(Item item) {
        items.remove(item);
    }
    
 // In the Map class

 // Add a method to retrieve a list of weapon names
 public List<String> getWeaponNames() {
     List<String> weaponNames = new ArrayList<>();
     for (Item item : items) {
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
  for (Item item : items) {
      if (item instanceof Weapon && item.getName().equals(name)) {
          return (Weapon) item;
      }
  }
  return null; // Return null if the weapon with the specified name is not found
}

public Location getLocationByName(String name) {
	for(Location location: locations) {
		if(location.getName().equals(name)) {
			return location;
		}
	}
	return null;
}


    
}



