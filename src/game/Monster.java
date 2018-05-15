package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Enemy class of type monster. Extends StaticBody.
 * @author Negar
 */
public class Monster extends Walker{
    MonsterController monsterC;
    
   private static final Shape monsterShape = new PolygonShape(
        -1.024f,1.083f, -1.001f,-0.79f, 0.97f,-0.762f, 0.998f,1.094f
);
    
    private static final BodyImage monsterImage = new BodyImage("data/monster.png", 2.25f);
    
    /**
     * Constructor for the Monster class.
     * @param world Passes in he world that the object is created in. 
     */
    public Monster(World world) {
         
        super(world, monsterShape);        
        addImage(monsterImage); 
        this.setGravityScale(0);
        monsterC = new MonsterController(this);
    }
    
    
   
}        

