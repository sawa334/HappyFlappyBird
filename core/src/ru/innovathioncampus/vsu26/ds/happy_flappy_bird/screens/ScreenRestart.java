package ru.innovathioncampus.vsu26.ds.happy_flappy_bird.screens;

import com.badlogic.gdx.Screen;

import ru.innovathioncampus.vsu26.ds.happy_flappy_bird.MyGdxGame;
import ru.innovathioncampus.vsu26.ds.happy_flappy_bird.components.MovingBackground;
import ru.innovathioncampus.vsu26.ds.happy_flappy_bird.components.TextButton;

import com.badlogic.gdx.utils.ScreenUtils;

public class ScreenRestart implements Screen {
    MovingBackground background;
    TextButton buttonRestart;

    MyGdxGame myGdxGame;
    public ScreenRestart(MyGdxGame myGdxGame){
        background = new MovingBackground("background/restart_bg.png");

        this.myGdxGame = myGdxGame;
        buttonRestart = new TextButton(100, 400, "Restart");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();
        background.draw(myGdxGame.batch);
        buttonRestart.draw(myGdxGame.batch);
        myGdxGame.batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        background.dispose();
        buttonRestart.dispose();

    }
}
