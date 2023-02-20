package fr.aelion.models.course;

import fr.aelion.Interfaces.IDisplay;

public class Document extends Media {
    @Override
    public void play() {
        System.out.println("J'ouvre un onglet");
    }

    @Override
    public void display() {
        System.out.println("Document");
        super.display();
    }
}
