package com.example.errorhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2, et3;
    TextView tv1;
    Button bt1, bt2;

    String matkul;
    int nilai, nilai1, rata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et_1);
        et2 = findViewById(R.id.et_2);
        et3 = findViewById(R.id.et_3);
        tv1 = findViewById(R.id.tv_1);
        bt1 = findViewById(R.id.bt_1);
        bt2 = findViewById(R.id.bt_2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    matkul = et1.getText().toString(); // ambil string dari et_1
                    if(matkul.equals("")) { // cek kalo matkul gaada isinya maka
                        throw new NullPointerException(); // ngelempar NullPointerException karna matkul gaada isinya
                    } else{
                        nilai = Integer.parseInt(et2.getText().toString()); // ambil integer dari et_2
                        nilai1 = Integer.parseInt(et3.getText().toString()); // ambil integer dari et_3
                    }
                } catch (NumberFormatException nfe) {
                    Log.d("Cek nilai", "Nilai harus integer"); // debug message
                    tv1.setText("Kesalahan input"); // nampilin hasil
                    Toast.makeText(MainActivity.this, "Ulang sih, coba input integer", Toast.LENGTH_SHORT).show(); // munculin pop-up pesan in a short duration
                } catch (NullPointerException npe){
                    Log.d("Cek matkul", "Harus diisi");
                    tv1.setText("Belom input nama matkul"); // nampilin hasil
                    Toast.makeText(MainActivity.this, "Nama matkul harus diisi", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    nilai = Integer.parseInt(et2.getText().toString());
                    nilai1 = Integer.parseInt(et3.getText().toString());
                    rata = (nilai+nilai1)/2;
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error nih", Toast.LENGTH_SHORT).show();
                }
                tv1.setText("Rata-rata : " + rata);
            }
        });
    }
}