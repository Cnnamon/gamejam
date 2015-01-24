package epic.platformer.game;

/**
 * Created by laurynas on 2015.01.24.
 */
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class CollisionObject extends Rectangle {
    int group;
    public enum CollisionSide { NONE, LEFT, RIGHT, TOP, BOTTOM }

    public CollisionObject()
    {
        super(0, 0, 0, 0);
        this.group = 1;
    }
    public CollisionObject(float x, float y, float w, float h, int group)
    {
        super(x, y, w, h);
        this.group = group;
    }

    public boolean overlaps(CollisionObject other)
    {
        if(Relations.shouldCollide(this.getGroup(), other.getGroup()))
        {
            return super.overlaps(other);
        }
        else
        {
            return false;
        }
    }

    public CollisionSide collisionSide(CollisionObject other)
    {
        if(this.overlaps(other))
        {
            float thisCollisionPointX = 0;
            float thisCollisionPointY = 0;
            float otherCollisionPointX = 0;
            float otherCollisionPointY = 0;

            if(this.getX() > other.getX())
            {
                // X
                thisCollisionPointX = this.getX();
                otherCollisionPointX = other.getX() + other.getWidth();
            }
            else
            {
                 // X + H
                thisCollisionPointX = this.getX() + this.getWidth();
                otherCollisionPointX = other.getX();
            }
            if(this.getY() > other.getY())
            {
                // Y
                thisCollisionPointY = this.getY();
                otherCollisionPointY = other.getY() + other.getHeight();
            }
            else
            {
                thisCollisionPointY = this.getY() + this.getHeight();
                otherCollisionPointY = other.getY();
            }
            float resultX = thisCollisionPointX - otherCollisionPointX;
            float resultY = thisCollisionPointY - otherCollisionPointY;
            if(Math.abs(resultX) > Math.abs(resultY))
            {
                if(resultY > 0)
                {
                    return CollisionSide.TOP;
                }
                else
                {
                    return CollisionSide.BOTTOM;
                }
            }
            else
            {
                if(resultX > 0)
                {
                    return CollisionSide.RIGHT;
                }
                else
                {
                    return CollisionSide.LEFT;
                }
            }
        }
        else
        {
            return CollisionSide.NONE;
        }
    }

    public int getGroup() { return group; }
    public void setGroup(int group) { this.group = group; }
}
