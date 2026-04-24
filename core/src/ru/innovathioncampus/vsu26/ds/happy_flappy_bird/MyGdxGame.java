package ru.innovathioncampus.vsu26.ds.happy_flappy_bird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.innovathioncampus.vsu26.ds.happy_flappy_bird.screens.ScreenGame;
import ru.innovathioncampus.vsu26.ds.happy_flappy_bird.screens.ScreenMenu;
import ru.innovathioncampus.vsu26.ds.happy_flappy_bird.screens.ScreenRestart;

public class MyGdxGame extends Game {
	public SpriteBatch batch;


	public static final int SCR_WIDTH = 1280;
	public static final int SCR_HEIGHT = 720;
	public OrthographicCamera camera;

	public ScreenGame screenGame;
	public ScreenRestart screenRestart;
	public ScreenMenu screenMenu;

	
	@Override
	public void create () {

		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);

		screenGame = new ScreenGame(this);
		screenMenu = new ScreenMenu(this);
		setScreen(screenMenu);

		screenRestart = new ScreenRestart(this);
	}

	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
