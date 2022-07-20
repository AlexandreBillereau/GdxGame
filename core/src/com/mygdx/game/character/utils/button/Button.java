package com.mygdx.game.character.utils.button;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.game.Context;

public class Button extends Actor{

  ShapeRenderer button;
  BitmapFont text;
  SpriteBatch btch;

  private final int width = 100;
  private final int height = 30;
  private final int x = 25;
  private final int y = 25;
  protected boolean clicked = false;
  protected boolean enable = true;

  public Button(){
    this.setName("button_atk");
    button = new ShapeRenderer();
    text = new BitmapFont();
    btch = new SpriteBatch();
    setBounds(x,y,width,height);
    this.addListener(new ButtonListener(this));
  }

  @Override
  public void draw(Batch batch, float parentAlpha) {
    super.draw(batch, parentAlpha);
    button.setProjectionMatrix(Context.camera.combined);
    button.begin(ShapeRenderer.ShapeType.Filled);
    button.rect(x,y, width, height);
    button.setColor(Color.WHITE);
    button.end();


    text.draw(batch, "attack",55,45);
    text.setColor(Color.BLACK);


  }


  public boolean isClick(){
    if(clicked && enable){
      enable = false;
      return true;
    }
    return false;
  }



}
