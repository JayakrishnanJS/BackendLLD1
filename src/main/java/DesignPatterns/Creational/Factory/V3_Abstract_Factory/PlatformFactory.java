package DesignPatterns.Creational.Factory.V3_Abstract_Factory;

public class PlatformFactory {
    public static UIComponentFactory getFactory(String platform) {
        return switch (platform) {
            case "Android" -> new AndroidUIComponentFactory();
            case "iOS"     -> new IOSUIComponentFactory();
            default        -> throw new IllegalArgumentException("Unknown platform: " + platform);
        };
    }
}
