package com.api.v1.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@NotNull
@Size(min = 10, max = 10)
public @interface PhoneNumber {
    String message() default "Invalid SSN format. Please enter a 9-digit Social Security Number.";
}