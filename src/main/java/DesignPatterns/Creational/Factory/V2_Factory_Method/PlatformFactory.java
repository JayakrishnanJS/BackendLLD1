package DesignPatterns.Creational.Factory.V2_Factory_Method;

import java.time.LocalDate;

public class PlatformFactory {
    /** 
     * Hides all instantiation logic from the client—no if/else there.
     */
    public static Platform getPlatform(String name, String version, LocalDate releaseDate) {
        return switch (name) {
            case "Android" -> new AndroidPlatform(version, releaseDate);
            case "iOS"     -> new IOSPlatform(version, releaseDate);
            default        -> throw new IllegalArgumentException("Unknown platform: " + name);
        };
    }
}
