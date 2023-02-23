package fr.aelion.helpers.strategies.media;

import fr.aelion.helpers.MediaBuilder;
import fr.aelion.helpers.exceptions.NoMediaTypeException;
import fr.aelion.helpers.exceptions.NotEnoughArgsException;
import fr.aelion.models.course.Video;

public class VideoMediaStrategy implements IMediaStrategy<Video> {
    @Override
    public Video castAs(MediaBuilder mediaBuilder) throws NoMediaTypeException, NotEnoughArgsException {
        return (Video) mediaBuilder.build();
    }
}
