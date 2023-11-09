package com.example.restfulwebservices.exception;

import jdk.jfr.StackTrace;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@StackTrace
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    private LocalDate timeStamp;
    private String message;
    private String details;
}
