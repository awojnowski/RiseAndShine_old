package comp3350.assignment.riseandshine.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import comp3350.assignment.riseandshine.R;

import comp3350.assignment.riseandshine.abstract_data_types.AlarmList;
import comp3350.assignment.riseandshine.controllers.AlarmController;
import comp3350.assignment.riseandshine.models.Alarm;

public class AlarmsFragment extends Fragment {

    public static CharSequence TAB_TITLE = "ALARMS";

    public AlarmsFragment() {

        ;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.alarms_home, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.alarm_list);

        //get array of alarms from alarm list
        AlarmList alarmList = AlarmController.sharedController().getAlarmList();
        Alarm[] alarms = alarmList.getAlarms();

        ArrayList<HashMap<String, String>> alarmDictList = new ArrayList<HashMap<String, String>>();
        for(int i = 0 ; i < alarms.length; i++) {
            HashMap<String, String> alarmDictionary = new HashMap<String, String>();
            Alarm alarm = alarms[i];
            alarmDictionary.put("time", alarm.timeString());
            alarmDictionary.put("sound", alarm.soundName());
            alarmDictionary.put("puzzle", alarm.puzzleName());
            alarmDictList.add(alarmDictionary);
        }

        ListAdapter alarmAdapter = new SimpleAdapter(getActivity(), alarmDictList, R.layout.alarm_list_item, new String[]{"time", "sound", "puzzle"}, new int[] {R.id.time, R.id.sound, R.id.puzzle});
        listView.setAdapter(alarmAdapter);

        return rootView;
    }

}