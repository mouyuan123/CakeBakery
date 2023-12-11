package com.mycompany.cakebakery.Command;

import com.mycompany.cakebakery.Models.Music;

public class MusicOn implements Command {
    
    private Music music;

    public MusicOn(Music music) {
        this.music = music;
    }
    
    @Override
    public void execute() {
        music.on();
    }
}
