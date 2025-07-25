package DesignPatterns.Structural.Flyweight.V0;

public class Bullet {
    // Extrinsic + Intrinsic state all in one object
    private double x, y, z;
    private double radius, direction, speed;
    private int status, type;
    private byte[] imageData; // ~1KB per bullet

    public Bullet(double x, double y, double z,
                  double radius, double direction, double speed,
                  int status, int type,
                  byte[] imageData) {
        this.x = x; this.y = y; this.z = z;
        this.radius = radius;
        this.direction = direction;
        this.speed = speed;
        this.status = status;
        this.type = type;
        this.imageData = imageData;
    }

    public void updatePosition(double dt) {
        x += Math.cos(direction) * speed * dt;
        y += Math.sin(direction) * speed * dt;
        // z unchanged for simplicity
    }

    public byte[] getImageData() {
        return imageData;
    }
}
