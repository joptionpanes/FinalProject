import javax.swing.JOptionPane;

public class Score {
    public static void End(){

        /*      !TO DO BEFORE FINiSHED!         *
         * 1.enemiesKilled int                   *
         * 2.dragon boolean                      *
         *                                       *
         * -Alex Anderson                        *
         ****************************************/

        final int MAX_SCORE = 10000;
        int score = 0;
        Enemys enemys = new Enemys();
        score += (enemys.enemiesKilled() * 10);
        score += Start.player.getCoins();
        if(score > MAX_SCORE){
            score = MAX_SCORE;
        }
        if(enemys.isDragonKilled()){
            score *= score;
            JOptionPane.showMessageDialog(null, "Congrats on beating Dustin the dragon\n here is your score: " + score);
        }
        else
            JOptionPane.showMessageDialog(null, "You died :(\nhere is your score: " + score);

    }
}
