package openCV_Basics;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class Test_1 {
    public static void main(String[] ar) {
        System.loadLibrary( Core.NATIVE_LIBRARY_NAME);
        Mat mat = Mat.eye(30, 30, CvType.CV_8UC1);
        System.out.println("mat = " + mat.dump());

        Mat mat2 = Mat.eye(3, 3, CvType.CV_16SC(4));
        System.out.println(mat2.dump());
    }
}
