package game;

import city.cs.engine.*;
/**
 * GoldBox class extends StaticBody.
 * Initialise a new static body with no shapes attached.
 * @author Negar
 */
public class GoldBox extends StaticBody{
    
    private static final Shape goldBoxShape = new PolygonShape(
        -1.14f,1.113f, -1.116f,-0.927f, 1.08f,-0.915f, 1.077f,1.068f);
    
    private static final BodyImage goldBoxImage = new BodyImage("data/goldbox.png", 2.25f);
    
    public GoldBox(World world) {
         
        super(world, goldBoxShape);       
        addImage(goldBoxImage);        
     }   
}
