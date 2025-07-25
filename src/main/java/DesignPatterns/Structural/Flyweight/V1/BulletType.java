package DesignPatterns.Structural.Flyweight.V1;

// stores intrinisc state of a bullet
public class BulletType {
    private final int    typeId;
    private final byte[] imageData;

    public BulletType(int typeId, byte[] imageData) {
        this.typeId    = typeId;
        this.imageData = imageData;
    }

    public int getTypeId() {
        return typeId;
    }

    public byte[] getImageData() {
        return imageData;
    }
}
