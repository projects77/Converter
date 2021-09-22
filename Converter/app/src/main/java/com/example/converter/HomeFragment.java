package com.example.converter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {


    Button currency_Btn ;
    Button mass_Btn ;
    Button units_Btn ;
    Button temp_Btn ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        currency_Btn = view.findViewById(R.id.currency_btn);
        mass_Btn = view.findViewById(R.id.mass_btn);
        units_Btn = view.findViewById(R.id.units_btn);
        temp_Btn = view.findViewById(R.id.temp_btn);

        NavController navController = Navigation.findNavController(view);

        currency_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_homeFragment_to_currencyFragment4);
            }
        });

        mass_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_homeFragment_to_massFragment);
            }
        });

        units_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_homeFragment_to_unitsFragment);
            }
        });

        temp_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_homeFragment_to_tempFragment);
            }
        });


    }
}
