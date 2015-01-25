package epic.platformer.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by tautvis on 15.1.24.
 */
public class Snail extends Mob {

    private CollisionObject platform = null;
    private float walkSpeed = 1.0f;
    private boolean goLeft = true;


    public Snail(int width, int height, Texture texture, CollisionObject o){
        super((int)(o.getX()+o.getWidth()/2), (int)(o.getY()+o.getHeight()/2), width, height, texture);
        platform = o;
        type = "snail";
        dealsDmg = true;
    }

    public void update(float delta){
        super.update(delta);

        /*float distance = Engine.player.getX() - this.getX();
        xForce = speed * ((distance)/(Math.abs(distance)));
        x += xForce * delta;*/

        if(goLeft){
            if(this.x + walkSpeed + this.width >= platform.getX() + platform.getWidth() ){
                goLeft = false;
            }else{
                this.x += walkSpeed;
            }
        }else{
            if(this.x - walkSpeed  < platform.getX()) {
                goLeft = true;
            }else{
                this.x -= walkSpeed;
            }
        }

        fallIfNotOnGround();
    }

    private void fallIfNotOnGround()
    {
        if(inAir) return;
        //Fails if trying to jump while moving, collects yForce.TODO Should fix this
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

}
