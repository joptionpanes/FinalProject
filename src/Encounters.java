public class Encounters {
    private String[] weaponTypes = {"Sword", "Bow", "Wand"};
    private String[] catalysts = {"Healing Catalyst", "Attack Catalyst", "Defense Catalyst"};

    public int generateInn(){
        return (int)(Math.random() * 10) + 5;
    }
    public void generateQuest(){
        int rand = (int)(Math.random() * 50) + 10;
    }
    public Object[][] generateShop(){
        int shopLvl = (int)(Math.random() * 5) + 1;
        System.out.println("Shoplvl: "+ shopLvl);
        int amountOfItems = (int) (Math.random() * 5) + 5;
        Object[][] shop = new Object[amountOfItems][2];
        System.out.println(amountOfItems + " in generated shop");
        for (int i = 0; i < amountOfItems; i++){
            int woc = (int)(Math.random() * 10); //weapon or catalyst decider
            if (woc < 7){ //choose weapon
                int random = (int)(Math.random() * 3);
                int attack = (int)(Math.random() * (30 * shopLvl)) + 10;
                Object[] temp = {weaponTypes[random], attack};
                shop[i] = temp;
            }else{
                int random = (int)(Math.random() * 3);
                int potency;
                if (random == 0){
                    potency = (int) (Math.random() * (5 * shopLvl)) + 3;
                }else {
                    potency = (int) (Math.random() * shopLvl) + 1;
                }
                Object[] temp = {catalysts[random], potency};
                shop[i] = temp;
            }

        }
        return shop;
    }
}
