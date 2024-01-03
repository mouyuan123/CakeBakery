package com.mycompany.cakebakery.Models;

import com.mycompany.cakebakery.Constants.DirConstant;

public class Music {
    
    private volatile static Music uniqueMusicInstance;
    
    private boolean off;
    private String[] music = new String[] {"/cafe.mp3", "/lounge.mp3", "/upbeat.mp3", "/piano.mp3", "/happy.mp3" };
    private String curr_music;
    private int music_idx;
    private double volume;
    
    private Music(){
        this.off();
        this.music_idx = 0;
        this.curr_music = null;
        this.volume = 1.0;
    }
    
    public static Music getMusicInstance(){
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
        this.curr_music = DirConstant.SPEAKER_MUSIC_PATH + music[this.music_idx];
        this.off = false;
    }
    
    public void off(){
        this.curr_music = null;
        this.off = true;
    }
    
    public void swapLeft(){
        this.music_idx = this.music_idx - 1 < 0 ? this.music.length - 1 : this.music_idx - 1;
        this.curr_music = DirConstant.SPEAKER_MUSIC_PATH + this.music[music_idx];
    }
    
    public void swapRight(){
        this.music_idx = this.music_idx + 1 >= this.music.length ? 0 : this.music_idx + 1;
        this.curr_music = DirConstant.SPEAKER_MUSIC_PATH + this.music[music_idx];
    }

    public String getCurr_music() {
        return curr_music;
    }

    public void setCurr_music(String curr_music) {
        this.curr_music = curr_music;
    }

    public boolean isOff() {
        return off;
    } 
}
