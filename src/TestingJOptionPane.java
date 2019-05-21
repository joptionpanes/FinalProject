import javax.swing.*;
import java.awt.*;

public class TestingJOptionPane {

    public static void main(String[] args){

        //THIS FILE CAN BE DELETED!

        //Creates a input dialog that asks the user for their name
        String input = JOptionPane.showInputDialog("Enter your name");
        String name = input;

        //creates a message dialog that says hello to the name entered from the user earlier
        JOptionPane.showMessageDialog(null, "Hello " + name);

        //sets an image to a variable (The image needs to be inside the project folder)
        ImageIcon dab = new ImageIcon("download.jpg");

        //Display the image set along with text to go along with the image and a title for the popup window
        JOptionPane.showMessageDialog(null,"Dab on the haters", "Display Image", JOptionPane.INFORMATION_MESSAGE, dab);

        //Setting labels and panels to modify the popup window
        JLabel icon = new JLabel(dab);
        JLabel text = new JLabel("Dab on the Hatters");
        JLabel text2 = new JLabel("2nd Message, Dab");
        JPanel panel = new JPanel();

        //Changes the layout of the window
        panel.setLayout(new BorderLayout());
        panel.add(icon,BorderLayout.CENTER);
        panel.add(text,BorderLayout.NORTH);
        panel.add(text2,BorderLayout.SOUTH);
        //Creates modified window
        JOptionPane.showMessageDialog(null,panel, "title",JOptionPane.PLAIN_MESSAGE);

        //Adding in custom buttons
        Object[] options1 = { "Try This Number", "Choose A Random Number",
                "Quit" };

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Enter number between 0 and 1000"));
        JTextField textField = new JTextField(10);
        panel2.add(textField);

        int result = JOptionPane.showOptionDialog(null, panel2, "Enter a Number",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);
        if (result == JOptionPane.YES_OPTION)
            JOptionPane.showMessageDialog(null, textField.getText());
    }
}