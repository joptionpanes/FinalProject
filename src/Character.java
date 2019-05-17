public class Character {

    private int playerClass; //Classes 0-2, 0 = swordsman, 1 = archer, 2 = mage
    private Object[][] inventory = new Object[20][2]; //[20 inv slots.] [Name, number]
    private Object[][] armor = new Object[4][2]; //[4 armor slots] [Name, protection]
    
    public Character(){ //defaults
        playerClass = 0;
    }
    public void setPlayerClass(int c){
        playerClass = c;
    }
    public void setInventory(String name, int number){
        for (int i = 0; i < inventory.length; i++){
            if (inventory[i][1].equals(name)) {
                int num2 = Integer.parseInt(String.valueOf(inventory[i][1])); //current number of items in inv
                Object[] inventoryItem = {name, number + num2}; //add them together and
                inventory[i] = inventoryItem;
            } else if (inventory[i][1].equals(0)){
                Object[] inventoryItem = {name, number};
                inventory[i] = inventoryItem;
            } else if ()
        }
    }
}
