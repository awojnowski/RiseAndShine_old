package comp3350.assignment.riseandshine.models;

import comp3350.assignment.riseandshine.models.tasks.*;

public class Alarm {

    public static String[] sounds = new String[]{"Sound 1", "Sound 2", "Sound 3", "Sound 4"};
    public static String[] puzzles = new String[]{"Puzzle 1", "Puzzle 2", "Puzzle 3", "Puzzle 4"};

    private Task task = null;

    private int hours;
    private int minutes;

    private int alarmID;
    //not sure how we will store sound and puzzle options per alarm so I just set to int's for now
    // these ID's can be used to reference a resource file so heavy information does not need to be stored by the sql
    private int soundID;
    private int puzzleID;
    private boolean isActive;

    // only the AlarmList class should be making Alarm objects
    public Alarm(int alarmID, int hours, int minutes, int soundID, int puzzleID, boolean isActive)
    {
        this.alarmID = alarmID;
        this.hours = hours;
        this.minutes = minutes;
        this.soundID = soundID;
        this.puzzleID = puzzleID;
        this.isActive = isActive;
    }

    //never set data after init, only read from it. change to information is done in the sql database and then regenerated
    public int getHours(){
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getAlarmID() {
        return alarmID;
    }

    public int getPuzzleID() {
        return puzzleID;
    }

    public int getSoundID() {
        return soundID;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Task getTask() {
        return this.task;
    }

    // Info

    public String toString() {
        return hours + ":" + minutes + " Sound: " + Alarm.sounds[soundID] + " Puzzle: " + Alarm.puzzles[puzzleID];
    }

    public String timeString() {
        int hrs = hours;
        String ampm = "am";
        if (hrs > 12) {
            hrs = hrs % 12;
            ampm = "pm";
        }
        return hrs + ":" + minutes + ampm;
    }

    public String soundName() {
        return Alarm.sounds[soundID];
    }

    public String puzzleName() {
        return Alarm.puzzles[puzzleID];
    }
}
