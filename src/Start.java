//https://stackoverflow.com/questions/13707223/how-to-write-an-array-to-a-file-java
import javax.swing.*;
import java.io.*;

public class Start {
    public static Character player = new Character();
    public static void main(String[] args){
        File saveLocation = new File(Save.getSaveLocation());
//        if (saveLocation.exists()){
//            System.out.println("Save location already exists!");
//        } else {
            boolean f = saveLocation.mkdirs(); //attempt to create dir returning boolean (true means it was made)
            if(f) {
                System.out.println("Directory Created");
            } else {
                JOptionPane.showMessageDialog(null, "Error in creating save file directory!\n" +
                        "Specify a new location!", "Error", JOptionPane.ERROR_MESSAGE); //if an error occurred, say so.
                JFileChooser selectedFile;
                do {
                    selectedFile = new JFileChooser(saveLocation); //save dialog opens in saves folder
                }while (selectedFile.showDialog(null, "Enter name of new folder") != JFileChooser.APPROVE_OPTION);
                Save.setSaveLocation(selectedFile.getSelectedFile()); //saveFile = save file location

            }
        //}
        String[] options = {"Start New", "Load Existing"};

        int selection = JOptionPane.showOptionDialog(null, "Welcome to " + Save.getGameName() + ". Select an option:",
                Save.getGameName(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
        if (selection == 0){
            Save.saveToFile();
        }
        else if (selection == 1){
            Object[] save = Save.loadFromFile();
        }
    }
}
