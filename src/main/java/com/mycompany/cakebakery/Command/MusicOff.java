package com.mycompany.cakebakery.Command;

import com.mycompany.cakebakery.Models.Music;


public class MusicOff implements Command{
    
    private Music music;

    public MusicOff(Music music) {
        this.music = music;
    }
    
    @Override
    public void execute() {
        music.off();
    }
}
