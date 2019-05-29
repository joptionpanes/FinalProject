import javax.swing.*;

public class Movement {

    /*      !TO DO BEFORE FINiSHED!          *
     * 1.Add in inventory                     *
     * 2.Add a way to exit and save           *
     * 3.Send encounters to the right methods *
     *                                        *
     * -Alex Anderson                         *
     *****************************************/

    //VARIABLES
    private static int x = 0;
    private static int y = 0;
    private static int[] location = { x, y };
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
        String[] options = new String[] {"Move North", "Move South", "Move East", "Move West",
                "Inventory", "Save", "Exit and Save"};
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
            Start.player.displayInv();
        else if (response == 5)
            save();
        else if(response == 6 || response == -1)
            exitAndSave();

        location[0] = x;
        location[0] = y;
    }


    //MOVEMENT METHODS
    public static void moveNorth(){
        y += 1;
        System.out.println("Moving North to: " + x + ", " + y);
        encounterCheck();
    }

    public static void moveWest(){
        x -= 1;
        System.out.println("Moving West to: " + x + ", " + y);
        encounterCheck();
    }

    public static void moveEast(){
        x += 1;
        System.out.println("Moving East to: " + x + ", " + y);
        encounterCheck();
    }

    public static void moveSouth(){
        y -= 1;
        System.out.println("Moving South to: " + x + ", " + y);
        encounterCheck();
    }


    //ENCOUNTER METHODS
    public static void encounterCheck(){
        int exists = checkForExisting();
        if (exists != 0 && exists != 2) {
            movesBeforeEncounter();
            moveRand1 = (int) (Math.random() * range) + min;
            moveRand2 = (int) (Math.random() * range) + min;
            if (moveRand1 == moveRand2) {
                encounter();
            } else {
                Save.setMapAtPos(x, y, "NULL", null);
                if ((int)(Math.random() * 10) == 5){
                    JOptionPane.showMessageDialog(null, "You found shiny rocks, maybe they could be used for something?");
                    Start.player.addInventory("Rock", (int)(Math.random() * 3) + 1);
                }
            }
        } else if (exists == 2){
            caveEncounter();
        }
    }

    public static void movesBeforeEncounter(){
        movesBeforeEncounter++;
        range = max - movesBeforeEncounter + 1;
    }

    public static void encounter(){
        movesBeforeEncounter = 0; //chances 10 30 60
        moveRand = (int)(Math.random() * 100) + 1;
        Encounters encounter = new Encounters();
        if(moveRand <= 8){
            System.out.println("Wander encounter");
            Save.setMapAtPos(x, y, "NULL", null);
            encounter.generateWandererShop();
        }
        else if((moveRand >= 70) && checkForExisting() == -1){
            System.out.println("City encounter");
            encounter.generateCity();
        }
        else{
            System.out.println("Enemy encounter");
            Save.setMapAtPos(x, y, "NULL", null);
            encounter.generateBattle();
        }
    }

    public static void caveEncounter(){
        Encounters boss = new Encounters();
        boss.generateBossBattle();
    }

    public static int checkForExisting(){ //0 = does exist, 1 = doesn't exist, -1 = not generated, 2 = dragon boss
        Object[][] save = Save.getMapAtPos(x, y);
        if (save == null) {
            return -1;
        } else if (save[0][0].equals("NULL")){
            return 1;
        } else if (save[0][0].equals("BOSS")){
            return 2;
        } else {
            Encounters encounter = new Encounters();
            encounter.loadCity();
            return 0;
        }
    }


    //EXIT AND SAVE METHODS
    public static void exitAndSave(){
        Start.player.save();
        System.exit(3);
    }

    public static void save(){
        Start.player.save();
    }


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
