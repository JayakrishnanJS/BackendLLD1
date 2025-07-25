package DesignPatterns.Structural.Flyweight.V1;

public class FlyingBullet {
    private double x, y, z;
    private double radius, direction, speed;
    private int status;
    // above 3 are extrinsic state
    private final BulletType bulletType; // shared intrinsic state

    public FlyingBullet(double x, double y, double z,
                        double radius, double direction, double speed,
                        int status,
                        BulletType bulletType) {
        this.x          = x;
        this.y          = y;
        this.z          = z;
        this.radius     = radius;
        this.direction  = direction;
        this.speed      = speed;
        this.status     = status;
        this.bulletType = bulletType;
    }

    public void updatePosition(double dt) {
        x += Math.cos(direction) * speed * dt;
        y += Math.sin(direction) * speed * dt;
        // z unchanged
    }

    public byte[] getImageData() {
        return bulletType.getImageData();
    }
}
