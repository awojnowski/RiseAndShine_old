package comp3350.assignment.riseandshine.controllers;

import comp3350.assignment.riseandshine.abstract_data_types.*;
import comp3350.assignment.riseandshine.models.*;

public class AlarmController {

    private static final AlarmList alarmList = new AlarmList();
    private static int currAlarmID = 1;

    private AlarmController() {

    }

    // Getters & Setters

    public AlarmList getAlarmList() {

        return this.alarmList;

    }

    // MARK: Singleton

    private static AlarmController _sharedInstance = null;
    public static AlarmController sharedController() {

        if (_sharedInstance == null) {

            _sharedInstance = new AlarmController();

        }
        return _sharedInstance;

    }

    //fill the alarmList with data
    public static void populateAlarms ()
    {
        //replace contents of this for loop with calls to get data from SQLite
        for (int i = 0; i< 3; i++)
        {
            Alarm a = getAlarm(i);
            alarmList.addAlarm(a);
        }

    }
    // this method is used to retrieve test data to populate the alarms list
    // (this can later be used to do testing for edge cases
    private static Alarm getAlarm(int i)
    {
        if (i == 0)
            return new Alarm(1, 5, 23, 2, 5);
        else if(i == 1)
            return new Alarm(2, 6, 45, 3, 3);
        else
            return new Alarm(3, 7, 56, 1, 1);
    }

    //TODO: takes the data, adds it to the SQL database, calls populateAlarms to update.
    //for now (no sql) just add it to the alarmList
    public static void addAlarm(int hours, int minutes, int soundID, int puzzleID)
    {
        Alarm a = new Alarm(currAlarmID, hours, minutes, soundID, puzzleID);
        //increment alarmID
        //TODO: get lowest non used AlarmID from SQLite instead of just incrementing, handle incrementing when appropriate
        currAlarmID++;

        alarmList.addAlarm(a);
    }
}
