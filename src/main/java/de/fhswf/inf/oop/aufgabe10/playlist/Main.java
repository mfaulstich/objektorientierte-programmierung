package de.fhswf.inf.oop.aufgabe10.playlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Track> tracks = new ArrayList<>();
		tracks.add(new Track("Heidi, Heidiiiiiii", 5));
		tracks.add(new Track("Katzenklo, Katzenklo,...", 4));
		Playlist<Track> playList = new Playlist<>(tracks);
		System.out.println(playList);
		tracks.add(new Track("Im Tretboot in Seenot...", 3));
		System.out.println(playList);
	}
}
