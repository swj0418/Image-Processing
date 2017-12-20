package graphics_basics_reformed;

public class Main {
    /*
    Previous Method bears a significant problem where the program has to access each grid points in an array.
    This increases a memory usage of a single variable therefore creating a heap overflow error.
    I will revise by making each grid points instances and these Point class instances will be stored in an arraylist.
     */
    public static void main(String[] ar) {
        Grid G = new Grid();
        G.setGridsize(800, 1200);
        G.setLightsource(new Light(500, 300, 500, 100));
        G.renderGrid();

        //Showing
        G.showGrid();
        //G.showBaseDistanceFromLight();
        //G.showPeakDistanceFromLight();
        //G.showSlopeToLight();




        //new SwingDraw2D(G);
        SonarDraw2D Draw2DSonar = new SonarDraw2D(G);
    }
}
