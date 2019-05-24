import javax.swing.*;

public class Battle {
    public void battle(Enemys enemy){
        Character player = Start.player;
        enemy.enemyGenerator();
        while(player.isAlive() && enemy.isAlive()){
           String[] battleOptions = {"Attack","Items"};
            int result = JOptionPane.showOptionDialog(null, null, "Choose what to do", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE ,null,battleOptions,null);
            boolean itemUsed = true;
            if (result == 0){
                enemy.defend(player);
            }
            else{
                itemUsed = player.displayInv();
            }
            if (enemy.isAlive() && itemUsed){
                player.defend(enemy);
            }
        }
    }
}
