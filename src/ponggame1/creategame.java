package ponggame1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_F;
import static java.awt.event.KeyEvent.VK_J;
import static java.awt.event.KeyEvent.VK_N;
import static java.awt.event.KeyEvent.VK_V;
import java.awt.event.KeyListener;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class creategame extends JPanel implements KeyListener, ActionListener
{
    public int ballposX;
    public int ballposY;
    public int balldirX=-4;
    public int balldirY=-4;
    int playerY=400;
    int playerYY=400;
    private int scorePlayerA=0;
    private int scorePlayerB=0;
    private boolean play=false;
    int chances=0;
   

    JFrame f;
    Toolkit t;
    Dimension size;
    private Timer timer;
    private int delay=10;
    creategame()
    {

        
        addKeyListener(this);
        setFocusable(true);
        f=new JFrame();
        t=f.getToolkit();
        size=t.getScreenSize();
        ballposX=size.width/2;
        ballposY=size.height/2;
        f.setVisible(false);
        setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
        timer.start();
    }
    Graphics ball;
    public void paint(Graphics g)
    {
        ball=g;
        g.setColor(Color.black);
        g.fillRect(0, 0, size.width, size.height);
        
        //paddle 1
        g.setColor(Color.green);
        g.fillRect(1, playerY, 15, 150);


        //paddle 2
        g.setColor(Color.yellow);
        g.fillRect(size.width-33, playerYY, 15, 150);
    
        
        //ball
        createBall(g);
        
        
                
        
        //scoresPlayerA
        
        g.setColor(Color.green);
        g.setFont(new Font("serif",Font.BOLD,30));
        g.drawString("PlayerA  "+scorePlayerA, 10, 25);

        //scoresPlayerB

        g.setColor(Color.yellow);
        g.setFont(new Font("serif",Font.BOLD,30));
        g.drawString("PlayerB  "+scorePlayerB, size.width-180, 25);

        if(scorePlayerA>=50)
        {
            g.setColor(Color.white);
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("Game Over, Press Enter to restart", 400, 400);
            g.drawString("player green won", 400, 432);
            play=false;
        }
        else if(scorePlayerB>=50)
        {
            g.setColor(Color.white);
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("Game Over, Press Enter to restart", 400, 400);
            g.drawString("player green won", 400, 432);
            play=false;
        }
        g.dispose();
    }
    @Override
    public void keyTyped(KeyEvent e) {
      
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_F)
        {
            if(size.height-200<playerY)
                playerY=size.height-200;
            else
            {
             play=true;
             playerY+=20;
            }
        }
        else if(e.getKeyCode()==KeyEvent.VK_J)
        {
            if(playerY<20)
               playerY=20;
            else
            {
              play=true;
              playerY-=20;
            }
        }
        else if(e.getKeyCode()==KeyEvent.VK_V)
        {
            if(size.height-200<playerYY)
                playerYY=size.height-200;
            else
            {
             play=true;
             playerYY+=20;
            }
        }
        else if(e.getKeyCode()==KeyEvent.VK_N)
        {
            if(playerYY<20)
               playerYY=20;
            else
            {
              play=true;
              playerYY-=20;
            }        
        } 
        else if(e.getKeyCode()==KeyEvent.VK_ENTER)
        {
         balldirX=-4;
         balldirY=-4;
         playerY=400;
         playerYY=400;
         scorePlayerA=0;
         scorePlayerB=0;      
         ballposX=size.width/2;
         ballposY=size.height/2;
         play=true;
        }
      
    }
    @Override
    public void keyReleased(KeyEvent arg0) {}

    @Override
    public void actionPerformed(ActionEvent arg0) {
       
     
            
            if(new Rectangle(ballposX,ballposY,30,30).intersects(new Rectangle(1,playerY,10,150)))
                balldirX=-balldirX;
             
            if(new Rectangle(ballposX,ballposY,30,30).intersects(new Rectangle(size.width-25,playerYY,10,150)))
                balldirX=-balldirX;
            
        if(play)
        {   
            ballposX+=balldirX;
            ballposY+=balldirY;
            
            if(ballposY>size.height-70)
            {
               
                balldirY=-balldirY;
            }
            else if(ballposY<10)
            {
                
                balldirY=-balldirY;
            }
            else if(ballposX<0)
            {
                ballposX=size.width/2;
                ballposY=size.height/2;
                createBall(ball);
                scorePlayerB+=5;
            }
            else if(ballposX>size.width-2)
            {
                ballposX=size.width/2;
                ballposY=size.height/2;
                createBall(ball);
                scorePlayerA+=5;
            }
            
        }     
       repaint();
    }
    
    
    /*public void run()
    {
        balldirX=balldirX++;
        balldirY=balldirY++;
    }*/
    
    
    
    private void createBall(Graphics g)
    {
        g.setColor(Color.red);
        g.fillOval(ballposX,ballposY,30,30);        
    }
}
