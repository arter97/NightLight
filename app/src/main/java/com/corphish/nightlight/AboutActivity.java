package com.corphish.nightlight;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.corphish.nightlight.design.fragments.AboutFragment;
import com.corphish.nightlight.design.fragments.ContributorsFragment;
import com.corphish.nightlight.design.fragments.DonateFragment;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) viewInit();
    }

    private void viewInit() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

        int containerId = R.id.layout_container;

        fragmentTransaction.add(containerId, new AboutFragment());
        if (getResources().getBoolean(R.bool.contributors_card_enabled)) fragmentTransaction.add(containerId, new ContributorsFragment());
        fragmentTransaction.add(containerId, new DonateFragment());

        fragmentTransaction.commit();
    }
}
