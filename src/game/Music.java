
package game;
import city.cs.engine.SoundClip;
import city.cs.engine.UserView;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;                

/**
 * Music class extends SoundClip.
 * @author Negar
 */
public class Music extends SoundClip {

    public Music(String fileName) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(fileName);
    }
    
    @Override
    public void play(){
        super.play();
    }

}