package com.corphish.nightlight.design.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.corphish.nightlight.data.Constants;
import com.corphish.nightlight.engine.Core;
import com.corphish.nightlight.helpers.PreferenceHelper;
import com.corphish.nightlight.R;

/**
 * Created by Avinaba on 10/24/2017.
 * Force switch fragment
 */

public class ForceSwitchFragment extends Fragment {

    SwitchCompat forceSwitch;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.card_force_switch, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        forceSwitch = getView().findViewById(R.id.force_switch);

        forceSwitch.setChecked(PreferenceHelper.getBoolean(getContext(), Constants.PREF_FORCE_SWITCH));
        forceSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // Preference for this is handled in Core now
                Core.applyNightModeAsync(b, getContext(), false);
            }
        });
    }

    public void updateSwitch(boolean newState) {
        if (forceSwitch != null) forceSwitch.setChecked(newState);
    }
}
