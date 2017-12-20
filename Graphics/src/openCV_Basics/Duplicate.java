package openCV_Basics;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.imgcodecs.Imgcodecs;

import java.io.File;

public class Duplicate {
    public void run() {
        Mat image = null;
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        File file = new File("A:\\2017_Winter\\Programming\\JAVA\\ImgFiles\\Blackhole.jpg");
        try {
            image = Imgcodecs.imread("A:\\2017_Winter\\Programming\\JAVA\\ImgFiles\\Blackhole.jpg");
        } catch(Exception e) {
            e.printStackTrace();
        }
        MatOfKeyPoint keypoint = new MatOfKeyPoint();
        keypoint.alloc(10);

        System.out.println("Image size : " + image.size());
        System.out.println(image.t());
        System.out.println();

        Imgcodecs.imwrite("A:\\2017_Winter\\Programming\\JAVA\\ImgOutput\\output_1.jpg", image);
        System.out.println("Image output successful!");
    }




    public static void main(String[] ar) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        new Duplicate().run();
    }
}
