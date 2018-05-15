/*
This CONTROLLER class includes all code for object movement + object collision
*/

package game;

import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * Controller class extends Key Adapter.
 * @author Negar
 */
public class Controller extends KeyAdapter {
    
    private static final float JUMPING_SPEED = 16;
    private static final float WALKING_SPEED = 6;
    private CoolAlien alien;
    
    public Controller(CoolAlien ca) {        
        this.alien = ca;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode();
        
        // SPACE = jump
        switch (code) {
            case KeyEvent.VK_SPACE:
                Vec2 v = alien.getLinearVelocity();
                // only jump if body is not already jumping
                if (Math.abs(v.y) < 0.01f)
                    alien.jump(JUMPING_SPEED);
                break;
            case KeyEvent.VK_I:
                alien.startWalking(-WALKING_SPEED);
                alien.removeAllImages();
                alien.imageChangeLeft();
                break;
            case KeyEvent.VK_P:
                alien.startWalking(WALKING_SPEED);
                alien.removeAllImages();
                alien.imageChangeRight();
                break;
            default:
                break;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode();
        
        if (code == KeyEvent.VK_I){
            alien.stopWalking();
        }       
        else if (code == KeyEvent.VK_P){
            alien.stopWalking();
        }
    }
    
    public void setBody(CoolAlien ca) {
        this.alien = ca;
    }
}
