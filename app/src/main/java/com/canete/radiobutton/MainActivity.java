package com.canete.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton btnDam ;
    RadioButton btnDaw ;
    RadioButton btnAsir ;

    RadioButton btnManiana;
    RadioButton btnTarde ;
    RadioButton btnOnline;
    EditText txtNombre;
    Switch swIncluirIva ;
    TextView txtDinero;



    public final int iDamPrecio = 1000;
    public final int iDawPrecio = 1200 ;
    public final int iAsirPrecio= 750;
    public final int iManianaPrecio = 600;
    public final int iTardePrecio = 400;
    public final int iOnlinePrecio= 200;
    public final float dIvaPrecio= 0.21f;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Modulo
        btnDam = findViewById(R.id.btnDam);
        btnDaw = findViewById(R.id.btnDaw);
        btnAsir = findViewById(R.id.btnAsir);

        //turno
        btnManiana = findViewById(R.id.btnManiana);
        btnTarde = findViewById(R.id.btnTarde);
        btnOnline = findViewById(R.id.btnOnline);

        txtNombre = findViewById(R.id.txtNombre);
        txtDinero = findViewById(R.id.txtDinero);



        swIncluirIva = findViewById(R.id.swIncluirIva);
        txtDinero= findViewById(R.id.txtDinero);

        findViewById(R.id.btnCalcularImporte).setOnClickListener(v ->calcular() );



    }


    private void calcular(){

        if(txtNombre.getText().toString().length()==0){
            Toast.makeText(this,"Introduce un nombre",Toast.LENGTH_SHORT).show();
        }else{
            int iPrecioCurso =0;
            if (btnDam.isChecked()) {
                iPrecioCurso= iDamPrecio;
            }else if (btnDaw.isChecked()) {
                iPrecioCurso= iDawPrecio;
            }else if (btnAsir.isChecked()){
                iPrecioCurso= iAsirPrecio;
            }
            if(btnManiana.isChecked()){
                iPrecioCurso= iPrecioCurso + iManianaPrecio;
            }else if (btnTarde.isChecked()){
                iPrecioCurso= iPrecioCurso+ iTardePrecio;
            }else if (btnOnline.isChecked()){
                iPrecioCurso= iPrecioCurso + iOnlinePrecio;
            }

            if(swIncluirIva.isChecked()){
                iPrecioCurso += (int) (iPrecioCurso * dIvaPrecio);
            }

            txtDinero.setText(iPrecioCurso + "");
        }




    }

}