
package balls;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

    

public class Main extends JFrame {
    
    
    UI ui;

    
    
    
    public Main() {
        /*
        For full screen applications

        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        */
        
        

        
        ui = new UI();
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(ui);
        setResizable(false);
        setTitle("Balls");
        
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
    
}
