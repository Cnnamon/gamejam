package epic.platformer.game;

/**
 * Created by laurynas on 2015.01.24.
 */
import com.badlogic.gdx.math.Rectangle;

public class CollisionObject extends Rectangle {
    int group;

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

    public int getGroup() { return group; }
    public void setGroup(int group) { this.group = group; }
}
