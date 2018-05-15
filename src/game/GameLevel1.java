package game;

import city.cs.engine.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * The class GameLevel 1 extends Abstract Game Class.
 * @author Negar
 */
public class GameLevel1 extends AbstractGameClass {
             boolean gameOver = false; 

    private CoolAlien coolAlien;
    private Monster monster1, monster2, monster3;
    private GoldBox goldBox;
    private MagicalDoor magicalDoor;
    private EnergyHeart heart;
    private GoldCoin coin;
    private float   xAlien,
                    yAlien,
                    xMonster1,
                    yMonster1, 
                    xMonster2,
                    yMonster2,
                    xMonster3, 
                    yMonster3,
                    xGoldBox, 
                    yGoldBox,
                    xMagiclaDoor,
                    yMagicalDoor,
                    xHeart, 
                    yHeart;
    
    private int numberOfCoinsCollected;
    private int time = 50;
    private SoundClip gameMusic;
    
    
    
    @Override
    public void populate(Game game) {
        
        super.populate(game);
        
        xAlien = 8;
        yAlien = -10;
        xMonster1 = 3;
        yMonster1 = 0;      
        xMonster2 = -8;
        yMonster2 = -8;
        xMonster3 = 6;
        yMonster3 = 0; 
        xGoldBox = 10; 
        yGoldBox = -5;
        xMagiclaDoor = 10;
        yMagicalDoor = 10;
        xHeart = 10; 
        yHeart = 0;
        
        numberOfCoinsCollected = 1;
                     
////////////////////////////  all 4 characters in the game: //////////////////////////////
        
        //Soldier object:
        coolAlien = new CoolAlien(this);
        coolAlien.setPosition(setCoolAlienPosition(8, -10));

        //Portal object (+ collision with SOLDIER)
        magicalDoor = new MagicalDoor(this);
        magicalDoor.setPosition(setMagicalDoorPosition(10, 10));
        magicalDoor.addCollisionListener(new MagicalDoorListener(game));

        monster1= new Monster(this);
        monster1.setPosition(setMonsterPosition(3, 0));
        monster1.addCollisionListener(new CollisionClass(coolAlien));
       
        monster2 = new Monster(this);
        monster2.setPosition(setMonsterPosition(-8, -8));      
        monster2.addCollisionListener(new CollisionClass(coolAlien));
        
        monster3 = new Monster(this);
        monster3.setPosition(setMonsterPosition(2, -5));      
        monster3.addCollisionListener(new CollisionClass(coolAlien));

        heart = new EnergyHeart(this);
        heart.setPosition(setEnergyHeartPosition(-12, 3.5f));
        heart.addCollisionListener(new CollisionClass(coolAlien));
        

  
        for(int i=0; i<numberOfCoinsCollected; i++){
            coin = new GoldCoin(this);
            coin.setPosition(setEnergyHeartPosition(i*1+1, -10));
            coin.addCollisionListener(new CollisionClass(coolAlien));
            
            
        }
                                   
        //ground platform:
        Shape groundShape = new BoxShape(20, 1.0f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(setBasePlatformPosition(0, -11.5f));
        ground.setFillColor(Color.PINK);

        
         //walls
        Shape wallShape = new BoxShape(0.5f, 6);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-20.5f, -2));
        Body rightWall = new StaticBody(this,wallShape);
        rightWall.setPosition(new Vec2(20.5f, -2));
        
        
        
        
        
        //long middle-low platform:
        Shape middlePlatformShape = new BoxShape(7, 0.1f);
        Body platform1 = new StaticBody(this, middlePlatformShape);
        platform1.setPosition(setMiddlePlatform(5, -1.5f));
        platform1.setFillColor(Color.black);
        
       
        
         ActionListener taskPerformer = new ActionListener() {
             
  
            public void actionPerformed(ActionEvent evt) {
             if (game.getNumberOfLevel()== 1 && gameOver == false){
               game.setLevel1time(game.getLevel1time()-1);
               
               if (game.getLevel1time() <= 0){
                   
                   game.setLevel1time(game.getLevel1time()-1);
                   
                   GameLevel1.this.stop();
                   game.getMusic().stop();
                   JOptionPane.showMessageDialog(null, "Time is over ","Game Over.",JOptionPane.OK_OPTION);
                   game.getFrame().dispose();
                   Screen screen = new Screen();
                   screen.setVisible(true);
                   gameOver = true;
                   
    }
        
             }
                
               
           
               
           
               
               

            }
        };
    
        Timer timer = new Timer(1500, taskPerformer);
        timer.start();
                       
  
        
        
        
        
        
        
        
    }
    
                       
  
    @Override   
    public CoolAlien getAlien(){          
        return coolAlien;
    } 
       
    @Override
    public Vec2 setCoolAlienPosition(float x, float y) {
        return new Vec2(x, y);
    }

    @Override
    public Vec2 setMagicalDoorPosition(float x, float y) {
        return new Vec2(x, y);
    }
    
    
    @Override
    public Vec2 setMonsterPosition(float x, float y){
        return new Vec2(x, y);
    }
    
    @Override
    public Vec2 setGoldCoinPosition(float x, float y){
        return new Vec2(x, y);
    }
    
    @Override
    public Vec2 setGoldBoxPosition(float x, float y){
        return new Vec2(x, y);
    
    }
   
    @Override
    public Vec2 setEnergyHeartPosition(float x, float y){
        return new Vec2(x, y);
    }
    
    
    @Override
    public Vec2 setBasePlatformPosition(float x, float y){
        return new Vec2(x, y);
    }
    
    @Override
    public Vec2 setMiddlePlatform(float x, float y){
        return new Vec2(x, y);       
    }
    
    
    @Override
    public Vec2 setUpperPlatform(float x, float y){
        return new Vec2(x, y);       
    }
    

    @Override
    public boolean allCoinsCollected(){
        return coolAlien.getGoldCoins() == numberOfCoinsCollected;
    }

    @Override
    public boolean isCompleted() {  
        
    
        return coolAlien.getGoldCoins() ==  numberOfCoinsCollected;

        
    }
}
