package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.character.Hero;
import com.mygdx.game.character.Skull;
import com.mygdx.game.character.utils.Button;
import com.mygdx.game.screen.FightScreen;


//Todo: https://happycoding.io/tutorials/libgdx/game-screens
//Todo: Refactor

public class MyGdxGame extends Game {

	Viewport viewport;

	@Override
	public void create () {

		Context.camera = new OrthographicCamera(Context.viewPortWidth, Context.viewPortHeight);
		Context.camera.position.set(Context.camera.viewportWidth/2, Context.camera.viewportHeight/2, 0);
		viewport = new ExtendViewport(Context.camera.viewportWidth, Context.camera.viewportHeight, Context.camera);


		setScreen(new FightScreen(this));
;	}

	// supet.render() render the current setScreen()
	// and u can change the current screen with show() methods
	// ex : https://happycoding.io/tutorials/libgdx/game-screens
	@Override
	public void render () {
		super.render();
	}

	@Override
	public void resize (int width, int height) {
		viewport.update(width, height);
	}
	
	@Override
	public void dispose () {
	}
}
