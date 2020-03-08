import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Block extends JPanel {
    int posX,posY,w=60,h=30;
    private BufferedImage img;
    Block(int posX,int posY){
        this.posX = posX;
        this.posY = posY;
        setSize(w,h);
        setLocation(posX,posY);
        try {
            img = ImageIO.read(new File(
                    "C:\\Users\\Igor\\Desktop\\block.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, w, h, this);
    }
}
