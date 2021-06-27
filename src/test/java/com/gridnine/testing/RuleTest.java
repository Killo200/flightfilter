package com.gridnine.testing;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

public class RuleTest extends TestCase {

    Rule ruleArrivalBeforeDeparture = new RuleArrivalBeforeDeparture();
    Rule ruleDepartureBeforeCurrentTime = new RuleDepartureBeforeCurrentTime();
    Rule ruleSumTimeOnEarthMoreTwoHours = new RuleSumTimeOnEarthMoreTwoHours();
    List<Flight> flightList = FlightBuilder.createFlights();


    @Test
    public void testRuleArrivalBeforeDeparture_ShouldReturnCorrectFlight() {

        List<Flight> expected = new ArrayList<>();
        expected.add(flightList.get(3));

        Assert.assertEquals(expected, ruleArrivalBeforeDeparture.useRule(flightList));
    }

    @Test
    public void testRuleDepartureBeforeCurrentTime_ShouldReturnCorrectFlight() {

        List<Flight> expected = new ArrayList<>();
        expected.add(flightList.get(2));

        Assert.assertEquals(expected, ruleDepartureBeforeCurrentTime.useRule(flightList));
    }

    @Test
    public void testRuleSumTimeOnEarthMoreTwoHours_ShouldReturnCorrectFlight() {

        List<Flight> expected = new ArrayList<>();
        expected.add(flightList.get(4));
        expected.add(flightList.get(5));

        Assert.assertEquals(expected, ruleSumTimeOnEarthMoreTwoHours.useRule(flightList));
    }
}