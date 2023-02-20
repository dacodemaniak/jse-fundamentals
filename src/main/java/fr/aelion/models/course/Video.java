package fr.aelion.models.course;

import fr.aelion.Interfaces.IDisplay;

public class Video extends Media {
    @Override
    public void play() {
        System.out.println("Je joue la vidéo");
    }

    @Override
    public void display() {
        System.out.println("Vidéo");
        super.display();
    }
}
