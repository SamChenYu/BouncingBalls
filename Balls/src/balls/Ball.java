
package balls;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball {
    
    Random r = new Random();
    int screenWidth, screenHeight;
    
    int radius;
    int x;
    int y;
    double initialY;
    boolean falling = true;
    boolean parabolaArc = false;
    int continousFallingAccelerator = 0;
    
    Color color;
    
    double velocity;
    
    
    public Ball(int x, int y, int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        radius = r.nextInt(29) + 20;
        
        this.x = x;
        this.y = y;
        this.initialY = (double) y;
        
        int red = r.nextInt(256);   // Generates a random value between 0 and 255
        int green = r.nextInt(256);
        int blue = r.nextInt(256);

        color = new Color(red, green, blue);
        velocity = 10;//r.nextInt(30);
        
    }
    
    
    public void update() {
        
        
        if(velocity > 0.05) {
            if(parabolaArc) {;
                parabolaArc();
            } 
            else {
                if(falling) {
                    fall();
            } 
                else {
                    bounce();
                }
            }
        }

    }
    
    
        public void fall() {
        // if it is above the screenHeight fall
        if(y < screenHeight - (radius*2)) {
            
            
            if(continousFallingAccelerator > 1) {
                velocity = velocity * 1.058;
            }
            
            y+=velocity;
            continousFallingAccelerator++;
        }
        // if there contact with ground and there is velocity, change to bounce
        if(y >= screenHeight - (radius*2) && velocity > 0) {
            falling = false;
            parabolaArc = true;
            velocity = velocity * 0.8;
            initialY = initialY * 1.2;
            continousFallingAccelerator = 0;
        }
    }
        
    public void parabolaArc() {
        if(velocity > 0.82) {
            velocity = velocity * 0.95;
            y-=velocity;
        }
        if(velocity <= 0.82) {
            parabolaArc = false;
            falling = true;
        }
    }
    
    public void bounce() {
        // it will only reach up to the initialY 
        if(y>initialY) {
            y-=velocity;
            velocity = velocity * 0.98;
        }
        // if it reaches the initialY it will lose momentum and fall again
        if(y<=initialY) {
            falling = true;
            velocity = velocity * 0.8;
            
        }
    }
    
    
    

    
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x,y,radius,radius);
    }
    
    
    
    
}