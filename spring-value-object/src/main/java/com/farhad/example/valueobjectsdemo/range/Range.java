package com.farhad.example.valueobjectsdemo.range;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class Range<T> {
    private final T start;
    private final T end;

    public boolean includes(T t) {
        return true;
    }
}
