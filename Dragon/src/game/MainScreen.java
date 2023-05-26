package game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainScreen extends BasicGameState {
	public StateBasedGame sbg;     // Member variable to store the StateBasedGame object
    public static GameContainer gc;
	//rules
	//each win +1 power and +2 gold
	//each lose spin the bad wheel
	
	//stick 1 power
	//shadow sword 12 power
	//iron sword 5 power
	//
	
	//goblin 1 power
	//slime 3 power each win +2
	//skeleton 4 power
	//hydra 17 power
	
	
    private Map map;
    
    public static String goblin = "/home/ibrahim/Downloads/images/goblin.png";
    public static String goblin_name = "goblin";
    public static String goblin_description = "";
    private Character goblin1,goblin2,goblin3;
    
    private Character slime1;
    public static String slime = "/home/ibrahim/Downloads/images/slime.png";
    public static String slime_name = "slime";
    public static String slime_description = "gain 2 power after each win";
    
    private Character wolf1;
    public static String wolf = "/home/ibrahim/Downloads/images/wolf.png";
    public static String wolf_name = "wolf";
    public static String wolf_description = "";
    
    private Character hydra1;
    public static String hydra = "/home/ibrahim/Downloads/images/hydra.png";
    public static String hydra_name = "hydra";
    public static String hydra_description = "";
    
    private Character golem1;
    public static String golem = "/home/ibrahim/Downloads/images/golem.png";
    public static String golem_name = "golem";
    public static String golem_description = "";
    
    private Character dragon1;
    public static String dragon = "/home/ibrahim/Downloads/images/dragon.png";
    public static String dragon_name = "dragon";
    public static String dragon_description = "";
    
    private Character tower1;
    public static String tower = "/home/ibrahim/Downloads/images/tower.png";
    public static String tower_name = "tower";
    public static String tower_description = "";
    
    private Character skeleton1;
    public static String skeleton = "/home/ibrahim/Downloads/images/skeleton.png";
    public static String skeleton_name = "skeleton";
    public static String skeleton_description = "";
    
    public static String red_potion = "/home/ibrahim/Downloads/images/redpotion.png";
    public static String blue_potion = "/home/ibrahim/Downloads/images/bluepotion.png";
    
    public static String stick = "/home/ibrahim/Downloads/images/stick.png";
    public static String iron_sword = "/home/ibrahim/Downloads/images/iron_sword.png";
    public static String bow = "/home/ibrahim/Downloads/images/bow.png";
    public static String shield = "/home/ibrahim/Downloads/images/shield.png";
    public static String shadow_sword = "/home/ibrahim/Downloads/images/shadow_sword.png";
    public static String knife = "/home/ibrahim/Downloads/images/knife.png";
    public static String mithril_sword = "/home/ibrahim/Downloads/images/mithril_sword.png";
    public static String reward_ring = "/home/ibrahim/Downloads/images/reward_ring.png";
    public static String power_ring = "/home/ibrahim/Downloads/images/power_ring.png";
    public static String gold_ring = "/home/ibrahim/Downloads/images/gold_ring.png";
    public static String scythe = "/home/ibrahim/Downloads/images/scythe.png";
    public static String ball = "/home/ibrahim/Downloads/images/ball.png";
    
    public static String stick_name = "stick";
    public static String iron_sword_name = "iron sword";
    public static String bow_name = "bow";
    public static String shield_name = "shield";
    public static String shadow_sword_name = "shadow sword";
    public static String knife_name = "knife";
    public static String mithril_sword_name = "mithril sword";
    public static String reward_ring_name = "reward ring";
    public static String power_ring_name = "power ring";
    public static String gold_ring_name = "gold ring";
    public static String scythe_name = "scythe";
    public static String ball_name = "ball";
    
    public static int stick_price = 3;
    public static int iron_sword_price = 5;
    public static int bow_price = 7;
    public static int shield_price = 4;
    public static int shadow_sword_price = 11;
    public static int knife_price = 8;
    public static int mithril_sword_price = 25;
    public static int reward_ring_price = 7;
    public static int power_ring_price = 4;
    public static int gold_ring_price = 4;
    public static int scythe_price = 12;
    public static int ball_price = 15;
    
    public static int stick_power = 1;
    public static int iron_sword_power = 4;
    public static int bow_power = 5;
    public static int shield_power = 0;
    public static int shadow_sword_power = 12;
    public static int knife_power = 8;
    public static int mithril_sword_power = 24;
    public static int reward_ring_power = 0;
    public static int power_ring_power = 0;
    public static int gold_ring_power = 4;
    public static int scythe_power = 8;
    public static int ball_power = 10;
    
    public static String stick_description = "just a stick";
    public static String iron_sword_description = "sharp iron sword";
    public static String bow_description = "";
    public static String shield_description = "you don't lose power";
    public static String shadow_sword_description = "a sword from ancient civilazation in the shadow realm";
    public static String knife_description = "a kitchen knife";
    public static String mithril_sword_description = "Forged by Dwarven master craftsmen using the hardest matter in the earth";
    public static String reward_ring_description = "Born from triumph, a champion's coveted reward";
    public static String power_ring_description = "Forged in fire, coveted by the mighty";
    public static String gold_ring_description = "A gleaming circle, wealth's timeless emblem";
    public static String scythe_description = "A sinister harvest, wielded by the reaper";
    public static String ball_description = "A menacing orb, adorned with wicked spikes.";
    
    private Character character;
    private Character character2;
    private Character character3;
    private Character character4;
    private static int character_width = 50, character_height = 50;
    public static List<Character> characters;
    public static List<Character> players;
    public static List<Weapon> items;
    public static boolean drag = false;
    public MainScreen(int state, GameContainer gc2) throws SlickException {
    	super();
    	init(gc2, sbg);
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
    	this.gc = gc;
        map = new Map();
        items = new ArrayList<>();
        
        //adding items)
    
        items.add(new Weapon(stick_name));
        items.add(new Weapon(iron_sword_name));
        items.add(new Weapon(bow_name));
        items.add(new Weapon(shield_name));
        items.add(new Weapon(shadow_sword_name));
        items.add(new Weapon(knife_name));
        items.add(new Weapon(mithril_sword_name));
        items.add(new Weapon(reward_ring_name));
        items.add(new Weapon(power_ring_name));
        items.add(new Weapon(gold_ring_name));
        items.add(new Weapon(scythe_name));
        items.add(new Weapon(ball_name));
        float offset = 70;
        //goblins
        this.goblin1 = new Character(goblin_name, map, map.getLocation(Map.the_road).getCenterX(), map.getLocation(Map.the_road).getCenterY());
        this.goblin2 = new Character(goblin_name, map, map.getLocation(Map.the_cave).getCenterX(), map.getLocation(Map.the_cave).getCenterY());
        this.goblin3 = new Character(goblin_name, map, map.getLocation(Map.monsters_forest_II).getCenterX(), map.getLocation(Map.monsters_forest_II).getCenterY());
        //slime
        this.slime1 = new Character(slime_name, map, map.getLocation(Map.monsters_forest_I).getCenterX(), map.getLocation(Map.monsters_forest_I).getCenterY());
        //wolf
        this.wolf1 = new Character(wolf_name, map, map.getLocation(Map.monsters_forest_III).getCenterX(), map.getLocation(Map.monsters_forest_III).getCenterY());
        //hydra
        this.hydra1 = new Character(hydra_name, map, map.getLocation(Map.the_swamp).getCenterX(), map.getLocation(Map.the_swamp).getCenterY());
        //golem
        this.golem1 = new Character(golem_name, map, map.getLocation(Map.the_abandond_village).getCenterX(), map.getLocation(Map.the_abandond_village).getCenterY());
        //dragon
        this.dragon1 = new Character(dragon_name, map, map.getLocation(Map.the_dragon_nest).getCenterX(), map.getLocation(Map.the_dragon_nest).getCenterY());
        //tower
        this.tower1 = new Character(tower_name, map, map.getLocation(Map.the_tower).getCenterX(), map.getLocation(Map.the_tower).getCenterY());
        //skeleton
        this.skeleton1 = new Character(skeleton_name, map, map.getLocation(Map.the_cave).getCenterX(), map.getLocation(Map.the_cave).getCenterY());
        //characters

        
            	character = new Character(new Image("/home/ibrahim/Downloads/cat.bmp"), "ali", 100, 100, character_width, character_height,map);
                character2 = new Character(new Image("/home/ibrahim/Downloads/cat.bmp"), "omar",100+offset, 100, character_width, character_height,map);
                character3 = new Character(new Image("/home/ibrahim/Downloads/cat.bmp"), "ahmed",100+offset*2, 100, character_width, character_height,map);
                character4 = new Character(new Image("/home/ibrahim/Downloads/cat.bmp"), "salim",100+offset*3, 100, character_width, character_height,map);
            
        characters = new ArrayList<Character>();
        players = new ArrayList<Character>();
        
        //adding to charactersNo OpenGL contextNo OpenGL context found in the current threadNo OpenGL context found in the current threadNo OpenGL context found in the current threadNo OpenGL context found in the current threadNo OpenGL context found in the current threadNo OpenGL context found in the current thread found in the current thread
        characters.add(character);
        characters.add(character2);
        characters.add(character3);
        characters.add(character4);
        players.add(character);
        players.add(character2);
        players.add(character3);
        players.add(character4);
        //adding goblins
        characters.add(goblin1);
        characters.add(goblin2);
        characters.add(goblin3);
        //adding slime
        characters.add(slime1);
        //adding wolf
        characters.add(wolf1);
        //adding hydra
        characters.add(hydra1);
        //adding golem
        characters.add(golem1);
        //adding dragon
        characters.add(dragon1);
        //adding tower
        characters.add(tower1);
        characters.add(skeleton1);
        characters.remove(skeleton1);
        
        // Add mouse and key listeners to the game container

    }
        
    

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
    	Input input = gc.getInput();
        // Render the circles
        map.render(g,input);
        // Render the character
        for(int i = 0; i < characters.size() ; i++) {
        	if(characters.get(i) != null)
        	characters.get(i).render(g, input);
        }
        
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();
        if (input.isKeyPressed(Input.KEY_A)) {
        	addMonsterWindow();
        }
        if(input.isKeyPressed(Input.KEY_P)) {
        	openPotionsWindow(players);
        }
        if(input.isKeyPressed(Input.KEY_B)) {
        	openBountiesWindow(players);
        }
        if(input.isKeyPressed(Input.KEY_Q)) {
        	openEquipmentWindow(items);
        }
        map.update(input, delta);
        for(int i = 0; i < characters.size() ; i++) {
        	if(characters.get(i) != null)
        		characters.get(i).update(input, delta);
        }
    }

    private void addMonsterWindow() {
		
    	// Create the JFrame
        JFrame frame = new JFrame("add Monster Window");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create a JPanel to hold the form components
        JPanel formPanel = new JPanel(new GridLayout(11, 2));

        // Create the JLabels
        JLabel monstersLabel = new JLabel("Monsters:");

        // Create a dropdown list for selecting a weapon
        List<String> monsters = new ArrayList<>();
        monsters.add("None");
        monsters.add(skeleton_name);
        monsters.add(hydra_name);
        JComboBox<String> monstersDropdown = new JComboBox<>(monsters.toArray(new String[0]));
        monstersDropdown.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             // Retrieve the selected weapon name from the dropdown list
             String selectedMonsterName = (String) monstersDropdown.getSelectedItem();
             if(selectedMonsterName.equals("None"))
            	 return;
             // Find the corresponding weapon in the map based on the selected weapon name
             Character selectedMonster = null;
			try {
					selectedMonster = new Character(selectedMonsterName, map, map.getLocation(Map.the_cave).getCenterX(), map.getLocation(Map.the_cave).getCenterY());
					characters.add(selectedMonster);
			} catch (SlickException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
         }
        });

        // Add components to the form panel
        formPanel.add(monstersLabel);
        formPanel.add(monstersDropdown);

        // Add the form panel and description panel to the frame
        frame.add(formPanel, BorderLayout.NORTH);

        // Set frame properties
        frame.pack();
        frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static int getMonsterPower(String selectedMonsterName) {
		if(selectedMonsterName.equals(skeleton_name))
			return 4;
		if(selectedMonsterName.equals(goblin_name))
			return 1;
		if(selectedMonsterName.equals(slime_name))
			return 3;
		if(selectedMonsterName.equals(wolf_name))
			return 5;
		if(selectedMonsterName.equals(hydra_name))
			return 17;
		if(selectedMonsterName.equals(golem_name))
			return 5;
		if(selectedMonsterName.equals(dragon_name))
			return 5;
		return 0;
	}

	public static String getMonsterPath(String selectedMonsterName) {
		
		if(selectedMonsterName.equals(skeleton_name))
			return skeleton;
		if(selectedMonsterName.equals(goblin_name))
			return goblin;
		if(selectedMonsterName.equals(slime_name))
			return slime;
		if(selectedMonsterName.equals(wolf_name))
			return wolf;
		if(selectedMonsterName.equals(hydra_name))
			return hydra;
		if(selectedMonsterName.equals(golem_name))
			return golem;
		if(selectedMonsterName.equals(dragon_name))
			return dragon;
		if(selectedMonsterName.equals(tower_name))
			return tower;
		return null;
	}
	
	public static String getMonsterDescription(String selectedMonsterName) {
		
		if(selectedMonsterName.equals(skeleton_name))
			return skeleton_description;
		if(selectedMonsterName.equals(goblin_name))
			return goblin_description;
		if(selectedMonsterName.equals(slime_name))
			return slime_description;
		if(selectedMonsterName.equals(wolf_name))
			return wolf_description;
		if(selectedMonsterName.equals(hydra_name))
			return hydra_description;
		if(selectedMonsterName.equals(golem_name))
			return golem_description;
		if(selectedMonsterName.equals(dragon_name))
			return dragon_description;
		return null;
	}

	public int getID() {
        return GameApp.MAIN_GAME_SCREEN_ID; // Change this to the appropriate ID for your screen
    }

	public static void removeById(Character character5) {
		
		characters.remove(character5);
		
	}
	
	private void openPotionsWindow(List<Character> characters) {
	    // Create the JFrame for the potions window
	    JFrame potionsFrame = new JFrame("Potions Window");
	    potionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    potionsFrame.setLayout(new BorderLayout());

	    // Create a JPanel to hold the potions, character details, and gold labels
	    JPanel potionsPanel = new JPanel(/*new GridLayout(0, 2, 10, 10)*/new FlowLayout());

	    // Create a JPanel for the first potion
	    JPanel potion1Panel = new JPanel(new BorderLayout());

	    // Create a JLabel for the first potion image
	    ImageIcon imageIcon2 = scaledImage(red_potion);
	    JLabel potion1ImageLabel = new JLabel(imageIcon2);  // Replace "path/to/potion1/image" with the actual path to the image

	    // Create a JLabel for the first potion text
	    JLabel potion1TextLabel = new JLabel("8g: Bad Spin");

	    // Add the first potion image and text to the potion panel
	    potion1Panel.add(potion1ImageLabel, BorderLayout.CENTER);
	    potion1Panel.add(potion1TextLabel, BorderLayout.PAGE_END);

	    // Add the first potion panel to the potions panel
	    potionsPanel.add(potion1Panel);

	    // Create a JPanel for the second potion
	    JPanel potion2Panel = new JPanel(new BorderLayout());

	    // Create a JLabel for the second potion image
	    JLabel potion2ImageLabel = new JLabel(scaledImage(blue_potion));  // Replace "path/to/potion2/image" with the actual path to the image

	    // Create a JLabel for the second potion text
	    JLabel potion2TextLabel = new JLabel("8g: Good Spin");

	    // Add the second potion image and text to the potion panel
	    potion2Panel.add(potion2ImageLabel, BorderLayout.CENTER);
	    potion2Panel.add(potion2TextLabel, BorderLayout.PAGE_END);

	    // Add the second potion panel to the potions panel
	    potionsPanel.add(potion2Panel);

	    // Iterate over the characters list
	    for (Character character : characters) {
	        // Create a JPanel for each character
	        JPanel characterPanel = new JPanel(new GridLayout(2,10,10,10));

	        // Create a JLabel for the character image
	        //JLabel characterImageLabel = new JLabel(new ImageIcon(character.getImage()));  // Replace character.getImage() with the method or field that provides the character's image

	        // Create a JLabel for the character text
	        JLabel characterTextLabel = new JLabel(character.getName());  // Replace character.getName() and character.getDescription() with the appropriate methods or fields

	        // Add the character image and text to the character panel
	        //characterPanel.add(characterImageLabel, BorderLayout.CENTER);
	        characterPanel.add(characterTextLabel);
	        // Create a JLabel for the character's gold
	        JLabel goldLabel = new JLabel("Gold: " + character.getGold());  // Replace character.getGold() with the appropriate method or field

	        // Add the gold label to the potions panel
	        characterPanel.add(goldLabel);

	        // Add the character panel to the potions panel
	        potionsPanel.add(characterPanel);

	        
	    }

	    // Add the potions panel to the potions frame
	    potionsFrame.add(potionsPanel, BorderLayout.CENTER);

	    // Set frame properties
	    potionsFrame.pack();
	    potionsFrame.setLocationRelativeTo(null); // Center the frame on the screen
	    potionsFrame.setVisible(true);
	}
	
	private void openBountiesWindow(List<Character> characters) {
	    // Create the JFrame for the potions window
	    JFrame potionsFrame = new JFrame("Bounties Window");
	    potionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    potionsFrame.setLayout(new BorderLayout());

	    // Create a JPanel to hold the potions, character details, and gold labels
	    JPanel potionsPanel = new JPanel(/*new GridLayout(0, 2, 10, 10)*/new FlowLayout());

	    for (Character character : characters) {
	        // Create a JPanel for each character
	        JPanel characterPanel = new JPanel(new GridLayout(2,10,10,10));

	        // Create a JLabel for the character image
	        //JLabel characterImageLabel = new JLabel(new ImageIcon(character.getImage()));  // Replace character.getImage() with the method or field that provides the character's image

	        // Create a JLabel for the character text
	        JLabel characterTextLabel = new JLabel(character.getName());  // Replace character.getName() and character.getDescription() with the appropriate methods or fields

	        // Add the character image and text to the character panel
	        //characterPanel.add(characterImageLabel, BorderLayout.CENTER);
	        characterPanel.add(characterTextLabel);
	        // Create a JLabel for the character's gold
	        JLabel goldLabel = new JLabel("bounty: " + character.getGold()/1.5);  // Replace character.getGold() with the appropriate method or field

	        // Add the gold label to the potions panel
	        characterPanel.add(goldLabel);

	        // Add the character panel to the potions panel
	        potionsPanel.add(characterPanel);

	        
	    }
	    
	    JPanel seperatePanel = new JPanel(new GridLayout(4,1,10,10));
	    seperatePanel.add(new JLabel("|"));
	    seperatePanel.add(new JLabel("|"));
	    seperatePanel.add(new JLabel("|"));
	    seperatePanel.add(new JLabel("|"));
	    potionsPanel.add(seperatePanel);
	    // Iterate over the characters list
	    for (Character character : characters) {
	        // Create a JPanel for each character
	        JPanel characterPanel = new JPanel(new GridLayout(2,10,10,10));

	        // Create a JLabel for the character image
	        //JLabel characterImageLabel = new JLabel(new ImageIcon(character.getImage()));  // Replace character.getImage() with the method or field that provides the character's image

	        // Create a JLabel for the character text
	        JLabel characterTextLabel = new JLabel(character.getName());  // Replace character.getName() and character.getDescription() with the appropriate methods or fields

	        // Add the character image and text to the character panel
	        //characterPanel.add(characterImageLabel, BorderLayout.CENTER);
	        characterPanel.add(characterTextLabel);
	        // Create a JLabel for the character's gold
	        JLabel goldLabel = new JLabel("Gold: " + character.getGold());  // Replace character.getGold() with the appropriate method or field

	        // Add the gold label to the potions panel
	        characterPanel.add(goldLabel);

	        // Add the character panel to the potions panel
	        potionsPanel.add(characterPanel);

	        
	    }

	    // Add the potions panel to the potions frame
	    potionsFrame.add(potionsPanel, BorderLayout.CENTER);

	    // Set frame properties
	    potionsFrame.pack();
	    potionsFrame.setLocationRelativeTo(null); // Center the frame on the screen
	    potionsFrame.setVisible(true);
	}
	
	public void openEquipmentWindow(List<Weapon> items) {
	    // Create the JFrame
	    JFrame frame = new JFrame("Equipment Window");
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setLayout(new BorderLayout());
	    frame.setPreferredSize(new Dimension(900, 500));

	    // Create a JPanel to hold the equipment items
	    JPanel itemsPanel = new JPanel(new GridLayout(items.size(), 4));
	    //itemsPanel.setPreferredSize(new Dimension(900, 500));

	    // Create JLabels for each item
	    for (Weapon item : items) {
	    	int item_width_image = 150;
	    	int item_height_image = 150;
	    	int item_width = 50;
	    	int item_height = 50;
	        // Create a JLabel for the item's image
	        JLabel imageLabel = new JLabel(scaledImage50(getItemPath(item.getName())));
	        // Create a JLabel for the item's name
	        JLabel nameLabel = new JLabel(item.getName());
	        Border border = BorderFactory.createLineBorder(java.awt.Color.BLACK, 2);
	        
	        imageLabel.setBorder(border);
	        imageLabel.setPreferredSize(new Dimension(item_width_image,item_height_image));
	        
	        nameLabel.setBorder(border);
	        nameLabel.setPreferredSize(new Dimension(item_width,item_height));
	        nameLabel.setMinimumSize(new Dimension(item_width,item_height));
	        JLabel descriptionLabel = makeLabel(item.getDescription());
	        descriptionLabel.setBorder(border);
	        descriptionLabel.setPreferredSize(new Dimension(item_width_image,item_height_image));
	        
	        JLabel powerLabel = new JLabel("power: "+item.getPower());
	        powerLabel.setBorder(border);
	        powerLabel.setPreferredSize(new Dimension(item_width,item_height));
	        powerLabel.setMinimumSize(new Dimension(item_width,item_height));
	        JLabel priceLabel = new JLabel("price"+item.getPrice());
	        priceLabel.setBorder(border);
	        priceLabel.setPreferredSize(new Dimension(item_width,item_height));
	        priceLabel.setMinimumSize(new Dimension(item_width,item_height));

	        // Add the image label and name label to the items panel
	        itemsPanel.add(imageLabel);
	        itemsPanel.add(nameLabel);
	        itemsPanel.add(powerLabel);
	        itemsPanel.add(priceLabel);
	        itemsPanel.add(descriptionLabel);
	    }
	    
	    JPanel playerGoldPanel = new JPanel(/*new GridLayout(0, 2, 10, 10)*/new FlowLayout());
	    
	    for (Character character : players) {
	        // Create a JPanel for each character
	        JPanel characterPanel = new JPanel(new GridLayout(2,10,10,10));

	        // Create a JLabel for the character image
	        //JLabel characterImageLabel = new JLabel(new ImageIcon(character.getImage()));  // Replace character.getImage() with the method or field that provides the character's image

	        // Create a JLabel for the character text
	        JLabel characterTextLabel = new JLabel(character.getName());  // Replace character.getName() and character.getDescription() with the appropriate methods or fields

	        // Add the character image and text to the character panel
	        //characterPanel.add(characterImageLabel, BorderLayout.CENTER);
	        characterPanel.add(characterTextLabel);
	        // Create a JLabel for the character's gold
	        JLabel goldLabel = new JLabel("Gold: " + character.getGold());  // Replace character.getGold() with the appropriate method or field

	        // Add the gold label to the potions panel
	        characterPanel.add(goldLabel);

	        // Add the character panel to the potions panel
	        playerGoldPanel.add(characterPanel);

	        
	    }

	    JScrollPane scrollPane = new JScrollPane(itemsPanel);

	    // Set scroll pane properties
	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    
	    // Add the items panel and gold label to the frame
	    frame.add(scrollPane, BorderLayout.CENTER);
	    frame.add(playerGoldPanel, BorderLayout.SOUTH);

	    // Set frame properties
	    frame.pack();
	    frame.setLocationRelativeTo(null); // Center the frame on the screen
	    frame.setVisible(true);
	}


	private JLabel makeLabel(String description) {
		JLabel label = new JLabel("<html>"+ description+ "</html>");
		label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.CENTER);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        return label;
	}

	private String getItemPath(String name) {
		if(name.equals(stick_name))
			return stick;
		if(name.equals(iron_sword_name))
			return iron_sword;
		if(name.equals(bow_name))
			return bow;
		if(name.equals(shield_name))
			return shield;
		if(name.equals(shadow_sword_name))
			return shadow_sword;
		if(name.equals(knife_name))
			return knife;
		if(name.equals(mithril_sword_name))
			return mithril_sword;
		if(name.equals(reward_ring_name))
			return reward_ring;
		if(name.equals(power_ring_name))
			return power_ring;
		if(name.equals(gold_ring_name))
			return gold_ring;
		if(name.equals(scythe_name))
			return scythe;
		if(name.equals(ball_name))
			return ball;
		return null;
	}

	private ImageIcon scaledImage(String goblin4) {
		ImageIcon imageIcon2 = new ImageIcon(goblin4);
	    java.awt.Image image2 = imageIcon2.getImage(); // transform it 
	    java.awt.Image newimg2 = image2.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	    imageIcon2 = new ImageIcon(newimg2);
		return imageIcon2;
	}
	private ImageIcon scaledImage50(String goblin4) {
		ImageIcon imageIcon2 = new ImageIcon(goblin4);
	    java.awt.Image image2 = imageIcon2.getImage(); // transform it 
	    java.awt.Image newimg2 = image2.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	    imageIcon2 = new ImageIcon(newimg2);
		return imageIcon2;
	}

	public static Weapon getWeaponByName(String name) {
  for (Item item : items) {
      if (item instanceof Weapon && item.getName().equals(name)) {
          return (Weapon) item;
      }
  }
  return null; // Return null if the weapon with the specified name is not found
}

	 public static List<String> getWeaponNames() {
     List<String> weaponNames = new ArrayList<>();
     for (Item item : items) {
         if (item instanceof Weapon) {
             Weapon weapon = (Weapon) item;
             weaponNames.add(weapon.getName());
         }
     }
     return weaponNames;
 }

	public static int getWeaponPower(String name) {
		if(name.equals(stick_name))
			return stick_power;
		if(name.equals(iron_sword_name))
			return iron_sword_power;
		if(name.equals(bow_name))
			return bow_power;
		if(name.equals(shield_name))
			return shield_power;
		if(name.equals(shadow_sword_name))
			return shadow_sword_power;
		if(name.equals(knife_name))
			return knife_power;
		if(name.equals(mithril_sword_name))
			return mithril_sword_power;
		if(name.equals(reward_ring_name))
			return reward_ring_power;
		if(name.equals(power_ring_name))
			return power_ring_power;
		if(name.equals(gold_ring_name))
			return gold_ring_power;
		if(name.equals(scythe_name))
			return scythe_power;
		if(name.equals(ball_name))
			return ball_power;
		return 0;
	}

	public static int getWeaponPrice(String name) {
		if(name.equals(stick_name))
			return stick_price;
		if(name.equals(iron_sword_name))
			return iron_sword_price;
		if(name.equals(bow_name))
			return bow_price;
		if(name.equals(shield_name))
			return shield_price;
		if(name.equals(shadow_sword_name))
			return shadow_sword_price;
		if(name.equals(knife_name))
			return knife_price;
		if(name.equals(mithril_sword_name))
			return mithril_sword_price;
		if(name.equals(reward_ring_name))
			return reward_ring_price;
		if(name.equals(power_ring_name))
			return power_ring_price;
		if(name.equals(gold_ring_name))
			return gold_ring_price;
		if(name.equals(scythe_name))
			return scythe_price;
		if(name.equals(ball_name))
			return ball_price;
		return 0;
	}

	public static String getWeaponDescripton(String name) {
		if(name.equals(stick_name))
			return stick_description;
		if(name.equals(iron_sword_name))
			return iron_sword_description;
		if(name.equals(bow_name))
			return bow_description;
		if(name.equals(shield_name))
			return shield_description;
		if(name.equals(shadow_sword_name))
			return shadow_sword_description;
		if(name.equals(knife_name))
			return knife_description;
		if(name.equals(mithril_sword_name))
			return mithril_sword_description;
		if(name.equals(reward_ring_name))
			return reward_ring_description;
		if(name.equals(power_ring_name))
			return power_ring_description;
		if(name.equals(gold_ring_name))
			return gold_ring_description;
		if(name.equals(scythe_name))
			return scythe_description;
		if(name.equals(ball_name))
			return ball_description;
		return null;
	}

	public static String getWeaponPath(String name) {
		if(name.equals(stick_name))
			return stick;
		if(name.equals(iron_sword_name))
			return iron_sword;
		if(name.equals(bow_name))
			return bow;
		if(name.equals(shield_name))
			return shield;
		if(name.equals(shadow_sword_name))
			return shadow_sword;
		if(name.equals(knife_name))
			return knife;
		if(name.equals(mithril_sword_name))
			return mithril_sword;
		if(name.equals(reward_ring_name))
			return reward_ring;
		if(name.equals(power_ring_name))
			return power_ring;
		if(name.equals(gold_ring_name))
			return gold_ring;
		if(name.equals(scythe_name))
			return scythe;
		if(name.equals(ball_name))
			return ball;
		return null;
	}

     
}
