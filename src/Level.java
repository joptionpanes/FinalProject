public class Level {


    public static void checkLvl(){
        int needed = Start.player.getXpNeeded();
        if(Start.player.getXp() >= needed){
            Start.player.addLevel();
            Start.player.setXpNeeded((int)(needed * 1.5));
            Start.player.setXp(Start.player.getXp() - needed);
            Start.player.addMaxHp(20);
            Start.player.addHp(20);
            Start.player.addCoins(20);
        }
    }
}
