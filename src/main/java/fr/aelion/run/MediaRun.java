package fr.aelion.run;

import fr.aelion.helpers.MediaBuilder;
import fr.aelion.helpers.exceptions.NoMediaTypeException;
import fr.aelion.helpers.exceptions.NotEnoughArgsException;
import fr.aelion.models.course.Author;
import fr.aelion.models.course.Media;
import fr.aelion.models.course.Video;

import java.util.HashSet;
import java.util.Set;

public class MediaRun {
    private Media video = new Video();
    private MediaBuilder builder = new MediaBuilder();

    private Set<Media> medias = new HashSet<>();
    public MediaRun() {
        video.setSummary("Ca va pas marcher");
        video.setAuthor(new Author());

        builder.setMediaType("video");
        builder
                .summary("Ca marchera pas non plus mais mieux")
                .author(new Author());
    }

    public void run() {
        medias.add(video);

        try {
            medias.add(builder.build());
        } catch (NoMediaTypeException e) {
            System.out.println("Ton objet il est pourri, je l'ajoute pas na !");
        } catch (NotEnoughArgsException e) {
            System.out.println("T'as pas compris comment on fait les objets !");
        }

        medias.forEach(m -> {
            System.out.println(m.getTitle() + " Duration : " + m.getDuration());
        });
    }
}
