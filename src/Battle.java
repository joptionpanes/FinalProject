import javax.swing.*;

public class Battle {
    public Battle( Character player, Enemys enemy){
        enemy.enemyGenerator();
        //while(player.isAlive() && enemy.isAlive()){
           String[] battleOptions = {"Attack","Items","Magic"};
            int result = JOptionPane.showOptionDialog(null, null, "Choose what to do", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE ,null,battleOptions,null);
            if (result == 0){
                enemy.defend(player);
            }
            else if(result == 1){
                //don't know how to call inventory
            }
            else {
//                enemy.defendMagic(player);
            }
            if (enemy.isAlive()){
                //player.defend(enemy);
           // }
        }
    }
}
