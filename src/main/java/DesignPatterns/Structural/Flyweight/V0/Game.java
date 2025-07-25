package DesignPatterns.Structural.Flyweight.V0;

import DesignPatterns.Structural.Flyweight.util.MemoryCalculator;

import java.util.*;

public class Game {
    public static void main(String[] args) {
        List<Bullet> bullets = new ArrayList<>();
        byte[] rawImage = loadImageBytes("bullet.png");

        // Simulate 200 players each firing 400 bullets
        for (int i = 0; i < 200 * 400; i++) {
            bullets.add(new Bullet(
                /* x,y,z */      0, 0, 0,
                /* radius */     0.1,
                /* direction */  0,
                /* speed */      50,
                /* status */     1,
                /* type */       1,
                /* imageData */  rawImage
            ));
        }

        System.out.println("Total bullets: " + bullets.size());
        // … game loop, render, update …

        // Estimate memory usage for v0
        MemoryCalculator.calculate(
                "v0 Total Image Data",
                bullets.size(),
                rawImage.length
        );
    }

    private static byte[] loadImageBytes(String path) {
        // pretend we read ~1KB of image data
        return new byte[1024];
    }
}
/*
    The memory used by a single bullet instance would be:
    Double - 8 bytes * 6 = 48 bytes
    Integer - 4 bytes * 2 = 8 bytes
    Image - 1KB
    Let us say each person has around 400 bullets and there are 200 people playing the game.
    The total memory used by the bullets would be 1KB * 400 * 200 = 80MB. This is a lot of
    memory for just 200 people playing the game. Imagine if the number of bullets increase or
    the number of players increase. The memory usage would be even higher. For 2000 bullets
    for 200 players the memory usage would be 800MB.
    The major problem here is for each object, the image field consumes a lot of memory. The
    image is also the same for all the bullets.
*/