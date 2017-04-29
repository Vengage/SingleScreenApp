package com.example.student.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * goToWebsite(View view) Function used to go to the website of the
     * business presented in the application
     *
     * @param view It is the layout which contains the website address
     */
    public void goToWebsite(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.full_website_address)));
        startActivity(intent);
    }

    /**
     * sendEmail(View view) Function used to send an email when the
     * email address is tapped
     *
     * @param view It is the layout which contains the website email address
     */
    public void sendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, getString(R.string.email));
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject));
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.email_body));

        startActivity(Intent.createChooser(intent, "Write Email"));
    }

    /**
     * goToLocation(View view) Function to get show the location on Google Maps
     *
     * @param view It is the layout which contains the address
     */
    public void goToLocation(View view) {
        // The coordonates of the business
        Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(getString(R.string.location)));
        startActivity(mapIntent);
    }

    /**
     * call(View view) Function to dial the number. It will put the user to choose
     * a phone calls application
     *
     * @param view It is the layout which contains the telephone number
     */
    public void call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.tel_nr)));
        startActivity(intent);
    }

}
