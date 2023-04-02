package com.example.mini_oyun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button
        btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnEsittir,btnTemizle;

    TextView
        txtKalanHak, txtSkor, txtSonuc,txtSayi;

    String gelenDeger;
    int kalanHak = 3, randomSayi;
    Random rndNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0=findViewById(R.id.button0);
        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);
        btn3=findViewById(R.id.button3);
        btn4=findViewById(R.id.button4);
        btn5=findViewById(R.id.button5);
        btn6=findViewById(R.id.button6);
        btn7=findViewById(R.id.button7);
        btn8=findViewById(R.id.button8);
        btn9=findViewById(R.id.button9);
        btnEsittir=findViewById(R.id.esittir);
        btnTemizle=findViewById(R.id.temizle);

        txtSayi =findViewById(R.id.tahmin);
        txtKalanHak =findViewById(R.id.kalanhak);
        txtSkor =findViewById(R.id.skor);
        txtSonuc =findViewById(R.id.sonuc);

        txtSayi.setText("0");
        randomSayi =(int) (Math.random()*5+1);
        System.out.println("sayı : " + randomSayi);






        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklaNumara(0);

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklaNumara(1);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklaNumara(2);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklaNumara(3);

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklaNumara(4);

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklaNumara(5);

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklaNumara(6);

            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklaNumara(7);

            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklaNumara(8);

            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklaNumara(9);

            }
        });

        btnEsittir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tiklaSembol("=");

            }
        });

        btnTemizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tiklaSembol("temizle");


            }
        });


    }

    private void tıklaNumara(int sayi){

        if(txtSayi.getText().toString() == "0") {
            txtSayi.setText("");
        }

        txtSayi.setText(txtSayi.getText() + String.valueOf(sayi));
    }

    private void tiklaSembol (String sembol){



        switch (sembol) {
            case "temizle":
                txtSayi.setText("0");
                break;

            case "=":
                gelenDeger = txtSayi.getText().toString();

                    if (!TextUtils.isEmpty(gelenDeger)) {
                        if (kalanHak > 0) {

                            if (gelenDeger.equals(String.valueOf(randomSayi))) {
                                sonucGoster("Tebrikler Doğru Tahmin");
                                    kalanHak=0;
                                    if(kalanHak==0){
                                        txtSkor.setText("Tutulan Sayı : " + randomSayi);
                                    }
                                }


                            else{
                                txtSonuc.setText("Yanlış Tahminde Bulundunuz");
                                kalanHak--;
                                if(kalanHak==0){
                                    txtSkor.setText("Tutulan Sayı : " + randomSayi);
                                }
                            }
                            txtKalanHak.setText("Kalan Hak : " + kalanHak);
                        }
                    else {
                            txtSkor.setText("Tutulan Sayı : " + randomSayi);
                            sonucGoster("Oyun Bitti");
                        }
                    }}


        }












    private void sonucGoster(String mesaj) {
        txtSayi.setEnabled(false);

        txtSonuc.setText(mesaj);
    }

}
