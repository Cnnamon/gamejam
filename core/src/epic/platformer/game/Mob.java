package epic.platformer.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;


/**
 * Created by god on 15.1.23.
 */
public abstract class Mob extends CollisionObject{

    protected Texture icon;
    protected boolean inAir;
    protected String type;
    protected boolean dealsDmg;

    public Mob(int x, int y, float width, float height, Texture icon){
        this.icon = icon;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;

        inAir = true;
        yForce = 0;
        xForce = 0;
    }

    public Texture getIcon() {
        return icon;
    }

    public String getType(){
        return type;
    }

    public void update(float Delta){
        CollisionSide colSide = CollisionSide.NONE;
        CollisionObject playerFoundation = null;
        for(CollisionObject obj : World.rectList) {
            colSide = this.collisionSide(obj);

            if(colSide != CollisionSide.NONE)
            {
                if(inAir)
                {
                    if(colSide == CollisionSide.TOP)
                    {
                        //inAir = false;
                        yForce = 1;
                        y = obj.getY() - this.getHeight();
                        Sounds.playHitTop();
                    }
                    if(colSide == CollisionSide.BOTTOM)
                    {
                        inAir = false;
                        yForce = 0;
                        y = obj.getY() + obj.getHeight();
                        playerFoundation = obj;
                    }
                    if(colSide == CollisionSide.RIGHT)
                    {
                    }
                }
                if(colSide == CollisionSide.RIGHT)
                {
                    xForce = 0;
                    x = obj.getX() - this.getWidth();
                }
                if(colSide == CollisionSide.LEFT)
                {
                    xForce = 0;
                    x = obj.getX() + obj.getWidth();
                }
            }
        }
        if(inAir)
        {
            yForce -= 9.8 * World.gravity;
            y += yForce * Delta;
        }
        if(playerFoundation != null) {
            x += playerFoundation.xForce*2;
        }
        x += xForce * Delta;
    }
}