package gdx.simplify.lib;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Context;

public class Point{

    public int x,y;
    public double angle;
    ShapeRenderer shape;

    public Point(int x, int y){
        this.x = x;
        this.y = y;

        shape = new ShapeRenderer();
    }

    public Point(int x, int y, double angle){
        this.x = x;
        this.y = y;
        this.angle = angle;

        shape = new ShapeRenderer();
    }

    public void draw(){
        shape.setProjectionMatrix(Context.camera.combined);
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.RED);
        shape.circle(x,y,5);
        shape.end();
    }

    public void setColor(Color color){
        shape.setColor(color);
    }
}