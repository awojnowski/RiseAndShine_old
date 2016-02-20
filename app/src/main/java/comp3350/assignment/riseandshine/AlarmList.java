package comp3350.assignment.riseandshine;

import java.util.ArrayList;

/**
 * Created by Jeff on 2/20/2016.
 */
public class AlarmList {
    // alarms is generated from an sql database. adding to alarms should only be done in the generation
    ArrayList<Alarm> alarms;

    public AlarmList()
    {
        alarms = new ArrayList<Alarm>();
    }

    //return true or false for success/failure
    //generate the alarm list. Alarm objects should only be generated through this method
    // when changes are made to alarms, sql should be updated and then this method should be re called.
    public boolean generateAlarms()
    {
        //get data from sql
        // make a loop to keep getting info
        // get info to be added
        // create an alarm

        //add it to the list

        //end loop

        return true;
    }

    private Alarm createAlarm(int alarmID, int hours, int minutes, int soundID, int puzzleID)
    {
        // add error / value tests (e.g. puzzleID exists)
        Alarm a = new Alarm(alarmID, hours, minutes, soundID, puzzleID);
        return a;
    }


    //return true or false depending on success of deletion
    public boolean deleteAlarm(int AlarmID)
    {
        //make call to sql here


        //re call generation of alarms
        generateAlarms();

        return true;
    }


    //return true or false depending on success of adding
    public boolean addAlarm(int AlarmID)
    {
        //make call to sql here


        //re call generation of alarms
        generateAlarms();

        return true;
    }

    //return true or false depending on success of edit
    public boolean editAlarm(int AlarmID)
    {
        //make call to sql here


        //re call generation of alarms
        generateAlarms();

        return true;
    }


    public ArrayList<Alarm> getAlarms() {
        return alarms;
    }
}
