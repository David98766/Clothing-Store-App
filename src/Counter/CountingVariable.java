package Counter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.util.prefs.Preferences;

public class CountingVariable {
    //Declaring strings
    private static final String COUNTER_KEY = "counter";
    private static final int DEFAULT_COUNTER_VALUE = 0;
    private static final Preferences preferences = Preferences.userNodeForPackage(CountingVariable.class);

    private int value;

    public CountingVariable() {
        // Retrieve the value of the counter from the preferences, or use the default value if it's not set yet
        this.value = preferences.getInt(COUNTER_KEY, DEFAULT_COUNTER_VALUE);
    }

    public int getValue() {
        return value;
    }

    public void increment() {
        value++;
        // Store the new value of the counter in the preferences
        preferences.putInt(COUNTER_KEY, value);
    }
}

