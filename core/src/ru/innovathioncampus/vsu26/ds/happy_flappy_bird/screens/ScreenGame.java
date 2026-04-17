package ru.innovathioncampus.vsu26.ds.happy_flappy_bird.screens;

import static ru.innovathioncampus.vsu26.ds.happy_flappy_bird.MyGdxGame.SCR_HEIGHT;
import static ru.innovathioncampus.vsu26.ds.happy_flappy_bird.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.innovathioncampus.vsu26.ds.happy_flappy_bird.characters.Bird;
import ru.innovathioncampus.vsu26.ds.happy_flappy_bird.components.MovingBackground;
import ru.innovathioncampus.vsu26.ds.happy_flappy_bird.MyGdxGame;
import ru.innovathioncampus.vsu26.ds.happy_flappy_bird.components.PointCounter;
import ru.innovathioncampus.vsu26.ds.happy_flappy_bird.characters.Tube;


public class ScreenGame implements Screen {

    Bird bird;
    int tubeCount = 3;
    MyGdxGame myGdxGame;

    Tube[] tubes;

    int gamePoints;

    PointCounter pointCounter;
     MovingBackground background;

    final  int pointCounterMarginTop = 60;
    final int pointCounterMarginRight = 400;




     public ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        bird = new Bird(20, SCR_HEIGHT / 2, 10, 200, 150);
        pointCounter = new PointCounter(SCR_WIDTH - pointCounterMarginRight, SCR_HEIGHT - pointCounterMarginTop);
        initTubes();
        background = new MovingBackground("background/game_bg.png");
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
        background.move();
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
        background.draw(myGdxGame.batch);
        bird.draw(myGdxGame.batch);
        for (Tube tube : tubes) tube.draw(myGdxGame.batch);
        pointCounter.draw(myGdxGame.batch, gamePoints);

        myGdxGame.batch.end();

        if (isGameOver) {
            myGdxGame.setScreen(myGdxGame.screenRestart);
        }

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
        background.dispose();
        for (Tube tube : tubes){
            tube.dispose();
        }
        pointCounter.dispose();
    }


}
