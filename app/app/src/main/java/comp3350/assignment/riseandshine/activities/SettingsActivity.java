package comp3350.assignment.riseandshine.activities;

import android.preference.*;//PreferenceFragment;
import android.content.*;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;//View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import comp3350.assignment.riseandshine.R;
/**
 * Created by guot3 on 2016-02-21.
 */
public class SettingsActivity extends PreferenceActivity{

    private ListPreference dRange;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);

        dRange = (ListPreference)  getPreferenceManager().findPreference("date_range");
        dRange.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if (preference == dRange)
                {
                    dRange.setSummary(dRange.getEntry());
                }
                return true;
            }
        });
    }
}
