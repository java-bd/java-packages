
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;


public class ImageDownLoadThread implements Runnable{
    private String imgURL;
    private String destFile;
    public ImageDownLoadThread(String imgURL, String destFile){
        this.imgURL = imgURL;
        this.destFile = destFile;
    }
    
    public void run(){
        
        try{
            URL url = new URL(imgURL);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destFile);
            byte[] b = new byte[2048];
            int length;
            while( (length = is.read(b)) != -1 ){
                os.write(b, 0, length);
            }
            os.close();
            is.close();
        } catch (Exception e){
            e.printStackTrace();
        }        
    }
    
}
