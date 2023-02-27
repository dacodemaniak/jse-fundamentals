package fr.aelion.helpers.dto;

import fr.aelion.helpers.dto.annotations.ClassInitial;

public class MediaDetailDto {

    public String title;
    public Float duration;
    /**
     * Initial of the specific Media (V for Video, S for Slide or D for Document)
     */
    @ClassInitial
    public String mediaType;
    public String summary;
}
