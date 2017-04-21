package com.kobako.first;

import com.kobako.first.objs.Ball;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by kobako on 2017/4/21.
 * Just a game
 */
public class MyKeyListener implements MouseListener{
    BoxManager boxManager;

    public MyKeyListener(BoxManager manager){
        this.boxManager = manager;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(MouseEvent.BUTTON1 == e.getButton()){
            addBallToWorld(e);
        }else if(MouseEvent.BUTTON2 == e.getButton()){
            addWoodToWorld(e);
        }
    }

    private void addBallToWorld(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        Ball ball = new Ball(Common.pixel2Mile(mx),Common.pixel2Height(my),2);
        boxManager.addToObjs(ball);
    }

    private void addWoodToWorld(MouseEvent e){

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
