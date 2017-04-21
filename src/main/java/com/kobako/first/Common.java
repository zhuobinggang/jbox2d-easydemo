package com.kobako.first;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

import java.awt.*;

/**
 * Created by kobako on 2017/4/21.
 * Just a game
 */
public class Common {
    public static World world = new World(new Vec2(0f,-10f));
    public static final int WIDTH = 800;
    public static final int HIGHT = 600;
    public static final float RATE = 10f;
    public static final float TIME_STEP = 1f/30f;

    public static int mile2Pixel(float mile){
        return (int)(mile*RATE);
    }

    public static float pixel2Mile(int pixel){
        return pixel/RATE;
    }

    public static int toPixelHeight(float mile){
        return HIGHT - (int) (mile*RATE);
    }

    public static float pixel2Height(int height){
        return (HIGHT - height)/RATE;
    }

    public static void step(){
        world.step(TIME_STEP,6,6);
    }
}
