
/** Run From Command Line & See How Fast Downloading Images from TaskBar :)
*	
*   javac MainMultiThreadImageDownload.java
*	java MainMultiThreadImageDownload
*/


public class MainMultiThreadImageDownload {

    public static void main(String[] args) throws Exception {

        Images images = new Images();

        int i = 0;

        for (String imString : images.imageUrls) {
            ImageDownLoadThread imageDownLoadThread = new ImageDownLoadThread(imString, Integer.toString(i) + ".jpg");
            Thread t = new Thread(imageDownLoadThread);
            t.start();
            i++;
        }        

    }

}
