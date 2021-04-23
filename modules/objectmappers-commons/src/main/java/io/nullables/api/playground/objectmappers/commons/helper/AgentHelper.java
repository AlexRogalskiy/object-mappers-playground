package io.nullables.api.playground.objectmappers.commons.helper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AgentHelper {

    public static void pump(final InputStream stream, final PrintStream out) {
        new Thread(() -> new BufferedReader(new InputStreamReader(stream)).lines()
            .forEach(out::println)).start();
    }
}
