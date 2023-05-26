package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterWindow {
    private JFrame frame;
    private Character character;
	private Map map;
   

    public CharacterWindow(Character character,Map map) {
        this.character = character;
        this.map = map;
        createWindow(character);
    }

    private void createWindow(Character character) {
        // Create the JFrame
        frame = new JFrame("Character Window");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create a JPanel to hold the form components
        JPanel formPanel = new JPanel(new GridLayout(13, 2));

        // Create the JLabels
        JLabel nameLabel = new JLabel("Name:");
        JLabel mainPowerLabel = new JLabel("Main Power:");
        JLabel mainWeaponPowerLabel = new JLabel("Main Weapon Power:");
        JLabel effectsPowerLabel = new JLabel("Effects Power:");
        JLabel goldLabel = new JLabel("Gold:");
        JLabel AllPowerLabel = new JLabel("Over All Power: "+character.overAllPower());
        JLabel mapItemsLabel = new JLabel("map items:");
        JLabel characterItemsLabel = new JLabel("character items:");
        JLabel shopItemsLabel = new JLabel("shop items:");
        JLabel characterItemsshopLabel = new JLabel("character items shop:");
        JLabel space = new JLabel("");

        // Create the JTextFields
        JTextField nameField = new JTextField(character.getName());
        nameField.setEditable(false);

        // Create the JSpinners for numeric attributes
        JSpinner mainPowerSpinner = new JSpinner(new SpinnerNumberModel(character.getMainPower(), 0, 100, 1));
        JSpinner mainWeaponPowerSpinner = new JSpinner(new SpinnerNumberModel(character.getMainWeaponPower(), 0, 100, 1));
        JSpinner effectsPowerSpinner = new JSpinner(new SpinnerNumberModel(character.getEffectsPower(), 0, 100, 1));
        JSpinner goldSpinner = new JSpinner(new SpinnerNumberModel(character.getGold(), 0, Integer.MAX_VALUE, 1));

        // Create the JTextArea for the description attribute
        JTextArea descriptionArea = new JTextArea(character.getDescription(), 4, 20);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);

        // Update the character attributes when the spinner values change
        mainPowerSpinner.addChangeListener(e -> {
            character.setMainPower((int) mainPowerSpinner.getValue());
            AllPowerLabel.setText("Over All Power: "+character.overAllPower());
            frame.revalidate();
            frame.repaint();
        });

        mainWeaponPowerSpinner.addChangeListener(e -> {
            character.setMainWeaponPower((int) mainWeaponPowerSpinner.getValue());
            AllPowerLabel.setText("Over All Power: "+character.overAllPower());
            frame.revalidate();
            frame.repaint();
        });

        effectsPowerSpinner.addChangeListener(e -> {
            character.setEffectsPower((int) effectsPowerSpinner.getValue());
            AllPowerLabel.setText("Over All Power: "+character.overAllPower());
            frame.revalidate();
            frame.repaint();
        });

        goldSpinner.addChangeListener(e -> {
            character.setGold((int) goldSpinner.getValue());
            frame.revalidate();
            frame.repaint();
        });
     // In the CharacterWindow class

     // Create a button for adding an item
     // In the CharacterWindow class
        JLabel itemsLabel = new JLabel("\nItems:\n");
        
        String itemsText = "<html>Items:<br>";
        for (Item item : character.getItems()) {
            itemsText += item.special() + "<br>";
        }
        itemsText += "</html>";
        itemsLabel.setText(itemsText);

     // Create a dropdown list for selecting a weapon
     JComboBox<String> weaponDropdown = new JComboBox<>(map.getWeaponNames().toArray(new String[0]));
     weaponDropdown.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             // Retrieve the selected weapon name from the dropdown list
             String selectedWeaponName = (String) weaponDropdown.getSelectedItem();

             // Find the corresponding weapon in the map based on the selected weapon name
             Weapon selectedWeapon = map.getWeaponByName(selectedWeaponName);

             // Remove the selected weapon from the map
             map.removeItem(selectedWeapon);

             // Add the selected weapon to the character's backpack
             character.addItemToBackpack(selectedWeapon);
             refresh();
         }
     });
     
     JComboBox<String> mainweaponDropdown = new JComboBox<>(character.getWeaponNames().toArray(new String[0]));
     mainweaponDropdown.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             // Retrieve the selected weapon name from the dropdown list
             String selectedWeaponName = (String) mainweaponDropdown.getSelectedItem();

             // Find the corresponding weapon in the map based on the selected weapon name
             Weapon selectedWeapon = character.getWeaponByName(selectedWeaponName);

             // Remove the selected weapon from the map

             // Add the selected weapon to the character's backpack
             character.main_Weapon = selectedWeapon;
             refresh();
         }
     });
     
     
     
     JComboBox<String> removeItemDropdown = new JComboBox<>(character.getItemNamesmap().toArray(new String[0]));
     removeItemDropdown.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             // Retrieve the selected item name from the dropdown list
             String selectedItemName = (String) removeItemDropdown.getSelectedItem();

             // Find the corresponding item in the character's items based on the selected item name
             Item selectedItem = character.getItemByNamemap(selectedItemName);

             // Remove the selected item from the character's items
             character.removeItem(selectedItem);

             // Add the selected item back to the map
             map.items.add(selectedItem);
             selectedItem.special();

             // Update the character window
             refresh();
         }
     });


     JComboBox<String> shopWeaponDropdown = new JComboBox<>(MainScreen.getWeaponNames().toArray(new String[0]));
     shopWeaponDropdown.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             // Retrieve the selected weapon name from the dropdown list
             String selectedWeaponName = (String) shopWeaponDropdown.getSelectedItem();

             // Find the corresponding weapon in the map based on the selected weapon name
             Weapon selectedWeapon = MainScreen.getWeaponByName(selectedWeaponName);

             // Remove the selected weapon from the map

             // Add the selected weapon to the character's backpack
             character.addItemToBackpackShop(selectedWeapon);
             refresh();
         }
     });
     
     
     JComboBox<String> shopremoveItemDropdown = new JComboBox<>(character.getItemNamesshop().toArray(new String[0]));
     shopremoveItemDropdown.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             // Retrieve the selected item name from the dropdown list
             String selectedItemName = (String) shopremoveItemDropdown.getSelectedItem();

             // Find the corresponding item in the character's items based on the selected item name
             Item selectedItem = character.getItemByNameshop(selectedItemName);

             // Remove the selected item from the character's items
             character.removeItemshop(selectedItem);

             // Add the selected item back to the map
             selectedItem.special();

             // Update the character window
             refresh();
         }
     });

        // Add components to the form panel
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(mainPowerLabel);
        formPanel.add(mainPowerSpinner);
        formPanel.add(mainWeaponPowerLabel);
        formPanel.add(mainWeaponPowerSpinner);
        formPanel.add(effectsPowerLabel);
        formPanel.add(effectsPowerSpinner);
        formPanel.add(goldLabel);
        formPanel.add(goldSpinner);
        formPanel.add(AllPowerLabel);
        formPanel.add(space);
        //map items
        formPanel.add(mapItemsLabel);
        formPanel.add(weaponDropdown);
        //shop items
        formPanel.add(shopItemsLabel);
        formPanel.add(shopWeaponDropdown);
        //character items
        formPanel.add(characterItemsLabel);
        formPanel.add(mainweaponDropdown);
        //remove item
        formPanel.add(new JLabel("Remove Item:"));
        formPanel.add(removeItemDropdown);
        //remove item shop
        formPanel.add(new JLabel("Remove Item shop:"));
        formPanel.add(shopremoveItemDropdown);
      //items show
        formPanel.add(itemsLabel);

        // Create a JPanel for the description field
        JPanel descriptionPanel = new JPanel(new BorderLayout());
        descriptionPanel.setBorder(BorderFactory.createTitledBorder("Description"));
        descriptionPanel.add(descriptionScrollPane, BorderLayout.CENTER);

        // Add the form panel and description panel to the frame
        frame.add(formPanel, BorderLayout.NORTH);
        frame.add(descriptionPanel, BorderLayout.CENTER);

        // Set frame properties
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame on the screen
    }


    public void open() {
    	createWindow(this.character);
        frame.setVisible(true);
        character.isCharacterWindowOpen = true;
    }

    public void close() {
        frame.setVisible(false);
        character.isCharacterWindowOpen = false;
    }
    
    public void refresh() {
    	frame.setVisible(false);
    	createWindow(this.character);
    	frame.setVisible(true);
    }
}

