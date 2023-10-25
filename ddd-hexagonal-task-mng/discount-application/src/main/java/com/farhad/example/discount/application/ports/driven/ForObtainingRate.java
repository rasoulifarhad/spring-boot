package com.farhad.example.discount.application.ports.driven;

import java.util.ListIterator;

import com.farhad.example.discount.application.BreakPointWithRate;

public interface ForObtainingRate {
	ListIterator<BreakPointWithRate> getDescendingBreakPointIterator();
}
