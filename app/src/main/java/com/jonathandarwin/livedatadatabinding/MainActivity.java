package com.jonathandarwin.livedatadatabinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;

import com.jonathandarwin.livedatadatabinding.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity {

    private MainActivityBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initiate Data Binding and View Model
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        // Set ViewModel to Layout
        binding.setViewModel(viewModel);

        // Set Binding to Observe the Live Data
        // The Binding will automatically update when the Live Data is updated
        binding.setLifecycleOwner(this);

        // Set Name for the First Time
        viewModel.setName();

        // Set Listener
        binding.fabRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setName();
            }
        });
    }
}
