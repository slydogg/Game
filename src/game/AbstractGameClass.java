
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
/**
 * Abstract game class extends World.
 * @author Negar
 */
public abstract class AbstractGameClass extends World{
    
    public void populate(Game game) {}
       
    public abstract Vec2 setCoolAlienPosition(float x, float y);  
    public abstract Vec2 setMagicalDoorPosition(float x, float y); 
    public abstract Vec2 setGoldBoxPosition(float x, float y); 
    public abstract Vec2 setMonsterPosition(float x, float y);   
    public abstract Vec2 setEnergyHeartPosition(float x, float y); 
    public abstract Vec2 setGoldCoinPosition(float x, float y);
    public abstract Vec2 setBasePlatformPosition(float x, float y);
    public abstract Vec2 setMiddlePlatform(float x, float y);
    public abstract Vec2 setUpperPlatform(float x, float y);
    //create more platfoms?

    public abstract boolean isCompleted();   
    public abstract CoolAlien getAlien();
    public abstract boolean allCoinsCollected();
    
}
