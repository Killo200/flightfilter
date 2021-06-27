package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

abstract class RuleAbstract implements Rule {
    public final List<Flight> listFilterByRule = new ArrayList<>();

    abstract List<Flight> rule(List<Flight> listAllFlights);
}
