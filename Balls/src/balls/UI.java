
package balls;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

    

public final class UI extends JPanel  implements Runnable {
        
    Thread thread;
    long fpsDelay = 1000/60; // Miliseconds
    int screenWidth = 800;
    int screenHeight = 800;
    ArrayList<Ball> balls = new ArrayList<>();
    
    MouseAdapter mouseA= new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
                Ball newball = new Ball(e.getX(), e.getY(), screenWidth, screenHeight);
                balls.add(newball);
                System.out.println(balls.size());
        }
    }; // End mouseAdapter
    
        MouseMotionListener mouseL = new MouseMotionListener() {
        @Override
        public void mouseDragged(MouseEvent e){
                Ball newball = new Ball(e.getX(), e.getY(), screenWidth, screenHeight);
                balls.add(newball);
                System.out.println(balls.size());
        } 
        @Override 
        public void mouseMoved(MouseEvent e) {
        };
    }; // End MouseListener
    
    
    
    public UI() {
       setBackground(Color.WHITE);
       addMouseListener(mouseA);
       addMouseMotionListener(mouseL);
       startThread();
       setSize(screenWidth, screenHeight);
       
    }
    
    public void startThread() {
        thread = new Thread(this);
        thread.start();
    }
    
    
    public void update() {
        for(int i=0; i<balls.size(); i++) {
            balls.get(i).update();
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        for(int i=0; i<balls.size(); i++) {
            balls.get(i).draw(g);
        }
        g.setColor(Color.RED);
    }
    
    @Override
    public void run() {
        
        while(true) {
            try {
                Thread.sleep(fpsDelay);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            update();
            repaint();
        }
    }
    

}


