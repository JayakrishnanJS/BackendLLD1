package DesignPatterns.Structural.Decorator.Addons;

import DesignPatterns.Structural.Decorator.Addon;
import DesignPatterns.Structural.Decorator.Beverage;

public class ChocoChip extends Addon {
    public ChocoChip(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int getCost() {
        return 2 + beverage.getCost();
    }

    @Override
    public void getDescription() {
        beverage.getDescription();
        System.out.println("Added Choco Chip");
    }
}
