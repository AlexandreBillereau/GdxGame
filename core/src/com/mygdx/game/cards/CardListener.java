package com.mygdx.game.cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.mygdx.game.Context;

import java.util.ArrayList;

public class CardListener extends InputListener {

    Card linked_card;
    CardHand linked_hand;
    ArrayList<Card> hand;
    int z_index;

    public CardListener(Card card){
        linked_card = card;
        hand = Pointer.player_hand.hand;
        linked_hand = Pointer.player_hand;
    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

        linked_card.drag = !linked_card.drag;
        linked_card.first_x_click = Gdx.input.getX();
        linked_card.first_y_click = Context.viewPortHeight - Gdx.input.getY();
        linked_card.first_x = linked_card.getX();
        linked_card.first_y = linked_card.getY();

        System.out.println("clicked");
        if(!linked_card.drag){
            linked_hand.updateHand(linked_hand.findPosition());
        }

        return super.touchDown(event, x, y, pointer, button);
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

            linked_card.addAction(Actions.scaleBy(-0.2f, -0.2f, 0.3f));

            int current_card = hand.indexOf(linked_card);
            hand.get(current_card).setZIndex(z_index);
            Pointer.player_hand.updateHand(Pointer.player_hand.findPosition());

            super.exit(event, x, y, pointer, toActor);
        }

    }
}

