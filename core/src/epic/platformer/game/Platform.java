package epic.platformer.game;

class Platform {
    static final int PLATFORM_STEP = 2;
    private CollisionObject obj;
    private int dir = 1;

    public Platform(CollisionObject obj) {
        this.obj = obj;
    }

    public void update(float delta) {
        for (CollisionObject collObj : World.rectList) {
            // Change direction for overlapping
            if (!collObj.equals(obj) && obj.overlaps(collObj))
                dir *= -1;
            // and out of range
            else if (obj.getX() < 0 || obj.getX() > Assets.screenSizeWidth)
                dir *= -1;
        }

        obj.setX(obj.getX() + dir * PLATFORM_STEP);
    }
}