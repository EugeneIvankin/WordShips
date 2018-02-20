import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Backgraund extends JPanel{
	
	private BufferedImage image;

    public Backgraund(String srt) {
                      
          try {
			image = ImageIO.read(new File(srt));
          } 
          catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
          }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null); 
    }

}
