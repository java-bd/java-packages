
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class YoutubeMediaToFileBit {

    public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
        String ytMedia720 = "https://r2---sn-1mvoapox-q5jl.googlevideo.com/videoplayback?sparams=cnr%2Cdur%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2cms%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cupn%2Cexpire&mime=video%2Fmp4&pcm2cms=yes&ipbits=0&initcwndbps=2002500&ip=103.19.255.202&cnr=14&pl=24&mt=1466206230&mv=m&ms=au&mm=31&mn=sn-1mvoapox-q5jl&id=o-APXaZva5cwkF3MMRmBWCba2U9T3i-Y2UA7GlRFJ00VzZ&upn=qU10Yr4GIPA&expire=1466227999&sver=3&itag=22&ratebypass=yes&requiressl=yes&source=youtube&dur=196.510&lmt=1458202380533239&fexp=9416126%2C9416891%2C9419451%2C9422596%2C9428398%2C9428635%2C9429854%2C9431012%2C9432048%2C9432825%2C9433096%2C9433380%2C9433946%2C9435526%2C9435876%2C9435917%2C9436346%2C9436607%2C9437057%2C9437066%2C9437103%2C9437552%2C9437652%2C9438338%2C9438570%2C9439653&key=yt6&signature=470153E47E7DD84E25C8F31CC4D2BBD39D2FF40E.254F36AAEF8106982086C10FEE97A7A1BD4EFC4A";
        URL urlYtMedia = new URL(ytMedia720);

        try (InputStream bIs = urlYtMedia.openStream()) {
            File file = new File("ytMedia720.mp4");
            try (FileWriter fileWriter = new FileWriter(file)) {
                byte[] b = new byte[20];
                int length;
                // For How Much Data From Media Start Position to Collect
                int StopN = 0;
                int i = 0;
                while ((length = bIs.read(b)) != -1) {
                    for (int it = 0; it < 20; it++) {
                        String binString = String.format("%8s", Integer.toBinaryString(b[it] & 0xFF)).replace(' ', '0');
                        fileWriter.write(binString);
                    }
                    i++;
                    StopN++;
                    fileWriter.write("\n");
                }
                // System.out.println(i); => 1819472
            }
        }
    }
}
