package ticket_booking.entities;

import java.sql.Time;
import java.util.List;
import java.util.Map;

public class Train {
    private  String traindId;
    private String trainNo;
    private List<List<Integer>> seats;
    private Map<String, Time> stationTimes;
    private List<String> stations;
}
