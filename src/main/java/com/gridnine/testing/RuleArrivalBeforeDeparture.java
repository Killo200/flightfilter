package com.gridnine.testing;

import java.util.List;

public class RuleArrivalBeforeDeparture extends RuleAbstract  {


    @Override
    List<Flight> rule(List<Flight> listFlights) {
        for(Flight f : listFlights){
            List<Segment> segments = f.getSegments();

            for(Segment s : segments) {
                if (s.getArrivalDate().isBefore(s.getDepartureDate())) {
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
