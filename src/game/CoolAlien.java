
package game;

import city.cs.engine.*;
/**
 * CoolAlien class extends Walker.
 * @author Negar
 */
public class CoolAlien extends Walker{
    
    private static final Shape coolAlienShape = new PolygonShape(
            -1.33f,1.39f, -1.29f,-1.31f, 1.02f,-1.29f, 1.0f,1.42f, -1.3f,1.42f);
    
    private static final BodyImage coolAlienImageLeft = new BodyImage("data/coolAlienLeft.gif", 2.25f);  
    private static final BodyImage coolAlienImageRight = new BodyImage("data/coolAlienRight.gif", 2.25f);
    
    private static int life, goldCoins;

    public CoolAlien(World world) {         
        super(world, coolAlienShape);       
        addImage(coolAlienImageLeft);       
        CoolAlien.life = 3;
        CoolAlien.goldCoins = 0;
    }

    /**
     * 
     * @return value.
     */
    public int getLife(){       
        return life;
    }
    
    public int getGoldCoins(){      
        return goldCoins;
    }

    /**
     * 
     * @param l
     */
    public void setLife(int l){      
        life = l;
    }
    /** 
     * 
     */
    public void loseSomeLife(){      
        life--;
        if(life > 0)
            System.out.println("Alien has lost some life! life = " + life); 
        else
            gameOver();
    }
    
    public void addSomeLife(){       
        life = 3;
        System.out.println("Alien has now all his life! -> life = " + life); 
    }
    
    public void gameOver(){       
        life = 0;
        System.out.println("Sorry! Game over! Bye!");
        System.exit(0);
    }

    public void collectSomeLife(){       
        life++;
        System.out.println("Great! Alien has more life! life = " + life);
    }
    
    public void swallowGoldCoins(){       
        goldCoins++;
        System.out.println("Alien is getting richer! gold coins = " + goldCoins);
    }
    
    public void gameWin(){      
        System.out.println("You win! Well done!");
        System.exit(0);
    }   
    
    public void imageChangeRight(){       
        removeAllImages();
        addImage(coolAlienImageRight);
    }
    
    public void imageChangeLeft(){       
        removeAllImages();
        addImage(coolAlienImageLeft);
    }   
}
 