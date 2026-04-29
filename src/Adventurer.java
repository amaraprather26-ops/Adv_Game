import java.awt.*;

/**
 * Created by chales on 11/6/2017.
 */
public class Adventurer {

    //VARIABLE DECLARATION SECTION
    //Here's where you state which variables you are going to use.
    public String name;                //holds the name of the hero
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int dx;                    //the speed of the hero in the x direction
    public int dy;                    //the speed of the hero in the y direction
    public int width;
    public int height;
    public boolean isAlive;            //a boolean to denote if the hero is alive or dead.
    public Rectangle hitBox;
    public boolean isCrashing;
    public boolean right;
    public boolean left;
    public boolean up;
    public boolean down;


    // METHOD DEFINITION SECTION

    // Constructor Definition
    // A constructor builds the object when called and sets variable values.


    //This is a SECOND constructor that takes 3 parameters.  This allows us to specify the hero's name and position when we build it.
    // if you put in a String, an int and an int the program will use this constructor instead of the one above.
    public Adventurer(int pXpos, int pYpos) {
        xpos = pXpos;
        ypos = pYpos;
        dx = -1;
        dy = -1;
        width = 120;
        height = 150;
        isAlive = true;
        hitBox = new Rectangle(xpos, ypos, width, height);
        isCrashing = false;
        up = false;
        down = false;
        left = false;
        right = false;



    } // constructor

    public void move() {
        if(up){
            ypos = ypos - dy;
        }
        if(down){
            ypos = ypos +dy;
        }
        if(left){
            xpos = xpos-dx;
        }
        if(right){
            xpos = xpos +dx;
        }
        hitBox = new Rectangle(xpos, ypos, width, height);
    }

}







    //The move method.  Everytime this is run (or "called") the hero's x position and y position change by dx and dy
    /*public void move() {

        xpos = xpos + dx;
        ypos = ypos + dy;
/*
        if (isUp){
            dy = -Math.abs(dy);
        }
        if(isDown){
           dy = Math.abs(dy);
        }
        if(isLeft){
            dx = -Math.abs(dx);
        }
        if(isRight){
            dx = Math.abs(dx);
        }

        if (xpos < 0) {
            dx = -dx;
        }
        if (xpos > 1000 - width){
            dx = -dx;
        }
        if (ypos < height ) {
            dy = -dy;
        }
        if (ypos > 700- height){
            dy = -dy;
        }
        hitBox = new Rectangle(xpos, ypos, width, height);
    }
}*/






