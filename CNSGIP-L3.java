package cns;

import java.util.ArrayList;
import java.util.LinkedList;

// Song class
class Song {
    private String title;
    private double duration;

    // Constructor
    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Method to display song details
    public void displaySongDetails() {
        System.out.println("Title: " + title + ", Duration: " + duration + " minutes");
    }
}

// Album class
class Album {
    private String name;
    private ArrayList<Song> songs;

    // Constructor
    public Album(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    // Method to add song to the album
    public void addSong(String title, double duration) {
        songs.add(new Song(title, duration));
    }

    // Method to find a song in the album
    public Song findSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }
}

// Playlist class
class Playlist {
    private String name;
    private LinkedList<Song> songs;

    // Constructor
    public Playlist(String name) {
        this.name = name;
        this.songs = new LinkedList<>();
    }

    // Method to add a song to the playlist
    public boolean addSong(Song song) {
        if (songs.contains(song)) {
            System.out.println("Song is already in the playlist.");
            return false;
        } else {
            songs.add(song);
            return true;
        }
    }

    // Method to remove a song from the playlist
    public boolean removeSong(Song song) {
        if (!songs.contains(song)) {
            System.out.println("Song is not in the playlist.");
            return false;
        } else {
            songs.remove(song);
            return true;
        }
    }

    // Method to play the playlist
    public void play() {
        System.out.println("Playing playlist: " + name);
        for (Song song : songs) {
            song.displaySongDetails();
        }
    }
}

// Main class
public class SongPlaylistApp {
    public static void main(String[] args) {
        // Creating an album
        Album album = new Album("My Album");
        album.addSong("Song 1", 3.5);
        album.addSong("Song 2", 4.2);
        album.addSong("Song 3", 5.0);

        // Creating a playlist
        Playlist playlist = new Playlist("My Playlist");
        // Adding songs from the album to the playlist
        playlist.addSong(album.findSong("Song 1"));
        playlist.addSong(album.findSong("Song 3"));

        // Playing the playlist
        playlist.play();
    }
}
