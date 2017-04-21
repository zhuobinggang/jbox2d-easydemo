package com.kobako.first.objs;

import com.kobako.first.Common;
import org.jbox2d.collision.shapes.PolygonShape;
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
public class Wood implements MyNode{
    Body wood;
    float hw;
    float hh;

    public Wood(float worldX,float worldY,float hw,float hh){
        initWood2World(worldX,worldY,hw,hh);
    }

    private void initWood2World(float worldX,float worldY,float hw,float hh){
        this.hw = hw;
        this.hh = hh;
        BodyDef bd = new BodyDef();
        bd.position = new Vec2(worldX,worldY);
        bd.type = BodyType.STATIC;

        FixtureDef fd = new FixtureDef();
        PolygonShape ps = new PolygonShape();
        ps.setAsBox(hw,hh);
        fd.shape = ps;

        wood = Common.world.createBody(bd);
        wood.createFixture(fd);
    }

    private int getPixelX(){
        return Common.mile2Pixel(wood.getPosition().x-hw);
    }
    private int getPixelY(){
        return Common.toPixelHeight(wood.getPosition().y+hh);
    }
    private int getPixelWidth(){
        return Common.mile2Pixel(hw*2);
    }
    private int getPixelHeight(){
        return Common.mile2Pixel(hh*2);
    }

    @Override
    public void drawMe(Graphics2D g) {
        g.setColor(Color.PINK);
        g.fillRect(getPixelX(),getPixelY(),getPixelWidth(),getPixelHeight());
    }
}
