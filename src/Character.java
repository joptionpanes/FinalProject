public class Character {

    private int playerClass; //Classes 0-2, 0 = swordsman, 1 = archer, 2 = mage
    private int coins;
    private static Object[][] inventory = new Object[20][2]; //[20 inv slots.] [Name, number]
    private Object[][] armor = new Object[4][2]; //[4 armor slots] [Name, protection]
    //armor names should be structured like: Material (Iron), Piece (Helmet), Armor
    private String[] armorPieces = {"Helmet", "Chestplate", "Leggings", "Boots"}; //4 armor pieces
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

        }
    }
    public void setCoins(int c){
        coins = c;
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
    public Object[] equipArmor(String name, int prot){
        int i = 0;
        Object[] prev = defaultEmpty;

        for (String p : armorPieces){
            if (name.toLowerCase().contains(p.toLowerCase())){ //checks name of item to put in correct slot
                prev = armor[i];

                armor[i][0] = name;
                armor[i][1] = prot;
            }
            i++;
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
    public void party(){

    }
}
