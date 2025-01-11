package com.apress.springrecipes.sequence.dao;

import com.apress.springrecipes.sequence.Entity.Sequence;

public interface SequenceDao {
    Sequence getSequence(String sequenceId);
    int getNextValue(String sequenceId);
}
