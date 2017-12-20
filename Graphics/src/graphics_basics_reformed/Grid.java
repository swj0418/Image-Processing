package graphics_basics_reformed;

import java.util.ArrayList;
import java.util.Random;

public class Grid {
    public int gridsizeHeight = 0;
    public int gridsizeWidth = 0;
    public ArrayList<Point> grid = new ArrayList<Point>();

    public Light lightsource;

    Grid() {

    }

    public void setGridsize(int gridsizeHeight, int gridsizeWidth) {
        this.gridsizeHeight = gridsizeHeight;
        this.gridsizeWidth = gridsizeWidth;
    }

    public void setLightsource(Light light) {
        this.lightsource = light;
    }

    public void renderGrid() {
        /*
        Random random = new Random();
        System.out.println("=================Rendering Grid==================");
        for(int i = 0; i < gridsizeHeight; i++) {
            for(int j = 0; j < gridsizeWidth; j++) {
                int randomheight = random.nextInt(200);
                grid.add(new Point(j, i, randomheight));
            }
        }
        */
        ArrayList<Integer> newMap;
        newMap = Map.MapGeneration_1(this);

        //Map component
        int iter = 0;
        for(int i = 0; i < gridsizeHeight; i++) {
            for(int j = 0; j < gridsizeWidth; j++) {
                grid.add(new Point(j, i, newMap.get(iter)));
                iter++;
            }
        }


        calculateDistanceFromLight();
        calculateSlopeToLight();
    }

    public void showGrid() {
        System.out.println("=================Printing Grid Height Map==================");
        int iter = 0;
        for(int i = 0; i < gridsizeHeight; i ++) {
            for(int j = 0; j < gridsizeWidth; j++) {
                //System.out.print(grid.get(iter).height + "(" + grid.get(iter).positionX + " " + grid.get(iter).positionY + ")" + "\t");
                System.out.print(grid.get(iter).height + ",");
                iter++;
            }
            System.out.println();
        }
    }

    public void showBaseDistanceFromLight() {
        System.out.println("=================Printing Base Distance from Light Map==================");
        int iter = 0;
        for(int i = 0; i < gridsizeHeight; i ++) {
            for(int j = 0; j < gridsizeWidth; j++) {
                System.out.print(grid.get(iter).baseDistanceFromLight + "(" + grid.get(iter).positionX + " " + grid.get(iter).positionY + ")" + "\t");
                iter++;
            }
            System.out.println();
        }
    }

    public void showPeakDistanceFromLight() {
        System.out.println("=================Printing Peak Distance from Light Map==================");
        int iter = 0;
        for(int i = 0; i < gridsizeHeight; i ++) {
            for(int j = 0; j < gridsizeWidth; j++) {
                System.out.print(grid.get(iter).peakDistanceFromLight + "(" + grid.get(iter).positionX + " " + grid.get(iter).positionY + ")" + "\t");
                iter++;
            }
            System.out.println();
        }
    }

    public void showSlopeToLight() {
        System.out.println("=================Printing Slope to Light Map==================");
        int iter = 0;
        for(int i = 0; i < gridsizeHeight; i ++) {
            for(int j = 0; j < gridsizeWidth; j++) {
                System.out.print(grid.get(iter).slopeToLight + "(" + grid.get(iter).positionX + " " + grid.get(iter).positionY + ")" + "\t");
                iter++;
            }
            System.out.println();
        }
    }

    public void calculateDistanceFromLight() {
        System.out.println("=================Calculating Distance From the Light Source==================");
        int iter = 0;
        for(int i = 0; i < gridsizeHeight; i ++) {
            for(int j = 0; j < gridsizeWidth; j++) {
                double posX = grid.get(iter).positionX;
                double posY = grid.get(iter).positionY;
                double pointHeight = grid.get(iter).height;
                //Base Distance
                grid.get(iter).baseDistanceFromLight = Math.sqrt(Math.pow(posX - lightsource.lightPositionX, 2) + Math.pow(posY - lightsource.lightPositionY, 2));
                //Peak Distance
                grid.get(iter).peakDistanceFromLight = Math.sqrt(Math.pow(grid.get(iter).baseDistanceFromLight, 2) + Math.pow(pointHeight - lightsource.lightHeight, 2));
                iter++;
            }
        }
    }

    public void calculateSlopeToLight() {
        System.out.println("=================Calculating Slope to the Light Source==================");
        int iter = 0;
        for(int i = 0; i < gridsizeHeight; i ++) {
            for(int j = 0; j < gridsizeWidth; j++) {
                double pointHeight = grid.get(iter).height;
                grid.get(iter).slopeToLight = (pointHeight - lightsource.lightHeight) / grid.get(iter).baseDistanceFromLight;
                iter++;
            }
        }
    }
}
