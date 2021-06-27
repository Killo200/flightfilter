package com.gridnine.testing;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> listAllFlights = FlightBuilder.createFlights();
        Rule ruleCurrentTime = new RuleDepartureBeforeCurrentTime();
        Rule ruleArrivalBeforeDeparture = new RuleArrivalBeforeDeparture();
        Rule ruleSumTime = new RuleSumTimeOnEarthMoreTwoHours();

        System.out.println("Список перелетов, не обработанных правилами");
        listAllFlights.stream().forEach(System.out::println);

        System.out.println();
        System.out.println("Список фильтра по правилу: время вылета до текущего момента времени");

        ruleCurrentTime.useRule(listAllFlights).stream().forEach(System.out::println);

        System.out.println();
        System.out.println("Список фильтра по правилу: время прилета раньше даты вылета");

        ruleArrivalBeforeDeparture.useRule(listAllFlights).stream().forEach(System.out::println);

        System.out.println();
        System.out.println("Список фильтра по правилу: время на земле больше двух часов");

        ruleSumTime.useRule(listAllFlights).stream().forEach(System.out::println);
    }
}
