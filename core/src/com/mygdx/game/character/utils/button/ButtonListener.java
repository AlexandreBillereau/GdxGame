package com.mygdx.game.character.utils.button;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class ButtonListener extends InputListener {

    Button parent;
    public ButtonListener(Button button){
        parent = button;
    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int buttons){
        parent.clicked = true;
        return true;
    }

    @Override
    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        parent.clicked = false;
        parent.enable = true;
    }
}
