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

    }

    private void handleInput(){
        if(Gdx.input.isButtonPressed(Input.Keys.W)) wKey = true;
        if(Gdx.input.isButtonPressed(Input.Keys.A)) aKey = true;
        if(Gdx.input.isButtonPressed(Input.Keys.D)) dKey = true;
        if(Gdx.input.isButtonPressed(Input.Keys.S)) sKey = true;
        wKey=false;
        dKey = false;
        aKey = false;
        sKey = false;
    }

    public void update(float Delta){
        super.update(Delta);
        handleInput();

        if(wKey){
            inAir = true;
            yForce += 10;
        }
        if(dKey) x += 200*Delta;
        if(aKey) x -= 200*Delta;
        if(sKey) y -= 1000*Delta;
    }

}
