package com.mygdx.game.character.utils;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Context;
import com.mygdx.game.MyGdxGame;

public class LifeBar {


  private Pixmap pixmap;
  private Texture texture;
  private SpriteBatch batch;
  private BitmapFont lifeInfo;
  private int x, y, pv, pvMax, width;

  public LifeBar(int width, int height, int radius, int color, int x, int y, int pv){
    this.x  = x;
    this.y  = y;
    this.pv = pv;
    this.pvMax = pv;
    this.width = width;

    pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
    pixmap.setColor(color);
    pixmap.fillRectangle(0, radius, pixmap.getWidth(), pixmap.getHeight()-2*radius);
    pixmap.fillRectangle(radius, 0, pixmap.getWidth() - 2*radius, pixmap.getHeight());

    // Bottom-left circle
    pixmap.fillCircle(radius, radius, radius);

    // Top-left circle
    pixmap.fillCircle(radius, pixmap.getHeight()-radius, radius);

    // Bottom-right circle
    pixmap.fillCircle(pixmap.getWidth()-radius, radius, radius);

    // Top-right circle
    pixmap.fillCircle(pixmap.getWidth()-radius, pixmap.getHeight()-radius, radius);

    texture = new Texture(this.pixmap);
    batch = new SpriteBatch();
    lifeInfo = new BitmapFont();
  }


  public void draw(){
    batch.setProjectionMatrix(Context.camera.combined);
    batch.begin();
    batch.draw(texture, x, y);
    lifeInfo.draw(batch, pv + "/" + pvMax, x , y);
    batch.end();
  }

  public void update(){

  }




}
