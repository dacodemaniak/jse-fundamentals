package fr.aelion.helpers.strategies.media;


import fr.aelion.helpers.builders.medias.MediaBuilder;
import fr.aelion.helpers.builders.medias.VideoBuilder;
import fr.aelion.helpers.exceptions.NoMediaTypeException;
import fr.aelion.helpers.exceptions.NotEnoughArgsException;
import fr.aelion.models.course.Media;
import fr.aelion.models.course.Video;

public class VideoMediaStrategy implements IMediaStrategy<VideoBuilder> {
    @Override
    public VideoBuilder build() throws NoMediaTypeException, NotEnoughArgsException {
        return new VideoBuilder();
    }
}
