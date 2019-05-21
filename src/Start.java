//https://stackoverflow.com/questions/13707223/how-to-write-an-array-to-a-file-java
import javax.swing.*;
import java.io.*;

public class Start {
    public static void main(String[] args){
        File saveLocation = new File(Save.getSaveLocation());
        if (saveLocation.exists()){
            System.out.println("Save location already exists!");
        } else {
            boolean f = saveLocation.mkdirs(); //attempt to create dir returning boolean (true means it was made)
            if(f) {
                System.out.println("Directory Created");
            } else {
                JOptionPane.showMessageDialog(null, "Error in creating save file directory! Access is probably denied",
                        "Error", JOptionPane.ERROR_MESSAGE); //if an error occurred, say so.
            }
        }
        String[] options = {"Start New", "Load Existing"};

        int selection = JOptionPane.showOptionDialog(null, "Welcome to " + Save.getGameName() + ". Select an option:",
                Save.getGameName(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
        if (selection == 0){ //start new
            JFileChooser selectedFile;
            do {
                selectedFile = new JFileChooser(saveLocation); //save dialog opens in saves folder
            }while (selectedFile.showDialog(null, "Enter name of new save folder") != JFileChooser.APPROVE_OPTION);
            Save.setSaveLocation(selectedFile.getSelectedFile()); //saveFile = save file location
            File saveFile = selectedFile.getSelectedFile();
            File map = new File(saveFile + "\\map");
            map.mkdirs(); //make the map folder
            Save.setMapLocation(); //set map folder location to newly created map folder
            Object[][][] save = {};
            startGame(save);
        }
        else if (selection == 1){ //load existing
            Object[][][] save = Save.loadFromFile();
            startGame(save);
        }
    }
    public static void startGame(Object[][][] save){
        
    }
}
