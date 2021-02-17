package com.EECS.GraphQLDemo.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreedNotFoundException extends RuntimeException implements GraphQLError
{
    Map<String, Object> extension = new HashMap<>();

    public BreedNotFoundException(String msg, String breed)
    {
        super(msg);
        extension.put("invalidBreedName", breed);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extension;
    }
}
