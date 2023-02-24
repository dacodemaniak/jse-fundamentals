package fr.aelion.helpers.builders.medias;

import fr.aelion.helpers.exceptions.NoMediaTypeException;
import fr.aelion.helpers.exceptions.NotEnoughArgsException;
import fr.aelion.models.course.Video;

public class VideoBuilder extends MediaBuilder {
    public Video build() throws NoMediaTypeException, NotEnoughArgsException {
        return (Video) super.build();
    }
}
