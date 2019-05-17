public class Character {

    private int playerClass; //Classes 0-2, 0 = swordsman, 1 = archer, 2 = mage
    private Object[][] inventory = new Object[20][2]; //[20 inv slots.] [Name, number]
    private Object[][] armor = new Object[4][2]; //[4 armor slots] [Name, protection]
    //armor names should be structured like: Material (Iron), Piece (Helmet), Armor
    public Character(){ //defaults
        playerClass = 0;
        for (int i = 0; i < inventory.length; i++) { //inventory
            inventory[i][0] = "EMPTY";
            inventory[i][1] = 0;
        }
        for (int i = 0; i < armor.length; i++){
            armor[i][0] = "EMPTY";
            armor[i][1] = 0;
        }
    }
    public void setPlayerClass(int c){
        playerClass = c;
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
    public void equipArmor(String name, int prot){
        if (name.toLowerCase().contains("helmet")){
            armor[0][0] = name;
            armor[0][1] = prot;
        }
    }
    public Object[][] getInventory(){
        return inventory;
    }
    public Object[][] getArmor(){
        return armor;
    }
    public void party(){

    }


}
