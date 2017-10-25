package com.vaddi.atom.vaddilekkalu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {
    private EditText input1;
    private EditText input2;
    private EditText input3;


    EditText amount,hund;

    private EditText input4;
    private EditText input5;
    private EditText input6;
    double dresult,mresult,yresult;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        // Toasts the test ad message on the screen. Remove this after defining your own ad unit ID.
        Toast.makeText(this, "Enjoy with this app", Toast.LENGTH_LONG).show();




        amount = (EditText) findViewById(R.id.ammount);
        hund = (EditText) findViewById(R.id.hundred);



        input1 = (EditText) findViewById(R.id.year1);
        input2 = (EditText) findViewById(R.id.month1);
        input3 = (EditText) findViewById(R.id.day1);


        input4 = (EditText) findViewById(R.id.year2);
        input5 = (EditText) findViewById(R.id.month2);
        input6 = (EditText) findViewById(R.id.day2);


        Button bt_calculate = (Button) findViewById(R.id.bt_calculate);

        tv_result = (TextView) findViewById(R.id.tv_result);

        bt_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(amount.getText().toString().equals(""))
                {

                    amount.setError("అసలును నమోదు చేయండి");
                }

                else if(hund.getText().toString().equals(""))
                {
                    hund.setError("వడ్డీని నమోదు చేయండి");

                }



             else  if(input1.getText().toString().equals(""))
               {
                   input1.setError("తేదీని నమోదు చేయండి");

               }

                 else if(input2.getText().toString().equals(""))
                {

                    input2.setError("నెలను నమోదు చేయండి");
                }
                else  if(input3.getText().toString().equals(""))
                {
                    input3.setError("సంవత్సరం నమోదు చేయండి");
                }


                else  if(input4.getText().toString().equals(""))
                {
                    input4.setError("తేదీని నమోదు చేయండి");

                }

                else if(input5.getText().toString().equals(""))
                {

                    input5.setError("నెలను నమోదు చేయండి");
                }
                else  if(input6.getText().toString().equals(""))
                {
                    input6.setError("సంవత్సరం నమోదు చేయండి");
                }


                else {
                     makeCalculations();
                 }


            }
        });


    }




    private void makeCalculations() {
        // I'm assuming you're getting numbers.


        double n1 = Double.valueOf(input1.getText().toString());

        double n2 = Double.valueOf(input2.getText().toString());
        double n3 = Double.valueOf(input3.getText().toString());


        double n4 = Double.valueOf(input4.getText().toString());
        double n5 = Double.valueOf(input5.getText().toString());
        double n6 = Double.valueOf(input6.getText().toString());

        double amt = Double.valueOf(amount.getText().toString());
        double phr = Double.valueOf(hund.getText().toString());


        if (n4 > 31) {

            input4.setError("తేదీ 31 లోపే ఉండాలి");

            input4.setText("");
        } else if (n5 > 12) {

            input5.setError("నెల 12 మించరాదు");
            input5.setText("");
        }

        else if(input6.getText().toString().length()<4)
        {
            input6.setError("నమోదు చేసిన సంవత్సరం సరిచూసుకోండి");
            input6.setText("");
        }

       else if (n1> 31) {

            input1.setError("తేదీ 31 లోపే ఉండాలి");
            input1.setText("");
        } else if (n2 > 12) {

            input2.setError("నెల 12 మించరాదు");
            input2.setText("");
        }

        else if(input3.getText().toString().length()<4)
        {
            input3.setError("నమోదు చేసిన సంవత్సరం సరిచూసుకోండి");
            input3.setText("");
        }




        else {


            if (n1 > n4)//days
            {

                dresult = n1 - n4;

                if (n2 > n5)//months
                {
                    mresult = n2 - n5;

                    if (n3 > n6)//years
                    {

                        yresult = n3 - n6;
                    } else if (n3 < n6) {

                        Intent i = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(i);
                    } else if (n3 == n6) {
                        yresult = n3 - n6;

                    }


                } else if (n2 < n5) {
                    mresult = (n2 + 12) - n5;

                    if (n3 > n6) {

                        yresult = (n3 - 1) - n6;
                    } else if (n3 < n6) {

                        Intent i = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(i);
                    } else if (n3 == n6) {
                        yresult = n3 - n6;

                    }

                } else if (n2 == n5) {

                    mresult = n2 - n5;

                    if (n3 > n6) {

                        yresult = n3 - n6;
                    } else if (n3 < n6) {

                        Intent i = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(i);
                    } else if (n3 == n6) {
                        yresult = n3 - n6;

                    }


                }


            } else if (n1 < n4)

            {

                dresult = (n1 + 30) - n4;

                double n = n2 - 1;

                if (n > n5) {
                    mresult = (n) - n5;


                    if (n3 > n6) {

                        yresult = (n3) - n6;
                    } else if (n3 < n6) {

                        Intent i = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(i);
                    } else if (n3 == n6) {
                        yresult = (n3) - n6;

                    }


                } else if (n < n5) {
                    mresult = ((n) + 12) - n5;


                    double y = n3 - 1;

                    if (y > n6) {

                        yresult = (y) - n6;
                    } else if (y < n6) {

                        Intent i = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(i);
                    } else if (y == n6) {
                        yresult = (y) - n6;

                    }

                } else if (n == n5) {
                    mresult = n - n5;
                    double y = n3;

                    if (y > n6) {

                        yresult = (y) - n6;
                    } else if (y < n6) {

                        Intent i = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(i);
                    } else if (y == n6) {
                        yresult = (y) - n6;

                    }

                }


            } else if (n1 == n4) {

                dresult = n1 - n4;

                if (n2 > n5)//months
                {
                    mresult = n2 - n5;

                    if (n3 > n6)//years
                    {

                        yresult = n3 - n6;
                    } else if (n3 < n6) {

                        Intent i = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(i);
                    } else if (n3 == n6) {
                        yresult = n3 - n6;

                    }


                } else if (n2 < n5) {
                    mresult = (n2 + 12) - n5;

                    if (n3 > n6) {

                        yresult = (n3 - 1) - n6;
                    } else if (n3 < n6) {

                        Intent i = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(i);
                    } else if (n3 == n6) {
                        yresult = n3 - n6;

                    }

                } else if (n2 == n5) {

                    mresult = n2 - n5;

                    if (n3 > n6) {

                        yresult = n3 - n6;
                    } else if (n3 < n6) {

                        Intent i = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(i);
                    } else if (n3 == n6) {
                        yresult = n3 - n6;

                    }


                }


            }


            double months = (yresult * (12.0 / 1.0)) + mresult;


            double permonth = (amt * phr / 100);

            double amount12 = permonth * months;

            double perday = permonth / 30;

            double daysmoney = perday * dresult;

            double total = amt + amount12 + daysmoney;

            double vaddi = amount12 + daysmoney;


            // Do your calculation here.
            // I'm assuming you have inserted the result on a variable called 'result'. Like: double result
            //if((n3>n6 || n3==10)||(<5 || b1>10)||(c1<5 || c1>10))


            // tv_result.setText(" date " + dresult + "   months :" + mresult + "  years:" + yresult + "   number of months" + months + " Total =" + total);
            if (n3 >= n6) {

                if (n2 >= n5 || n2 <= n5) {
                    if (n1 >= n4 || n1 <= n4) {


                        if (vaddi < 0.0 || dresult < 0.0)

                        {

                            Intent i = new Intent(MainActivity.this, Main2Activity.class);
                            startActivity(i);
                        } else {


                            Intent intent = new Intent(MainActivity.this, AllTextViews.class);
      /*  intent.putExtra("date", dresult);
        intent.putExtra("motnth", mresult);
        intent.putExtra("year", yresult);
        intent.putExtra("total", total);
        intent.putExtra("asalu", amt);
        intent.putExtra("vaddi", vaddi);*/


                            intent.putExtra("doubleValue_e1", dresult);
                            intent.putExtra("doubleValue_e2", mresult);
                            intent.putExtra("doubleValue_e3", yresult);
                            intent.putExtra("doubleValue_e4", total);
                            intent.putExtra("doubleValue_e5", amt);
                            intent.putExtra("doubleValue_e6", vaddi);


                            startActivity(intent);
                        }
                    }
                }
            } else {


                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);

            }


        }


    }


    // The rest of your Activity and methods.
}
