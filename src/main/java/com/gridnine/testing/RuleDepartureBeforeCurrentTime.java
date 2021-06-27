package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public class RuleDepartureBeforeCurrentTime extends RuleAbstract implements Rule {

    List<Flight> rule(List<Flight> listFlights) {
        for (Flight f : listFlights) {
            List<Segment> segments = f.getSegments();

            for (Segment s : segments) {
                if (s.getDepartureDate().isBefore(LocalDateTime.now())) {
                    listFilterByRule.add(f);
                }
            }
        }
        return listFilterByRule;
    }

    @Override
    public List<Flight> useRule(List<Flight> listFlights) {

        return rule(listFlights);
    }
}
