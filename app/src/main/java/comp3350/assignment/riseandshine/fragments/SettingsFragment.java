package comp3350.assignment.riseandshine.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import comp3350.assignment.riseandshine.R;

public class SettingsFragment extends Fragment {

    public static CharSequence TAB_TITLE = "SETTINGS";

    public SettingsFragment() {

        ;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.settings_home, container, false);
        return rootView;

    }

}
