package comp3350.assignment.riseandshine.activities;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import comp3350.assignment.riseandshine.R;

public class CreateAlarmActivity extends AppCompatActivity {

    // UI references.
    private EditText mTitleView;
    private EditText mTimeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_alarm);

        // Set up the form.
        mTitleView = (EditText) findViewById(R.id.title);
        mTimeView = (EditText) findViewById(R.id.time);

        Button mCreateAlarmButton = (Button) findViewById(R.id.create_alarm_button);
        mCreateAlarmButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}

