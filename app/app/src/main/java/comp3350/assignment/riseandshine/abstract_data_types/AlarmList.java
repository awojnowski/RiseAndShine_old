package comp3350.assignment.riseandshine.abstract_data_types;

import comp3350.assignment.riseandshine.models.*;
import java.util.*;

public class AlarmList {

    private ArrayList<Alarm> alarms;

    public AlarmList() {

        alarms = new ArrayList<Alarm>();

    }

    // Fetching

    public Alarm[] getAlarms() {

        return this.alarms.toArray(new Alarm[alarms.size()]);

    }

    public boolean contains(Alarm alarm) {

        return this.alarms.contains(alarm);

    }

    // Mutation

    public void addAlarm(Alarm alarm) {

        /*if (this.contains(alarm)) {

            return;

        }*/
        this.alarms.add(alarm);

    }

    public void removeAlarm(Alarm alarm) {

        this.alarms.remove(alarm);

    }

}
