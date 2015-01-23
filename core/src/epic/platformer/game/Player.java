package epic.platformer.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by god on 15.1.23.
 */
public class Player extends Mob {

    private boolean wKey;
    private boolean dKey;
    private boolean aKey;
    private boolean sKey;

    public Player(float width, float height, Texture icon){
        super(width, height, icon);
    }

    private void handleInput(){

    }

    public void update(){
        handleInput();
    }

}
