package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
// Other imports omitted
 
class TimerHandler implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Action event!");
    }
}
 
//public class GameLevel1 extends GameLevel1 implements ActionListener {
   // private static final int coins = 3;
   // private Timer timer;
 
    //public void populate(Game game) {
        // Code omitted
        //timer = new Timer(1000, new TimerHandler());
        //timer.setInitialDelay(100); 
        //timer.start();
    //}
//}