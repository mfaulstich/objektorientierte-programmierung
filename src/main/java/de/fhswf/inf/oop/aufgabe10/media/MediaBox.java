package de.fhswf.inf.oop.aufgabe10.media;

public class MediaBox<T> {
	private T media;

	public T getMedia() {
		return media;
	}

	public MediaBox(T media) {
		this.media = media;
	}

}
