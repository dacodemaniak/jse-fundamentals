package fr.aelion.models.course;

public class Document extends Media {
    @Override
    public void play() {
        System.out.println("J'ouvre un nouvel onglet");
    }
}
