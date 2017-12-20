package graphics_basics_reformed;

import javax.swing.*;
import java.awt.*;

public class SonarDraw2D extends JFrame implements Runnable {
    Grid G;
    int x = 0;
    int[][] GridArray;

    SonarDraw2D(Grid G) {
        this.G = G;
        setSize(G.gridsizeWidth, G.gridsizeHeight);
        int mx = G.grid.get(0).height;
        for(int i = 0; i < G.grid.size(); i++) {
            if(mx < G.grid.get(i).height) {
                mx = G.grid.get(i).height;
            }
        }
        x = mx;
        gridconverter();

        while(x > -1000) {
            this.run();
        }
    }

    public void run() {
        x = x - 1;
        System.out.println(" x : " + x);
        /*
        try {
            Thread.sleep(10);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        */


        add(new Panel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        validate();
        repaint();
    }

    public void gridconverter() {
        int iter = 0;
        GridArray = new int[G.gridsizeHeight][G.gridsizeWidth];
        for(int i = 0; i < G.gridsizeHeight; i++) {
            for(int j = 0; j < G.gridsizeWidth; j++) {
                GridArray[i][j] = G.grid.get(iter).height;
                iter++;
            }
        }
    }

    class Panel extends JPanel {

        Panel() {

        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int iter = 0;
            for(int i = 0; i < G.gridsizeHeight; i++) {
                for(int j = 0; j < G.gridsizeWidth; j++) {
//                    if(G.grid.get(iter).height < (x + 3) && G.grid.get(iter).height > (x - 3)) {
//                        g.drawOval(j, i, 1, 1);
//                    }
                    if(GridArray[i][j] == x) {
                        g.drawOval(j, i, 1, 1);
                    }
                    iter++;
                }
            }
        }

    }
}
