package comp3350.assignment.riseandshine.activities;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import comp3350.assignment.riseandshine.R;
import comp3350.assignment.riseandshine.abstract_data_types.AlarmList;
import comp3350.assignment.riseandshine.controllers.AlarmController;
import comp3350.assignment.riseandshine.models.Alarm;

public class CreateAlarmActivity extends AppCompatActivity {

    // UI references.
    private TimePicker mTimePicker;
    private Spinner mSoundSpinner;
    private Spinner mPuzzleSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_alarm);

        // Set up the form.
        mTimePicker = (TimePicker) findViewById(R.id.time_picker);
        mSoundSpinner = (Spinner) findViewById(R.id.sound_spinner);
        mPuzzleSpinner = (Spinner) findViewById(R.id.puzzle_spinner);

        ArrayAdapter<String> soundsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Alarm.sounds);
        soundsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSoundSpinner.setAdapter(soundsAdapter);

        ArrayAdapter<String> puzzlesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Alarm.puzzles);
        puzzlesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mPuzzleSpinner.setAdapter(puzzlesAdapter);

        Button mCreateAlarmButton = (Button) findViewById(R.id.create_alarm_button);
        mCreateAlarmButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // getCurrentHour and min are now just getHour and getMin but then we can't support older versions of Android
                AlarmController.sharedController().addAlarm(mTimePicker.getCurrentHour(), mTimePicker.getCurrentMinute(), mSoundSpinner.getSelectedItemPosition(), mPuzzleSpinner.getSelectedItemPosition());
                CreateAlarmActivity.this.finish();
                // notify main alarm list view? (could also just listen to addAlarm)
            }
        });
    }
}

