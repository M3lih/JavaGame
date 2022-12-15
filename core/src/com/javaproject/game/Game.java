package com.javaproject.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.javaproject.game.states.GameStateManager;
import com.javaproject.game.states.MenuState;

public class Game extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public static final int HEIGTH = 800;

	public static final String TITLE = "Flappy Bird";
	private GameStateManager gsm;
	private SpriteBatch batch;

	private Music music;

	@Override
	public void create() {
		ScreenUtils.clear(1, 0, 0, 1);
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render() {
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}

	@Override
	public void dispose() {
		super.dispose();
		music.dispose();
	}


}