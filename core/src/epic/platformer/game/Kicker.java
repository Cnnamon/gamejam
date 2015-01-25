package epic.platformer.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by tautvis on 15.1.24.
 */
public class Kicker extends Mob {

    private CollisionObject platform = null;
    private Animation walkAnimation;
    private Animation kickAnimation;
    private Animation flipAnimation;

    TextureRegion currentFrame;

    private CollisionObject collisionObject = null;
    private float walkSpeed = 1.0f;
    private boolean goLeft = true;

    public Kicker(int width, int height, Texture texture, CollisionObject o){
        super((int)(o.getX()+o.getWidth()/2), (int)(o.getY()+o.getHeight()/2), width, height, texture);
        platform = o;
    }

    public void update(float delta){
        super.update(delta);
        if(goLeft){
            if(this.x + walkSpeed - this.width >= platform.getX() + platform.getWidth()){
                goLeft = false;
            }else{
                this.x += walkSpeed;
            }
        }else{
            if(this.x - walkSpeed < platform.getX()) {
                goLeft = true;
            }else{
                this.y -= walkSpeed;
            }
        }
//        currentFrame = walkAnimation.getKeyFrame(delta, true);

    }

}
