package com.mycompany.cakebakery.Command;

import com.mycompany.cakebakery.Models.Music;

public class MusicOnCommand implements Command {
    
    private Music music;

    public MusicOnCommand(Music music) {
        this.music = music;
    }
    
    @Override
    public void execute() {
        music.on();
    }
}
