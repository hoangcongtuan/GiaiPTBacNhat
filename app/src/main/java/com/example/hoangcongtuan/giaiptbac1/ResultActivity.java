package com.example.hoangcongtuan.giaiptbac1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    Button btnBack;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvResult = (TextView)findViewById(R.id.tvResult);

        Intent intent = getIntent();
        final double a, b;
        a = intent.getDoubleExtra(MainActivity.HE_SO_A, 0);
        b = intent.getDoubleExtra(MainActivity.HE_SO_B, 0);

        Double x;
        if (a == 0 && b == 0)
            tvResult.setText("PT VSN");
        else if (a == 0 && b != 0)
            tvResult.setText("PT VN");
        else {
            x = - b / a;
            tvResult.setText(x.toString());
        }

        btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.HE_SO_A, a);
                intent.putExtra(MainActivity.HE_SO_B, b);
                setResult(MainActivity.RC_OK, intent);
                finish();
            }
        });
    }
}
