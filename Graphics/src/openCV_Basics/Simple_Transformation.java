package openCV_Basics;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.awt.font.ImageGraphicAttribute;
import java.io.File;

import static org.opencv.core.CvType.CV_8UC3;

public class Simple_Transformation {
    public void run() {
        Mat image = null; int row = 0; int col = 0;
        Mat image2 = null;
        Mat newImage = null;
        try {
            image = Imgcodecs.imread("A:\\2017_Winter\\Programming\\JAVA\\ImgFiles\\4K_WarHammer.jpg");
            image2 = Imgcodecs.imread("A:\\2017_Winter\\Programming\\JAVA\\ImgFiles\\4K_Tiger_2.jpg");
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("Image sizes : " + image.size() + "        " + image2.size());
        System.out.println("Image 1 : " + image.t()); row = image.rows();
        System.out.println("Image 2 : " + image2.t()); col = image.cols();
        System.out.println();

        System.out.println("Simple Processing");
        System.out.println("1 ::::: absdiff()==============================");
        newImage = Mat.zeros(row, col, CV_8UC3);
        Core.absdiff(image, image2, newImage);
        Imgcodecs.imwrite("A:\\2017_Winter\\Programming\\JAVA\\ImgOutput\\absdiff.jpg", newImage);







        System.out.println("Image output successful!");
    }




    public static void main(String[] ar) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        new Simple_Transformation().run();
    }
}
