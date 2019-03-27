package com.wgdetective.projectstartdemo.converter;

/**
 * @author Wladimir Litvinov
 */
public interface DtoDboConverter<T, B> {
    T convertToDto(final B dbo);
    B convertToDbo(final T dto);
}
