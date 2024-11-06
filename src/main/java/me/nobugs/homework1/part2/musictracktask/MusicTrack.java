package me.nobugs.homework1.part2.musictracktask;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MusicTrack {
    private String musicTrackTitle;
    private String artist;
    private MusicGenre genre;
}