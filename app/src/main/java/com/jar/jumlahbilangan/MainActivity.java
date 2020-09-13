package com.jar.jumlahbilangan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText bil1;
    private EditText bil2;
    private EditText jumlah;
    private Button btnhasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initEvent();

    }

    public void initUI() {
        bil1 = findViewById(R.id.input_bilangan_pertama);
        bil2 = findViewById(R.id.input_bilangan_kedua);
        jumlah = findViewById(R.id.input_hasil);
        btnhasil = findViewById(R.id.btn_hitung);
        bil1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(8)});
        bil2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(8)});

    }

    public void initEvent(){
        btnhasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( bil1.getText().toString().length() == 0 )
                    bil1.setError( "Bilangan pertama kosong" );
                if( bil2.getText().toString().length() == 0 )
                    bil2.setError( "Bilangan kedua kosong" );
                else {
                    hitungJumlah();
                }

            }
        });
    }

    public void hitungJumlah(){
        int angka1 = Integer.parseInt(bil1.getText().toString());
        int angka2 = Integer.parseInt(bil2.getText().toString());
        int total = angka1 + angka2;
        jumlah.setText(total+"");
    }
}