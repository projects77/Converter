package com.example.converter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class UnitsFragment extends Fragment {

    double Cm;
    double M;
    double Km;
    ArrayList<Double> unit = new ArrayList<>();

    Spinner src_Spinner;
    Spinner t_Spinner;
    Button convert ;
    EditText UEditText ;
    TextView UTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment, container, false);
        return root;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        src_Spinner = view.findViewById(R.id.src_spinner);
         t_Spinner = view.findViewById(R.id.t_spinner);
        convert = view.findViewById(R.id.button_convert);
        UEditText = view.findViewById(R.id.text_edit);
        UTextView = view.findViewById(R.id.view_text);

        unit.add(Cm);
        unit.add(M);
        unit.add(Km);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this.getContext(), R.array.length, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        src_Spinner.setAdapter(arrayAdapter);
        t_Spinner.setAdapter(arrayAdapter);

        convert.setOnClickListener(v -> {
            try {
                double amount = Double.parseDouble(UEditText.getText().toString());
                convert(src_Spinner.getSelectedItemPosition(), amount);
                UTextView.setText(unit.get(t_Spinner.getSelectedItemPosition())+" "+t_Spinner.getSelectedItem().toString());
            }
            catch (NumberFormatException e){
                e.printStackTrace();
            }
        });

    }

    private void convert(int position, double amount){
        switch (position){
            case 0: // cm
                unit.set(0, amount);
                unit.set(1, amount/100);
                unit.set(2, amount/100000);
                break;
            case 1: // m
                unit.set(0, amount*100);
                unit.set(1, amount);
                unit.set(2, amount/1000);
                break;
            case 2: // km
                unit.set(0, amount*100000);
                unit.set(1, amount*1000);
                unit.set(2, amount);
                break;
        }
    }














}