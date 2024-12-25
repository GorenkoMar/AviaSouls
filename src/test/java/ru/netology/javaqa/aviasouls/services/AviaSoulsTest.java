package ru.netology.javaqa.aviasouls.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {
    AviaSouls aviaSouls = new AviaSouls();
    TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

    Ticket ticket1 = new Ticket("DME", "LED", 6_800, 15, 16);
    Ticket ticket2 = new Ticket("DME", "LED", 7_800, 17, 19);
    Ticket ticket3 = new Ticket("LED", "DME", 6_300, 18, 19);
    Ticket ticket4 = new Ticket("LED", "DME", 43_300, 15, 18);
    Ticket ticket5 = new Ticket("LED", "DME", 6_300, 23, 24);
    Ticket ticket6 = new Ticket("IST", "ALC", 50_300, 23, 26);


    @Test
    public void testTicketComparePriceMin() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTicketComparePriceMax() {
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        int expected = 1;
        int actual = ticket4.compareTo(ticket3);
    }

    @Test
    public void testTicketComparePriceEquals() {
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket3);
        int expected = 0;
        int actual = ticket5.compareTo(ticket3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTicketSearchAndSort() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        Ticket[] expected = {ticket3, ticket5, ticket4};
        Ticket[] actual = aviaSouls.search("LED", "DME");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testTicketSearchOne() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        Ticket[] expected = {ticket6};
        Ticket[] actual = aviaSouls.search("IST", "ALC");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testTicketSearchNone() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("DME", "IST");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testTicketCompareFlightTimeMin() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        int expected = -1;
        int actual = ticketTimeComparator.compare(ticket1, ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTicketCompareFlightTimeMax() {

        aviaSouls.add(ticket3);
        aviaSouls.add(ticket6);
        int expected = 1;
        int actual = ticketTimeComparator.compare(ticket6, ticket3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortFlightTime() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        Ticket[] expected = {ticket3, ticket5, ticket4};
        Ticket[] actual = aviaSouls.searchAndSortBy("LED", "DME", ticketTimeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortFlightTimeOne() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        Ticket[] expected = {ticket6};
        Ticket[] actual = aviaSouls.searchAndSortBy("IST", "ALC", ticketTimeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }


}
