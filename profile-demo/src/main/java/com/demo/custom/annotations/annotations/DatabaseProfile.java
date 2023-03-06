package com.demo.custom.annotations.annotations;


import org.springframework.context.annotation.Profile;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
@Profile("database")
public @interface DatabaseProfile {
}
