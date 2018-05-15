/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Negar
 */
public class MonsterController {
    
    
    private static  float JUMPING_SPEED = -3f;
    private static final float WALKING_SPEED = 0.5f;
    private Monster monster;
    
    public MonsterController(Monster ca) {   
        
        this.monster = ca;
            
         ActionListener taskPerformer = new ActionListener() {
             
  
            public void actionPerformed(ActionEvent evt) {
               // monster.stopWalking();
               if (System.currentTimeMillis()%4 == 1){
                   JUMPING_SPEED = JUMPING_SPEED *-1;
               }
               
               if (System.currentTimeMillis()%4 == 2){
                   JUMPING_SPEED = JUMPING_SPEED *-2;
               }
               
               if (System.currentTimeMillis()%4 == 3){
                   JUMPING_SPEED = JUMPING_SPEED *-0.5f;
               }
                float speed = (float) Math.random()*JUMPING_SPEED;
            monster.startWalking(speed);
                
               
           
               
           
               
               

            }
        };
    
        Timer timer = new Timer(500 , taskPerformer);
        timer.start();
    }


    
    
    
    public void setBody(Monster ca) {
        this.monster = ca;
    }
}

