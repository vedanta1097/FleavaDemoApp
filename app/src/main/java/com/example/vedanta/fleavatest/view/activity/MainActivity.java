package com.example.vedanta.fleavatest.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.vedanta.fleavatest.view.fragment.BodyFragment;
import com.example.vedanta.fleavatest.view.fragment.EventFragment;
import com.example.vedanta.fleavatest.view.fragment.MindFragment;
import com.example.vedanta.fleavatest.R;
import com.example.vedanta.fleavatest.view.fragment.SpiritFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_body:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main, new BodyFragment())
                            .commit();
                    return true;
                case R.id.navigation_mind:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main, new MindFragment())
                            .commit();
                    return true;
                case R.id.navigation_spirit:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main, new SpiritFragment())
                            .commit();
                    return true;
                case R.id.navigation_event:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main, new EventFragment())
                            .commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main, new SpiritFragment())
                    .commit();
        }
    }
}
