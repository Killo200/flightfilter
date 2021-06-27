package com.gridnine.testing;

import java.util.List;

interface Rule {
    List<Flight> useRule(List<Flight> listFlights);
}
