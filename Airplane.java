import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Airplane here.
 * 
 * @author (Sandeep Balram Satone) 
 * @version (1.0)
 */
public class Airplane extends Actor

{
    private static final int SPEED = 10;
    /**
     * Act - do whatever the Airplane wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
       getDirections();
      // move(10);
       //if(isAtEdge()){turn(45);}
       fireBullet();
       detectRockCollision(); 
     

   
    }   
    
    private void getDirections(){ 
        // This code will get the directions for the objects 
        if(Greenfoot.isKeyDown("up")){
           //    System.out.println("pressed UP");
         setLocation(getX(), getY()-SPEED);   
          
        }
        if(Greenfoot.isKeyDown("down")){
            //   System.out.println("pressed Down");
             setLocation(getX(), getY()+SPEED);
           
        }
        if(Greenfoot.isKeyDown("right")){
          //  System.out.println("pressed Right");
             setLocation(getX()+SPEED, getY());

        }
        if(Greenfoot.isKeyDown("left")){
          //  System.out.println("pressed Left");
             setLocation(getX()-SPEED, getY());

        }
    }
    
    private void fireBullet(){
        if(Greenfoot.getKey()=="space"){
          //  System.out.println("pressed Left");
              BulletBlue bulletblue = new BulletBlue();
              GreenfootImage airplaneImage = getImage();        
              getWorld().addObject(bulletblue,getX()+airplaneImage.getWidth()/2,getY());

        }   
    }
        private void detectRockCollision(){
        Actor airplaneRock = getOneIntersectingObject(Rock.class);
       if(airplaneRock != null){    
           
            //getWorld().removeObject(this);   
            GameOver gameOver = new GameOver();
            getWorld().addObject(gameOver,getWorld().getWidth()/2,getWorld().getHeight()/2);
            Greenfoot.stop();
            
          
        }
     
    }
    

}
