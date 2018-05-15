package game;

 import city.cs.engine.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

/**
 * GameLevel 4 class extends abstract game class.
 * @author Negar
 */
public class GameLevel3 extends AbstractGameClass {
                 boolean gameOver = false; 

    private CoolAlien coolAlien;
    private Monster monster1, monster2, monster3, monster4, monster5, monster6;
    private GoldBox goldBox;
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
                    xMonster4, 
                    yMonster4,
                    xMonster5, 
                    yMonster5,
                    xMonster6, 
                    yMonster6,
                    xGoldBox, 
                    yGoldBox,
                    xMagiclaDoor,
                    yMagicalDoor,
                    xHeart, 
                    yHeart;
    
    private int numberOfCoinsCollected;
    private int time = 30;
       
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
        
        numberOfCoinsCollected = 4;
                     
////////////////////////////  all 4 characters in the game: //////////////////////////////
        
       
        coolAlien = new CoolAlien(this);
        coolAlien.setPosition(setCoolAlienPosition(8, -10));
        
//        monster1= new Monster(this);
//        monster1.setPosition(setMonsterPosition(9, -9));
//        monster1.addCollisionListener(new CollisionClass(coolAlien));
//       
        monster2 = new Monster(this);
        monster2.setPosition(setMonsterPosition(-8, -8));      
        monster2.addCollisionListener(new CollisionClass(coolAlien));
        
        monster3 = new Monster(this);
        monster3.setPosition(setMonsterPosition(12, 9));      
        monster3.addCollisionListener(new CollisionClass(coolAlien));
        
        monster4 = new Monster(this);
        monster4.setPosition(setMonsterPosition(5, -0.5f));      
        monster4.addCollisionListener(new CollisionClass(coolAlien));
        
        monster5 = new Monster(this);
        monster5.setPosition(setMonsterPosition(-7, -2));      
        monster5.addCollisionListener(new CollisionClass(coolAlien));
        
        monster6 = new Monster(this);
        monster6.setPosition(setMonsterPosition(-3, -6));      
        monster6.addCollisionListener(new CollisionClass(coolAlien));

        heart = new EnergyHeart(this);
        heart.setPosition(setEnergyHeartPosition(-12, 3.5f));
        heart.addCollisionListener(new CollisionClass(coolAlien));

 
        for(int i=0; i<numberOfCoinsCollected; i++){
            coin = new GoldCoin(this);
            coin.setPosition(setEnergyHeartPosition(i*1+1, -10));
            coin.addCollisionListener(new CollisionClass(coolAlien));
        }
        
        goldBox = new GoldBox(this);
        goldBox.setPosition(setGoldBoxPosition(16, 4));
        goldBox.addCollisionListener(new CollisionClass(coolAlien));
                                   
        //ground platform:
        Shape groundShape = new BoxShape(20, 1.0f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(setBasePlatformPosition(0, -11.5f));
        ground.setFillColor(Color.ORANGE);

        
        //long middle-low platform:
        Shape middlePlatformShape = new BoxShape(7, 0.1f);
        Body platform1 = new StaticBody(this, middlePlatformShape);
        platform1.setPosition(setMiddlePlatform(5, -11.5f));
        platform1.setFillColor(Color.RED);
        
        Body platform2 = new StaticBody(this, middlePlatformShape);
        platform2.setPosition(setMiddlePlatform(5, -1.5f));
        platform2.setFillColor(Color.YELLOW);
        
        Body platform3 =new StaticBody(this, middlePlatformShape);
        platform3.setPosition(setMiddlePlatform(15,-7.5f));
        platform3.setFillColor(Color.red);
        
               
         ActionListener taskPerformer = new ActionListener() {
             
  
            public void actionPerformed(ActionEvent evt) {
             if (game.getNumberOfLevel()== 3 && gameOver == false){
               game.setLevel3time(game.getLevel3time()-1);
               if (game.getLevel3time() <= 0){
                   GameLevel3.this.stop();
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
    
        Timer timer = new Timer(1000, taskPerformer);
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

