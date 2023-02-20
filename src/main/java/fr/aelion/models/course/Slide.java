package fr.aelion.models.course;

import fr.aelion.Interfaces.IDisplay;

public class Slide extends Media {
    @Override
    public void play() {
        System.out.println("Je charge une présentation");
    }

    @Override
    public void display() {
        System.out.println("Slide");
        super.display();
    }
}
