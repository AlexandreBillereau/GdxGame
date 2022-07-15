package com.mygdx.game.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.mygdx.game.Context;
import com.mygdx.game.character.utils.Button;
import com.mygdx.game.character.utils.LifeBar;
import gdx.simplify.lib.TextureAnimation;

import java.io.File;

public class Hero {
  TextureAnimation idle;
  TextureAnimation attack;
  TextureAnimation death;
  TextureAnimation current;
  final public File directory_idle = new File("assets/Warrior/Individual Sprite/idle");
  final public File directory_Attack = new File("assets/Warrior/Individual Sprite/Attack");
  final public File directory_death = new File("assets/Warrior/Individual Sprite/Death-Effect");

  LifeBar lifeBar;
  int pv = 100;

  float elapsedTime;

  //const
  int positionX = (int)(Gdx.graphics.getWidth()*0.15);
  int positionY = Gdx.graphics.getHeight()/2;
  float scale = 2f;

  public Hero(){
    idle = new TextureAnimation(directory_idle,1f/5f, positionX,positionY, scale);
    attack = new TextureAnimation(directory_Attack, 1f/12f, positionX,positionY,scale);
    death = new TextureAnimation(directory_death, 1f/11f, positionX, positionY,scale);
    lifeBar = new LifeBar(100,8,3, Color.rgba8888(Color.RED), positionX, positionY + Context.LIFE_BAR_Y, pv );

    current = idle;
  }

  public void draw(Button atk){

    elapsedTime += Gdx.graphics.getDeltaTime();

    if(atk.isClick() && atk.isClickable()){
      current = attack;
      elapsedTime = 0;
      atk.disable();
    }else if(current.isAnimationFinished(elapsedTime)){
      current = idle;
      atk.enable();
    }

    current.draw(elapsedTime);
    lifeBar.draw();

  }


}
