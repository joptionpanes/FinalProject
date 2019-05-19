//https://stackoverflow.com/questions/13707223/how-to-write-an-array-to-a-file-java
/*
Proof of concept map
ArrayList
*/
import javax.swing.*;
import java.io.*;

public class Start {
    public static void main(String[] args){
        File saveLocation = new File(getSaveLocation());
        if (saveLocation.exists()){
            System.out.println("Save location already exists!");
        } else {
            boolean f = saveLocation.mkdirs(); //attempt to create dir returning boolean (true means it was made)
            if(f) {
                System.out.println("Directory Created");
            } else {
                JOptionPane.showMessageDialog(null, "Error in creating save file directory!\n" +
                        "When you save, you'll have to specify a location", "Error", JOptionPane.ERROR_MESSAGE);
                //if an error occurred, say so.
            }
        }
        String[] options = {"Start New", "Load Existing"};

        int selection = JOptionPane.showOptionDialog(null, "Welcome to " + getName() + ". Select an option:", getName(),
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
        if (selection == 0){
            saveToFile();
        }
        else if (selection == 1){
            Object[] save = loadFromFile();
        }
    }
    public static void saveToFile(){
        Object[][][] testSave = {
                {
                    {"Name", 10}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {} //inventory
                },
                {
                        {"Item Name", 10}, {}, {}, {} //armor
                },

        };
        JFileChooser selectedFile = new JFileChooser(getSaveLocation()); //save dialog opens in saves folder
        if (selectedFile.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) { //if user selects save
            File saveFile = selectedFile.getSelectedFile(); //saveFile = save file location
            try { //tries saving file
                saveFile.createNewFile();
            } catch (IOException e){
                JOptionPane.showMessageDialog(null, e, "Exception", JOptionPane.ERROR_MESSAGE);
            }
            try { //tries writing to file
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(saveFile));
/////////                //os.writeObject(); //insert name of var to write here
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e, "Exception", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public static Object[] loadFromFile(){
        JFileChooser selectedFile = new JFileChooser(getSaveLocation()); //load dialog opens in saves folder
        if (selectedFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { //if user selects open
            File saveFile = selectedFile.getSelectedFile(); //saveFile = save file location
            try { //tries reading and returning file as Object[]
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(saveFile));
                return (Object[])is.readObject();
            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, e, "Exception", JOptionPane.ERROR_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(null, "Error, empty file selected", "Error", JOptionPane.ERROR_MESSAGE);
        Object[] empty = {};
        return empty;
    }
    public static String getName(){
        return "gameName";
    }
    public static String getSaveLocation(){
        return "C:\\ProgramData\\" + getName() + "\\saves";
    }
}
