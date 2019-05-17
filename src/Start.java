import javax.swing.*;

public class Start {
    public static void main(String[] args){
        final String NAME = "NULL";
        String[] Saves = {"Start New"};

        JOptionPane.showOptionDialog(null, "Welcome to " + NAME + ". Select a save:", NAME,
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, Saves, null);
    }
}
