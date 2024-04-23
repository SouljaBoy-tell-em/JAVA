package org.example.tickets;


import lombok.Getter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class TicketServiceManager {
    // MAIN FIELDS:
    private static final String FIELD_TICKETS = "tickets";
    private final String SRC;
    private final String DST;
    @Getter
    private List<MainTicketInfo> tickets = new ArrayList<>();

    // PATTERNS:
    private static final String CENTURY = "20";
    private static final String SHORT_PATTERN_TIME = "H:mm";
    private static final String STANDART_PATTERN_TIME = "HH:mm";
    private static final int    TIME_PATTERN_LENGTH = 5;

    // TICKET FIELDS:
    private static final String ARRIVAL_DATE = "arrival_date";
    private static final String ARRIVAL_TIME = "arrival_time";
    private static final String CARRIER = "carrier";
    private static final String DEPARTURE_DATE = "departure_date";
    private static final String DEPARTURE_TIME = "departure_time";
    private static final String DESTINATION = "destination";
    private static final String DESTINATION_NAME = "destination_name";
    private static final String ORIGIN_NAME = "origin_name";
    private static final String PRICE = "price";
    private static final String STOPS = "stops";

    public TicketServiceManager(String fileName, String SRC, String DST) throws IOException,
                                                                                ParseException,
                                                                                java.text.ParseException {
        this.SRC = SRC;
        this.DST = DST;
        this.tickets = generateTickets(fileName);
        sort(tickets);
    }

    /**
     * The convertDate(String) converts string, that contains date in "dd.mm.yyyy" format
     * to LocalDate format (yyyy-mm-dd).
     * @param dateString string, that contains a date
     * @return date in LocalDate format.
     */
    private LocalDate convertDate(String dateString) throws java.text.ParseException {
        int day = Integer.parseInt(dateString.substring(0, 2));
        int month = Integer.parseInt(dateString.substring(3, 5));
        int year = Integer.parseInt(CENTURY + dateString.substring(6, 8));
        return LocalDate.of(year, month, day);
    }

    /**
     * The convertTime(String) converts string, that contains time in one of the formats:
     * 1) hh:mm;
     * 2) h:mm.
     * to LocalTime format (hh-mm).
     * @param timeString string, that contains a time.
     * @return time in LocalTime format.
     */
    private LocalTime convertTime(String timeString) throws java.text.ParseException {
        return LocalTime.parse(timeString,
                              (timeString.length() == TIME_PATTERN_LENGTH) ?
                               DateTimeFormatter.ofPattern(STANDART_PATTERN_TIME) :
                               DateTimeFormatter.ofPattern(SHORT_PATTERN_TIME));
    }

    /**
     * The diffTimesAnalyzer(MainTicketInfo) calculates the difference in milliseconds
     * between two periods of time including the date.
     * @param ticket ticket.
     * @return difference in millis.
     */
    private long diffTimesAnalyzer(MainTicketInfo ticket) {
        LocalDateTime arrivalLocalDate =
                LocalDateTime.of(
                        ticket.getArrival_date().getYear(),
                        ticket.getArrival_date().getMonth(),
                        ticket.getArrival_date().getDayOfMonth(),
                        ticket.getArrival_time().getHour(),
                        ticket.getArrival_time().getMinute());
        LocalDateTime departureLocalDate =
                LocalDateTime.of(
                        ticket.getDeparture_date().getYear(),
                        ticket.getDeparture_date().getMonth(),
                        ticket.getDeparture_date().getDayOfMonth(),
                        ticket.getDeparture_time().getHour(),
                        ticket.getDeparture_time().getMinute());

        return ChronoUnit.MILLIS.between(departureLocalDate, arrivalLocalDate);
    }

    /**
     * The fluctuate() calculates the difference between median and average price.
     * @return difference in points (dollars, rubles etc.).
     */
    public int fluctuate() {
        return Math.abs(getMedianPrice() - getAvgPrice());
    }

    /**
     * The generateTickets(String) generates tickets parsing from JSON-file.
     * @param filename name of file where contains info about tickets.
     * @return list of tickets.
     */
    public List<MainTicketInfo> generateTickets(String filename) throws IOException,
                                                                       ParseException,
                                                                       java.text.ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(filename));
        JSONArray jsonArray = (JSONArray) jsonObject.get(FIELD_TICKETS);

        for(int iTicket = 0; iTicket < jsonArray.size(); iTicket++) {
            JSONObject ticket = (JSONObject) jsonArray.get(iTicket);
            if (status(ticket))
                tickets.add(MainTicketInfo
                        .builder()
                        .arrival_time(convertTime(ticket.get(ARRIVAL_TIME).toString()))
                        .arrival_date(convertDate(ticket.get(ARRIVAL_DATE).toString()))
                        .departure_date(convertDate(ticket.get(DEPARTURE_DATE).toString()))
                        .departure_time(convertTime(ticket.get(DEPARTURE_TIME).toString()))
                        .price(Integer.parseInt(ticket.get(PRICE).toString()))
                        .carrier(ticket.get(CARRIER).toString())
                        .build());
        }
        return tickets;
    }

    /**
     * The getAvgPrice() calculates the average price of all tickets.
     * @return average price.
     */
    private int getAvgPrice() {
        AtomicInteger sum = new AtomicInteger();
        tickets.forEach(iTicket -> sum.addAndGet(iTicket.getPrice()));
        if(tickets.size() == 0)
            return 0;
        return sum.get() / tickets.size();
    }

    /**
     * The getFastWays() searches the fastest tickets from different companies.
     * @return list of the fastest tickets.
     */
    public List<MainTicketInfo> getFastWays() {
        Map<String, MainTicketInfo> mapTicketsTimes = new HashMap<>();
        for(int iTicket = 0; iTicket < tickets.size(); iTicket++) {
            MainTicketInfo ticket = tickets.get(iTicket);
            if(mapTicketsTimes.get(ticket.getCarrier()) == null)
                mapTicketsTimes.put(ticket.getCarrier(), ticket);
            else
                if(diffTimesAnalyzer(ticket) < diffTimesAnalyzer(mapTicketsTimes
                                                     .get(ticket.getCarrier())))
                    mapTicketsTimes.put(ticket.getCarrier(), ticket);

        }
        return getTicketsValues(mapTicketsTimes);
    }

    /**
     * The getMedianPrice() determines median among all tickets.
     * @return median in points(dollars, rubles etc.).
     */
    private int getMedianPrice() {
        int capacity = tickets.size();
        if(capacity == 0)
            return 0;
        return (capacity % 2 == 0) ? ((tickets.get(capacity / 2 - 1).getPrice() +
                                       tickets.get((capacity / 2)).getPrice()) / 2) :
                                      (tickets.get((capacity / 2)).getPrice());
    }

    /**
     * The getTicketsValues(Map<String, MainTicketInfo>) transforms ticket map to list.
     * @param mapTicketsTimes already the fastest tickets, that saves in the map.
     * @return list of the fastest tickets from different companies.
     */
    private List<MainTicketInfo> getTicketsValues(Map<String, MainTicketInfo> mapTicketsTimes) {
        List<Map.Entry<String, MainTicketInfo>> fastTicketsEntry =
                new ArrayList<>(mapTicketsTimes.entrySet());
        List<MainTicketInfo> fastTickets = new ArrayList<>();
        for(int iTicket = 0; iTicket < fastTicketsEntry.size(); iTicket++)
            fastTickets.add(fastTicketsEntry.get(iTicket).getValue());
        return fastTickets;
    }

    /**
     * The sort(List) sorts tickets by prices.
     */
    private void sort(List<MainTicketInfo> tickets) {
        Collections.sort(tickets, new Comparator<MainTicketInfo>() {
            @Override
            public int compare(MainTicketInfo ticket1, MainTicketInfo ticket2) {
                return ticket1.getPrice() - ticket2.getPrice();
            }
        });
    }

    /**
     * The status(JSONObject) weeds out tickets from unnecessary points.
     * @return true, if JSONObject satisfies the conditions.
     */
    private boolean status(JSONObject ticket) {
        return ticket.get(ORIGIN_NAME).toString().equals(SRC) &&
               ticket.get(DESTINATION_NAME).toString().equals(DST);
    }
}