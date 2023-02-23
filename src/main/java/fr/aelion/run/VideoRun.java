package fr.aelion.run;

import fr.aelion.helpers.MediaBuilder;
import fr.aelion.helpers.exceptions.NoMediaTypeException;
import fr.aelion.helpers.exceptions.NotEnoughArgsException;
import fr.aelion.models.course.Author;
import fr.aelion.models.course.Media;
import fr.aelion.models.course.Video;

public class VideoRun {
    private MediaBuilder mediaBuilder = new MediaBuilder();

    public VideoRun() throws NoMediaTypeException, NotEnoughArgsException {
        mediaBuilder.setMediaType("video");
        mediaBuilder
                .title("Titre")
                .summary("Résumé")
                .author(new Author())
                .duration(5.35F);
        Media video = mediaBuilder.build();

    }
}
