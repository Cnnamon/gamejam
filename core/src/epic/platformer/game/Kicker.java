package epic.platformer.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by tautvis on 15.1.24.
 */
public class Kicker extends Mob {

    private CollisionObject collisionObject = null;
    private float walkSpeed = 1.0f;

    public Kicker(int width, int height, Texture texture, CollisionObject collisionObject){
        super((int)(collisionObject.getX()+collisionObject.getHeight()), (int)(collisionObject.getY()+collisionObject.getWidth()/2), width, height, texture);
        this.collisionObject = collisionObject;
    }

    public void update(){

    }

}
