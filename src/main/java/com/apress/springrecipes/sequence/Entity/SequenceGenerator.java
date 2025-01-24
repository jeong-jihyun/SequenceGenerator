package com.apress.springrecipes.sequence.Entity;

import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceGenerator {
    @Setter
    private PrefixGenerator prefixGenerator;
    @Setter
    private String prefix;
    @Setter
    private String suffix;
    @Setter
    private int initial;
    private final AtomicInteger counter = new AtomicInteger();

    public SequenceGenerator() {

    }

    public synchronized String getSequence() {
        return prefix + initial + counter.getAndIncrement() + suffix;
    }

}
