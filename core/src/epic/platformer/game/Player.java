package epic.platformer.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import javax.swing.*;

/**
 * Created by god on 15.1.23.
 */
public class Player extends Mob {

    private boolean wKey;
    private boolean dKey;
    private boolean aKey;
    private boolean sKey;


    public Player(int x, int y, float width, float height, Sprite icon){
        super(x, y, width, height, icon);
        wKey =false;
        dKey = false;
        aKey = false;
        sKey = false;

    }

    private void handleInput(){
        if(Gdx.input.isKeyPressed(Input.Keys.W) && !inAir) wKey = true;
        if(Gdx.input.isKeyPressed(Input.Keys.A)) aKey = true;
        if(Gdx.input.isKeyPressed(Input.Keys.D)) dKey = true;
        if(Gdx.input.isKeyPressed(Input.Keys.S)) sKey = true;

        if(!Gdx.input.isKeyPressed(Input.Keys.W) || inAir) wKey = false;
        if(!Gdx.input.isKeyPressed(Input.Keys.D)) dKey = false;
        if(!Gdx.input.isKeyPressed(Input.Keys.A)) aKey = false;
        if(!Gdx.input.isKeyPressed(Input.Keys.S)) sKey = false;

        if(Gdx.input.isTouched()){

        }



    }

    public void update(float Delta){
        super.update(Delta);
        handleInput();

        if(wKey){
            inAir = true;
            yForce += 450;
        }
        if(dKey)
        {
            x += 200*Delta;
            fallIfNotOnGround();
        }
        if(aKey)
        {
            x -= 200*Delta;
            fallIfNotOnGround();
        }
        if(sKey && inAir != true) y -= 1000*Delta;


        //world scrolling stuff
        if(x > 450){
            //loop through all game objects, subtract their x by (x-450)
            for(CollisionObject object : Rects.rectList){
                object.x -= x-450;
            }
            x = 450;
        }
        if(x<200){
            for(CollisionObject object : Rects.rectList){
                object.x += 200-x;
            }
            x = 200;
        }


//        //if below zero, game over screen
//        if(y<0){
//            //gameover
//        }
    }

    private void fallIfNotOnGround()
    {
        //Fails if trying to jump while moving, collects yForce.TODO Should fix this
        inAir = true;
        for(CollisionObject obj : Rects.rectList) {
            if (this.overlaps(obj)) {
                inAir = false;
                break;
            }
        }
    }

}
