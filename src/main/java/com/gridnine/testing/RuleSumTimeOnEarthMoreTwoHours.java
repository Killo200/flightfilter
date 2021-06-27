package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class RuleSumTimeOnEarthMoreTwoHours extends RuleAbstract implements Rule {

    @Override
    List<Flight> rule(List<Flight> listFlights) {
        long sum = 0;
        for (Flight f : listFlights) {
            List<Segment> segments = f.getSegments();

            if (!(segments.size() <= 1)) {

                LocalDateTime start = segments.get(0).getArrivalDate();

                for (int i = 1; i < segments.size(); i++) {
                    sum += ChronoUnit.HOURS.between(start, segments.get(i).getDepartureDate());

                    if (sum >= 2) {
                        listFilterByRule.add(f);
                        break;
                    }
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
