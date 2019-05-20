import javax.swing.*;
import java.io.*;

public class Save {
    private static String gameName = "gameName";
    private static String saveLocation = "C:\\ProgramData\\" + gameName + "\\saves";

    public static void saveToFile(){
        Object[][][] testSave = {
                {
                        {"Name", 10}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {} //inventory
                },
                {
                        {"Item Name", 10}, {}, {}, {} //armor
                },

        };
        JFileChooser selectedFile = new JFileChooser(saveLocation); //save dialog opens in saves folder

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
        JFileChooser selectedFile = new JFileChooser(saveLocation); //load dialog opens in saves folder
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
    public static String getSaveLocation(){
        return saveLocation;
    }
    public static void setSaveLocation(File s){
        saveLocation = s.toString();
        System.out.println(saveLocation + " is new location for saves");
    }
    public static String getGameName() {
        return gameName;
    }
}
