import javax.swing.*;
import java.util.ArrayList;

public class Character {

    private int playerClass; //Classes 0-2, 0 = swordsman, 1 = archer, 2 = mage
    private int coins;
    private int dmg; // needs to be set  i don't like your arrays so you do it
    private int hitPoint = 100;
    private int maxHp = hitPoint;
    private int armorRating; // needs to be set  i don't like your arrays so you do it
    private static Object[][] inventory = new Object[20][2]; //[20 inv slots.] [Name, number]
    private Object[][] armor = new Object[4][2]; //[4 armor slots] [Name, protection]
    private Object[] weapon = new Object[2]; //[Name, damage]
    //armor names should be structured like: Material (Iron), Piece (Helmet), Armor
    private String[] armorPieces = {"Helmet", "Chestplate", "Leggings", "Boots"}; //4 armor pieces
    private String[] weapons = {"Sword", "Bow", "Wand"};
    private Object[] defaultEmpty = {"EMPTY", 0};


    public Character(){ //defaults
        playerClass = 0;
        coins = 0;
        for (int i = 0; i < inventory.length; i++) { //inventory
            inventory[i] = defaultEmpty;
        }
        for (int i = 0; i < armor.length; i++){
            armor[i] = defaultEmpty;
        }
    }


    public void setPlayerClass(int c){
        playerClass = c;
        if (c == 0){
            addInventory("Basic Shortsword", 5);
        }else if (c == 1){
            addInventory("Basic Shortbow", 5);
        }else if (c == 2){
            addInventory("Basic Wand", 5);
        }else
            System.out.println("Error when selecting class. Does not exist!");
    }
    public void addCoins(int c){
        coins = coins + c;
    }
    public boolean addInventory(String name, int number){
        boolean itemPlaced = false;
        for (int i = 0; i < inventory.length; i++){ //go thru all inventory items
            if (!itemPlaced) {
                if (inventory[i][0].equals(name) && !inventory[i][0].toString().toLowerCase().contains("armor")) {
                    //if the item at i slot is the same as the one being added, and does not contain armor
                    int num2 = Integer.parseInt(String.valueOf(inventory[i][1])); //current number of items in inv
                    Object[] inventoryItem = {name, number + num2}; //add them together and
                    inventory[i] = inventoryItem; //put them in the slot
                    itemPlaced = true;
                } else if (inventory[i][1].equals(0)) { //else if the item is not found find new unused slot
                    Object[] inventoryItem = {name, number};
                    inventory[i] = inventoryItem; //add the item there
                    itemPlaced = true;
                }
            }
        }
        return itemPlaced;
    }
    public Object[] equip(String name, int prot){

        Object[] prev = defaultEmpty;

        for (int i = 0; i < armor.length; i++){
            if (name.contains(armorPieces[i])){ //checks name of item to put in correct slot
                prev = armor[i]; //saves item in that slot so it can be returned to inv
                Object[] curr = {name, prot};
                armor[i] = curr;
                System.out.println(name + " added to " + armorPieces[i]);
                System.out.println(getArmorString());
            }
        }
        armorRating = 0;
        for (int a = 0; a < armor.length; a++){
            armorRating = armorRating + (int)armor[a][1];
            System.out.println(armorRating);
        }
        if (name.contains(weapons[0])||name.contains(weapons[1])||name.contains(weapons[2])){ //checks if it is a weapon
            prev = weapon; //saves item in that slot so it can be returned to inv
            Object[] curr = {name, prot};
            weapon = curr;
            dmg = prot;
            System.out.println(name + " added to weapon slot");
            System.out.println(weapon[0].toString() + " [" + weapon[1].toString() + "]");
        }
        return prev; //return the previously worn armor so it isn't deleted and can be put in the inv
    }

    public int getPlayerClass() {
        return playerClass;
    }

    public int getCoins() {
        return coins;
    }

    public static Object[][] getInventory(){
        return inventory;
    }
    public Object[][] getArmor(){
        return armor;
    }
    public String getInvString(){
        StringBuilder inv = new StringBuilder();
        int i = 0;
        for (Object[] s : inventory){ //for each object in inv
            String num = s[1].toString();
            if (num.equals("0")) { //if the slot is empty
                if (i == 0) //and is the first slot
                    return "Inventory is empty";
                inv.replace(inv.length()-2, inv.length(), "."); //replace last two chars "; " with "."
                return inv.toString();
            }
            inv.append(s[0] + " (" + s[1] + ")"); //add the item to the string in this format: "itemName (num)"
            ++i;
            if (i < inventory.length){
                inv.append("; "); //separate each item with "; "
            }
            if (i == inventory.length){
                inv.append("."); //end with "."
            } else if ((i%5) == 0){
                inv.append("\n"); //add new line every 5 items, but not after the last one
            }
        }
        return inv.toString();
    }
    public String getArmorString(){
        StringBuilder arm = new StringBuilder();
        int i = 0;
        for (Object[] a : armor){ //for each object in inv
            String num = a[1].toString();
            if (num.equals("0")) //if the slot is empty
                arm.append(armorPieces[i] + " slot is empty"); //say the slot is empty
            else
                arm.append(a[0] + " (" + a[1] + ")"); //add the item to the string in this format: "itemName (prot);"
            ++i;
            if (i < inventory.length)
                arm.append(";\n"); //separate each item with ";" and a new line
            else if (i == inventory.length)
                arm.append("."); //end with "."
        }
        return arm.toString();
    }
    public ArrayList<Object[]> getEquipables(){
        ArrayList<Object[]> equipables = new ArrayList<>();
        for (Object[] i : inventory){
            String itemName = i[0].toString();
            if (itemName.contains("Armor")||itemName.contains("Catalyst")||itemName.contains("Sword")||
                    itemName.contains("Bow")||itemName.contains("Wand")||itemName.contains("Helmet")||
                    itemName.contains("Chestplate")||itemName.contains("Leggings")||itemName.contains("Boots")){
                equipables.add(i);
            }
        }
        return equipables; //equ[3]
    }
    public boolean displayInv(){
        String inv = getInvString();
        String[] options = {"Close", "Equip"};
        int choice = JOptionPane.showOptionDialog(null, inv, "Inventory", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, null);
        if (choice == 1){
            ArrayList<Object[]> equipables = getEquipables();
            boolean acceptableValue = false;
            do{
                try {
                    int equipItem = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Type the number corresponding to the item you wish to equip:\n" + convert(equipables)));
                    equip(equipables.get(equipItem)[0].toString(), (int)equipables.get(equipItem)[1]);
                    acceptableValue = true;
                }catch(NumberFormatException|IndexOutOfBoundsException e){
                    System.out.println(e);
                }

            }while(!acceptableValue);
            return true;
        }
        return false;
    }
    public void defend(Enemys monster){
        int attackStrength = monster.attack();
        if (attackStrength - armorRating <= 0){
            JOptionPane.showMessageDialog(null, "You took 0 dmg");
        }else {
            hitPoint = (hitPoint > (attackStrength - armorRating)) ? hitPoint - (attackStrength - armorRating) : 0;
            JOptionPane.showMessageDialog(null, "You took " + (attackStrength - armorRating) + " dmg");
            if (hitPoint <= 0) {
                Score.End();
            }
        }
    }
    public int attack(){
        return dmg;
    }
    public boolean isAlive(){
        return hitPoint > 0;
    }
    public String convert(ArrayList<Object[]> a){
        StringBuilder s = new StringBuilder();
        int i = 0;
        for (Object[] n : a){
            s.append(i + ": " + n[0].toString() + " [" + n[1].toString() + "], ");
            i++;
        }
        return s.toString();
    }
}
