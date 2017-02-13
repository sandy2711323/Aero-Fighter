import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



/**
 * Write a description of class MyWorld here.
 * 
 * @author (Sandeep Balram Satone) 
 * @version (1.0)
 */
public class MyWorld extends World
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int NUMBER_OF_ROCKS = 5;
    private static final String CREDIT = "Developed by SANDEEP SATONE";

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1); 
        /*GreenfootImage background = new GreenfootImage(WIDTH,HEIGHT);
        background.setColor(Color.WHITE);
        background.fill();
        setBackground(background);*/
       
        addObject(new Rock(),Greenfoot.getRandomNumber(WIDTH)+WIDTH/2,Greenfoot.getRandomNumber(HEIGHT));
        prepare();
        showText(CREDIT,200,10);
       
        resetStaticVariables();
       
        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Airplane airplane = new Airplane();
        addObject(airplane,WIDTH/8,HEIGHT/2);     
        
    }
    
    private void resetStaticVariables() {  

            Rock.SCORE = 0;

    }
}
