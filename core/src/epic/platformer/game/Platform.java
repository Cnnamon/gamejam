package epic.platformer.game;

class Platform {

    private CollisionObject obj;
    //private float force;
    private int dir = 1;

    public Platform(CollisionObject obj, float force) {
        this.obj = obj;
        obj.xForce = force;
    }

    public void update(float delta) {
        for (CollisionObject collObj : World.rectList) {
            // Change direction for overlapping
            if (!collObj.equals(obj) && obj.overlaps(collObj))
                obj.xForce *= -1;
                // and out of range
            else if (obj.getX() < 0 || obj.getX() > Assets.screenSizeWidth * 3)
                obj.xForce *= -1;
        }

        obj.setX(obj.getX() + obj.xForce);
    }

    public float getForce() {
        return obj.xForce;
    }

    public void setForce(float force) {
        obj.xForce = force;
    }

    public CollisionObject getCollisionObject() {
        return obj;
    }
}