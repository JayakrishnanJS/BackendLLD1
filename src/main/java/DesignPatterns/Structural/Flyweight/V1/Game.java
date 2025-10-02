package DesignPatterns.Structural.Flyweight.V1;

import DesignPatterns.Structural.Flyweight.util.MemoryCalculator;
import java.util.*;

public class Game {
    public static void main(String[] args) {
        List<FlyingBullet> bullets = new ArrayList<>();

        // Simulate 200 players each firing 400 bullets
        for (int i = 0; i < 200 * 400; i++) {
            // use factory to create & track bullets
            FlyingBullet b = BulletFactory.getBullet(
                /* typeId */   1,
                /* x,y,z */    0, 0, 0,
                /* radius */   0.1,
                /* direction */0,
                /* speed */    50,
                /* status */   1
            );
            bullets.add(b);
        }

        System.out.println("Total bullets created: " + bullets.size());
        System.out.println("Shared BulletType instances: " + BulletFactory.getBulletCountForType(1));
        // … game loop, render, update …

        // Estimate intrinsic state memory usage for v1
        double intrinsicStateMemory = MemoryCalculator.calculate(
                                        "v1 Shared Image Data",
                                        1,
                                        BulletFactory.getBulletType(1).getImageData().length
                                    );

        // Approximate extrinsic state per bullet (object header + primitives)
        final int EXTRINSIC_BYTES = 64;
        double extrinsicStateMemory = MemoryCalculator.calculate(
                                        "v1 Extrinsic State Total",
                                        bullets.size(),
                                        EXTRINSIC_BYTES
                                    );

        // Total memory occupied for 80000 flying bullets
        System.out.println("Total memory occupied by 80000 flying bullets = " + (intrinsicStateMemory + extrinsicStateMemory));
    }
}

/**
    Flyweight is a structural design pattern that lets you fit more objects into the available
    amount of RAM by sharing common parts of state between multiple objects instead of
    keeping all the data in each object.

    The major problem faced earlier for each object, the image field consumes a lot of memory. The
    image is also the same for all the bullets.

    Other parts of a particle’s state, such as coordinates, movement vector and speed, are
    unique to each particle. After all, the values of these fields change over time. This data
    represents the always changing context in which the particle exists, while the color and
    sprite remain constant for each particle.

    This constant data of an object is usually called the intrinsic state. It lives within the
    object; other objects can only read it, not change it. The rest of the object’s state, often
    altered “from the outside” by other objects, is called the extrinsic state.

    The Flyweight pattern suggests that you stop storing the extrinsic state inside the object.
    Instead, you should pass this state to specific methods which rely on it. Only the intrinsic
    state stays within the object, letting you reuse it in different contexts. As a result, you’d
    need fewer of these objects since they only differ in the intrinsic state, which has much
    fewer variations than the extrinsic.

    So our Bullet class will have to be divided into two classes. One class will contain the
    intrinsic state and the other class will contain the extrinsic state. The extrinsic state will be
    passed to the methods that need it.

 * 1. Purpose of `bulletType`:
 *    - The `bulletType` field represents the **intrinsic state** of a bullet.
 *      Intrinsic state is constant and can be shared among many objects.
 *    - Here, `bulletType` (of type `BulletType`) contains properties like `typeId`
 *      and `imageData`, defining characteristics of a bullet that do not change
 *      per individual bullet (e.g., its sprite).
 *
 * 2. Key Properties of `bulletType`:
 *    - Marked as `final` to ensure its reference cannot change once initialized.
 *    - Shared between multiple `FlyingBullet` objects to reduce memory consumption.
 *
 * 3. Intrinsic State vs. Extrinsic State:
 *    - **Intrinsic State** (shared): Data in `BulletType` (e.g., `imageData`, `typeId`).
 *      Stored in `bulletType` and reused across bullets of the same type.
 *    - **Extrinsic State** (unique): Properties like position (`x, y, z`), size
 *      (`radius`), movement (`direction`, `speed`), `status`. Passed separately
 *      to keep each `FlyingBullet` unique.
 *
 * 4. Flyweight Pattern in Action:
 *    - Objects with shared data (`BulletType`) are managed by a factory (`BulletFactory`).
 *    - On `BulletFactory.getBullet(...)`, the factory returns a shared `BulletType`
 *      instead of creating new data for each bullet.
 *    - Extrinsic state remains per-bullet to preserve uniqueness.
 *
 * 5. Creation and Sharing of `bulletType`:
 *    - `BulletFactory` maintains a `Map<Integer, BulletType>` keyed by `typeId`.
 *    - On first request, it loads intrinsic data (e.g., image bytes) and caches it.
 *    - Subsequent requests return the cached `BulletType`, ensuring reuse.
 *
 * 6. Memory Efficiency:
 *    - Sharing `BulletType` objects drastically reduces memory when many bullets
 *      share the same intrinsic data.
 *    - Only extrinsic state is stored per `FlyingBullet`, while intrinsic data
 *      lives once per bullet type.
 *
 * 7. Real‑world Analogy:
 *    - Bullets in a shooter game share their visual sprite. Instead of storing
 *      the same sprite per bullet, the Flyweight pattern holds one central
 *      `BulletType` for all bullets of that type, while each bullet tracks its
 *      own position, speed, etc.
 *
 *
 * Impl:
      1. Identify Intrinsic vs. Extrinsic State
         - Intrinsic: constant data shared across all bullets (e.g., image).
         - Extrinsic: varies per instance (e.g., position, speed, direction).
      2. Define the Flyweight Class
         - Create a lightweight object holding only intrinsic state.
         - Ensure it is immutable or read‑only for safe sharing.
      3. Define the Context Class
         - Holds extrinsic properties and a reference to the shared flyweight.
      4. Implement the Flyweight Factory
         - Maintain a map of intrinsic keys to flyweight instances.
         - On request, return existing flyweight or create, cache, and return a new one.
      5. (Optional) Pre‑load Flyweights
         - At startup, initialize all expected bullet types in the factory.
      6. Client Usage
         - For each new bullet, retrieve the shared flyweight from the factory.
         - Instantiate the context class with extrinsic data and the flyweight.
      7. Operate on Bullets
         - Game loop uses extrinsic data for logic and shared intrinsic data for rendering.
      8. (Optional) Monitor Memory
         - Compare usage before and after flyweight to verify savings.
 **/

