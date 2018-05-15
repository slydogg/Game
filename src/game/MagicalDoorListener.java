
package game;

import city.cs.engine.*;
/**
 * MagicalDoorListener class implements collisionListener.
 * @author Negar
 */
public class MagicalDoorListener implements CollisionListener{
    
    private Game game;
    private CoolAlien coolAlien;
    
    public MagicalDoorListener(Game game){
        this.game = game;
    }
    
    @Override
    public void collide(CollisionEvent e){
        
        coolAlien = game.getCoolAlien();
        
        if(e.getOtherBody() == coolAlien && game.isCurrentLevelCompleted()){
            System.out.println("Super! Now going to next level!");
            game.goToNextLevel();
        }
    }
}
