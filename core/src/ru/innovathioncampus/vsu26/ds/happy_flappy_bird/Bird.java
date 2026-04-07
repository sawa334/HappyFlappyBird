package ru.innovathioncampus.vsu26.ds.happy_flappy_bird;

import static ru.innovathioncampus.vsu26.ds.happy_flappy_bird.MyGdxGame.SCR_HEIGHT;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Bird {
    int jumpHeight;
    final int maxHeightOfJump = 130;
    boolean jump;
    int x,y;
    int speed  ;
    Texture texture;
    int width, height;

    Texture[] framesArray = new Texture[]{
        new Texture("birdTiles/bird0.png"),
                new Texture("birdTiles/bird1.png"),
                new Texture("birdTiles/bird2.png"),
                new Texture("birdTiles/bird1.png"),
    };
    int frameCounter;

    public Bird(int x, int y, int speed, int width, int  height){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public void fly() {
        if (y >= jumpHeight) {
            jump = false;
        }

        if (jump) {
            y += speed;
        } else {
            y -= speed;
        }
    }
    public  void draw (Batch batch) {
        batch.draw(framesArray[frameCounter], x, y, width, height);
        if (frameCounter++ == framesArray.length - 1) frameCounter = 0;
    }
    public void dispose() {
        texture.dispose();
    }
    void onClick() {
        jump = true;
        jumpHeight = maxHeightOfJump + y;
    }
    public boolean isInField() {
        if (y + height < 0) return false;
        if (y > SCR_HEIGHT) {
            return false;
        }
        return true;

    }

}

