package graphics_basic;

import java.util.Random;

public class Grid {
    public int horizontal = 0; //Grid size
    public int vertical = 0; //Grid size

    public int Light_Horizontal = 0;
    public int Light_Vertical = 0;
    public int Light_Height = 0;


    public int[][] grid;
    public double[][] base_distance_from_light;
    public double[][] peak_distance_from_light;

    //Neighboring information
    public double[    ][    ][    ][    ] Neighbor;
    //             y     x     3     3
    //Additional Information
    public boolean[][] light_reacheable;
    public boolean[][] frontier;

    Grid() {
        grid = new int[vertical][horizontal];
        base_distance_from_light = new double[vertical][horizontal];
        peak_distance_from_light = new double[vertical][horizontal];
    }

    public void renderDefaultGrid() {
        Random random = new Random();
        for(int y = 0; y < vertical; y++) {
            for (int x = 0; x < horizontal; x++) {
                grid[y][x] = random.nextInt(100);
            }
        }
    }

    public void calculateBaseDistance() {
        for(int y = 0; y < vertical; y++) {
            for(int x = 0; x < horizontal; x++) {
                double tmpx = x - Light_Horizontal;
                double tmpy = y - Light_Vertical;
                base_distance_from_light[y][x] = Math.sqrt(Math.pow((tmpx), 2.d) + Math.pow((tmpy), 2));
            }
        }
    }

    public void calculatePeakDistance() {
        for(int y = 0; y < vertical; y++) {
            for(int x = 0; x < horizontal; x++) {
                double tmpx = base_distance_from_light[y][x];
                double tmpy = Light_Height - grid[y][x];
                peak_distance_from_light[y][x] = Math.sqrt(Math.pow((tmpx), 2.d) + Math.pow((tmpy), 2));
            }
        }
    }

    public void setReacheable() { //Assuming Light hits left side, in linear form.
        light_reacheable = new boolean[vertical][horizontal];
        for(int y = 0; y < vertical; y++) {
            for(int x = 0; x < horizontal; x++) {
                light_reacheable[y][x] = false;
            }
        }

        for(int y = 0; y < vertical; y++) {
            for(int x = 1; x < horizontal; x++) {
                double delta_y = grid[y][x] - grid[y][x - 1];
                double delta_x = 1;
                double slope = delta_y / delta_x;

                double pre_y = 0;
                double pre_x = 0;
                int frontiercoordinate = 0;
                for(int i = 0; i < horizontal; i++) {
                    if (i != x && frontier[y][i] == true) {
                        System.out.println("Frontier at : " + y + " " + i);
                        frontiercoordinate = i;
                        pre_y = grid[y][x - 1] - Light_Height;
                        pre_x = base_distance_from_light[y][x - 1];
                        //System.out.print("Sloping : " + (pre_y / pre_x));
                    }
                }
                double pre_slope = pre_y / pre_x;
                if(pre_slope <= slope) {
                    light_reacheable[y][x] = true;
                    frontier[y][frontiercoordinate] = false;
                    frontier[y][x] = true;
                } else {
                    light_reacheable[y][x] = false;
                }
            }
        }
    }

    public void showGrid() {
        System.out.println("===============Printing Heights of Elements of the Grid===============");
        for(int y = 0; y < vertical; y++) {
            for(int x = 0; x < horizontal; x++) {
                System.out.print(grid[y][x] + "\t");
            }
            System.out.print("\n");
        }
    }

    public void showBaseDistance() {
        System.out.println("===============Printing Base Distance of Grid from the Light Source===============");
        for(int y = 0; y < vertical; y++) {
            for(int x = 0; x < horizontal; x++) {
                System.out.print(base_distance_from_light[y][x] + "\t");
            }
            System.out.print("\n");
        }
    }

    public void showPeakDistance() {
        System.out.println("===============Printing Peak Distance of Grid from the Light Source===============");
        for(int y = 0; y < vertical; y++) {
            for(int x = 0; x < horizontal; x++) {
                System.out.print(peak_distance_from_light[y][x] + "\t");
            }
            System.out.print("\n");
        }
    }

    public void calcualateNeighbor() {
        /*
        Neighbor = new double[vertical][horizontal][3][3];
        for(int y_out = 0; y_out < vertical; y_out++) {
            for(int x_out = 0; x_out < horizontal; x_out++) {

                for(int y_in = -1; y_in <= y_out + 1; y_in++) {
                    for(int x_in = x_out - 1; x_in <= x_out + 1; x_in++) {
                        //System.out.println(y_out + " " + x_out + "  " + y_in + " " + x_in);
                            if(y_out > 0 && y_out < vertical && x_out > 0 && x_out < horizontal) {
                                System.out.println(y_out + " " + x_out + "  " + y_in + " " + x_in);
                                if(x_in == x_out && y_in == y_out) { // Itself
                                    Neighbor[y_out][x_out][y_in - y_out][x_in - x_out] = 0.d;
                                } else{
                                    double delta_y = grid[y_out][x_out] - grid[y_in][x_in];
                                    double delta_x = Math.sqrt(Math.pow(x_out - x_in, 2) + Math.pow(y_out - y_in, 2));
                                    //System.out.println(y_out + " " + x_out + "  " + y_in + " " + x_in);
                                    Neighbor[y_out][x_out][y_in - y_out][x_in - x_out] =
                                            delta_y / delta_x;
                                }
                            }
                    }
                }


            }
        }
        */
    }



    public void setGridSize(int horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;

        //Redefine our grid size
        grid = new int[vertical][horizontal];
        base_distance_from_light = new double[vertical][horizontal];
        peak_distance_from_light = new double[vertical][horizontal];

        setIntialFrontiers();
    }
    public void setLightLocation(int lighthorizontal, int lightvertical, int lightheight) {
        this.Light_Horizontal = lighthorizontal;
        this.Light_Vertical = lightvertical;

        setLightHeight(lightheight);
    }
    private void setLightHeight(int light_Height) {
        this.Light_Height = light_Height;
    }
    private void setIntialFrontiers() {
        frontier = new boolean[vertical][horizontal];
        for(int y = 0; y < vertical; y++) {
            for(int x = 0; x < horizontal; x++) {
                frontier[y][x] = false;
            }
        }

        for(int i = 0; i < vertical; i++) {
            frontier[i][0] = true;
        }
    }
}
