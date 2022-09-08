package com.mygdx.game.cards;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import java.util.ArrayList;

public class CardHoverListener extends InputListener {

    Card linked_card;
    ArrayList<Card> hand;

    public CardHoverListener(Card card){
        linked_card = card;
        hand = Pointer.player_hand.hand;
    }

    @Override
    public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {

        if (pointer == -1){
            linked_card.addAction(Actions.rotateBy(-linked_card.rotation_hand, 0.3f));
            linked_card.addAction(Actions.scaleBy(0.5f, 0.5f, 0.3f));

            int current_card = hand.indexOf(linked_card);
            System.out.println("index of :" + current_card);
            System.out.println("X :" + linked_card.getX());

            //todo: remove if its for debug
            if(current_card == 1){
                float previous_x = hand.get(current_card - 1).getX();
                float next_x = hand.get(current_card + 1).getX();
                Pointer.player_hand.updateHandOnFocusEnter(current_card - 1, current_card + 1 , previous_x, next_x );
            }

            super.enter(event, x, y, pointer, fromActor);

        }


    }

    @Override
    public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {

        if(pointer == -1) {
            linked_card.addAction(Actions.rotateBy(linked_card.rotation_hand, 0.3f));
            linked_card.addAction(Actions.scaleBy(-0.5f, -0.5f, 0.3f));

            int current_card = hand.indexOf(linked_card);
            if(current_card == 1){
                float previous_x = hand.get(current_card - 1).getX();
                float next_x = hand.get(current_card + 1).getX();
                Pointer.player_hand.updateHandOnFocusEnd(current_card - 1, current_card + 1 , previous_x, next_x );
            }
            super.exit(event, x, y, pointer, toActor);
        }

    }
}

