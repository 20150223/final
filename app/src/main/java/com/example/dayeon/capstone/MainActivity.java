package com.example.dayeon.capstone;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    DashboardFragment frag1;
    AlarmlogFragment frag2;
    InformationFragment frag3;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {

                case R.id.navigation_dashboard:
                    mTextMessage.setText("DASHBOARD");
                    setFrag(0);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText("ALARM LOG");
                    setFrag(1);
                    return true;
                case R.id.navigation_camera:
                    mTextMessage.setText("INFORMATION");
                    setFrag(2);
                    return true;
            }

            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.title);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        frag1 = new DashboardFragment();
        frag2 = new AlarmlogFragment();
        frag3 = new InformationFragment();
        setFrag(0);

    }



    public void setFrag(int n) {

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (n){
            case 0:
                fragmentTransaction.replace(R.id.content,frag1);
                fragmentTransaction.commit();
                break;
            case 1:
                fragmentTransaction.replace(R.id.content,frag2);
                fragmentTransaction.commit();
                break;
            case 2:
                fragmentTransaction.replace(R.id.content,frag3);
                fragmentTransaction.commit();
                break;
        }
    }


}
