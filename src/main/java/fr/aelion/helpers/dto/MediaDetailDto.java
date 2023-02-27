package fr.aelion.helpers.dto;

import fr.aelion.models.course.Media;

public class MediaDetailDto {
    public String title;
    public Float duration;
    public String mediaType;
    public String summary;

    public void deserialize(Media media) {
        this.title = media.getTitle();
        this.summary = media.getSummary();
        this.duration = media.getDuration();

        // Explicit transform mediaType
        this.mediaType = media.getClass().getSimpleName().substring(0, 1);
    }
}
