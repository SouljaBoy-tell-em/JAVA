package org.example;


import org.example.tickets.MainTicketInfo;
import org.example.tickets.TicketServiceManager;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException, ParseException, java.text.ParseException {
        if(!CHECK(args[0]))
            return;

        TicketServiceManager manager = new TicketServiceManager(args[0], "Владивосток", "Тель-Авив");

        System.out.println("DIFF: " + manager.fluctuate());

        System.out.println("FAST TICKETS FROM DIFFERENT COMPANIES: ");
        List<MainTicketInfo> fastTickets = manager.getFastWays();
        for(int iTicket = 0; iTicket < fastTickets.size(); iTicket++)
            System.out.println(fastTickets.get(iTicket));

        System.out.println("TIME: ");
        for(int iTicket = 0; iTicket < fastTickets.size(); iTicket++) {
            MainTicketInfo ticketInfo = fastTickets.get(iTicket);
            System.out.print("CARRIER: " + ticketInfo.getCarrier() + " ");
            System.out.println(ChronoUnit.SECONDS.between(ticketInfo.getDeparture_time(),
                                                            ticketInfo.getArrival_time())
                                                                                + 25200);
        }
    }

    private static boolean CHECK(String arg) {
        if(arg == null) {
            System.out.println("File not found");
            return false;
        }
        return true;
    }
}
