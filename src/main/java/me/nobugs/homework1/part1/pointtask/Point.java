package me.nobugs.homework1.part1.pointtask;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Point implements Movable {
    private double x;
    private double y;

    @Override
    public void moveUp() {
        y += 1.0;
    }

    @Override
    public void moveDown() {
        y -= 1.0;
    }

    @Override
    public void moveLeft() {
        x -= 1.0;
    }

    @Override
    public void moveRight() {
        x += 1.0;
    }
}
