package game;

import city.cs.engine.*;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
/**
 * Class Game is abstract class game.
 * @author Negar
 */
public class Game{
    JFrame frame;
    private AbstractGameClass absGameClass;
    private int levelNumber, life;
    private UserView view;
    private ControlPanel panel;
    private CoolAlien coolAlien;            
    private Controller controller; 
    private GameView score;
    private Music music;
    private int level1time = 20;
    private int level2time = 18;
    private int level3time = 16;

    public Music getMusic() {
        return music;
    }

    public int getLevel1time() {
        return level1time;
    }

    public int getLevel2time() {
        return level2time;
    }

    public int getLevel3time() {
        return level3time;
    }

    public void setLevel1time(int level1time) {
        this.level1time = level1time;
    }

    public void setLevel2time(int level2time) {
        this.level2time = level2time;
    }

    public void setLevel3time(int level3time) {
        this.level3time = level3time;
    }

    public JFrame getFrame() {
        return frame;
    }

    public Game(){
             
        absGameClass = new GameLevel1();
        absGameClass.populate(this);
        levelNumber = 1;
        life = 3;
        view = new UserView(absGameClass, 1000, 500);
        view = new MyGameBackground(absGameClass, 1000, 500, this);
        panel = new ControlPanel(this);
        coolAlien = absGameClass.getAlien();
//        score = new GameView(this);

        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        // display the view in a frame (quit the application when the game window is closed)
        frame = new JFrame("Encapsulation Demo");
        controller = new Controller(absGameClass.getAlien());  
        frame.addKeyListener(controller);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.add(view);    
        frame.add(panel, BorderLayout.NORTH);
        UserView wideView = new UserView(absGameClass, 500, 100);
        wideView.setZoom(4);
        frame.add(wideView, BorderLayout.SOUTH);
        
        // don't let the game window be resized:
        frame.setResizable(false);
        
        // size the game window to fit the world view:
        frame.pack();
        
        // make the window visible:
        frame.setVisible(true);

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);
        
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new Focus(frame));
        
        frame.addKeyListener(new Controller(absGameClass.getAlien()));
        
        try {
            music = new Music("data/song.wav");     
            music.setVolume(0.5f);
            music.loop();
            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //uncomment this to make the view track the soldier non-functional:
        absGameClass.addStepListener(new Tracker(view, absGameClass.getAlien()));

        // start!
        absGameClass.start();
    }

    
    public Game(boolean sound){
             
        absGameClass = new GameLevel1();
        absGameClass.populate(this);
        levelNumber = 1;
        life = 3;
        view = new UserView(absGameClass, 1000, 500);
        view = new MyGameBackground(absGameClass, 1000, 500, this);
        panel = new ControlPanel(this);
        coolAlien = absGameClass.getAlien();
//        score = new GameView(this);

        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        // display the view in a frame (quit the application when the game window is closed)
        frame = new JFrame("Encapsulation Demo");
        controller = new Controller(absGameClass.getAlien());  
        frame.addKeyListener(controller);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.add(view);    
        frame.add(panel, BorderLayout.NORTH);
        UserView wideView = new UserView(absGameClass, 500, 100);
        wideView.setZoom(4);
        frame.add(wideView, BorderLayout.SOUTH);
        
        // don't let the game window be resized:
        frame.setResizable(false);
        
        // size the game window to fit the world view:
        frame.pack();
        
        // make the window visible:
        frame.setVisible(true);

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);
        
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new Focus(frame));
        
        frame.addKeyListener(new Controller(absGameClass.getAlien()));
        if (sound ){
             try {
            music = new Music("data/song.wav");
             music.setVolume(0.5f);
            music.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        }
        
       
        //uncomment this to make the view track the soldier non-functional:
        absGameClass.addStepListener(new Tracker(view, absGameClass.getAlien()));

        // start!
        absGameClass.start();
    }

    
    
    
    
    
    public CoolAlien getCoolAlien() {       
        return absGameClass.getAlien();
    }

    public boolean isCurrentLevelCompleted() {       
        return absGameClass.isCompleted();
    }
    
    public AbstractGameClass getWorld(){      
        return absGameClass;       
    }
    
    public int getNumberOfLevel(){     
        return levelNumber;
    }
    
    public int getScore(){
        return coolAlien.getGoldCoins();
    
}
    public int getLife(){
        return coolAlien.getLife();
    }
    public void goToNextLevel(){
        
        switch (levelNumber) {
            case 1:
                absGameClass.stop();
                levelNumber++;
                absGameClass = new GameLevel2();
                absGameClass.populate(this);
                controller.setBody(absGameClass.getAlien());
                absGameClass.addStepListener(new Tracker(view, absGameClass.getAlien()));
                view.setWorld(absGameClass);
                coolAlien.setLife(life);
                absGameClass.start();
                break;
            case 2:
                absGameClass.stop();
                levelNumber++;
                absGameClass = new GameLevel3();
                absGameClass.populate(this);
                controller.setBody(absGameClass.getAlien());
                absGameClass.addStepListener(new Tracker(view, absGameClass.getAlien()));
                view.setWorld(absGameClass);
                coolAlien.setLife(life);
                absGameClass.start();
                break;
//            case 3:
//                absGameClass.stop();
//                levelNumber++;
//                absGameClass = new GameLevel3();
//                absGameClass.populate(this);
//                controller.setBody(absGameClass.getAlien());
//                absGameClass.addStepListener(new Tracker(view, absGameClass.getAlien()));
//                view.setWorld(absGameClass);
//                coolAlien.setLife(life);
//                absGameClass.start();
//                break;
            default:
                System.exit(0);
        }
    }
    
/////////////////////////////// RUNNING THE PROGRAM ////////////////////////////
/**
 * 
 * @param args  go to next level.
 */
    public static void main(String[] args) {
        
        //creating instance of GAME class in MAIN():
        Game game = new Game();
    }
}
