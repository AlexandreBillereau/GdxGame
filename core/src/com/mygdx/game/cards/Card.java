package com.mygdx.game.cards;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import gdx.simplify.lib.Point;

public class Card extends Image {

    float position_hand_x;
    float position_hand_y;

    float rotation_hand;

    public Card(){
        super(new Texture("assets/Cards/Web 1920 – 1.png"));
        setWidth(getWidth()/3);
        setHeight(getHeight()/3);
        setOrigin(getHeight()/2, getWidth()/2);
        addListener(new CardDragListener(this));
        addListener(new CardHoverListener(this));
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        position_hand_x = x;
        position_hand_y = y;
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
}
