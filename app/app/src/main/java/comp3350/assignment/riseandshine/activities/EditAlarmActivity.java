package comp3350.assignment.riseandshine.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TimePicker;

import comp3350.assignment.riseandshine.R;
import comp3350.assignment.riseandshine.controllers.AlarmController;
import comp3350.assignment.riseandshine.models.Alarm;

/**
 * Created by Elliot on 2/22/2016.
 */
public class EditAlarmActivity extends AppCompatActivity
{
    private TimePicker mTimePicker;
    private Spinner mSoundSpinner;
    private Spinner mPuzzleSpinner;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_alarm);

        Bundle b = getIntent().getExtras();
        position = b.getInt("key");
        final Alarm alarm = AlarmController.sharedController().getAlarmList().getAlarms()[position];

        // Set up the form.
        mTimePicker = (TimePicker) findViewById(R.id.edit_time_picker);
        mSoundSpinner = (Spinner) findViewById(R.id.edit_sound_spinner);
        mPuzzleSpinner = (Spinner) findViewById(R.id.edit_puzzle_spinner);

        ArrayAdapter<String> soundsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Alarm.sounds);
        soundsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSoundSpinner.setAdapter(soundsAdapter);

        ArrayAdapter<String> puzzlesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Alarm.puzzles);
        puzzlesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mPuzzleSpinner.setAdapter(puzzlesAdapter);

        // Fill in information
        mTimePicker.setCurrentHour(alarm.getHours());
        mTimePicker.setCurrentMinute(alarm.getMinutes());
        mSoundSpinner.setSelection(alarm.getSoundID());
        mPuzzleSpinner.setSelection(alarm.getPuzzleID());

        Button mEditAlarmButton = (Button) findViewById(R.id.edit_alarm_button);
        Button mDeleteAlarmButton = (Button)findViewById(R.id.delete_alarm_button);
        mEditAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // getCurrentHour and min are now just getHour and getMin but then we can't support older versions of Android
                AlarmController.sharedController().editAlarm(mTimePicker.getCurrentHour(), mTimePicker.getCurrentMinute(), mSoundSpinner.getSelectedItemPosition(), mPuzzleSpinner.getSelectedItemPosition(), alarm.isActive(), position);
                EditAlarmActivity.this.finish();
            }
        });
        mDeleteAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlarmController.sharedController().deleteAlarm(position);
                EditAlarmActivity.this.finish();
            }
        });
    }
}
