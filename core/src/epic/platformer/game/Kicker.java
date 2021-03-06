package epic.platformer.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by tautvis on 15.1.24.
 */
public class Kicker extends Mob {

    private CollisionObject platform = null;

    boolean isKicking;
    boolean isFliping;

    private float walkStateTime;
    private float kickStateTime;
    private float flipStateTime;

    private float walkStateTimeReverse;
    private float kickStateTimeReverse;
    private float flipStateTimeReverse;

    private Animation walkAnimation;
    private Animation kickAnimation;
    private Animation flipAnimation;

    private Animation walkAnimationReverse;
    private Animation kickAnimationReverse;
    private Animation flipAnimationReverse;

    TextureRegion currentFrame;

    private float walkSpeed = 1.0f;
    private boolean goLeft = true;

    public Kicker(int width, int height, CollisionObject o){
        super((int)(o.getX()+o.getWidth()/2), (int)(o.getY()+o.getHeight()/2), width, height, Assets.kickerSprite);
        platform = o;
        walkStateTime = 0;

        walkAnimation = Assets.kickerWalkAnimation;
        kickAnimation = Assets.kickerKickAnimation;
        flipAnimation = Assets.kickerFlipAnimation;

        walkAnimationReverse = Assets.kickerWalkAnimationReverse;
        kickAnimationReverse = Assets.kickerKickAnimationReverse;
        flipAnimationReverse = Assets.kickerFlipAnimationReverse;

        isKicking = false;
        isFliping = false;

        currentFrame = walkAnimation.getKeyFrame(walkStateTime, true);
        type = "kicker";
        dealsDmg = false;
    }

    public void update(float delta){
        super.update(delta);
        if(goLeft){
            if(this.x + walkSpeed + this.width >= platform.getX() + platform.getWidth() ){
                goLeft = false;
            }else{
                this.x += walkSpeed;
            }
        }else{
            if(this.x - walkSpeed  <= platform.getX()) {
                goLeft = true;
            }else{
                this.x -= walkSpeed;
            }
        }
        fallIfNotOnGround();
        if(!isKicking && !isFliping){
            walkStateTime += delta;
            if(goLeft) currentFrame = walkAnimation.getKeyFrame(walkStateTime, true);
            else {
                currentFrame = walkAnimationReverse.getKeyFrame(walkStateTime, true);
            }
        }
        if(World.player.overlaps(this)){
            World.player.getKicked();
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

}
