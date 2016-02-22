package comp3350.assignment.riseandshine.models.tasks;

public class Task {

    private Class activityClass;
    private Class settingsClass;

    public Task(Class activityClass, Class settingsClass) {

        this.activityClass = activityClass;
        this.settingsClass = settingsClass;

    }

    // MARK: Getters & Setters

    public Class getActivityClass() {

        return this.activityClass;

    }

    public Class getSettingsClass() {

        return this.settingsClass;

    }

}
