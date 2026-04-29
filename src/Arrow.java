import java.awt.*;

public class Arrow {
public int width;
public int height;
public int xpos;
public int ypos;
public int dx;
public int dy;
public Rectangle hitBox;

    public Arrow(int pXpos, int pYpos, int pWidth, int pHeight, int pXspeed, int pYspeed){
        xpos = pXpos;
        ypos = pYpos;
        width = pWidth;
        height = pHeight;
        dx = pXspeed;
        dy = pYspeed;


    }

    public void move(){
        xpos = xpos + dx;
        ypos = ypos + dy;

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
    }// arrows bounce
}
