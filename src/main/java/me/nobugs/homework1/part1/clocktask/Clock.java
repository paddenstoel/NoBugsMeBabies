package me.nobugs.homework1.part1.clocktask;

import lombok.*;

@Getter
@Setter
public class Clock implements Readable {
    private int hour;
    private int minutes;
    private int seconds;

    public void tick() {
        seconds += 1;
    }

    @Override
    public void readTime() {
        System.out.println(getHour() + ":" + getMinutes() + ":" + getSeconds());
    }
}
