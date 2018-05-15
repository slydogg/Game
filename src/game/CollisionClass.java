package game;

import city.cs.engine.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * Collision class implements Collision Listener.
 * @author Negar
 */
public class CollisionClass implements CollisionListener {
    
    private final CoolAlien bibo;
    SoundClip sound;
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
            else if (e.getReportingBody() instanceof Monster){
                
            
                bibo.loseSomeLife();
                try {
                    sound = new SoundClip ("data/over.wav");
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    Logger.getLogger(CollisionClass.class.getName()).log(Level.SEVERE, null, ex);
                }
                 sound.setVolume(2);
                    sound.play();
        }
            
            
            else if (e.getReportingBody() instanceof GoldCoin){
                bibo.swallowGoldCoins();
                try {
                 sound = new SoundClip ("data/Arrow.wav");
                 sound.setVolume(2);
                    sound.play();
                    
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    Logger.getLogger(CollisionClass.class.getName()).log(Level.SEVERE, null, ex);
                }
                e.getReportingBody().destroy(); 
                
                
                
                
            }           
            else if (e.getReportingBody() instanceof GoldBox)
                bibo.gameWin();
        }
    } 
}
