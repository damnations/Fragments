package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormFragment extends Fragment {
    private EditText nameEditText;
    private EditText addressEditText;
    private Button addButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_form, container, false);

        // Map each UI element to a field variable
        nameEditText = view.findViewById(R.id.nameEditText);
        addressEditText = view.findViewById(R.id.addressEditText);
        addButton = view.findViewById(R.id.addButton);

        // Set up addButton click listener
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.d("TAG", "onClick: " + nameEditText.getText() + "," + addressEditText.getText());
                    String name = nameEditText.getText().toString().trim();
                    String address = addressEditText.getText().toString().trim();

                    MainActivity activity = (MainActivity) getActivity();
                    if (activity != null) {
                        activity.addToList(name, address);
                    }

                    nameEditText.setText("");
                    addressEditText.setText("");
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        return view;
    }
}