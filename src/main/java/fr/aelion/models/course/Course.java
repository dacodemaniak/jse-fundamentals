package fr.aelion.models.course;

import fr.aelion.Interfaces.IDisplay;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Course implements IDisplay {
    private Set<Media> medias = new HashSet<>();
    private String title;

    @Override
    public void display() {
        System.out.println("Course : " + title + " (" + medias.size() + " items)");
        medias.forEach(m -> m.display());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addMedia(Media media) {
        this.medias.add(media);
    }

    public void removeMedia(Media media) {
        Set<Media> medias = this.medias.stream()
                .filter(m -> m.equals(media))
                .collect(Collectors.toSet());
        this.medias = medias;
    }
}
