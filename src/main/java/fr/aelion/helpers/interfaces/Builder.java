package fr.aelion.helpers.interfaces;

import java.util.Optional;

public interface Builder<T> {
    T build() throws Exception;
}
