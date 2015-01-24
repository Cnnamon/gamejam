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
    protected float yForce;

    public Mob(int x, int y, float width, float height, Texture icon){
        this.icon = icon;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;

        inAir = true;
        yForce = 0;
    }

    public Texture getIcon() {
        return icon;
    }

    public void update(float Delta){
        if(inAir){
            boolean collided = false;
            Vector2 center1 = new Vector2(this.x+this.width/2, this.y+this.height/2);
            Vector2 center2;
            float coordinate = y;
            for(CollisionObject obj : World.rectList) {
                center2 = new Vector2(obj.x+obj.width/2, obj.y+obj.height/2);
                if (this.overlaps(obj) && center2.sub(center1).y > 0) {
                    collided = true;
                    coordinate = obj.y - this.height;
                    y = coordinate;
                    break;
                }
            }
            if(collided)
            {
                System.out.print("what");
                yForce = 0;
            }
        }
        if(inAir)
        {
            boolean collided = false;
            Vector2 center1 = new Vector2(this.x+this.width/2, this.y+this.height/2);
            Vector2 center2;
            float coordinate = this.y;
            //todo current collision cant properly check from which direction we ram into something. This should be addressed
            //perhaps with a custom overlapping method?
            CollisionObject collider = null;
            for(CollisionObject obj : World.rectList) {
                center2 = new Vector2(obj.x+obj.width/2, obj.y+obj.height/2);
                if (this.overlaps(obj)) {
                    collided = true;
                    collider = obj;
                    coordinate = obj.y + obj.height;
                    break;
                }
            }
            if(!collided) {
                yForce -= 9.8 * World.gravity;
                y += yForce * Delta;
            }
            else
            {
                inAir = false;
                yForce = 0;
                //y = coordinate;
                while (this.overlaps(collider))this.y+=0.2;

            }
        }
//        if(Assets.world[(int)x][(int)y] == 1){
//            inAir = false;
//            y -= yForce*Delta;
//            yForce = 0;
//        }
    }
}