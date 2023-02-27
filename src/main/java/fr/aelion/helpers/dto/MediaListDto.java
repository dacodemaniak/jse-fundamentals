package fr.aelion.helpers.dto;

import fr.aelion.models.course.Media;

public class MediaListDto {
    /**
     * Title of a media
     * @property String title
     */
    public String title;

    /**
     * Duration of a media
     */
    public Float duration;

    /**
     * Transform a Media Object to a MediaListDto object
     * @param media Media to deserialize to MediaListDto
     */
    public void deserialize(Media media) {
        this.title = media.getTitle();
        this.duration = media.getDuration();
    }
}
