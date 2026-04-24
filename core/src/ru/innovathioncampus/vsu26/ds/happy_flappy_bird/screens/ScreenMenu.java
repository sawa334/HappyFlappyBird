package ru.innovathioncampus.vsu26.ds.happy_flappy_bird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.innovathioncampus.vsu26.ds.happy_flappy_bird.MyGdxGame;
import ru.innovathioncampus.vsu26.ds.happy_flappy_bird.components.MovingBackground;
import ru.innovathioncampus.vsu26.ds.happy_flappy_bird.components.TextButton;

public class ScreenMenu implements Screen {

    MovingBackground background;
    TextButton buttonNewGame;
    TextButton buttonExit;
    MyGdxGame myGdxGame;

    public ScreenMenu(MyGdxGame myGdxGame){
        background = new MovingBackground("background/restart_bg.png");

        this.myGdxGame = myGdxGame;
        buttonNewGame = new TextButton(100, 400, "Start");
        buttonExit = new TextButton(800, 400, "Exit");


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

            if (buttonNewGame.isHit((int) touch.x, (int) touch.y)){
                myGdxGame.setScreen(myGdxGame.screenGame);
            }
            if (buttonExit.isHit((int) touch.x, (int) touch.y)){
                Gdx.app.exit();
            }
        }
        ScreenUtils.clear(1, 0, 0, 1);

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();
        background.draw(myGdxGame.batch);
        buttonNewGame.draw(myGdxGame.batch);
        buttonExit.draw(myGdxGame.batch);
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
        buttonNewGame.dispose();
        buttonExit.dispose();
    }
}
