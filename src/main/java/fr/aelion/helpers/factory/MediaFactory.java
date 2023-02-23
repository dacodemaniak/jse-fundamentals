package fr.aelion.helpers.factory;

import fr.aelion.models.course.Document;
import fr.aelion.models.course.Media;
import fr.aelion.models.course.Slide;
import fr.aelion.models.course.Video;

import javax.swing.event.MenuDragMouseEvent;
import java.util.HashMap;

public class MediaFactory {
    private final static String classRoot = "fr.aelion.models.course";

    public Media getMedia(String mediaType) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String className = mediaType.toLowerCase();
        className = String.valueOf(mediaType.charAt(0)).toUpperCase() + className.substring(1);
        return getInstance(className);
    }

    private Media getInstance(String mediaType) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String className = MediaFactory.classRoot + "." + mediaType;
        return (Media) Class.forName(className).newInstance();
    }
}
