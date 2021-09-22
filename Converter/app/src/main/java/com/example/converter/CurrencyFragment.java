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


public class CurrencyFragment extends Fragment {

    double Dollar ;
    double Euro ;
    double Egp ;
    ArrayList<Double> currency = new ArrayList<>();
    Spinner src_Spinner ;
    Spinner t_Spinner ;
    Button convert ;
    EditText cEditText ;
    TextView cTextView ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         src_Spinner = view.findViewById(R.id.src_spinner);
         t_Spinner = view.findViewById(R.id.t_spinner);
         convert = view.findViewById(R.id.button_convert);
         cEditText = view.findViewById(R.id.text_edit);
         cTextView = view.findViewById(R.id.view_text);

        currency.add(Dollar);
        currency.add(Euro);
        currency.add(Egp);

        ArrayAdapter<CharSequence> firstAdapter = ArrayAdapter.createFromResource(this.getContext(), R.array.currency, android.R.layout.simple_spinner_item);
        firstAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        src_Spinner.setAdapter(firstAdapter);
        t_Spinner.setAdapter(firstAdapter);

        convert.setOnClickListener(v -> {
            try {
                double amount = Double.parseDouble(String.valueOf(cEditText.getText()));
                convert(src_Spinner.getSelectedItemPosition(), amount);
                cTextView.setText(currency.get(t_Spinner.getSelectedItemPosition())+" "+ t_Spinner.getSelectedItem().toString());
            }
            catch (NumberFormatException e){
                e.printStackTrace();
            }
        });

    }

    private void convert(int position, double amount){
        switch (position){
            case 0: // dollar
                currency.set(0, amount);
                currency.set(1, amount*0.85);
                currency.set(2, amount*15);
                break;
            case 1: // euro
                currency.set(0, amount/0.84);
                currency.set(1, amount);
                currency.set(2, amount*18);
                break;
            case 2: // egp
                currency.set(0, amount/15);
                currency.set(1, amount/18);
                currency.set(2, amount);
                break;
        }
    }




}