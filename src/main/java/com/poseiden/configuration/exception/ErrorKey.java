package com.poseiden.configuration.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorKey {
    INVALID_FILE("invalid_file_type");
    private String value;

}
