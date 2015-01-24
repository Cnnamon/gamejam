package epic.platformer.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by god on 15.1.23.
 */
public class Player extends Mob {

    private boolean wKey;
    private boolean dKey;
    private boolean aKey;
    private boolean sKey;

    private boolean isAlive;


    public Player(int x, int y, float width, float height, Texture icon){
        super(x, y, width, height, icon);
        wKey =false;
        dKey = false;
        aKey = false;
        sKey = false;

        isAlive = true;

    }

    private void handleInput(){
        if(Gdx.input.isKeyPressed(Input.Keys.W) && !inAir) wKey = true;
        if(Gdx.input.isKeyPressed(Input.Keys.A)) aKey = true;
        if(Gdx.input.isKeyPressed(Input.Keys.D)) dKey = true;
        //if(Gdx.input.isKeyPressed(Input.Keys.S)) sKey = true;

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
            if(yForce >= 700) yForce = 600;
        }
        if(dKey)
        {
            //x += 200*Delta;
            xForce = 200;
            fallIfNotOnGround();
        }
        if(aKey)
        {
            //x -= 200*Delta;
            xForce = -200;
            fallIfNotOnGround();
        }
        if(!aKey && !dKey)
        {
            xForce = 0;
            fallIfNotOnGround();
        }
        if(sKey && !inAir) y -= 1000*Delta;


        //world scrolling stuff
        if(x > 550){
            //loop through all game objects, subtract their x by (x-450)
            for(CollisionObject object : World.rectList) object.x -= x-550;
            for(Mob mob: Engine.getMobList())  mob.x -= x-550;
            x = 550;
        }
        if(x<300){
            for(CollisionObject object : World.rectList) object.x += 300-x;
            for(Mob mob: Engine.getMobList())  mob.x += 300-x;
            x = 300;
        }

        if(y>550){
            for(CollisionObject object : World.rectList) object.y -= y-550;
            for(Mob mob: Engine.getMobList())  mob.y -= y-550;
            y = 550;
        }
        if(y<350){
            for(CollisionObject object : World.rectList) object.y += 350-y;
            for(Mob mob: Engine.getMobList())  mob.y += 350-y;
            y = 350;
        }




        //if below zero, game over screen
        if(y<0){
            isAlive = false;
        }
    }

    private void fallIfNotOnGround()
    {
        if(inAir) return;
        if(yForce > 0) { return; }
        inAir = true;
        for(CollisionObject obj : World.rectList) {
            Rectangle rectangle = new Rectangle(x, y, width, height);
            if (rectangle.overlaps(obj)) {
                inAir = false;
                break;
            }
        }
    }

    private boolean isColliding(){
        for(CollisionObject obj : World.rectList) {
            if (this.overlaps(obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
