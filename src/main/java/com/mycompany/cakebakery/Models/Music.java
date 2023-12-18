package com.mycompany.cakebakery.Models;

import com.mycompany.cakebakery.Constants.DirConstant;

public class Music {
    
    private volatile static Music uniqueMusicInstance;
    
    private boolean off;
    private String musicImg;
    private String[] music = new String[] {"/backgroundMusicNormal.mp3", "/backgroundMusicChristmas.mp3", "/backgroundMusicNewYear.mp3", "/backgroundMusicValentine.mp3" };
    private String curr_music;
    private int music_idx;
    
    private Music(){
        this.off();
        this.music_idx = 0;
        this.curr_music = null;
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
        this.musicImg = DirConstant.SPEAKER_PATH + "/speaker_on.png";
        this.curr_music = DirConstant.SPEAKER_MUSIC_PATH + music[this.music_idx];
        this.off = false;
    }
    
    public void off(){
        this.musicImg = DirConstant.SPEAKER_PATH + "/speaker_off.png";
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

    public String getMusicImg() {
        return musicImg;
    }

    public void setMusicImg(String musicImg) {
        this.musicImg = musicImg;
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
