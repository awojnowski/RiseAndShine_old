package comp3350.assignment.riseandshine.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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



        TextView textView = (TextView) rootView.findViewById(R.id.textView);

        //output alarms (into textView for now)
        String s;

        //get array of alarms from alarm list

        AlarmList a = AlarmController.sharedController().getAlarmList();
        Alarm[] al = a.getAlarms();

        if(al.length >2)
            s = "alarmID: "+al[0].getAlarmID()+", Time: " + al[0].getHours() +":" + al[0].getMinutes()+".";
        else
            s = "error";
        textView.setText(s);

        return rootView;
    }

}