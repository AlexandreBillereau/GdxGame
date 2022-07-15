package com.mygdx.game.character.utils;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Button {

  ShapeRenderer button;
  BitmapFont text;
  SpriteBatch batch;

  private int width = 100;
  private int height = 30;
  private int x = 25;
  private int y = 25;
  private boolean clickable = true;

  public Button(){
    button = new ShapeRenderer();
    text = new BitmapFont();
    batch = new SpriteBatch();
  }

  public void draw(){
    button.begin(ShapeRenderer.ShapeType.Filled);
    button.rect(x,y, width, height);
    button.setColor(Color.WHITE);
    button.end();

    batch.begin();
    text.draw(batch, "attack",55,45);
    text.setColor(Color.BLACK);
    batch.end();
  }

  public boolean isClick(){

    if(Gdx.input.isTouched()){
      if ( Gdx.input.getX() > x && Gdx.graphics.getHeight() - Gdx.input.getY() > y &&
           Gdx.input.getX() < x + width &&  Gdx.graphics.getHeight() - Gdx.input.getY() < y + height ){
        if(clickable){
          return true;
        }
      }
    }
    return false;
  }

  public void disable(){
    clickable = !clickable;
  }

  public void enable(){
    clickable = !clickable;
  }

  public boolean isClickable(){
    return clickable;
  }



}
