package com.mygdx.game.cards;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import java.util.ArrayList;

public class CardHoverListener extends InputListener {

    Card linked_card;
    ArrayList<Card> hand;
    int z_index;

    public CardHoverListener(Card card){
        linked_card = card;
        hand = Pointer.player_hand.hand;
    }

    @Override
    public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {

        if (pointer == -1){
            linked_card.addAction(Actions.rotateBy(-linked_card.rotation_hand, 0.3f));
            linked_card.addAction(Actions.scaleBy(0.2f, 0.2f, 0.3f));


            int current_card = hand.indexOf(linked_card);
            z_index = hand.get(current_card).getZIndex();
            hand.get(current_card).setZIndex(hand.size());

            Pointer.player_hand.updateHand(Pointer.player_hand.findPosition(current_card));

            super.enter(event, x, y, pointer, fromActor);

        }


    }

    @Override
    public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {

        if(pointer == -1) {
            linked_card.addAction(Actions.rotateBy(linked_card.rotation_hand, 0.3f));
            linked_card.addAction(Actions.scaleBy(-0.2f, -0.2f, 0.3f));



            int current_card = hand.indexOf(linked_card);
            hand.get(current_card).setZIndex(z_index);
            Pointer.player_hand.updateHand(Pointer.player_hand.findPosition());



            super.exit(event, x, y, pointer, toActor);
        }

    }
}

