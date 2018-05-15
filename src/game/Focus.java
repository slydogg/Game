package game;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * The class Focus extends MouseAdapter.
 * @author Negar
 */
public class Focus extends MouseAdapter {
    
    private Component target;
   
    public Focus(Component t) {       
        this.target = t;
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {       
        target.requestFocus();
    }
}

