package com.example.minesweeper;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ColorSettingsFragment extends Fragment {

    public ColorSettingsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color_settings, container, false);

        // Find the spinners
        Spinner spinnerCovered = view.findViewById(R.id.spinner);
        Spinner spinnerUncovered = view.findViewById(R.id.spinner2);
        Spinner spinnerMine = view.findViewById(R.id.spinner3);
        Spinner spinnerSuspected = view.findViewById(R.id.spinner4);

        // Populate them with the current settings
        ArrayAdapter<CharSequence> namesAdapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.color_names,
                android.R.layout.simple_spinner_item
        );
        namesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCovered.setAdapter(namesAdapter);
        spinnerUncovered.setAdapter(namesAdapter);
        spinnerMine.setAdapter(namesAdapter);
        spinnerSuspected.setAdapter(namesAdapter);

        SettingsActivity parent = (SettingsActivity) requireActivity();
        ColorSettings cs = parent.game.getColorSettings();

        spinnerCovered.setSelection(indexOfColorRes(cs.getCoveredCell()));
        spinnerUncovered.setSelection(indexOfColorRes(cs.getUncoveredCell()));
        spinnerMine.setSelection(indexOfColorRes(cs.getMine()));
        spinnerSuspected.setSelection(indexOfColorRes(cs.getSuspectedCell()));

        // Reset game settings upon changes
        spinnerCovered.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parentView, View itemView, int pos, long id) {
                cs.setCoveredCell(colorResAt(pos));
            }
            @Override public void onNothingSelected(AdapterView<?> parentView) { }
        });

        spinnerUncovered.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parentView, View itemView, int pos, long id) {
                cs.setUncoveredCell(colorResAt(pos));
            }
            @Override public void onNothingSelected(AdapterView<?> parentView) { }
        });

        spinnerMine.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parentView, View itemView, int pos, long id) {
                cs.setMine(colorResAt(pos));
            }
            @Override public void onNothingSelected(AdapterView<?> parentView) { }
        });

        spinnerSuspected.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parentView, View itemView, int pos, long id) {
                cs.setSuspectedCell(colorResAt(pos));
            }
            @Override public void onNothingSelected(AdapterView<?> parentView) { }
        });

        return view;
    }


    @ColorRes
    private int colorResAt(int index) {
        TypedArray ta = requireContext().getResources().obtainTypedArray(R.array.color_values);
        int resId = ta.getResourceId(index, 0);
        ta.recycle();
        return resId;
    }

    private int indexOfColorRes(@ColorRes int targetResId) {
        TypedArray ta = requireContext().getResources().obtainTypedArray(R.array.color_values);
        int found = 0;
        for (int i = 0; i < ta.length(); i++) {
            if (ta.getResourceId(i, 0) == targetResId) { found = i; break; }
        }
        ta.recycle();
        return found; // defaults to first option if not matched
    }
}
