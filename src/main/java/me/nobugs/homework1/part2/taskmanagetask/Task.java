package me.nobugs.homework1.part2.taskmanagetask;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Task {
    private String taskDescription;
    @Getter
    private Priority priority;
}
