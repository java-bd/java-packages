import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.File;
import javax.imageio.ImageIO;

class ImageIOReadFromURL{
	
	
	
	public static void main(String[] args) throws Exception{
		
			final BufferedImage image = ImageIO.read(new URL(
			"http://upload.wikimedia.org/wikipedia/en/2/24/Lenna.png")); 	 
			Graphics g = image.getGraphics();
			g.setFont(g.getFont().deriveFont(30f));
			g.drawString("Hello World!", 100, 100);
			g.dispose();
		 
			ImageIO.write(image, "png", new File("test.png"));
		
		
	}
	
}