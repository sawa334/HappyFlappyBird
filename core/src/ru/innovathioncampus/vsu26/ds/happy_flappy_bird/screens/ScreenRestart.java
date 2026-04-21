package ru.innovathioncampus.vsu26.ds.happy_flappy_bird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import ru.innovathioncampus.vsu26.ds.happy_flappy_bird.MyGdxGame;
import ru.innovathioncampus.vsu26.ds.happy_flappy_bird.components.MovingBackground;
import ru.innovathioncampus.vsu26.ds.happy_flappy_bird.components.PointCounter;
import ru.innovathioncampus.vsu26.ds.happy_flappy_bird.components.TextButton;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class ScreenRestart implements Screen {
    public int gamePoints;
    PointCounter pointCounter;


    MovingBackground background;
    TextButton buttonRestart;

    MyGdxGame myGdxGame;
    public ScreenRestart(MyGdxGame myGdxGame){
        background = new MovingBackground("background/restart_bg.png");

        this.myGdxGame = myGdxGame;
        buttonRestart = new TextButton(100, 400, "Restart");
        pointCounter = new PointCounter(750,530);

    }

    @Override
    public void show() {


    }

    @Override
    public void render(float delta) {

        if (Gdx.input.justTouched()) {

            Vector3 touch = myGdxGame.camera.unproject(
                    new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0)
            );

            if (buttonRestart.isHit((int) touch.x, (int) touch.y)) {
                myGdxGame.setScreen(myGdxGame.screenGame);
            }
        }



        ScreenUtils.clear(1, 0, 0, 1);

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();
        background.draw(myGdxGame.batch);
        pointCounter.draw(myGdxGame.batch, gamePoints);
        buttonRestart.draw(myGdxGame.batch);
        Vector3 touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
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
