package de.fhswf.inf.oop.aufgabe10.playlist;

import java.util.List;

public record Playlist<T>(List<T> medias) {
	public Playlist (List<T> medias){
        this.medias = List.copyOf(medias);
    }
}
