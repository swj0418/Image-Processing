package reader;

public class Main {
	public static void main(String[] ar) {
		ReaderTest T = new ReaderTest();
		String path = "A:\\2017_Winter\\Programming\\JAVA\\Image_Processing\\Files\\Kid.jpg";
		T.readImage(path);
		T.fileMetaData();
		
		int[] array = T.storeimage(path);
		
		/*
		for(int i = 0; i < T.height * T.width; i++) {
			System.out.print(array[i] + "\t");
			if(i % T.width == 0) {
				System.out.println();
			}
		}
		*/
		
		T.pixelfileout();
		
		T.createPixelModel();
		
		T.getMean();
		T.calculateDeviation();
		T.printDeviation();
		
		T.drawOutline();
	}

}
