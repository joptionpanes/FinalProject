public class Test {
    public static void main(String[] args){
        Character player = new Character();

        player.addInventory("Item", 5);
        Object[][] inventory = player.getInventory();
        System.out.print(inventory[0][0] + ", " + inventory[0][1] + "\n");
        player.addInventory("Item", 5);
        System.out.print(inventory[0][0] + ", " + inventory[0][1] + "\n");
        player.addInventory("Magic Armor", 20);
        System.out.print(inventory[1][0] + ", " + inventory[1][1] + "\n");
        player.addInventory("Magic Armor", 40);
        System.out.print(inventory[1][0] + ", " + inventory[1][1] + "\n");
        System.out.print(inventory[2][0] + ", " + inventory[2][1] + "\n");


    }
}
