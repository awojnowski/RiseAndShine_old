package comp3350.assignment.riseandshine.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import comp3350.assignment.riseandshine.R;

public class TasksFragment extends Fragment {

    public static CharSequence TAB_TITLE = "TASKS";

    public TasksFragment() {

        ;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.tasks_home, container, false);
        return rootView;

    }

}
