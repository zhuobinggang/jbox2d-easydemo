package com.kobako.first;

import com.kobako.first.objs.Ball;
import com.kobako.first.objs.MyNode;
import com.kobako.first.objs.Wood;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by kobako on 2017/4/21.
 * Just a game
 */
public class BoxManager {
    Vector<MyNode> myNodes = new Vector<>();


    public BoxManager(){
        initObjs();
    }


    private void initObjs(){
        Ball ball = new Ball(42f,50f,3f);
        myNodes.add(ball);

        Wood wood1 = new Wood(20f,10f,20f,5f);
        myNodes.add(wood1);
    }


    public void logic(){
        Common.step();
    }

    public void draw(Graphics2D g){
        myNodes.forEach(it->it.drawMe(g));
    }

    public void addToObjs(MyNode myNode){
        this.myNodes.add(myNode);
    }
}
