package com.example.aaron.kingdom;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bLogout;
    UserLocalStore userLocalStore;
    Intent i;
    Variables.User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bLogout = (Button) findViewById(R.id.bLogout);
        bLogout.setOnClickListener(this);
        userLocalStore = new UserLocalStore(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        TestFetchUserFromSP();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogout:
                userLocalStore.clearUserData();
                i = new Intent(this, LoginActivity.class);
                startActivity(i);
                break;
        }
    }

    public void TestFetchUserFromSP (){
        user = userLocalStore.getUserData();
        bLogout.setText("Logout from Username: '" + user.username + "' with Password: '" + user.password + "'");
    }
}
