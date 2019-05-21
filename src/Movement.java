import javax.swing.JOptionPane;

public class Movement {

    //VARIABLES
    private static int x = 0;
    private static int y = 0;
    private static int[] location = { x, y };
    private static int moveRand1;
    private static int moveRand2;
    private static int movesBeforeEncounter = 1;
    private static int max = 10;
    private static int min = movesBeforeEncounter;
    private static int range = max - movesBeforeEncounter + 1;
    private static int choice;


    //MOVEMENT MAIN METHOD
    public static void movementMain(){
        //Game Loop
        do {

            



            System.out.println("1.Move up\n2.Move down\n3.Move left\n4.Move right\n5.Inventory\n6.Exit and save");
            if(choice == 1){
                moveUp();
            }
            if(choice == 2){
                moveDown();
            }
            if(choice == 3){
                moveLeft();
            }
            if(choice == 4){
                moveRight();
            }
            if(choice == 5){
               Character.getInvString();
            }
            if(choice == 6){
                exitAndSave();
            }
            location[0] = x;
            location[0] = y;
        }while(choice != 0);
    }


    //MOVEMENT METHODS
    public static void moveUp(){
        y -= 1;
        movesBeforeEncounter();
        moveRand1 = (int)(Math.random() * range) + min;
        moveRand2 = (int)(Math.random() * range) + min;
        if(moveRand1 == moveRand2){
            encounter();
        }
    }

    public static void moveLeft(){
        x -= 1;
        movesBeforeEncounter();
        moveRand1 = (int)(Math.random() * range) + min;
        moveRand2 = (int)(Math.random() * range) + min;
        if(moveRand1 == moveRand2){
            encounter();
        }
    }

    public static void moveRight(){
        x += 1;
        movesBeforeEncounter();
        moveRand1 = (int)(Math.random() * range) + min;
        moveRand2 = (int)(Math.random() * range) + min;
        if(moveRand1 == moveRand2){
            encounter();
        }
    }

    public static void moveDown(){
        y += 1;
        movesBeforeEncounter();
        moveRand1 = (int)(Math.random() * range) + min;
        moveRand2 = (int)(Math.random() * range) + min;
        if(moveRand1 == moveRand2){
            encounter();
        }
    }


    //ENCOUNTER METHODS
    public static void movesBeforeEncounter(){
        movesBeforeEncounter++;
    }

    public static void encounter(){
        movesBeforeEncounter = 0;
    }



    //EXIT AND SAVE METHODS
    public static void exitAndSave(){

    }


    //SETTER METHODS
    public static void setX(int x1){
        x = x1;
    }

    public static void setY(int y1){
        y = y1;
    }

    public static void setMoveRand1(){
        moveRand1 = (int)(Math.random() * range) + min;
    }

    public static void setMoveRand2(){
        moveRand2 = (int)(Math.random() * range) + min;
    }

    public static void setMovesBeforeEncounter(int movesBeforeEncounter1){
        movesBeforeEncounter = movesBeforeEncounter1;
    }

    public static void setMax(int max1){
        max = max1;
    }

    public static void setMin(int min1){
        min = min1;
    }

    public static void setChoice(int choice1){
        choice = choice1;
    }



    //GETTER METHODS
    public static int getX(){
        return x;
    }

    public static int getY(){
        return y;
    }

    public static int[] getLocation(){
        return location;
    }

    public static int getMoveRand1(){
        return moveRand1;
    }

    public static int getMoveRand2(){
        return moveRand2;
    }

    public static int getMovesBeforeEncounter(){
        return movesBeforeEncounter;
    }

    public static int getMax(){
        return max;
    }

    public static int getMin(){
        return min;
    }

    public static int getRange(){
        return range;
    }

    public static int getChoice(){
        return choice;
    }
}
