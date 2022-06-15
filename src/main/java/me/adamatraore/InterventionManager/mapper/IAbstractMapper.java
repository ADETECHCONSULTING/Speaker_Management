package me.adamatraore.InterventionManager.mapper;

import java.util.List;
import java.util.Set;

/**
 * IAbstractDataMapper
 * 
 * @param <T> Target
 * @param <S> Source
 */
public abstract interface IAbstractMapper<T, S> {
    T mapFrom(S source);
    S mapTo(T target);
    List<T> mapListFrom(List<S> listSource);
    Set<T> mapSetFrom(Set<S> setSource);
    List<S> mapListTo(List<T> listTarget);
    Set<S> mapSetTo(Set<T> setTarget);
}
