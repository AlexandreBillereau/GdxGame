package com.mygdx.game.logic;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.character.Hero;
import com.mygdx.game.character.utils.button.Button;

public class FightLogic {

    Stage stage;
    Hero hero;
    Button buttonAtk;

    public FightLogic(Stage stage){
        this.stage = stage;
        buttonAtk = stage.getRoot().findActor("button_atk");
        hero = stage.getRoot().findActor("hero");
    }

    public void run(){

        //condition see if the button is clicked and the animation was finished.
//        if(buttonAtk.isClick() && hero.getCurrentAnimation().isAnimationFinished(hero.getElapsedTime())){
//            hero.playAttackAnimation();
//        }

    }

}
