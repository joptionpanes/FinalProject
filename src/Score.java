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
        Enemies enemys = new Enemies();
        score += (Start.player.enemiesKilled() * 10);
        score += Start.player.getCoins();
        score += (Start.player.getLevel() * 100);
        if(score > MAX_SCORE){
            score = MAX_SCORE;
        }
        if(enemys.isDragonKilled()){
            score *= score;
            JOptionPane.showMessageDialog(null, "Congrats on beating Dustin the dragon\n here is your score: " + score);
        }
        else
            JOptionPane.showMessageDialog(null, "You died :(\nScore: " + score);
        Start.player.save();
        System.exit(5);
    }
}
