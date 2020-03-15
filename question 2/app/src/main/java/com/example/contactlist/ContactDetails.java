package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        Bundle bundle=this.getIntent().getExtras();
        int pic=bundle.getInt("image");
        String name = bundle.getString("name");
        ImageView imageView = (ImageView) findViewById(R.id.contactImage);
        imageView.setImageResource(pic);
        TextView textView = (TextView) findViewById(R.id.contactName);
        textView.setText(name);
    }

    public void previousScreen(View view) {

        Intent myIntent = new Intent(getBaseContext(),   MainActivity.class);
        startActivity(myIntent);
    }
}
