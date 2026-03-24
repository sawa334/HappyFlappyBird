package ru.innovathioncampus.vsu26.ds.happy_flappy_bird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Bird {
    int jumpHeight;
    final int maxHeightOfJump = 200;
    boolean jump;
    int x,y;
    int speed  ;
    Texture texture;

    Texture[] framesArray = new Texture[]{
        new Texture("birdTiles/bird0.png"),
                new Texture("birdTiles/bird1.png"),
                new Texture("birdTiles/bird2.png"),
                new Texture("birdTiles/bird1.png"),
    };
    int frameCounter;

    public Bird(int x, int y, Texture texture, int speed){
        this.x = x;
        this.y = y;
        this.texture = texture;
        this.speed = speed;
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
        batch.draw(texture, x , y);
    }
    public void dispose() {
        texture.dispose();
    }
    void onClick() {
        jump = true;
        jumpHeight = maxHeightOfJump + y;
    }

}

