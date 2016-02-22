package comp3350.assignment.riseandshine.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
//        TextView textView = (TextView) rootView.findViewById(R.id.textView);
        ListView listView = (ListView) rootView.findViewById(R.id.alarm_list);

        //output alarms (into textView for now)
//        String s;

        //get array of alarms from alarm list
        AlarmList alarmList = AlarmController.sharedController().getAlarmList();
        Alarm[] alarms = alarmList.getAlarms();

//        if(alarms.length >2)
//            s = "alarms: "+alarms.length+" alarmID: "+alarms[0].getAlarmID()+", Time: " + alarms[0].getHours() +":" + alarms[0].getMinutes()+".";
//        else
//            s = "error";
//        textView.setText(s);
        Alarm[] alarms1 = new Alarm[] {new Alarm(3, 1, 56, 1, 1), new Alarm(3, 7, 56, 1, 1), new Alarm(3, 7, 56, 1, 1), new Alarm(3, 7, 56, 1, 1), new Alarm(3, 7, 56, 1, 1), new Alarm(3, 7, 56, 1, 1), new Alarm(3, 7, 56, 1, 1), new Alarm(3, 7, 56, 1, 1), new Alarm(3, 7, 56, 1, 1), new Alarm(3, 7, 56, 1, 1), new Alarm(3, 7, 56, 1, 1), new Alarm(3, 7, 56, 1, 1), new Alarm(3, 7, 56, 1, 1), new Alarm(3, 7, 56, 1, 1), new Alarm(3, 7, 56, 1, 1), new Alarm(3, 7, 56, 1, 1), new Alarm(3, 7, 56, 1, 1), new Alarm(3, 7, 56, 1, 1), new Alarm(3, 7, 56, 1, 1), new Alarm(3, 7, 56, 1, 1), new Alarm(3, 5, 56, 1, 1), new Alarm(3, 4, 56, 1, 1), new Alarm(3, 3, 56, 1, 1), new Alarm(3, 2, 56, 1, 1), new Alarm(3, 1, 00, 1, 1)};
        ArrayAdapter<Alarm> alarmAdapter = new ArrayAdapter<Alarm>(getActivity(), android.R.layout.simple_list_item_1, alarms1);
        listView.setAdapter(alarmAdapter);

        return rootView;
    }

}