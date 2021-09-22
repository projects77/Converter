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

public class TempFragment extends Fragment {


    double Celesius;
    double Fehrnhite;
    ArrayList<Double> tempreture = new ArrayList<>();

    Spinner src_Spinner;
    Spinner t_Spinner ;
    Button convert ;
    EditText tEditText;
    TextView tTextView ;
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
         tEditText = view.findViewById(R.id.text_edit);
         tTextView = view.findViewById(R.id.view_text);

        tempreture.add(Celesius);
        tempreture.add(Fehrnhite);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this.getContext(), R.array.temperature, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        src_Spinner.setAdapter(arrayAdapter);
        t_Spinner.setAdapter(arrayAdapter);

        convert.setOnClickListener(v -> {
            try {
                double amount = Double.parseDouble(tEditText.getText().toString());
                convert(src_Spinner.getSelectedItemPosition(), amount);
                tTextView.setText(tempreture.get(t_Spinner.getSelectedItemPosition())+" "+t_Spinner.getSelectedItem().toString());
            }
            catch (NumberFormatException e){
                e.printStackTrace();
            }
        });
    }

    private void convert(int position, double amount){
        switch (position){
            case 0: // celesius
                tempreture.set(0, amount);
                tempreture.set(1, (amount*1.8)+32);
                break;
            case 1: // fehrnhite
                tempreture.set(0, (amount-32)/1.8);
                tempreture.set(1, amount);
                break;
        }
    }












}