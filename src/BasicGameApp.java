//Basic Game Application
//Version 2
// Basic Object, Image, Movement
// Astronaut moves to the right.
// Threaded

//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.tools.Tool;


//*******************************************************************************
// Class Definition Section
//Implements play button use and key use
public class BasicGameApp implements Runnable, KeyListener { //MouseListener{

   //Variable Definition Section
   //Declare the variables used in the program 
   //You can set their initial values too
   
   //Sets the width and height of the program window
	final int WIDTH = 1000;
	final int HEIGHT = 800;

   //Declare the variables needed for the graphics
	public JFrame frame;
	public Canvas canvas;
   public JPanel panel;
   
	public BufferStrategy bufferStrategy;
	public Image adventPic;
    public Image background;
    public Image snakePic;
    public Image arrowPic;

   //Declare the objects used in the program
   //These are things that are made up of more than one variable type
	public Adventurer adv1;
    public Snake snake1;
    public Snake snake2;
    public Snake snake3;
    public boolean isStart;
    public boolean isLife1;
    public boolean isLife2;
    public boolean isLife3;
    public Arrow[] arrows; //makes arrows array

    // Main method definition
   // This is the code that runs first and automatically
	public static void main(String[] args) {
		BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
		new Thread(ex).start();//creates a threads & starts up the code in the run( ) method
        System.out.println("Press space bar to start.\nAvoid the snakes to live!");
    }


   // Constructor Method
   // This has the same name as the class
   // This section is the setup portion of the program
   // Initialize your variables and construct your program objects here.
	public BasicGameApp() {

      setUpGraphics();

      //random range 0-9
      int randx = (int)(Math.random() * 900) + 1;
      //Math.random picks # between a little more than 0 and a little less than one
        // ex. 0.0001 and .9999
        // *10 and take first digit as integer
        // (int)(Math.random() * 10) + 1 for 1-10 etc.

      int randy = (int)(Math.random()*600) + 1;

      //variable and objects
      //create (construct) the objects needed for the game and load up
        snakePic = Toolkit.getDefaultToolkit().getImage("snake.jpg");
        arrowPic = Toolkit.getDefaultToolkit().getImage("arrow.jpg");
        adventPic = Toolkit.getDefaultToolkit().getImage("indianaJones.png");
        background = Toolkit.getDefaultToolkit().getImage("jungleBackground.jpg");

        //load the picture
		adv1 = new Adventurer(800,400);
        snake1 = new Snake (400, 500, 70, 60, 1);
        snake2 = new Snake(150, 10, 120, 130, 2);
        snake3 = new Snake (570, 450, 90, 80, 3);

        arrows = new Arrow[10];
        for(int i=0;i<arrows.length;i++){
            arrows[i] = new Arrow(0, i*80, 45, 45, i, 1);
        }

    }// BasicGameApp()

   //
//*******************************************************************************
//User Method Section
//
// put your code to do things here.

   // main thread
   // this is the code that plays the game after you set things up

	public void run() {

      //for the moment we will loop things forever.
        isLife1 = true;
        isLife2 = true;
        isLife3 = true;
		while (true) {
         moveThings();  //move all the game objects
         render();  // paint the graphics
         pause(20); // sleep for 10 ms
		}
	}


	public void moveThings(){
        if (isStart) {
            adv1.move();
            snake1.move();
            snake2.move();
            snake3.move();
            for(int i=0; i<arrows.length; i++) {
                arrows[i].move();
            }

            //calls the move( ) code in the objects

            //adv1.move();

            Collision();
            //astro1Collision();
            /*if (astro1.isUp){
                astro1.dy = -Math.abs(astro1.dy);
            }
            if(astro1.isDown){
                astro1.dy = Math.abs(astro1.dy);
            }
            if(astro1.isLeft){
                astro1.dx = -Math.abs(astro1.dx);
            }
            if(astro1.isRight){
                astro1.dx = Math.abs(astro1.dx);
            }*/
        }
	}

    public void Collision(){
        if(adv1.hitBox.intersects(snake1.hitBox) && adv1.isCrashing == false&&isLife1&&isLife2&&isLife3) {
            System.out.println("Crash");
           // snake1.dy = snake1.dy +1;
            adv1.xpos = adv1.xpos +20;
            adv1.isCrashing = true;
            isLife1 = false;
        }
        if(adv1.hitBox.intersects(snake2.hitBox)&&!adv1.isCrashing&&isLife1&&isLife2&&isLife3) {
            System.out.println("Crash");
            //snake2.dy = snake2.dy +1;
            adv1.xpos = adv1.xpos +20;
            adv1.isCrashing = true;
            isLife1 = false;
        }
        if(adv1.hitBox.intersects(snake3.hitBox)&&!adv1.isCrashing&&isLife1&&isLife2&&isLife3) {
            System.out.println("Crash");
            // snake3.dy = snake3.dy +1;
            adv1.xpos = adv1.xpos + 20;
            adv1.isCrashing = true;
            isLife1 = false;
        }
        if(adv1.hitBox.intersects(snake1.hitBox) && adv1.isCrashing == false&&!isLife1&&isLife2&&isLife3) {
            System.out.println("Crash");
            //snake1.dy = snake1.dy +1;
            adv1.xpos = adv1.xpos +20;
            adv1.isCrashing = true;
            isLife2 = false;
        }
        if(adv1.hitBox.intersects(snake2.hitBox)&&!adv1.isCrashing&&!isLife1&&isLife2&&isLife3) {
            System.out.println("Crash");
            //snake2.dy = snake2.dy +1;
            adv1.xpos = adv1.xpos +20;
            adv1.isCrashing = true;
            isLife2 = false;
        }
        if(adv1.hitBox.intersects(snake3.hitBox)&&!adv1.isCrashing&&!isLife1&&isLife2&&isLife3) {
            System.out.println("Crash");
            //snake3.dy = snake3.dy + 1;
            adv1.xpos = adv1.xpos + 20;
            adv1.isCrashing = true;
            isLife2 = false;
        }

        if(adv1.hitBox.intersects(snake1.hitBox) && !adv1.isCrashing&&!isLife1&&!isLife2&&isLife3) {
                System.out.println("Crash");
              //  snake1.dy = snake1.dy +1;
                adv1.xpos = adv1.xpos +20;
                adv1.isCrashing = true;
            isLife3 = false;
            }
        if(adv1.hitBox.intersects(snake2.hitBox)&&!adv1.isCrashing&&!isLife1&&!isLife2&&isLife3) {
                System.out.println("Crash");
            //    snake2.dy = snake2.dy +1;
                adv1.xpos = adv1.xpos +20;
                adv1.isCrashing = true;
            isLife3 = false;
            }
        if(adv1.hitBox.intersects(snake3.hitBox)&&!adv1.isCrashing&&!isLife1&&!isLife2&&isLife3) {
                System.out.println("Crash");
              //  snake3.dy = snake3.dy + 1;
                adv1.xpos = adv1.xpos + 20;
                adv1.isCrashing = true;
                isLife3 = false;
            }

        if(!adv1.hitBox.intersects(snake1.hitBox)) {
            adv1.isCrashing = false;
        }
        if(!adv1.hitBox.intersects(snake2.hitBox)) {
            adv1.isCrashing = false;
        }
        if(!adv1.hitBox.intersects(snake3.hitBox)) {
            adv1.isCrashing = false;
        }

        if(!isLife3){
            adv1.isAlive = false;
        }

    }
/*
    public void astro1Collision(){
        for(int i=0; i<asteroids.length; i++) {
            if (asteroids[i].hitBox.intersects(astro1.hitBox)) {
                System.out.println("asteroid crash");
            }
        }
    }*/

   //Pauses or sleeps the computer for the amount specified in milliseconds
   public void pause(int time ){
   		//sleep
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {

			}
   }

   //Graphics setup method
   private void setUpGraphics() {
      frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.
      panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
      panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
      panel.setLayout(null);   //set the layout
      // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
      // and trap input events (Mouse and Keyboard events)
      canvas = new Canvas();

      //add key listener to canvas

       canvas.addKeyListener(this);

      //canvas.addMouseListener(this);

      canvas.setBounds(0, 0, WIDTH, HEIGHT);
      canvas.setIgnoreRepaint(true);
   
      panel.add(canvas);  // adds the canvas to the panel.
   
      // frame operations
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
      frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
      frame.setResizable(false);   //makes it so the frame cannot be resized
      frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!
      
      // sets up things so the screen displays images nicely.
      canvas.createBufferStrategy(2);
      bufferStrategy = canvas.getBufferStrategy();
      canvas.requestFocus();
      System.out.println("DONE graphic setup");
   
   }


	//paints things on the screen using bufferStrategy
	private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
        //
        //start
        // draw things here
        //draw the image of the adventurer
        if(adv1.isAlive) {
            g.drawImage(adventPic, adv1.xpos, adv1.ypos, adv1.width, adv1.height, null);
        }
        g.drawImage(snakePic, snake1.xpos, snake1.ypos,snake1.width, snake1.height, null);
        g.drawImage(snakePic, snake2.xpos, snake2.ypos,snake2.width, snake2.height, null);
        g.drawImage(snakePic, snake3.xpos, snake3.ypos,snake3.width, snake3.height, null);
        //g.drawRect(xpos, ypos, width, height)<-- would actually draw the hitBox rectangle
       // for(int i=0; i<asteroids.length; i++){
       //     g.drawImage(roidPic, asteroids[i].xpos, asteroids[i].ypos, asteroids[i].width, asteroids[i].height, null);
      //  }
        if(isLife1) {
            g.setColor(Color.RED);
            g.fillRect(150, 100, 25, 25);
        }
        if(isLife2) {
            g.setColor(Color.RED);
            g.fillRect(100, 100, 25, 25);
        }
        if(isLife3) {
            g.setColor(Color.RED);
            g.fillRect(50, 100, 25, 25);
        }

        for(int i=0; i<arrows.length; i++){
            g.drawImage(arrowPic, arrows[i].xpos, arrows[i].ypos, arrows[i].width, arrows[i].height, null);
        }
        //makes the life counters dependant on the islife variables
        //end
		g.dispose();

		bufferStrategy.show();
	}

    //add key methods
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if(e.getKeyCode()==32){
           isStart = true;
        }
        if(e.getKeyCode()==37){
            adv1.left = true;
        }
        else{
            adv1.left = false;
        }
        if(e.getKeyCode()==39){
            adv1.right = true;
        }
        else{
            adv1.right = false;
        }
        if(e.getKeyCode()==38){
            adv1.down = true;
        }
        else{
            adv1.down = false;
        }
        if(e.getKeyCode()==40){
            adv1.up = true;
        }
        else{
            adv1.up = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }
/*
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Rectangle pointBox = new Rectangle(e.getX(), e.getY(), 1, 1);
        if(startButton.intersects(pointBox)){
            System.out.println("Start Game");
            isStart = true;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("entered");

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
*/

}