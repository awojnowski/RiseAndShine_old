package comp3350.assignment.riseandshine.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import comp3350.assignment.riseandshine.R;

public class SettingsFragment extends PreferenceFragment {

    public static CharSequence TAB_TITLE = "SETTINGS";

    public SettingsFragment() {

        ;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
    }
/*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.settings_home, container, false);
        return rootView;

    }
*/
}
