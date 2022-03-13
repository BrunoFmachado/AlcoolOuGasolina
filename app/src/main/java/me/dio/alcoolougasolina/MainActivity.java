package me.dio.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {


    private TextInputEditText PrecoAlcool, PrecoGasoliona;
    private TextView textresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PrecoAlcool          = findViewById(R.id.editprecoalcool);
        PrecoGasoliona       = findViewById(R.id.editprecogasolina);
        textresultado        = findViewById(R.id.textresultado);


    }

    public void calcularpreco(View View){

        String precoalcool      = PrecoAlcool.getText().toString();
        String precogasolina    = PrecoGasoliona.getText().toString();



        boolean camposValidados = ValidarCampos(precoalcool, precogasolina);

        if ( camposValidados ){

            Double ValorAlcool      =       Double.parseDouble( precoalcool);
            Double ValorGasolina    =       Double.parseDouble( precogasolina);

            Double resultado = ValorGasolina / ValorAlcool;

            if(resultado >= 0.9) {
                textresultado.setText("Melhor usar gasolina!");
            }else{
                textresultado.setText("Melhor usar Álcool!!");
                        }

        } else {
            textresultado.setText("Preencha os preços primeiro!");
        }

}
    public boolean ValidarCampos(String pAlcool, String PGasolina){

        boolean camposValidados = true;

            if      (pAlcool == null || pAlcool.equals("") ){

                    camposValidados = false;

        }   else if (PGasolina == null || PGasolina.equals("") ) {

                    camposValidados = false;
        }

            return camposValidados;


    }
}