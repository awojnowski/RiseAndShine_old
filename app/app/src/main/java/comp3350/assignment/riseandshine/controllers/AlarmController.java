package comp3350.assignment.riseandshine.controllers;

import comp3350.assignment.riseandshine.abstract_data_types.*;

public class AlarmController {

    private AlarmList alarmList = new AlarmList();

    private AlarmController() {

        ;

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

}
