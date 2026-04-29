import java.awt.*;

public class Snake {
    int height;
    int width;
    int xpos;
    int ypos;
    int dy;
    boolean isAlive;
    Rectangle hitBox;
    public boolean isCrashing;

    public Snake(int pXpos, int pYpos, int pHeight, int pWidth,  int ySpeed){
        height = pHeight;
        width =  pWidth;
        xpos = pXpos;
        ypos = pYpos;
        dy = ySpeed;
        hitBox = new Rectangle (xpos, ypos, width, height);
        isCrashing = false;
    }

    public void move(){
        ypos = ypos + dy;

        if(ypos> 800){
            ypos = 0;
        }
        hitBox = new Rectangle(xpos, ypos, width, height);

    }//snakes wrap
}
