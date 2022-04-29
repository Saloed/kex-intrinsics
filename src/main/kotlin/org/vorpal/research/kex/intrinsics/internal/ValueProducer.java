package org.vorpal.research.kex.intrinsics.internal;

@FunctionalInterface
public interface ValueProducer<T> {
    T apply(int index);
}
