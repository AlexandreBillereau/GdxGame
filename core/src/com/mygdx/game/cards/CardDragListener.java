package com.mygdx.game.cards;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

public class CardDragListener extends DragListener {

    Card linked_card;
    CardHand linked_hand;

    public CardDragListener(Card card){
        linked_card = card;
    }

    float first_x, first_y, dist_x, dist_y;

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        first_x = x;
        first_y = y;
        return super.touchDown(event, x, y, pointer, button);
    }

    @Override
    public void touchDragged(InputEvent event, float x, float y, int pointer) {
        dist_x =  x - first_x;
        dist_y = y - first_y;

        //moveBy add the dist to x and y
        linked_card.moveBy( dist_x, dist_y);
        super.touchDragged(event, x, y, pointer);
    }

    @Override
    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        linked_card.addAction(Actions.moveTo(linked_card.position_hand_x, linked_card.position_hand_y, 0.5f));
        super.touchUp(event, x, y, pointer, button);
    }


}
