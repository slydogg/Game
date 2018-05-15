/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import city.cs.engine.*;
import java.awt.Font;
import static java.awt.Color.*;
import java.awt.Graphics2D;

/**
 *Class GameView extends User view.
 * @author Negar
 */
public class GameView extends UserView{
    private final Game game;
    
//private image background;
        
   public GameView (World world, Game game,int width,int height)
   {
    
    
   super(world,width,height);
   this.game = game;
   }
   
  //@override
    @Override
   protected void paintForeground(Graphics2D g)
   {
    
    g.setColor(BLACK);
    g.drawRect(0,0, 200, 50);
    g.setFont(new Font("Arial",Font.BOLD, 20));
    //g.drawString("Life Count: " + "22");
    

   //TOP_ALIGNMENT, TOP_ALIGNMENT);
    
    //+ game.getPlayer().getLifeCount(),20,10);
    //g.drawString("current score: " +game.getPlayer().getSkatecount(),20,30);
       
   }
}   
