import javax.swing.*;

public class Enemys {
    private int maxHitPoints;
    private int hitPoints;
    private int attack;
    private int xpGiven;
    private int goldGiven;
    private int armor;
    private String name;
    private int[] killCountArray = new int[5];
    private int encounter;

    private int[] maxHitPointsArray = {(int) (Math.random()*((10-1)+1))+1,(int)(Math.random()*((15-5)+1))+5,(int)
            (Math.random()*((10-8)+1))+8,(int) (Math.random()*((30-20)+1))+20,(int) (Math.random()*((60-40)+1))+40};

    private int[] attackArray = {(int) (Math.random()*((3-1)+1))+1, (int) (Math.random()*((20-10)+1))+10, (int)
            (Math.random()*((30-25)+1))+25,(int) (Math.random()*((50-45)+1))+45, (int) (Math.random()*((50-45)+1))+45};

    private int[] armorArray = {0,(int)(Math.random()*((3)+1)),(int)(Math.random()*((2)+1)),(int)(Math.random()*
            ((5-1)+1))+1,(int)(Math.random()*((8-5)+1))+5};

    private int[] xpGivenArray = {(int)(Math.random() *((5-1)+1))+1,(int)(Math.random() *((7-1)+1))+1,(int)(Math.random() *
            ((10-3))+1)+3,(int)(Math.random() *((15-8)+1))+8,(int)(Math.random() *((15-6))+1)+6};

    private int[] goldGivenArray = {(int)(Math.random()*((3))+1),(int)(Math.random()*((6-2))+1)+2,(int)(Math.random()*
            ((7-4))+1)+4,(int)(Math.random()*((16-6))+1)+6,(int)(Math.random()*((20-10))+1)+10};

    private String[] names = {"Slime","Goblin","Undead","Orc","Giant"};

    public void enemyGenerator() {
        encounter = (int) (Math.random() * ((5) + 1));
        maxHitPoints = maxHitPointsArray[encounter];
        hitPoints = maxHitPoints;
        attack = attackArray[encounter];
        xpGiven = xpGivenArray[encounter];
        goldGiven = goldGivenArray[encounter];
        armor = armorArray[encounter];
        name = names[encounter];
    }

    public void newDragon(){
        maxHitPoints=(int) (Math.random()*((100-80)+1))+80;
        hitPoints = maxHitPoints;
        attack = (int) (Math.random()*((70-60)+1))+60;
        armor = (int)(Math.random()*((15-10)+1))+10;
        xpGiven = (int)(Math.random() *((60-50))+1)+50;
        goldGiven = (int)(Math.random()*((60-50))+1)+50;
        name = "Dragon";
    }

    public String MonName(){
        return name;
    }
    public String getStatus(){
        return "Monster Hp: " + hitPoints;
    }
    public int attack(){
        return attack;
    }
    public void defend(Character player){
        int attackStrength = player.attack();
        hitPoints = (hitPoints > (attackStrength - armor)) ? hitPoints - (attackStrength-armor): 0;// checks attack vs dmg and adjusts health
        JOptionPane.showMessageDialog(null,"You did " + (attackStrength-armor) + " dmg");
        if(hitPoints <= 0){
            JOptionPane.showMessageDialog(null,name + " has been defeated");
            player.addCoins(goldGiven);
            killCountArray[encounter] = killCountArray[encounter] + 1;
        }
    }

    public boolean isAlive(){
        return hitPoints > 0;
    }

}
