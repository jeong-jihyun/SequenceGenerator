package com.apress.springrecipes.sequence.impl;

import com.apress.springrecipes.sequence.Entity.Sequence;
import com.apress.springrecipes.sequence.dao.SequenceDao;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component("sequenceDao")
public class SequenceDaoImpl implements SequenceDao {
    private final Map<String,Sequence> sequence = new HashMap<>();
    private final Map<String, AtomicInteger> values = new HashMap<>();

    public SequenceDaoImpl() {
        sequence.put("IT", new Sequence("IT", "30", "A"));
        values.put("IT", new AtomicInteger(100000));
    }

    @Override
    public Sequence getSequence(String sequenceId) {
        return sequence.get(sequenceId);
    }

    @Override
    public int getNextValue(String sequenceId) {
        AtomicInteger value = values.get(sequenceId);
        return value.getAndIncrement();
    }
}
