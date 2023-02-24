package fr.aelion.helpers.factory;

import fr.aelion.helpers.strategies.media.IMediaStrategy;
import fr.aelion.helpers.strategies.media.VideoMediaStrategy;
import fr.aelion.models.course.Document;
import fr.aelion.models.course.Media;
import fr.aelion.models.course.Slide;
import fr.aelion.models.course.Video;

import javax.swing.event.MenuDragMouseEvent;
import java.util.HashMap;

public class MediaFactory {
    private final static String classRoot = "fr.aelion.models.course";
    private String fullClassName = MediaFactory.classRoot;
    public Media getMedia(String mediaType) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String className = mediaType.toLowerCase();
        fullClassName += String.valueOf(mediaType.charAt(0)).toUpperCase() + className.substring(1);
        return getInstance();
    }

    public String getFullClassName() {
        return this.fullClassName;
    }
    private Media getInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        return (Media) Class.forName(fullClassName).newInstance();
    }
}
