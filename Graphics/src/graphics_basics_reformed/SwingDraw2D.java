package graphics_basics_reformed;

import javax.swing.*;
import java.awt.*;

public class SwingDraw2D extends JFrame {
    Grid G;
    SwingDraw2D(Grid G) {
        this.G = G;
        setSize(G.gridsizeWidth + 30, G.gridsizeHeight + 50);


        add(new panel());
        setVisible(true);
    }


    class panel extends JPanel {
        panel() {

        }

        protected void paintComponent(Graphics g){
            super.paintComponent(g);

            //Light Reaching Test Component
            /*
            int iter = 0;
            for(int i = 0; i < G.gridsizeHeight; i++) {
                for(int j = 0; j < G.gridsizeWidth; j++) {
                    if(G.grid.get(iter).peakDistanceFromLight < 150) {
                        g.fillRect(j, i, 1, 1);
                    }
                    iter++;
                }
            }
            */

            //Light Reaching according to slope component
            int iter = 0;
            for(int i = 0; i < G.gridsizeHeight; i++) {
                for(int j = 0; j < G.gridsizeWidth; j++) {
                    if(G.grid.get(iter).peakDistanceFromLight < 200) {
                        g.fillRect(j, i, 1, 1);
                    }
                    iter++;
                }
            }
        }
    }
}
