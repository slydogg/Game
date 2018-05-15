package game;

import city.cs.engine.*;
/**
 * Magical Door class extends static body.
 * @author Negar
 */
public class MagicalDoor extends StaticBody { 
    
   private static final Shape magicalDoorShape = new PolygonShape(
            -2.07f,1.041f, -2.031f,-0.928f, 1.884f,-0.934f, 1.924f,1.052f);
   
   private static final BodyImage magicalDoorImage = new BodyImage("data/magicaldoor.png", 2.25f);

    public MagicalDoor(World world) {
        
       super(world, magicalDoorShape);
       addImage(magicalDoorImage);             
    }
}
