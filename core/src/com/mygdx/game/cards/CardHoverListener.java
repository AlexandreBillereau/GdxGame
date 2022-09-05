package com.mygdx.game.cards;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class CardHoverListener extends InputListener {

    Card linked_card;

    public CardHoverListener(Card card){
        linked_card = card;
    }

    @Override
    public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {

        if (pointer == -1){
            linked_card.addAction(Actions.rotateBy(-linked_card.rotation_hand, 0.3f));
            linked_card.addAction(Actions.scaleBy(0.5f, 0.5f, 0.3f));
//            parent.setZIndex(15);
            int current_card = Pointer.player_hand.hand.indexOf(linked_card);
            Pointer.player_hand.updateHandOnFocusEnter(current_card - 1, current_card + 1, linked_card.getX(), linked_card.getX(), 0 );
            super.enter(event, x, y, pointer, fromActor);
        }


    }

    @Override
    public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {

        if(pointer == -1) {
            linked_card.addAction(Actions.rotateBy(linked_card.rotation_hand, 0.3f));
            linked_card.addAction(Actions.scaleBy(-0.5f, -0.5f, 0.3f));
//            parent.setZIndex(0);
            int current_card = Pointer.player_hand.hand.indexOf(linked_card);
            Pointer.player_hand.updateHandOnFocusEnd(current_card - 1, current_card + 1, linked_card.getX(), linked_card.getX(), 0);
            super.exit(event, x, y, pointer, toActor);
        }

    }
}

