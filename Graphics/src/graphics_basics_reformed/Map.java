package graphics_basics_reformed;

import java.util.ArrayList;
import java.util.Random;

public class Map {
    /*
    Generating a map from nothing seems to be an depressing job. However it looks like a lot of fun.
    Think now think...

    1. RandomWalk
    2. RandomWalk with Drift
    3.
     */

    public static ArrayList<Integer> MapGeneration_1(Grid G) {
        System.out.println("======================Map Generator 1======================");
        int width = G.gridsizeWidth;
        int height = G.gridsizeHeight;

        int initial = 20;
        int Drift = 50;
        ArrayList<Integer> map = new ArrayList<Integer>();

        int iter = 0;
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                Random random = new Random();
                boolean swi = false;
                int tmp = random.nextInt(2);
                if(tmp == 0) {
                    swi = true;
                } else if(tmp == 1){
                    swi = false;
                }
                if(iter == 0) {
                    map.add(initial);
                } else if(iter > 0 && iter < G.gridsizeWidth) {
                    if(swi == true) {
                        map.add(map.get(iter -1) + random.nextInt(2));
                    } else if(swi == false){
                        map.add(map.get(iter -1) - random.nextInt(2));
                    }
                } else if(iter > 0 && iter >= G.gridsizeWidth) {
                    if(swi == true) {
                        map.add(((map.get(iter -1) + map.get(iter - width)) / 2) + random.nextInt(2));
                    } else if (swi == false) {
                        map.add(((map.get(iter -1) + map.get(iter - width)) / 2) + random.nextInt(2));
                    }
                }
                iter++;
            }
        }
        return map;
    }

    public static ArrayList<Integer> MapGeneration_2(Grid G) {
        /*
        Giving some points (Say 4 point) that are used to generate the Initial points.
         */
        ArrayList<Integer> map = new ArrayList<Integer>();

        /*
        Initial Points (50, 50) ( 400, 20 ) ( 200, 600) Minimum Grid size => (400, 600)
         */
        int[][] IPoint = {{50, 50},
                {400, 20},
                {200, 600}};



        return map;
    }

}
