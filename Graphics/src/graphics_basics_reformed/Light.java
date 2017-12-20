package graphics_basics_reformed;

public class Light {
    //Basic Information
    public int lightPositionX = 0;
    public int lightPositionY = 0;
    public int lightHeight = 0;

    //Additional Information
    public int lightPower = 0;

    Light() {

    }
    Light(int lightPositionX, int lightPositionY) {
        this.lightPositionX = lightPositionX;
        this.lightPositionY = lightPositionY;
    }

    Light(int lightPositionX, int lightPositionY, int lightPower) {
        this.lightPositionX = lightPositionX;
        this.lightPositionY = lightPositionY;
        this.lightPower = lightPower;
    }
    Light(int lightPositionX, int lightPositionY, int lightHeight, int lightPower) {
        this.lightPositionX = lightPositionX;
        this.lightPositionY = lightPositionY;
        this.lightHeight = lightHeight;
        this.lightPower = lightPower;
    }
}
