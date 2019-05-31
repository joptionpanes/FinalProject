public class Level {


    public static void Lvl(){
        int needed = Start.player.getXpNeeded();
        if(Character.getXp() >= needed){
            Character.addLevel();
            Start.player.setXpNeeded(needed *= 1.5);
            Character.setXp(0);
            Start.player.addMaxHp(20);
            Start.player.addHp(20);
            Start.player.addCoins(20);
        }
    }
}
