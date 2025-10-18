package DesignPatterns.Creational.Factory.V3_Abstract_Factory;

public class PlatformFactory {
    public static UIComponentFactory getUIComponentFactory(String platform) {
        return switch (platform) {
            case "Android" -> new AndroidUIComponentFactory();
            case "iOS"     -> new IOSUIComponentFactory();
            default        -> throw new IllegalArgumentException("Unknown platform: " + platform);
        };
    }

    // Add additional methods here to return other product families for different platforms.
    public static UILayoutFactory getUILayoutFactory(String platform) {
        return switch (platform) {
            case "Android" -> new AndroidUILayoutFactory();
            case "iOS"     -> new IOSUILayoutFactory();
            default        -> throw new IllegalArgumentException("Unknown platform: " + platform);
        };
    }
}
