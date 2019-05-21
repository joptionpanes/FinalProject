import javax.swing.*;

public class Enemys {
    private int maxHitPoints;
    private int Hitpoints;
    private int attack;
    private int xpGiven;
    private int goldGiven;
    private int armor;
    private String name;

    private int[] MaxHitPointsarray = {(int) (Math.random()*((10-1)+1))+1,(int)(Math.random()*((15-5)+1))+5,(int)
            (Math.random()*((10-8)+1))+8,(int) (Math.random()*((30-20)+1))+20,(int) (Math.random()*((60-40)+1))+40};

    private int[] AttackArray = {(int) (Math.random()*((3-1)+1))+1, (int) (Math.random()*((45-35)+1))+35, (int)
            (Math.random()*((30-25)+1))+25,(int) (Math.random()*((50-45)+1))+45, (int) (Math.random()*((50-45)+1))+45};

    private int[] ArmorArray = {0,(int)(Math.random()*((3)+1)),(int)(Math.random()*((2)+1)),(int)(Math.random()*
            ((5-1)+1))+1,(int)(Math.random()*((8-5)+1))+5};

    private int[] xpGivenArray = {(int)(Math.random() *((5-1)+1))+1,(int)(Math.random() *((7-1)+1))+1,(int)(Math.random() *
            ((10-3))+1)+3,(int)(Math.random() *((15-8)+1))+8,(int)(Math.random() *((15-6))+1)+6};

    private int[] goldGivenArray = {(int)(Math.random()*((3))+1),(int)(Math.random()*((6-2))+1)+2,(int)(Math.random()*
            ((7-4))+1)+4,(int)(Math.random()*((16-6))+1)+6,(int)(Math.random()*((20-10))+1)+10};

    private String[] names = {"Slime","Goblin","Undead","Orc","Giant"};

    public void enemyGenerator() {
        int encounter = (int) (Math.random() * ((5) + 1));
        int maxHitPoints = MaxHitPointsarray[encounter];
        Hitpoints = maxHitPoints;
        attack = AttackArray[encounter];
        xpGiven = xpGivenArray[encounter];
        goldGiven = goldGivenArray[encounter];
        armor = ArmorArray[encounter];
        name = names[encounter];
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

    @Override
    public String MonName(){
        return name;
    }
    public String getStatus(){
        return "Monster Hp: " + Hitpoints;
    }
    public int attack(){
        return attack;
    }
    public void defend(Character player){
        int attackStrength = player.attack();//need the attack option made in Character class plz
        Hitpoints = (Hitpoints > attackStrength) ? Hitpoints - (attackStrength-armor): 0;
        JOptionPane.showMessageDialog(null,"You did " + (attackStrength-armor) + "dmg");
        if(Hitpoints <0){
            JOptionPane.showMessageDialog(null,name + " has been defeated");
        }
    }
    public boolean isAlive(){
        return Hitpoints > 0;
    }

}
