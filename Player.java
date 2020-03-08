import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends JPanel {
int w =180,h =30,posX=((Game.w_size/2)-w/2),posY=Game.w_size-h-29;
private BufferedImage img;
    Player(){
        setSize(w,h);
        setLocation(posX,posY);
        try {
            img = ImageIO.read(new File(
                    "C:\\Users\\Igor\\Desktop\\player.jpg"));
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
