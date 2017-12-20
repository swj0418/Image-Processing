package graphics_basic;

import java.util.Random;

public class Map {
    // 7 by 7
    public static int[][] ExampleMap =
            {{5, 10, 12, 14, 10, 5, 0, 2, 30, 31, 33, 35},
             {3, 2, 5, 8, 10, 9, 6, 7, 2, 1, 1, 4},
             {5, 10, 12, 19, 25, 20, 15, 17, 18, 19, 20, 20},
             {10, 7, 5, 2, 15, 19, 25, 24, 24, 24, 25, 25},
             {10, 7, 5, 2, 15, 19, 25, 25, 25, 21, 21, 21},
             {9, 9, 9, 10, 12, 15, 19, 19, 19, 20, 21, 20},
             {13, 12, 11, 10, 8, 7, 7, 10, 10, 12, 15, 16}};


    public static int[][] MapGen_1(int Horizontal, int Vertical) {
        int[][] m = new int[Vertical][Horizontal];
        Random random = new Random();
        int num = 0;
        for(int i = 0; i < Vertical; i++) {
            for(int k = 0; k < Horizontal; k++) {
                m[i][k] = random.nextInt(8) + num;
            }
            num++;
        }
        return m;
    }
    public static int[][] MapGen_2(int Horizontal, int Vertical) {
        int[][] m = new int[Vertical][Horizontal];
        Random random = new Random();
        for (int i = 0; i < Vertical; i++) {
            for (int k = 0; k < Horizontal; k++) {
                m[i][k] = random.nextInt(3);
            }
        }
        return m;
    }
}
