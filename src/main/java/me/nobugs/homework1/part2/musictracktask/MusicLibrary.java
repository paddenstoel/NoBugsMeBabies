package me.nobugs.homework1.part2.musictracktask;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MusicLibrary {
    private HashMap<MusicGenre, HashSet<MusicTrack>> library = new HashMap<>();

    public void addTrack(MusicTrack track) {
        library.putIfAbsent(track.getGenre(), new HashSet<>());
        library.get(track.getGenre()).add(track);
    }

    public void removeTrack(MusicTrack track) {
        HashSet<MusicTrack> tracks = library.get(track.getGenre());
        if (tracks != null) {
            tracks.remove(track);
        }
    }

    public HashSet<MusicTrack> getTracksByGenre(MusicGenre genre) {
        return library.getOrDefault(genre, new HashSet<>());
    }

    public void printLibrary() {
        for (Map.Entry<MusicGenre, HashSet<MusicTrack>> entry : library.entrySet()) {
            System.out.println("Genre: " + entry.getKey());
            for (MusicTrack track : entry.getValue()) {
                System.out.println(track);
            }
        }
    }
}