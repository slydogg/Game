package game;

import city.cs.engine.*;
/**
 * Collision class implements Collision Listener.
 * @author Negar
 */
public class CollisionClass implements CollisionListener {
    
    private final CoolAlien bibo;
    /**
     * Constructor for the Collision class.
     * @param ca Passes in he world that the object is created in.
     */
    public CollisionClass(CoolAlien ca) {       
        this.bibo = ca;
    }

    @Override
    public void collide(CollisionEvent e) {
        
        if (e.getOtherBody() == bibo) {

            if (e.getReportingBody() instanceof EnergyHeart){
                bibo.addSomeLife();
                e.getReportingBody().destroy();
            }          
            else if (e.getReportingBody() instanceof Monster)
                bibo.loseSomeLife();
            
            else if (e.getReportingBody() instanceof GoldCoin){
                bibo.swallowGoldCoins();
                e.getReportingBody().destroy(); 
                
                
                
                
            }           
            else if (e.getReportingBody() instanceof GoldBox)
                bibo.gameWin();
        }
    } 
}
