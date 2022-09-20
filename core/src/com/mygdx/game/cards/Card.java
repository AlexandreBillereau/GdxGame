package com.mygdx.game.cards;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Card extends Image {

    float position_hand_x;
    float position_hand_y;
    float rotation_hand;
    int z_index;

    public Card(){
        super(new Texture("assets/Cards/Web 1920 – 1.png"));
        setWidth(getWidth()/3);
        setHeight(getHeight()/3);
        setOrigin(getWidth()/2, getHeight()/2);
        addListener(new CardDragListener(this));
        addListener(new CardHoverListener(this));


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
        super.act(delta);
    }


    public void moveTo(float x, float y, float duration){
        addAction(Actions.moveTo(x, y, duration));
    }


    public void moveToInit(float x, float y, float duration){
        position_hand_x = x - getWidth()/2;
        position_hand_y = y - getHeight()/2;
        addAction(Actions.moveTo(position_hand_x, position_hand_y, duration));
    }




}
