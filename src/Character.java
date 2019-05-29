import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Character {

    private String[] classes = {"Swordsman", "Archer", "Mage"};
    private int playerClass; //Classes 0-2, 0 = swordsman, 1 = archer, 2 = mage
    private int coins;
    private int attackStrength;
    private int hitPoints;
    private int maxHp;
    private int armorRating;
    private int level;
    private int defense;
    private int strength;
    private int[] killCounters = {0, 0, 0, 0, 0, 0};
    private int[] activeQuest = {-1, 0, 0, 0, 0, 0};
    //enemy type (-1 means no quest), amnt to kill, reward, start amount, city x, city y
    private Object[][] inventory = new Object[20][2]; //[20 inv slots.] [Name, number]
    private Object[][] armor = new Object[4][2]; //[4 armor slots] [Name, protection]
    private Object[] weapon; //[Name, damage]
    //armor names should be structured like: Material, Piece. EX: Iron Boots
    //Following vars are naming schemes
    private String[] armorPieces = {"Helmet", "Chestplate", "Leggings", "Boots"}; //4 armor pieces
    private String[] weapons = {"Sword", "Bow", "Wand"};
    private final Object[] DEFAULT_EMPTY = {"EMPTY", 0};


    public Character(){ //defaults
        playerClass = 0;
        coins = 10;
        attackStrength = 1;
        hitPoints = 100;
        maxHp = hitPoints;
        armorRating = 0;
        level = 0;
        for (int i = 0; i < inventory.length; i++) { //inventory
            inventory[i] = DEFAULT_EMPTY;
        }
        for (int i = 0; i < armor.length; i++){
            armor[i] = DEFAULT_EMPTY;
        }
        weapon = DEFAULT_EMPTY;
    }

    public void setPlayerClass(int c){
        playerClass = c;
        System.out.println("Class changed to " + c + ": " + classes[c]);
        if (c == 0){
            addInventory("Basic Sword", 2);
        }else if (c == 1){
            addInventory("Basic Bow", 2);
        }else if (c == 2){
            addInventory("Basic Wand", 2);
        }else
            System.out.println("Error when selecting class. Does not exist!");
    }

    /**
     * @param q {enemy type (-1 means no quest), amnt to kill, reward, start amount, city loc x, city loc y}
     */
    public void setActiveQuest(int[] q){
        activeQuest = q;
    }

    public boolean activeQuest(){
        return activeQuest[0] != -1; //return true if quest is in progress
    }

    public int[] getActiveQuest(){
        return activeQuest;
    }

    public String[] getClasses(){
        return classes;
    }

    public int getLevel(){
        return level;
    }

    public void addStrength(int s){
        strength += s;
    }

    public void addDefense(int d){
        defense += d;
    }

    public void addCoins(int c){
        coins += c;
        System.out.println(c + " coins added. Total: " + coins);
    }

    public boolean addInventory(String name, int number){
        boolean itemPlaced = false;
        for (int i = 0; i < inventory.length; i++){ //go thru all inventory items
            if (!itemPlaced) {
                String item = inventory[i][0].toString();
                if (item.equals(name) && !item.contains(armorPieces[0]) && !item.contains(armorPieces[1]) &&
                        !item.contains(armorPieces[2]) && !item.contains(armorPieces[3]) &&
                        !item.contains(weapons[0]) && !item.contains(weapons[1]) && !item.contains(weapons[2])) {
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

    public Object[] equip(String name, int value){

        Object[] prev = DEFAULT_EMPTY;

        for (int i = 0; i < armor.length; i++){
            if (name.contains(armorPieces[i])){ //checks name of item to put in correct slot
                prev = armor[i]; //saves item in that slot so it can be returned to inv
                Object[] curr = {name, value}; //current
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
            Object[] curr = {name, value}; //current
            weapon = curr;
            if (name.contains(weapons[playerClass])){
                attackStrength = (int)(value * 1.5);
                System.out.println("Equipped weapon base: " + value + "\nWith class bonus: " + attackStrength);
            }
            else {
                attackStrength = value;
            }
            System.out.println(name + " added to weapon slot");
            System.out.println(weapon[0].toString() + " [" + weapon[1].toString() + "]");
        } else if (name.contains("Catalyst")){
            if (name.contains("Health")){
                addMaxHp(value);
                JOptionPane.showMessageDialog(null, "Added " + value + " to max health.");
            } else if (name.contains("Armor")){
                addDefense(value);
                JOptionPane.showMessageDialog(null, "Added " + value + " to base defense.");
            } else if (name.contains("Strength")){
                addStrength(value);
                JOptionPane.showMessageDialog(null, "Added " + value + " to base strength.");
            }
        }
        return prev; //return the previously worn armor so it isn't deleted and can be put in the inv
    }

    public int getPlayerClass() {
        return playerClass;
    }

    public int getCoins() {
        return coins;
    }

    public Object[][] getInventory(){
        return inventory;
    }

    public boolean getInvStatus(){
        return (int)inventory[19][1] == 0; //return false if full
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

    public int getMaxHp(){
        return maxHp;
    }

    public int getHitPoints(){
        return hitPoints;
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

    public ArrayList<Object[]> getAllInv(){
        ArrayList<Object[]> inv = new ArrayList<>();
        for (Object[] i : inventory){
            if (!Arrays.equals(i, DEFAULT_EMPTY)) {
                inv.add(i);
            }
        }
        return inv;
    }

    public boolean displayInv(){
        String inv = getInvString() + "\n\n" + getArmorString();
        String[] options = {"Close", "Equip", "Drop"};
        int choice = JOptionPane.showOptionDialog(null, inv, "Inventory", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, null);
        if (choice == 1){ //equip
            ArrayList<Object[]> equipables = getEquipables(); //get all equipable items
            Object[] eq = listToObject(equipables); //convert to object array
            try {
                String equipItem = JOptionPane.showInputDialog(null, "Choose the item you wish to equip:", "Equip",
                        JOptionPane.QUESTION_MESSAGE, null, eq, null).toString();
                boolean found = false;
                int eqNum = 0;
                while (!found) { //until item is found,
                    if (equipItem.equals(eq[eqNum])){ //if selected is same as current item in object array
                        found = true; //item location is found
                    } else {
                        eqNum++;
                    }
                }
                Object[] prev;
                prev = equip(equipables.get(eqNum)[0].toString(), (int)equipables.get(eqNum)[1]); //equip selected item
                Object[] item = {equipables.get(eqNum)[0].toString(), equipables.get(eqNum)[1]};
                removeFromInv(item);
                addInventory(prev[0].toString(), (int)prev[1]);
                return true; //return true if item is equipped
            } catch (NullPointerException e){
                System.out.println("Equipping cancelled: " + e);
                return false;
            }
        } else if (choice == 2) { //drop
            Object[] options2 = listToObject(getAllInv());
            try {
                String dropChoice = JOptionPane.showInputDialog(null, "Choose the item you wish to drop:\n" +
                                "This cannot be undone, and the item cannot be retrieved!", "Drop",
                        JOptionPane.QUESTION_MESSAGE, null, options2, null).toString();
                boolean found = false;
                int eqNum = 0;
                while (!found) { //until item is found,
                    if (dropChoice.equals(options2[eqNum])){ //if selected is same as current item in object array
                        found = true; //item location is found
                    } else {
                        eqNum++;
                    }
                }
                Object[] item = {inventory[eqNum][0].toString(), inventory[eqNum][1]};
                removeFromInv(item);
            } catch (NullPointerException e){
                System.out.println("Drop cancelled: " + e);
                return false;
            }
        }
        return false;
    }

    public void defend(Enemies monster){
        int attackStrength = monster.attack();
        if (attackStrength - armorRating <= 0){
            JOptionPane.showMessageDialog(null, "You took 0 damage");
        }else {
            hitPoints = (hitPoints > (attackStrength - armorRating)) ? hitPoints - (attackStrength - armorRating) : 0;
            JOptionPane.showMessageDialog(null, "You took " + (attackStrength - armorRating) + " damage");
            if (hitPoints <= 0) {
                Score.End();
            }
        }
    }

    public int getAttackStrength(){
        return attackStrength;
    }

    public boolean isAlive(){
        return hitPoints > 0;
    }

    public Object[] listToObject (ArrayList<Object[]> a){
        Object[] r = new Object[a.size()];
        int i = 0;
        for (Object[] n : a){
            r[i] = n[0] + " [" + n[1] + "]";
            i++;
        }
        return r;
    }

    public void addMaxHp(int a){
        maxHp += a;
    }

    public void addHp(int a){
        hitPoints = hitPoints + a;
        if (hitPoints > maxHp){
            hitPoints = maxHp;
        }
    }

    public void addLevel(){
        level++;
    }

    public void save(){
        Object[][][] saveValues = {
                        inventory, armor, {weapon},
                {
                        {Movement.getX(), Movement.getY()}, {playerClass}, {coins}, {hitPoints, maxHp},
                        {attackStrength, armorRating}, {level}, {killCounters}, {activeQuest}, {defense, strength}
                },

        };
        Save.saveToFile(saveValues);
        System.out.println("Saved");
    }

    public boolean load(){
        try {
            Object[][][] saveValues = Save.loadFromFile();
            inventory = saveValues[0];
            armor = saveValues[1];
            weapon = saveValues[2][0];
            Movement.setX((int) saveValues[3][0][0]);
            Movement.setY((int) saveValues[3][0][1]);
            playerClass = (int) saveValues[3][1][0];
            coins = (int) saveValues[3][2][0];
            hitPoints = (int) saveValues[3][3][0];
            maxHp = (int) saveValues[3][3][1];
            attackStrength = (int) saveValues[3][4][0];
            armorRating = (int) saveValues[3][4][1];
            level = (int) saveValues[3][5][0];
            killCounters = (int[])saveValues[3][6][0];
            activeQuest = (int[]) saveValues[3][7][0];
            defense = (int) saveValues[3][8][0];
            strength = (int) saveValues[3][8][1];
            System.out.println("Loaded");
            return true;
        } catch (NullPointerException e){
            System.out.println("User cancelled?: " + e);
            return false;
        }
    }

    public void removeCoins(int c){
        coins -= c;
        System.out.println(c + " coins removed. ");
    }

    public void removeFromInv(Object[] item){
        boolean found = false;
        int eqNum = 0;
        while (!found) { //until item is found,
            try {
                if (Arrays.equals(item, inventory[eqNum])) { //if item to be removed is same as current item in inv
                    found = true; //item location is found
                } else {
                    eqNum++;
                }
            } catch (NullPointerException e){
                System.out.println("User selected cancel: " + e);
            }
        }
        ArrayList<Object[]> list = new ArrayList<>(Arrays.asList(inventory));
        list.remove(eqNum);
        list.add(DEFAULT_EMPTY);
        inventory = list.toArray(new Object[][]{});
    }

    public int enemiesKilled(){
        int total = 0;
        for(int k = 0; k < killCounters.length; k++){
            total += killCounters[k];
        }
        return total;
    }

    public void addKill(int e){
        killCounters[e] += 1;
    }

    public int getKills(int e){
        return killCounters[e];
    }

    public Object[] getWeapon(){
        return weapon;
    }
}
