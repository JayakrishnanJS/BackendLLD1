package DesignPatterns.Creational.Factory.V2_Factory_Method;

public class PlatformFactory {
    /** 
     * Hides all instantiation logic from the client—no if/else there.
     */
    public static Platform getPlatform(String name) {
        return switch (name) {
            case "Android" -> new AndroidPlatform();
            case "iOS"     -> new IOSPlatform();
            default        -> throw new IllegalArgumentException("Unknown platform: " + name);
        };
    }
}
