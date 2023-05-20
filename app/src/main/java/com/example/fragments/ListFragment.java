package com.example.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    private ListView listView;
    private ArrayAdapter<String> adapter;

    private ArrayList<String> peopleList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        // Map each UI element to a field variable
        listView = view.findViewById(R.id.listView);

        // Set adapter for ListView
        Log.d("default", "defaultConfig: " + peopleList.toString());
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, peopleList);
        listView.setAdapter(adapter);

        // Get saved fragment data
        if (savedInstanceState != null) {
            ArrayList<String> savedPeopleList = savedInstanceState.getStringArrayList("peopleList");

            if (savedPeopleList != null) {
                peopleList.addAll(savedPeopleList);
                adapter.notifyDataSetChanged();
            }
        }

        return view;
    }

    // Save fragment data before rotating
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("peopleList", new ArrayList<>(peopleList));
    }

    // Add a String Item entered in Form Fragment to List Fragment
    public void addItem(String item) {
        peopleList.add(item);
        adapter.notifyDataSetChanged();
    }
}