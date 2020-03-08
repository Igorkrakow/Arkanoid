import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Game {

    public JFrame frame;
    public ArrayList<Block> blocks;
    Player p;
    Ball b;
    static public final int w_size = 800;
    public static void main(String[] args) {

        new Game().start();
    }
    public void start(){
        setting();
        double  speed = 1;
        double angle = 0;


        while(!blocks.isEmpty()){
            b.posY+=speed;
            b.posX += angle;

            b.p.setLocation(b.posX,b.posY);
            b.setLocation(b.p);


            if(p.posY == b.posY+b.h && (b.posX + b.w > p.posX && b.posX < p.posX + p.w)){
                speed = -1;
                angle = ((b.posX-p.posX)-78)/100;

            }
            if(b.posX <=0 || b.posX >=w_size-b.w)angle*=-1;
            if(b.posY <= 0)speed *=-1;
            for(int i=0;i<blocks.size();i++){


                if(blocks.get(i).posY+blocks.get(i).h == b.posY && (b.posX +b.w > blocks.get(i).posX && b.posX < blocks.get(i).posX + blocks.get(i).w)){
                    blocks.get(i).setVisible(false);
                    blocks.remove(i);
                    speed =1;
                    i=0;
                }

                if((((int)b.posX == (blocks.get(i).posX + blocks.get(i).w)) || ((int)(b.posX+b.w) ==blocks.get(i).posX) )&& (b.posY +b.h > blocks.get(i).posY && b.posY < blocks.get(i).posY + blocks.get(i).h)){
                    System.out.println("true");
                    blocks.get(i).setVisible(false);
                    blocks.remove(i);
                    angle*=-1;
                    i=0;
                }

                if(blocks.get(i).posY == b.posY+b.h && (b.posX +b.w > blocks.get(i).posX && b.posX < blocks.get(i).posX + blocks.get(i).w)){
                    blocks.get(i).setVisible(false);
                    blocks.remove(i);
                    speed =-1;
                    i=0;
                }
            }
            try {
                Thread.sleep(2);
            }catch (Exception ex){}
        }
    }
    public void setting(){
        frame = new JFrame("Arkanoid");

        //Убираем курсор мыши
        BufferedImage blankImage = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(blankImage, new Point(0, 0), "blank");
        frame.setCursor(blankCursor);
        //************************************************************************************************************************

        frame.setSize(w_size,w_size);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        creatLvl();
        p=new Player();
        b= new Ball();
        frame.add(b);
        frame.add(p);

        frame.setVisible(true);
        frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);

                    p.posX=e.getX();
                    p.setLocation(p.posX,p.posY);
            }
        });
    }
    public void creatLvl(){
        blocks = new ArrayList<>();
        int x=7,y=0;

        for(int i=0;i<130;i++){
            int r = (int)(Math.random()*2);
                if(r==1){
                    blocks.add(new Block(x,y));
                    frame.add(blocks.get(blocks.size()-1));
                }
                x+=60;
                if(i%12==0){
                    y+=30;
                    x=7;
            }
        }
    }
}
