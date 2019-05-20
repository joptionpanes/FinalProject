public class Enemys {
    private int maxHitPoints;
    private int Hitpoints;
    private int attack;
    private int xpGiven;
    private int goldGiven;
    private int armor;
    private String name;


    public void newSlime(){
        maxHitPoints =(int) (Math.random()*((10-1)+1))+1;
        Hitpoints = maxHitPoints;
        attack = (int) (Math.random()*((3-1)+1))+1;
        xpGiven = (int)(Math.random() *((5-1)+1))+1;
        goldGiven = (int)(Math.random()*((3))+1);
        name = "Slime";
    }
    public void newOrc(){
        maxHitPoints =(int) (Math.random()*((30-20)+1))+20;
        Hitpoints = maxHitPoints;
        attack = (int) (Math.random()*((50-45)+1))+45;
        armor = (int)(Math.random()*((5-1)+1))+1;
        xpGiven = (int)(Math.random() *((15-8)+1))+8;
        goldGiven = (int)(Math.random()*((16-6))+1)+6;
        name = "Orc";
    }
    public void newGoblin(){
        maxHitPoints =(int) (Math.random()*((15-5)+1))+5;
        Hitpoints = maxHitPoints;
        attack = (int) (Math.random()*((45-35)+1))+35;
        armor = (int)(Math.random()*((3)+1));
        xpGiven = (int)(Math.random() *((7-1)+1))+1;
        goldGiven = (int)(Math.random()*((6-2))+1)+2;
        name = "Goblin";
    }
    public  void newUndead(){
        maxHitPoints =(int) (Math.random()*((10-8)+1))+8;
        Hitpoints = maxHitPoints;
        attack = (int) (Math.random()*((30-25)+1))+25;
        armor = (int)(Math.random()*((2)+1));
        xpGiven = (int)(Math.random() *((10-3))+1)+3;
        goldGiven = (int)(Math.random()*((7-4))+1)+4;
        name = "Undead";
    }
    public void newGiant(){
        maxHitPoints =(int) (Math.random()*((60-40)+1))+40;
        Hitpoints = maxHitPoints;
        attack = (int) (Math.random()*((50-45)+1))+45;
        armor = (int)(Math.random()*((8-5)+1))+5;
        xpGiven = (int)(Math.random() *((15-6))+1)+6;
        goldGiven = (int)(Math.random()*((20-10))+1)+10;
        name = "Giant";
    }
    public void newDragon(){
        maxHitPoints=(int) (Math.random()*((100-80)+1))+80;
        Hitpoints = maxHitPoints;
        attack = (int) (Math.random()*((70-60)+1))+60;
        armor = (int)(Math.random()*((15-10)+1))+10;
        xpGiven = (int)(Math.random() *((60-50))+1)+50;
        goldGiven = (int)(Math.random()*((60-50))+1)+50;
        name = "Dragon";
    }
}
