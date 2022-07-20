package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.mygdx.game.Context;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.cards.Card;
import com.mygdx.game.cards.CardHand;
import com.mygdx.game.character.Hero;
import com.mygdx.game.character.Skull;
import com.mygdx.game.character.utils.button.Button;
import com.mygdx.game.logic.FightLogic;

import javax.xml.transform.Source;

public class FightScreen extends ScreenAdapter {

  MyGdxGame game;
  Skull skull ;
  Hero hero;
  Button button_atk;

  CardHand cardHand;
  Stage stage;
  FightLogic logic;

  public FightScreen(MyGdxGame game){
    this.game = game;

    skull = new Skull();
    hero = new Hero();
    cardHand = new CardHand();

    stage = new Stage(Context.viewport);
    stage.addActor(hero);
    stage.addActor(skull);
    stage.addActor(cardHand);

    Gdx.input.setInputProcessor(stage);

    logic = new FightLogic(stage);
  }

  //change screen
  @Override
  public void show(){



  }

  @Override
  public void render(float delta) {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    stage.draw();
    logic.run();
  }

  @Override
  public void dispose() {
    super.dispose();
    stage.dispose();
  }
}
