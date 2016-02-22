/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Petter
 */
public class Song {
    
    private int id, pop;
    private String songName, artist, location, genre, loc;
    
    public Song(int id, String name, String artist, String genre, int popularity, String loc) {
        this.id = id;
        this.songName = name;
        this.artist = artist;
        this.location = loc;
        this.genre = genre;
        this.pop = popularity;
        this.loc = loc;
    }
    
    public String getSongName(){
        return songName;
    }
    public String getArtist(){
        return artist;
    }
    public String getLocation(){
        return location;
    }
    public String getGenre(){
        return genre;
    }
    public int getPop(){
        return pop;
    }
    public String getLoc(){
        return loc;
    }
   
    
    
   
}
