package com.vaddi.atom.vaddilekkalu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static android.R.attr.defaultValue;

public class AllTextViews extends AppCompatActivity {

    TextView aslu,vaddi,days,months,years,total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_text_views);

        aslu=(TextView)findViewById(R.id.asalu);
        vaddi=(TextView)findViewById(R.id.vaddi) ;
        days=(TextView)findViewById(R.id.days);
        months=(TextView)findViewById(R.id.months);
        years=(TextView)findViewById(R.id.years) ;
        total=(TextView)findViewById(R.id.total);

        double e1,e2,e3,e4,e5,e6;
        Intent receiveIntent = this.getIntent();
        e1 = receiveIntent.getDoubleExtra("doubleValue_e1", defaultValue);
        e2 = receiveIntent.getDoubleExtra("doubleValue_e2", defaultValue);
        e3 = receiveIntent.getDoubleExtra("doubleValue_e3", defaultValue);
        e4 = receiveIntent.getDoubleExtra("doubleValue_e4", defaultValue);
        e5 = receiveIntent.getDoubleExtra("doubleValue_e5", defaultValue);
        e6 = receiveIntent.getDoubleExtra("doubleValue_e6", defaultValue);


        int t = (int) e4;
        int v = (int) e6;

        aslu.setText("  ="+e5+" రూపాయలు");
        vaddi.setText("  ="+v+" రూపాయలు");


        days.setText("  ="+e1+" రోజులు");
        months.setText("  ="+e2+" నెలలు");
        years.setText("  ="+e3+" సంవత్సరాలు");
        total.setText("  ="+t+" రూపాయలు");

        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        // Toasts the test ad message on the screen. Remove this after defining your own ad unit ID.




    }





}
