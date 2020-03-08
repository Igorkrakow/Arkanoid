import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ball extends JPanel {
int w = 25,h=w;
    Point p;
double posX=((Game.w_size/2)-w/2),posY=posX;
    private BufferedImage img;
    Ball(){
         p = new Point();
        setSize(w,h);
        p.setLocation(posX,posY);
        setLocation(p);
        try {
            img = ImageIO.read(new File(
                    "C:\\Users\\Igor\\Desktop\\ball.png"));
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