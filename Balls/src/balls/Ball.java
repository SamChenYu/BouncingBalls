
package balls;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball {
    
    // Driver Variables
    
    Random r = new Random();
    int screenWidth, screenHeight;
    Color color;
    
    // Oval Variables
    
    int radius;
    int x;
    int y;
    
    // Update Variables
    
    boolean falling = true;
    double velocity;
    
    
    public Ball(int x, int y, int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        radius = r.nextInt(29) + 20;
        
        this.x = x;
        this.y = y;
        
        int red = r.nextInt(256);   // Generates a random value between 0 and 255
        int green = r.nextInt(256);
        int blue = r.nextInt(256);

        color = new Color(red, green, blue);
        velocity = 10;//r.nextInt(30);
        
    }
    
    
    public void update() {
        
        
        if(velocity > 0.05) {
                if(falling) {
                    fall();
            } 
                else {
                    bounce();
                }
            
        }

    }
    
    
        public void fall() {
        // if it is above the screenHeight fall
        if(y < screenHeight - (radius*2)) {
            
            // Accelerate as it falls 
            velocity = velocity * 1.06;
            y+=velocity;
        }
        // if there contact with ground and there is velocity, change to bounce
        if(y >= screenHeight - (radius*2) && velocity > 0) {
            falling = false;
            velocity = velocity * 0.6;
        }
    }
 
    
    public void bounce() {
        // basically reduce the velocity until it is 0.82
        // it is so slow pretty
        if(velocity > 0.82) {
            velocity = velocity * 0.95;
            y-=velocity;
        }
        if(velocity <= 0.82) {
            falling = true;
        }
    }
    
    
    

    
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x,y,radius,radius);
    }
    
    
    
    
}
