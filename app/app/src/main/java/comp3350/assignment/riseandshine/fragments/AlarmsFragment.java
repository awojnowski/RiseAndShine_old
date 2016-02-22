package comp3350.assignment.riseandshine.fragments;

<<<<<<< HEAD
import android.content.Intent;
import android.content.ComponentName;
=======
import android.content.Context;
>>>>>>> refs/remotes/Nick-Comp3350/master
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
<<<<<<< HEAD
import android.widget.LinearLayout;
=======
import android.widget.CompoundButton;
>>>>>>> refs/remotes/Nick-Comp3350/master
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import comp3350.assignment.riseandshine.R;
import comp3350.assignment.riseandshine.abstract_data_types.AlarmList;
import comp3350.assignment.riseandshine.activities.CreateAlarmActivity;
import comp3350.assignment.riseandshine.activities.EditAlarmActivity;
import comp3350.assignment.riseandshine.controllers.AlarmController;
import comp3350.assignment.riseandshine.models.Alarm;

public class AlarmsFragment extends Fragment {

    public static CharSequence TAB_TITLE = "ALARMS";
    private ListView listView;
    private AlarmList sharedAlarmList;

    public AlarmsFragment() {

        ;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.alarms_home, container, false);
        listView = (ListView) rootView.findViewById(R.id.alarm_list);

        //get array of alarms from alarm list
        sharedAlarmList = AlarmController.sharedController().getAlarmList();

        AlarmListAdapter alarmAdapter = new AlarmListAdapter(getActivity(), R.layout.alarm_list_item, sharedAlarmList.getAlarms());
        listView.setAdapter(alarmAdapter);

        AdapterView.OnItemClickListener listClick = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent("android.intent.action.EditAlarm");
                //intent.setComponent(new ComponentName("comp3350.assignment.riseandshine.activities", ".activities.EditAlarmActivity"));
                Bundle b = new Bundle();
                b.putInt("key", position);
                intent.putExtras(b);
                startActivity(intent);
                System.out.println("test text: " + position);
            }
        };

        listView.setOnItemClickListener(listClick);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AlarmListAdapter)listView.getAdapter()).updateAlarms(sharedAlarmList.getAlarms());
    }

}

class AlarmListAdapter extends ArrayAdapter<Alarm> {

    public AlarmListAdapter(Context context, int resource, Alarm[] alarms) {
        super(context, resource, new ArrayList<Alarm>(Arrays.asList(alarms)));
    }

    public void updateAlarms(Alarm[] alarms) {
        clear();
        addAll(alarms);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.alarm_list_item, null);
        }

        final Alarm alarm = getItem(position);

        if (alarm != null) {
            TextView timeTextView = (TextView) v.findViewById(R.id.alarm_list_item_time);
            TextView soundTextView = (TextView) v.findViewById(R.id.alarm_list_item_sound);
            TextView puzzleTextView = (TextView) v.findViewById(R.id.alarm_list_item_puzzle);
            Switch alarmSwitch = (Switch) v.findViewById(R.id.alarm_list_item_switch);

            if (timeTextView != null) {
                timeTextView.setText(alarm.timeString());
            }

            if (soundTextView != null) {
                soundTextView.setText(alarm.soundName());
            }

            if (puzzleTextView != null) {
                puzzleTextView.setText(alarm.puzzleName());
            }

            if (alarmSwitch != null) {
                alarmSwitch.setChecked(alarm.isActive());
                alarmSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        alarm.setIsActive(!alarm.isActive());
                    }
                });
            }
        }

        return v;
    }

}