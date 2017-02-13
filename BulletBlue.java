import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BulletBlue here.
 * 
 * @author (Sandeep Balram Satone) 
 * @version (1.0)
 */
public class BulletBlue extends Actor
{
   
    /**
     * Act - do whatever the BulletBlue wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move(10);
        touchWorldEdge();
        
    }  
    
    private void touchWorldEdge(){
    
    if(isAtEdge()){       
          //  getWorld().removeObjects(getWorld().getObjects(Rock.class));
          getWorld().removeObject(this);
        }
    
    
    }
    
    
}
