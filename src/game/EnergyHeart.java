package game;

import city.cs.engine.*;
import java.awt.Polygon;
/**
 * EnergyHeart class extends Static body.
 * @author Negar
 */
public class EnergyHeart extends StaticBody{
    
    public static final Shape heartShape = new PolygonShape(
       -1.162f,1.101f, -1.135f,-0.924f, 1.079f,-0.93f, 1.1f,1.086f);
    
    public final static BodyImage heartImage = new BodyImage("data/energyheart.png", 2.25f);
    
    public EnergyHeart(World world){
        
        super(world, heartShape);
        addImage(heartImage);
    }    
}

