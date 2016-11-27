package itchetumal.com.mx.calculadora;

import android.content.DialogInterface;
import android.support.v4.view.MenuItemCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    TextView TextCalculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View v1 = findViewById(R.id.TextCalculadora);
        TextCalculadora = (TextView) v1;
        TextCalculadora.setText("");

        View boton1 = findViewById(R.id.btn1);
        boton1.setOnClickListener(this);
        View boton2 = findViewById(R.id.btn2);
        boton2.setOnClickListener(this);
        View boton3 = findViewById(R.id.btn3);
        boton3.setOnClickListener(this);
        View boton4 = findViewById(R.id.btn4);
        boton4.setOnClickListener(this);
        View boton5 = findViewById(R.id.btn5);
        boton5.setOnClickListener(this);
        View boton6 = findViewById(R.id.btn6);
        boton6.setOnClickListener(this);
        View boton7 = findViewById(R.id.btn7);
        boton7.setOnClickListener(this);
        View boton8 = findViewById(R.id.btn8);
        boton8.setOnClickListener(this);
        View boton9 = findViewById(R.id.btn9);
        boton9.setOnClickListener(this);
        View boton0 = findViewById(R.id.btn0);
        boton0.setOnClickListener(this);

        View botonSuma = findViewById(R.id.btnSuma);
        botonSuma.setOnClickListener(this);
        View botonResta = findViewById(R.id.btnResta);
        botonResta.setOnClickListener(this);
        View botonDivicion = findViewById(R.id.btnDivicion);
        botonDivicion.setOnClickListener(this);
        View botonMultiplicacion = findViewById(R.id.btnMultiplicacion);
        botonMultiplicacion.setOnClickListener(this);
        View botonPunto = findViewById(R.id.btnPunto);
        botonPunto.setOnClickListener(this);
        View botonBorra = findViewById(R.id.btnBorrar);
        botonBorra.setOnClickListener(this);
        View botonIgual = findViewById(R.id.btnIgual);
        botonIgual.setOnClickListener(this);
    }

    double result, m1 = 0, m2 = 0;
    char opAnterior = '+';

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn1) TextCalculadora.append("1");
        else if (v.getId() == R.id.btn2) TextCalculadora.append("2");
        else if (v.getId() == R.id.btn3) TextCalculadora.append("3");
        else if (v.getId() == R.id.btn4) TextCalculadora.append("4");
        else if (v.getId() == R.id.btn5) TextCalculadora.append("5");
        else if (v.getId() == R.id.btn6) TextCalculadora.append("6");
        else if (v.getId() == R.id.btn7) TextCalculadora.append("7");
        else if (v.getId() == R.id.btn8) TextCalculadora.append("8");
        else if (v.getId() == R.id.btn9) TextCalculadora.append("9");
        else if (v.getId() == R.id.btn0) TextCalculadora.append("0");
        else if (v.getId() == R.id.btnPunto) TextCalculadora.append(".");
        else if (v.getId() == R.id.btnBorrar) {

            TextCalculadora.setText("");
            m1 = 0;
            opAnterior = '+';
        }
        else if (v.getId() == R.id.btnSuma) calcula('+');
        else if (v.getId() == R.id.btnResta) calcula('-');
        else if (v.getId() == R.id.btnMultiplicacion) calcula('X');
        else if (v.getId() == R.id.btnDivicion) calcula('/');
        else if (v.getId() == R.id.btnIgual) calcula('=');
    }

    public void calcula(char op) {

        double result = m1;
        String cadena = TextCalculadora.getText().toString();
        try {
            m2 = Double.parseDouble(cadena);
            if (opAnterior == '+') result = m1 + m2;
            else if (opAnterior == '-') result = m1 - m2;
            else if (opAnterior == 'X') result = m1 * m2;
            else if (opAnterior == '/') result = m1 / m2;
            m1 = result;
            opAnterior = op;
            if (op == '=') {
                TextCalculadora.setText("" + m1);
            } else {
                TextCalculadora.setText("");
            }

        } catch (NumberFormatException nfe) {
            Toast.makeText(this, "numero incorrecto",Toast.LENGTH_LONG).show();
        }

    }
}



