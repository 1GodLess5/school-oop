package cz.godless.service;

import cz.godless.domain.Clazz;

import java.util.List;

public class ClazzManager {
    private final List<Clazz> clazzes;

    public ClazzManager(List<Clazz> clazzes) {
        this.clazzes = clazzes;
    }

    // TODO add control of students
    // Student can be only in one clazz!
}
