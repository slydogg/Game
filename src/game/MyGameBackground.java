package game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
/**
 * MyGameBackground class Extends user view.
 * @author Negar
 */
public class MyGameBackground extends UserView {
    Image  timerImage = Toolkit.getDefaultToolkit().createImage("data/timer.png");

    private final String life;
    private String coins;
    Image star = Toolkit.getDefaultToolkit().createImage("data/index.png");
    private final Image background1, background2, background3, background4;
    private Image lifeHeart;
    private final CoolAlien player;
    private final Game game;
    private AbstractGameClass gameLevel;
    
    private final int starSize = 50;
    
/**
 * 
 * @param world
 * @param width
 * @param height
 * @param game 
 */
    public MyGameBackground(AbstractGameClass world, int width, int height, Game game) {
        
        super(world, width, height);        
        this.game = game;
        player = game.getCoolAlien();
        background1 = new ImageIcon("data/background1.jpg").getImage();
        background2 = new ImageIcon("data/background2.png").getImage();
        background3 = new ImageIcon("data/background3.jpg").getImage();
        background4 = new ImageIcon("data/background4.png").getImage();
                
     
        life = "LIFE = ";      
    }
    
    
    
    @Override
    protected void paintBackground(Graphics2D g) {
        
        int mins = 0;
        String minutes = null;
        int secs = 0;
        String seconds = null;
        
        
        
        switch (game.getNumberOfLevel()) {
            case 1:
                g.drawImage(background2, 0, 0, this);
                mins = game.getLevel1time()/60;
         minutes = String.valueOf(mins);
         secs = game.getLevel1time() % 60;
        seconds = String.valueOf(secs);
        
                break;
            case 2:
                g.drawImage(background4, 0, 0, this);
                         mins = game.getLevel2time()/60;
         minutes = String.valueOf(mins);
         secs = game.getLevel2time() % 60;
        seconds = String.valueOf(secs);
                break;
            case 3:
                g.drawImage(background2, 0, 0, this);
                         mins = game.getLevel3time()/60;
         minutes = String.valueOf(mins);
         secs = game.getLevel3time() % 60;
        seconds = String.valueOf(secs);
                break;
            case 4: 
                g.drawImage(background4, 0, 0, this);
                break;
            default:
                break;
        }
        
        g.drawImage(star, 150, 50, starSize, starSize, this);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Garamond",Font.BOLD,20));
        
        
        g.drawString("GoldCoins : "+(game.getScore()), 150, 50);
        g.drawString("Life left : "+(game.getLife()), 150, 80);
        g.drawImage(timerImage, 785, 20, 100, 100, this);

            if (secs < 10) {

                g.drawString(minutes + ": " + "0" + seconds, 815, 77);

            }

            if (secs >= 10) {
                g.drawString(minutes + ": " + seconds, 815, 77);

            }

            if (mins == 0 && secs <= 30) {
                g.setColor(Color.red);

                if (secs < 10) {
                    g.drawString(minutes + ": " + "0" + seconds, 815, 77);
                } else {
                    g.drawString(minutes + ": " + seconds, 815, 77);
                }
            }
        

    }
    
    

    
}

