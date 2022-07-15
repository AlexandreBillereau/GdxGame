package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.character.Hero;
import com.mygdx.game.character.Skull;
import com.mygdx.game.character.utils.Button;

public class FightScreen extends ScreenAdapter {

  MyGdxGame game;
  Skull skull ;
  Hero hero;
  Button button_atk;

  public FightScreen(MyGdxGame game){
    this.game = game;

    skull = new Skull();
    hero = new Hero();
    button_atk = new Button();
  }

  //change screen
  @Override
  public void show(){



  }

  @Override
  public void render(float delta) {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    button_atk.draw();
    skull.draw();
    hero.draw(button_atk);
  }
}
