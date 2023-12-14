package com.mycompany.cakebakery.Models;

public class Music {
    
    private volatile static Music uniqueMusicInstance;
    private String[] music = new String[] {"0", "1", "2", "3"};
    private String curr_music;
    private int music_idx;
    
    private Music(){
        this.off();
        this.music_idx = 0;
        this.curr_music = null;
    }
    
    public static Music createMusicInstance(){
        if (uniqueMusicInstance == null) {
            synchronized(Music.class) {
                if (uniqueMusicInstance == null) {
                    uniqueMusicInstance = new Music();
                }
            }
        }
        return uniqueMusicInstance;
    }
    
    public void on(){
        System.out.println("The music is on");
        this.curr_music = music[this.music_idx];
        System.out.println(this.curr_music);
    }
    
    public void off(){
        System.out.println("The music is off");
    }
    
    public void swapLeft(){
        if(this.music_idx == 0) this.curr_music = this.music[this.music.length - 1];
        else this.curr_music = this.music[--music_idx];
        System.out.println(curr_music);
    }
    
    public void swapRight(){
        if(this.music_idx == this.music.length - 1) this.curr_music = this.music[0];
        else this.curr_music = this.music[++music_idx];
        System.out.println(curr_music);
    }
}
