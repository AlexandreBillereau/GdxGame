package com.mygdx.game.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.Context;
import com.mygdx.game.character.utils.LifeBar;
import gdx.simplify.lib.TextureAnimation;

public class Skull {
  public TextureAnimation skull_attack;
  public TextureAnimation skull_idle;
  public TextureAnimation skull_death;
  LifeBar lifeBar;

  int pv = 75;

  //const
  int positionX = (int)(Gdx.graphics.getWidth()*0.75f);
  int positionY = Gdx.graphics.getHeight()/2;
  float scale = 2f;
  float elapseTime = 0;

  public Skull(){
    skull_attack = new TextureAnimation("assets/Skeleton Sprite Pack/Skeleton/Sprite Sheets/Skeleton Attack.png",
            43,37,1f/18f, positionX,positionY,scale);
    skull_idle = new TextureAnimation("assets/Skeleton Sprite Pack/Skeleton/Sprite Sheets/Skeleton Idle.png",
            24,37, 1f/11f, positionX, positionY, scale);
    skull_death = new TextureAnimation("assets/Skeleton Sprite Pack/Skeleton/Sprite Sheets/Skeleton Dead.png",
            33, 32, 1f/15f, positionX, positionY, scale);

    // *3 its the flip ratio.
    lifeBar = new LifeBar(100,8,3, Color.rgba8888(Color.RED), positionX - (skull_idle.width()*3), positionY + Context.LIFE_BAR_Y, pv );

    skull_attack.flip(true, false);
    skull_idle.flip(true, false);
    skull_death.flip(true, false);

  }

  public void draw(){
    elapseTime += Gdx.graphics.getDeltaTime();

    skull_idle.draw(elapseTime);
    lifeBar.draw();

  }




}
