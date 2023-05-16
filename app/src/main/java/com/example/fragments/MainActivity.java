package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private FormFragment formFragment;
    private ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        formFragment = (FormFragment) getSupportFragmentManager().findFragmentById(R.id.formFrameLayout);
        listFragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.listFrameLayout);
    }

    public void addToList(String name, String address) {
        String item = name + " - " + address;
        if (listFragment != null) {
            listFragment.addItem(item);
        }
    }
}