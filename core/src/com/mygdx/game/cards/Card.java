package com.mygdx.game.cards;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import gdx.simplify.lib.Point;

public class Card extends Image {

    public Card(){
        super(new Texture("assets/Cards/Web 1920 – 1.png"));
        setWidth(getWidth()/3);
        setHeight(getHeight()/3);
        setOrigin(getHeight()/2, getWidth()/2);
//        setPosition(100,-50);
//        setRotation(10);
        addListener(new CardDragListener(this));
    }



}
