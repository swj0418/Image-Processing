package graphics_basics_reformed;

public class Point {
    //Basic information
    public int positionX;
    public int positionY;
    public int height;
    public int lightreflection; // Not able to implement yet. maybe some value between 0 ~ 100; 0 : absorbs light completely therefore will not reflect any

    //Calculated Information
    public double baseDistanceFromLight = 0.d;
    public double peakDistanceFromLight = 0.d;
    public double slopeToLight = 0.d;

    //Additional Information

    Point() {

    }

    Point(int positionX, int positionY, int height) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.height = height;
    }

    Point(int positionX, int positionY, int height, int light_reflection) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.height = height;
        this.lightreflection = light_reflection;
    }

}
