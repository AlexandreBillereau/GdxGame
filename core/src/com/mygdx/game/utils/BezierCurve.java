package com.mygdx.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Bezier;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Context;

import java.awt.*;
import java.util.ArrayList;

public class BezierCurve {

    Vector2 p0,p1,p2,p3;
    Vector3 input;
    ShapeRenderer p0_To_p1, p2_To_p3;

    ArrayList<ShapeRenderer> points = new ArrayList<>();
    Bezier<Vector2> bezier;

    public BezierCurve(){


        for (int i = 0 ; i < 10; i++){
            points.add(new ShapeRenderer());
        }

        p0 = new Vector2();
        p1 = new Vector2();
        p2 = new Vector2();
        p3 = new Vector2();
        p0_To_p1 = new ShapeRenderer();
        p2_To_p3 = new ShapeRenderer();
    }


    public void render(){

        calcPoint();

        p0_To_p1.begin(ShapeRenderer.ShapeType.Line);
        p0_To_p1.line(p0, p1);
        p0_To_p1.end();

        p2_To_p3.begin(ShapeRenderer.ShapeType.Line);
        p2_To_p3.line(p2, p3);
        p2_To_p3.end();

        bezier = new Bezier<>(p0, p1, p2, p3);


        Vector2 out = new Vector2();
        for(float i = 0; i < 1; i += 0.1){
            bezier.valueAt(out, i);
            ShapeRenderer c = points.get((int)(i*10));
            c.begin(ShapeRenderer.ShapeType.Filled);
            c.circle(out.x, out.y, 7);
            c.end();
        }


    }

    public void calcPoint(){
        p0.x = Context.viewPortWidth/2;
        p0.y = Context.viewPortHeight/4;

        input = Context.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

        p3.x = input.x;
        p3.y = input.y;

        p2.x = (int)(p0.x + (p3.x-p0.x) * 0);
        p2.y = (int)(p0.y + (p3.y-p0.y) * 1);

        p1.x = (int)(p0.x + (p3.x-p0.x) * -0.1);
        p1.y = (int)(p0.y + (p3.y-p0.y) * 0.8);
    }

}
