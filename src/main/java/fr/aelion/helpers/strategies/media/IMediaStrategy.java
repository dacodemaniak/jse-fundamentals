package fr.aelion.helpers.strategies.media;

import fr.aelion.helpers.exceptions.NoMediaTypeException;
import fr.aelion.helpers.exceptions.NotEnoughArgsException;
import fr.aelion.models.course.Media;

public interface IMediaStrategy<T> {
    T build() throws NoMediaTypeException, NotEnoughArgsException;
}
