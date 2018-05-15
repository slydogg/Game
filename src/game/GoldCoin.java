package game;

import city.cs.engine.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * GoldCoin class extends DynamicBody.
 * @author Negar
 */
public class GoldCoin extends DynamicBody{
    
   private static final Shape goldCoinShape = new PolygonShape(
         -1.086f,1.08f, -1.077f,-0.802f, 1.041f,-0.785f, 1.043f,1.086f);
   
   private static final BodyImage goldCoinImage = new BodyImage("data/goldcoin.png", 2.25f);
    private Music music;

   private static SoundClip GoldCoinSound;

   public GoldCoin(World world) {
        
       super(world, goldCoinShape);
       addImage(goldCoinImage);
              
   }   
   
   


   
   
   
   
   
   
}