package com.kobako.first;

import javax.swing.*;

/**
 * Created by kobako on 2017/4/21.
 * Just a game
 */
public class GameApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("box1.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Common.WIDTH,Common.HIGHT);

        BoxManager boxManager = new BoxManager();

        MyPanel myPanel = new MyPanel();
        myPanel.setManager(boxManager);

        frame.add(myPanel);
        frame.setVisible(true);
        myPanel.addMouseListener(new MyKeyListener(boxManager));
        new Thread(myPanel).start();
    }
}
