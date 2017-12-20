package graphics_basic;

public class Test {
    public static void main(String[] ar) {
        System.out.print("This is a test line\n");

        Grid G = new Grid();

        /*
        //Grid Settings
        G.setGridSize(1500, 600);
        G.setLightLocation(-10, 300, 80 );

        //Grid Render & Show
        G.renderDefaultGrid();
        //G.showGrid();
        G.grid = Map.MapGen_2(1500, 600);

        //Distance Calculation
        G.calculateBaseDistance();
        //G.showBaseDistance();

        //Peak Distance Calculation
        G.calculatePeakDistance();
        //G.showPeakDistance();

        //Calculating Slopes of Neighboring Peaks
        G.calcualateNeighbor();


        G.setReacheable();

        SwingDraw2D drawing = new SwingDraw2D(G);
        */

        //Grid Settings
        G.setGridSize(10, 7);
        G.setLightLocation(-10, 4, 10 );

        //Grid Render & Show
        G.renderDefaultGrid();
        G.grid = Map.ExampleMap;
        G.showGrid();

        //Distance Calculation
        G.calculateBaseDistance();
        //G.showBaseDistance();

        //Peak Distance Calculation
        G.calculatePeakDistance();
        //G.showPeakDistance();

        //Calculating Slopes of Neighboring Peaks
        G.calcualateNeighbor();

        G.setReacheable();

        SwingDraw2D drawing = new SwingDraw2D(G);
    }
}
