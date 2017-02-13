import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (Sandeep Balram Satone) 
 * @version (1.0)
 */
public class Rock extends Actor
{
    private static final int NUMBER_OF_ROCKS = 10;
    public  static int SCORE = 0;
   
   
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move(-1);
        addRock();
      // getWorld().addObject(new Rock(),Greenfoot.getRandomNumber(getWorld().getWidth())+getWorld().getWidth()/2,Greenfoot.getRandomNumber(getWorld().getHeight()));
       if(!isAtEdge()){       
          //  getWorld().removeObjects(getWorld().getObjects(Rock.class));          
          detectCollision();
        }
        else{
             getWorld().removeObject(this);
        }
        
    }   
    
   private void addRock(){
         
        while (getWorld().getObjects(Rock.class).size() < 7){
            getWorld().addObject(new Rock(), Greenfoot.getRandomNumber(getWorld().getWidth())+getWorld().getWidth()/2, Greenfoot.getRandomNumber(getWorld().getHeight()-50));  
     }
   }
   
   private void detectCollision(){
       
       Actor b = getOneIntersectingObject(BulletBlue.class);
       if(b != null && !isAtEdge()){    
            SCORE++;
            getWorld().showText(Integer.toString(Rock.SCORE),500,10);
            getWorld().removeObject(this);   
          
          
        }
    
    }
 
}
