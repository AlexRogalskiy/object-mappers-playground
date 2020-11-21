package io.nullables.api.playground.objectmappers.modelmapper.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.lang.reflect.Type;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Delegated {@link ModelMapper} implementation
 */
public final class DelegatedModelMapper {

    private final ModelMapper modelMapper;

    /**
     * Delegated model mapper constructor by input arguments
     *
     * @param modelMapper - initial input {@link ModelMapper}
     */
    public DelegatedModelMapper(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Returns {@link TypeMap} by input parameters
     *
     * @param <S> type of source object to map from
     * @param <D> type of result object
     * @param sourceClass initial input entity source {@link Class}
     * @param destinationClass initial input entity destination {@link Class}
     * @param typeName initial input type {@link String} name
     * @return new {@link TypeMap}
     */
    public <S, D> TypeMap<S, D> createTypeName(final Class<S> sourceClass, final Class<D> destinationClass,
                    final String typeName) {
        return this.modelMapper.createTypeMap(sourceClass, destinationClass, typeName);
    }

    /**
     * Returns {@code D} object by input {@code T} entity and {@link Type}
     *
     * @param <S> type of source object to map from
     * @param <D> type of result object
     * @param source entity that needs to be mapped.
     * @param destinationType type of result object.
     * @return new object of {@code D} type.
     */
    public <S, D> D map(final S source, final Type destinationType) {
        return this.modelMapper.map(source, destinationType);
    }

    /**
     * Returns {@code D} object by input {@code T} entity and {@link Type}
     *
     * @param <S> type of source object to map from
     * @param <D> type of result object
     * @param source entity that needs to be mapped.
     * @param destinationType type of result object.
     * @param typeName initial input type {@link String} name
     * @return new object of {@code D} type.
     */
    public <S, D> D map(final S source, final Type destinationType, final String typeName) {
        return this.modelMapper.map(source, destinationType, typeName);
    }

    /**
     * Returns {@code D} object by input {@code T} entity and {@link Class}
     *
     * @param <S> type of source object to map from
     * @param <D> type of result object
     * @param source entity that needs to be mapped.
     * @param destinationClass class of result object.
     * @return new object of {@code D} type.
     */
    public <S, D> D map(final S source, final Class<D> destinationClass) {
        return this.modelMapper.map(source, destinationClass);
    }

    /**
     * Returns {@code D} object by input {@code T} entity and {@link Class}
     *
     * @param <S> type of source object to map from
     * @param <D> type of result object
     * @param source entity that needs to be mapped.
     * @param destinationClass class of result object.
     * @param typeName initial input type {@link String} name
     * @return new object of {@code D} type.
     */
    public <S, D> D map(final S source, final Class<D> destinationClass, final String typeName) {
        return this.modelMapper.map(source, destinationClass, typeName);
    }

    /**
     * Returns {@link Iterable} collection of mapped {@code T} entities
     *
     * @param <S> type of objects in source list
     * @param <D> type of objects in result list
     * @param sourceList list of entities that needs to be mapped
     * @param destinationClass class of result list element
     * @return list of mapped object with {@code D} type.
     */
    public <S, D> Stream<D> mapAll(final Iterable<S> sourceList, final Class<D> destinationClass) {
        return StreamSupport.stream(sourceList.spliterator(), false).map(entity -> this.map(entity, destinationClass));
    }

    /**
     * Returns {@code D} destination type mapped from {@code S} source
     *
     * @param <S> type of source object to map from
     * @param <D> type of result object
     * @param source object to map from
     * @param destination object to map to
     * @return new object of {@code D} type.
     */
    public <S, D> D map(final S source, final D destination) {
        this.modelMapper.map(source, destination);
        return destination;
    }

    /**
     * Returns {@code D} destination type mapped from {@code S} source
     *
     * @param <S> type of source object to map from
     * @param <D> type of result object
     * @param source object to map from
     * @param destination object to map to
     * @param typeName initial input type {@link String} name
     * @return new object of {@code D} type.
     */
    public <S, D> D map(final S source, final D destination, final String typeName) {
        this.modelMapper.map(source, destination, typeName);
        return destination;
    }
}
