package graphics_basic;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class SwingDraw2D extends JFrame {
    Grid G;

    int base_light_reaching_distance = 0;
    int peak_light_reaching_distance = 0;

    SwingDraw2D(Grid G) {
        this.G = G;
        Scanner in = new Scanner(System.in);

        setSize(G.horizontal + 30, G.vertical + 50);
        System.out.println("Set the base light reaching distance");
        setBase_light_reaching_distance(in.nextInt());
        System.out.println("Set the peak light reaching distance");
        setPeak_light_reaching_distance(in.nextInt());

        add(new pnl());



        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    class pnl extends JPanel {
        pnl() {

        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            /*
            for(int y = 0; y < G.vertical; y++) {
                for(int x = 0; x < G.horizontal; x++) {
                    if(G.peak_distance_from_light[y][x] < peak_light_reaching_distance) {
                        g.drawOval(x, y, 1, 1 );
                    }
                }
            }
            */
            /*
            for(int y = 0; y < G.vertical; y++) {
                for(int x = 0; x < G.horizontal; x++) {
                    if(G.light_reacheable[y][x] == true) {
                        g.drawOval(x, y, 1, 1 );
                    }
                }
            }
            */
            for(int y = 0; y < G.vertical; y++) {
                for(int x = 0; x < G.horizontal; x++) {
                    if(G.light_reacheable[y][x] == true) {
                        g.drawOval(x * 10, y * 10, 10, 10 );
                    }
                }
            }
        }
    }

    public void setBase_light_reaching_distance(int dist) {
        this.base_light_reaching_distance = dist;
    }
    public void setPeak_light_reaching_distance(int dist) {
        this.peak_light_reaching_distance = dist;
    }
}
