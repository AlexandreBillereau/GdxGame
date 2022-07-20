package com.mygdx.game.cards;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

public class CardDragListener extends DragListener {

    Card parent;

    public CardDragListener(Card card){
        parent = card;
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
        parent.moveBy( dist_x, dist_y);
    }

}
