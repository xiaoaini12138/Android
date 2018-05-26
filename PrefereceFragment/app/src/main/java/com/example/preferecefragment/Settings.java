package com.example.preferecefragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;


/**
 * Created by 黄毅 on 2018/5/26.
 */
public class Settings extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
    }
}