package com.example.hoangcongtuan.giaiptbac1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getName();

    Button btnResult;
    EditText edtA;
    EditText edtB;
    public final static String HE_SO_A = "HSA";
    public final static String HE_SO_B = "HSB";
    public final static int RC_GPT = 1;
    public final static int RC_OK = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnResult = (Button)findViewById(R.id.btnKetqua);
        edtA = (EditText)findViewById(R.id.edtA);
        edtB = (EditText)findViewById(R.id.edtB);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double a, b;
                try {
                    a = Double.parseDouble(edtA.getText().toString());
                    b = Double.parseDouble(edtB.getText().toString());
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra(HE_SO_A, a);
                    intent.putExtra(HE_SO_B, b);
                    startActivityForResult(intent, RC_GPT);
                }
                catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Wrong number!", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        edtA.setText("0");
        edtB.setText("0");
        if (requestCode == RC_GPT && resultCode == RC_OK) {
            //activiy come back
            double a, b;
            a = data.getDoubleExtra(HE_SO_A, 0);
            b = data.getDoubleExtra(HE_SO_B, 0);
            Toast.makeText(MainActivity.this, "Welcom back to MainActivity, Your last edit text : a= " + a + " ,b= " + b, Toast.LENGTH_SHORT).show();

        }
    }

}
