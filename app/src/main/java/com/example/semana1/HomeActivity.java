package com.example.semana1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private NewItemFragment newItemFragment;
    private ListItemFragment listItemFragment;
    private BottomNavigationView navigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navigation = findViewById(R.id.navegacion);

        newItemFragment = NewItemFragment.newInstance();
        listItemFragment = ListItemFragment.newInstance();


        showFragment(newItemFragment);

        navigation.setOnNavigationItemSelectedListener(
                (menuItem) -> {
                    switch (menuItem.getItemId()){
                        case R.id.nuevo:
                            showFragment(newItemFragment);
                            break;
                        case R.id.lista:
                            showFragment(listItemFragment);
                            break;
                    }
                    return true;
                }
        );
    }

    public void showFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment);
        fragmentTransaction.commit();
    }
}