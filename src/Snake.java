public class Snake {
    int height;
    int width;
    int xpos;
    int ypos;
    int dx;
    boolean isAlive;

    public Snake(int pHeight, int pWidth, int pXpos, int pYpos, int xSpeed){
        pHeight = height;
        pWidth = width;
        pXpos = xpos;
        pYpos = ypos;
        xSpeed = dx;

    }

    public void move(){
        xpos = xpos + dx;

        if(xpos> 1000){
            xpos = 0;
        }

    }
}
