package com.example.minesweeper;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SettingsActivity extends AppCompatActivity {
    private boolean gridSettings = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);

        // Switch fragments functionality
        FragmentManager fragmentManager = getSupportFragmentManager();
        if(savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainerView, new GridSettingsFragment());
            fragmentTransaction.commit();
        }

        Button switchButton = findViewById(R.id.settingsSwitchButton);
        switchButton.setText(R.string.settingsSwitchButtonColorSettings);
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to the other fragment
                if(gridSettings) {
                    // Change the switchButton text
                    switchButton.setText(R.string.settingsSwitchButtonGridSettings);

                    // Change the switch boolean
                    gridSettings = !gridSettings;

                    // Change the fragment
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainerView, new ColorSettingsFragment());
                    fragmentTransaction.commit();
                } else {
                    // Change the switchButton text
                    switchButton.setText(R.string.settingsSwitchButtonColorSettings);

                    gridSettings = !gridSettings;

                    // Change the fragment
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainerView, new GridSettingsFragment());
                    fragmentTransaction.commit();
                }
            }
        });
    }
}