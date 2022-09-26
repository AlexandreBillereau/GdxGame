package com.mygdx.game.cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Context;

public class Card extends Image {

    float position_hand_x;
    float position_hand_y;
    float rotation_hand;
    int z_index;

    boolean played = false;
    boolean drag = false;

    float first_x, first_y, first_x_click, first_y_click;


    CardListener card_lister;

    public Card(){
        super(new Texture("assets/Cards/Web 1920 – 1.png"));
        card_lister = new CardListener(this);
        setWidth(getWidth()/3);
        setHeight(getHeight()/3);
        setOrigin(getWidth()/2, getHeight()/2);
        addListener(card_lister);


        z_index = getZIndex();
    }

    @Override
    // change for change position from origin and not left-bottom corner
    // setPosition not affected by setOrigin.
    public void setPosition(float x, float y) {
        position_hand_x = x - getWidth()/2;
        position_hand_y = y - getHeight()/2;
        super.setPosition(position_hand_x, position_hand_y);

    }

    @Override
    public void setRotation(float degrees) {
        super.setRotation(degrees);
        rotation_hand = degrees;
    }

    @Override
    public void act(float delta) {
        followCursor();
        super.act(delta);
    }


    public void moveTo(float x, float y, float duration){
        addAction(Actions.moveTo(x, y, duration));
    }


    public void moveToInit(float x, float y, float duration){
        position_hand_x = x - getWidth()/2;
        position_hand_y = y - getHeight()/4;
        addAction(Actions.moveTo(position_hand_x, position_hand_y, duration));
    }

    private void followCursor(){
        if(drag){
            moveTo(  first_x + Gdx.input.getX()-first_x_click, Context.viewPortHeight - Gdx.input.getY() - first_y_click, 0);
        }
    }




}
