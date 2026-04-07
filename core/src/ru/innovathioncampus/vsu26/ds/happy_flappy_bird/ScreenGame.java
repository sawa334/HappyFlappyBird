package ru.innovathioncampus.vsu26.ds.happy_flappy_bird;

import static ru.innovathioncampus.vsu26.ds.happy_flappy_bird.MyGdxGame.SCR_HEIGHT;
import static ru.innovathioncampus.vsu26.ds.happy_flappy_bird.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class ScreenGame implements Screen {

    Bird bird;
    int tubeCount = 3;
    MyGdxGame myGdxGame;

    Tube[] tubes;

    int gamePoints;

    PointCounter pointCounter;

    final  int pointCounterMarginTop = 60;
    final int pointCounterMarginRight = 400;




    ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        bird = new Bird(20, SCR_HEIGHT / 2, 10, 250, 200);
        pointCounter = new PointCounter(SCR_WIDTH - pointCounterMarginRight, SCR_HEIGHT - pointCounterMarginTop);
        initTubes();
    }
    public void initTubes(){
        tubes = new Tube[tubeCount];
        for (int i = 0; i < tubeCount; i++) {
            tubes[i] = new Tube(tubeCount, i);
        }
    }


    @Override
    public void show() {
        gamePoints = 0;
        isGameOver = false;
    }

    boolean isGameOver;

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()) {
            bird.onClick();


        }
        bird.fly();
        if (!bird.isInField()) {
            System.out.println("not in field");
            isGameOver = true;
        }

        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();
        pointCounter.draw(myGdxGame.batch, gamePoints);
        bird.draw(myGdxGame.batch);
        for (Tube tube : tubes) {
            tube.move();
            if (tube.isHit(bird)) {
                System.out.println("hit");
                isGameOver = true;
            } else if (tube.needAddPoint((bird))) {
                gamePoints += 1;
                tube.setPointReceived();
                System.out.println(gamePoints);
            }
        }
        for (Tube tube : tubes) tube.draw(myGdxGame.batch);
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
        bird.dispose();
    }


}
