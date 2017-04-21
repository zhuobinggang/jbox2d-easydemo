package com.kobako.first;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kobako on 2017/4/21.
 * Just a game
 */
public class MyPanel extends JPanel implements Runnable{
    BoxManager manager;

    public void setManager(BoxManager manager) {
        this.manager = manager;
    }

    public MyPanel(){
        this.setSize(Common.WIDTH,Common.HIGHT);
        this.setVisible(true);
        this.setBackground(Color.black);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        manager.draw((Graphics2D)g);
        g.dispose();
    }

    @Override
    public void run() {
        try{
            while (true){
                Thread.sleep(30);
                this.repaint();
                manager.logic();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
