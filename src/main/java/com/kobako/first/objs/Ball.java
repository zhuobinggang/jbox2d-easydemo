package com.kobako.first.objs;

import com.kobako.first.Common;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

import java.awt.*;

/**
 * Created by kobako on 2017/4/21.
 * Just a game
 */
public class Ball implements MyNode{
    float worldX;
    float worldY;
    float r;
    public Body ballInWorld;
    Color color = Color.cyan;

    public Ball(float worldX,float worldY,float r){
        this.worldX = worldX;
        this.worldY = worldY;
        this.r = r;
        initBallInWorld();
    }

    public Ball(){
        this(42f,50f,3f);
    }

    public int getPixelX(){
        int pixelX = Common.mile2Pixel(ballInWorld.getPosition().x-r);
        return pixelX;
    }

    public int getPixelY(){
        int pixelY = Common.toPixelHeight(ballInWorld.getPosition().y+r);
        return pixelY;
    }

    public int getWidthOrHeight(){
        return Common.mile2Pixel(r*2);
    }

    private void initBallInWorld(){
        BodyDef bd = new BodyDef();
        bd.position = new Vec2(worldX,worldY);
        bd.type = BodyType.DYNAMIC;

        FixtureDef fd = new FixtureDef();
        CircleShape cs = new CircleShape();
        cs.m_radius = r;
        fd.shape = cs;
        fd.density = 0.5f;
        fd.friction = 0.3f;
        fd.restitution = 0.6f;

        ballInWorld = Common.world.createBody(bd);
        ballInWorld.createFixture(fd);
    }

    @Override
    public void drawMe(Graphics2D g) {
        g.setColor(color);
        g.fillOval(this.getPixelX(),this.getPixelY(),this.getWidthOrHeight(),this.getWidthOrHeight());
    }
}
