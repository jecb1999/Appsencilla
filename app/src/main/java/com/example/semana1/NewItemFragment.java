package com.example.semana1;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewItemFragment extends Fragment implements View.OnClickListener{

    private EditText nuevaTarea;
    private Button agregarButton;

    public NewItemFragment() {
        // Required empty public constructor
    }

    public static NewItemFragment newInstance() {
        NewItemFragment fragment = new NewItemFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_new_item, container, false);
        nuevaTarea = root.findViewById(R.id.nuevaTarea);
        agregarButton = root.findViewById(R.id.agregarButton);
        agregarButton.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.agregarButton:
                Toast.makeText(getContext(),nuevaTarea.getText().toString(),Toast.LENGTH_LONG).show();
                break;
        }
    }
}