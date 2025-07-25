package DesignPatterns.Structural.Flyweight.V1;

import java.util.*;

// the factory returns a shared `BulletType` instead of creating new data for each bullet
public class BulletFactory {
    // Map typeId → shared BulletType
    private static final Map<Integer, BulletType> types = new HashMap<>();
    // Map typeId → list of created FlyingBullets (optional tracking)
    private static final Map<Integer, List<FlyingBullet>> bulletsByType = new HashMap<>();

    /**
     * Return the shared BulletType for this typeId,
     * loading the image data only once.
     */
    public static BulletType getBulletType(int typeId) {
        if (!types.containsKey(typeId)) {
            byte[] img = loadImageBytes("bullet_type_" + typeId + ".png");
            types.put(typeId, new BulletType(typeId, img));
        }
        return types.get(typeId);
    }

    /**
     * Create a new FlyingBullet for this type, register it,
     * and return it.
     */
    public static FlyingBullet getBullet(int typeId,
                                         double x, double y, double z,
                                         double radius,
                                         double direction,
                                         double speed,
                                         int status) {
        BulletType type = getBulletType(typeId);
        FlyingBullet bullet = new FlyingBullet(
            x, y, z,
            radius, direction, speed,
            status,
            type
        );
        addBullet(typeId, bullet);
        return bullet;
    }

    /**
     * Optional: track bullets by type for analytics/debugging.
     */
    public static void addBullet(int typeId, FlyingBullet bullet) {
        if (!bulletsByType.containsKey(typeId)) {
            bulletsByType.put(typeId, new ArrayList<>());
        }
        bulletsByType.get(typeId).add(bullet);
    }

    private static byte[] loadImageBytes(String path) {
        // simulate ~1KB of image data
        return new byte[1024];
    }

    /**
     * Optional helper to inspect how many bullets per type exist.
     */
    public static int getBulletCountForType(int typeId) {
        List<FlyingBullet> bullets = bulletsByType.get(typeId);
        if (bullets == null) {
            return 0;
        }
        return bullets.size();
    }
}
