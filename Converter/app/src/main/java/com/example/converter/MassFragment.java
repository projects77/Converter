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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MassFragment extends Fragment {



    double G;
    double Kg;
    ArrayList<Double> mass = new ArrayList<>();

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

        Spinner src_Spinner = view.findViewById(R.id.src_spinner);
        Spinner t_Spinner = view.findViewById(R.id.t_spinner);
        Button convert = view.findViewById(R.id.button_convert);
        EditText mEditText = view.findViewById(R.id.text_edit);
        TextView mTextView = view.findViewById(R.id.view_text);

        mass.add(G);
        mass.add(Kg);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this.getContext(), R.array.mass, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        src_Spinner.setAdapter(arrayAdapter);
        t_Spinner.setAdapter(arrayAdapter);

        convert.setOnClickListener(v -> {
            try {
                double amount = Double.parseDouble(mEditText.getText().toString());
                convert(src_Spinner.getSelectedItemPosition(), amount);
                mTextView.setText(mass.get(t_Spinner.getSelectedItemPosition())+" "+t_Spinner.getSelectedItem().toString());
            }
            catch (NumberFormatException e){
                e.printStackTrace();
            }
        });


    }

    private void convert(int position, double amount){
        switch (position){
            case 0: //from gram
                mass.set(0, amount);
                mass.set(1, amount/1000);
                break;
            case 1: //from kg
                mass.set(0, amount*1000);
                mass.set(1, amount);
                break;
        }
    }










    }






