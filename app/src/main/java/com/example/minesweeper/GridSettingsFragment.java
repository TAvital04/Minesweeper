package com.example.minesweeper;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

public class GridSettingsFragment extends Fragment {

    public GridSettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid_settings, container, false);

        // Find the seekbars
        SeekBar seekBarRows = view.findViewById(R.id.gridSettingsRowsSeekbar);
        SeekBar seekBarColumns = view.findViewById(R.id.gridSettingsColumnsSeekbar);
        SeekBar seekBarMines = view.findViewById(R.id.gridSettingsMinesSeekbar);

        // Populate them with the current settings
        SettingsActivity parent = (SettingsActivity) requireActivity();

        int currentRows = parent.game.getGrid().getGridSettings().getRows() - 5;
        int currentColumns = parent.game.getGrid().getGridSettings().getColumns() - 5;
        int currentMines = (parent.game.getGrid().getGridSettings().getMines() - 10)/5;

        seekBarRows.setProgress(currentRows);
        seekBarColumns.setProgress(currentColumns);
        seekBarMines.setProgress(currentMines);

        // Reset game settings upon changes
        seekBarRows.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                parent.game.getGrid().getGridSettings().setRows(progress + 5);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        seekBarColumns.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                parent.game.getGrid().getGridSettings().setColumns(progress + 5);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        seekBarMines.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                parent.game.getGrid().getGridSettings().setMines((progress * 5) + 10);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        return view;
    }
}