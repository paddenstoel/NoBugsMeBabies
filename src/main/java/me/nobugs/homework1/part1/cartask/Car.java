package me.nobugs.homework1.part1.cartask;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car implements Drivable {
    private String brand;
    private String model;
    private int manufactureYear;

    @Override
    public void start() {
        System.out.println("The car engine is running");
    }

    @Override
    public void stop() {
        System.out.println("The car engine stopped");
    }

    @Override
    public void drive(double distance) {
        System.out.println("The car has driven for " + distance + " miles");
    }
}
