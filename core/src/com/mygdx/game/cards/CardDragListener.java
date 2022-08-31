package com.mygdx.game.cards;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
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
        System.out.println("touchDown : " + pointer);
        return super.touchDown(event, x, y, pointer, button);
    }

    @Override
    public void touchDragged(InputEvent event, float x, float y, int pointer) {
        dist_x =  x - first_x;
        dist_y = y - first_y;

        //moveBy add the dist to x and y
        parent.moveBy( dist_x, dist_y);
        System.out.println("touchDragged : " + pointer);
        super.touchDragged(event, x, y, pointer);
    }

    @Override
    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        parent.addAction(Actions.moveTo(parent.position_hand_x, parent.position_hand_y, 0.5f));
        System.out.println("touchUp : " + pointer);
        super.touchUp(event, x, y, pointer, button);
    }


}
