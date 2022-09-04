package com.mygdx.game.cards;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;

public class CardHoverListener extends InputListener {

    Card parent;

    public CardHoverListener(Card card){
        parent = card;
    }

    @Override
    public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {

        if (pointer == -1){
            parent.addAction(Actions.rotateBy(-parent.rotation_hand, 0.3f));
            parent.addAction(Actions.scaleBy(0.5f, 0.5f, 0.3f));
//            parent.setZIndex(15);
            super.enter(event, x, y, pointer, fromActor);
        }


    }

    @Override
    public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {

        if(pointer == -1) {
            parent.addAction(Actions.rotateBy(parent.rotation_hand, 0.3f));
            parent.addAction(Actions.scaleBy(-0.5f, -0.5f, 0.3f));
//            parent.setZIndex(0);
            super.exit(event, x, y, pointer, toActor);
        }

    }
}

