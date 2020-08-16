package ponggame1;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.*;
import javax.swing.JFrame;


public class Ponggame extends TimerTask{
     
    
    creategame game;

    Ponggame()
    {
        
        JFrame f=new JFrame();
        Toolkit t=f.getToolkit();
        Dimension size=t.getScreenSize();
        f.setBounds(0,0,size.width,size.height);
       // ball=new BallSpeed();
           
        game=new creategame();
        //f.add(ball); 
        f.add(game);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


        public static void main(String...s)
    {
         Ponggame pong=new Ponggame();
         Timer time=new Timer();
         time.schedule(pong, 3000,5000);
                  
    }

    @Override
    public void run() {
      //game.balldirX=game.balldirX-1;
    }

   
}

