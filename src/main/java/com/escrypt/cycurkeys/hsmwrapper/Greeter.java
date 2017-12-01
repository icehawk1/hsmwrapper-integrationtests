package com.escrypt.cycurkeys.hsmwrapper;

import javax.inject.Inject;
import java.io.PrintStream;

/**
 * A component for creating personal greetings.
 */
public class Greeter {

    private final PhraseBuilder phraseBuilder;

    @Inject
    public Greeter(PhraseBuilder phraseBuilder) {
        this.phraseBuilder = phraseBuilder;
    }

    public void greet(PrintStream to, String name) {
        to.println(createGreeting(name));
    }

    public String createGreeting(String name) {
        return "Hello, " + name + "!";
    }
}