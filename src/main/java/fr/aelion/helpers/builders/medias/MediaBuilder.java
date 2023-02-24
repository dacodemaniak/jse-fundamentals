package fr.aelion.helpers.builders.medias;

import fr.aelion.helpers.exceptions.NoMediaTypeException;
import fr.aelion.helpers.exceptions.NotEnoughArgsException;
import fr.aelion.helpers.factory.MediaFactory;
import fr.aelion.helpers.interfaces.Builder;
import fr.aelion.models.course.*;

public abstract class MediaBuilder implements Builder<Media> {
    private String title;
    private String summary;
    private Float duration;
    private Author author;

    private String mediaType;

    private MediaFactory mediaFactory = new MediaFactory();
    public void setMediaType(String mediaType) {

        this.mediaType = mediaType;

    }

    public MediaBuilder title(String title) {
        this.title = title;
        return this;
    }

    public MediaBuilder summary(String summary) {
        this.summary = summary;
        return this;
    }

    public MediaBuilder duration(Float duration) {
        this.duration = duration;
        return this;
    }

    public MediaBuilder author(Author author) {
        this.author = author;
        return this;
    }
    public Media build() throws NotEnoughArgsException, NoMediaTypeException {

        // Hey Buddy, what if no title or duration ?
        if (this.title == null || this.duration == null) {
            throw new NotEnoughArgsException();
        }

        if (this.mediaType == null) {
            throw new NoMediaTypeException();
        }

        Media media = null;

        try {
            media = mediaFactory.getMedia(this.mediaType);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        // Next... fill attributes
        media.setTitle(this.title);
        media.setSummary(this.summary);
        media.setDuration(this.duration);
        media.setAuthor(this.author);

        return media;
    }

}
