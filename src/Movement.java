import javax.swing.*;

public class Movement {

    /*      !TO DO BEFORE FINiSHED!         *
    * 1.Add in inventory                    *
    * 2.Add a way to exit and save          *
    * 3.Send encounters to the right methods*
    *                                       *
    * -Alex Anderson                        *
    ****************************************/

    //VARIABLES
    private static int x = 0;
    private static int y = 0;
    private static int[] location = { x, y };
    final private static int[] DRAGON_LAIR = {100, 100};
    private static int moveRand;
    private static int moveRand1;
    private static int moveRand2;
    private static int movesBeforeEncounter = 1;
    private static int max = 10;
    private static int min = movesBeforeEncounter;
    private static int range = max - movesBeforeEncounter + 1;
    private static int choice = 1;


    //MOVEMENT MAIN METHOD
    public static void movementMain(){
        //Making The Control Panel for Movement
        String[] options = new String[] {"Move North", "Move South", "Move East", "Move West", "Inventory", "Exit and Save"};
        int response = JOptionPane.showOptionDialog(null, "Control Panel", "Movement",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);

        JPanel panel2 = new JPanel();
        JTextField textField = new JTextField(10);
        panel2.add(textField);

        if (response == 0)
            moveNorth();
        else if(response == 1)
            moveSouth();
        else if(response == 2)
            moveEast();
        else if(response == 3)
            moveWest();
        else if(response == 4)
            System.out.println("Your Inventory: :)");
        else if(response == 5)
            exitAndSave();

        location[0] = x;
        location[0] = y;
    }


    //MOVEMENT METHODS
    public static void moveNorth(){
        System.out.println("Moving North");
        y -= 1;
        movesBeforeEncounter();
        moveRand1 = (int)(Math.random() * range) + min;
        moveRand2 = (int)(Math.random() * range) + min;
        if(moveRand1 == moveRand2){
            encounter();
        }
    }

    public static void moveWest(){
        System.out.println("Moving West");
        x -= 1;
        movesBeforeEncounter();
        moveRand1 = (int)(Math.random() * range) + min;
        moveRand2 = (int)(Math.random() * range) + min;
        if(moveRand1 == moveRand2){
            encounter();
        }
    }

    public static void moveEast(){
        System.out.println("Moving East");
        x += 1;
        movesBeforeEncounter();
        moveRand1 = (int)(Math.random() * range) + min;
        moveRand2 = (int)(Math.random() * range) + min;
        if(moveRand1 == moveRand2){
            encounter();
        }
    }

    public static void moveSouth(){
        System.out.println("Moving South");
        y += 1;
        movesBeforeEncounter();
        moveRand1 = (int)(Math.random() * range) + min;
        moveRand2 = (int)(Math.random() * range) + min;
        if(moveRand1 == moveRand2){
            encounter();
        }
    }


    //ENCOUNTER METHODS
    public static void movesBeforeEncounter(){ movesBeforeEncounter++; }

    public static void encounter(){
        movesBeforeEncounter = 0; //chances 20 70 10
        moveRand = (int)(Math.random() * range) + min;
        if(moveRand == 1){
            //wandererEncounter();
        }
        else if(moveRand == 2 || moveRand1 == 3){
            //cityEncounter();
        }
        else{
            //enemyEncounter();
        }
    }
    public static void caveEncounter(){
        if (location == DRAGON_LAIR);
                //dragonsLair();
    }


    //EXIT AND SAVE METHODS
    public static void exitAndSave(){ System.out.println("Exited and Saved"); }


    //SETTER METHODS
    public static void setX(int x1){ x = x1; }

    public static void setY(int y1){ y = y1; }

    public static void setMoveRand1(){ moveRand1 = (int)(Math.random() * range) + min; }

    public static void setMoveRand2(){ moveRand2 = (int)(Math.random() * range) + min; }

    public static void setMovesBeforeEncounter(int movesBeforeEncounter1){ movesBeforeEncounter = movesBeforeEncounter1; }

    public static void setMax(int max1){ max = max1; }

    public static void setMin(int min1){ min = min1; }

    public static void setChoice(int choice1){ choice = choice1; }



    //GETTER METHODS
    public static int getX(){ return x; }

    public static int getY(){ return y; }

    public static int[] getLocation(){ return location; }

    public static int getMoveRand1(){ return moveRand1; }

    public static int getMoveRand2(){ return moveRand2; }

    public static int getMovesBeforeEncounter(){ return movesBeforeEncounter; }

    public static int getMax(){ return max; }

    public static int getMin(){ return min; }

    public static int getRange(){ return range; }

    public static int getChoice(){ return choice; }
}
