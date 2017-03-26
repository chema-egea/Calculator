package chema.egea.canales.calculadora;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.chema.calculadora.R;

public class MainActivity extends Activity
{

    MiServicioBind servicio; //La referencia al servicio
    boolean mBound = false;

    private ServiceConnection serviceConnection = new ServiceConnection()
    {
        @Override
        public void onServiceConnected(ComponentName className, IBinder service)
        {
            MiServicioBind.MiBinder binder = (MiServicioBind.MiBinder) service;
            servicio = binder.getService();
            mBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName className)
        {
            servicio = null;
            mBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        // Bind a MiServicioBind
        Intent intent = new Intent(this, MiServicioBind.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }


    public void sumar(View view)
    {
        if (mBound)
        {
            EditText operando1Text = (EditText) findViewById(R.id.operando1);
            EditText operando2Text = (EditText) findViewById(R.id.operando2);
            TextView resultado = (TextView) findViewById(R.id.resultado);

            float operando1;
            float operando2;

            //System.out.println("El operando1 es "+operando1Text.getText().toString()+" y el operando 2 es "+operando2Text.getText().toString());

            if (operando1Text != null && operando2Text != null)
            {
                if(operando1Text.length() != 0 && operando2Text.length() != 0) {
                    String operando1String = operando1Text.getText().toString();
                    String operando2String = operando2Text.getText().toString();

                    operando1 = Float.parseFloat(operando1String);
                    operando2 = Float.parseFloat(operando2String);


                    resultado.setText("" + servicio.sumar(operando1, operando2));
                }
                else
                {
                    resultado.setText("Rellena los dos campos de operacion");
                }
            }
        }
    }
    public void restar(View view)
    {

        if (mBound)
        {
            EditText operando1Text = (EditText) findViewById(R.id.operando1);
            EditText operando2Text = (EditText) findViewById(R.id.operando2);
            TextView resultado = (TextView) findViewById(R.id.resultado);

            float operando1;
            float operando2;

            //System.out.println("El operando1 es "+operando1Text.getText().toString()+" y el operando 2 es "+operando2Text.getText().toString());

            if (operando1Text != null && operando2Text != null)
            {
                if(operando1Text.length() != 0 && operando2Text.length() != 0) {
                    String operando1String = operando1Text.getText().toString();
                    String operando2String = operando2Text.getText().toString();

                    operando1 = Float.parseFloat(operando1String);
                    operando2 = Float.parseFloat(operando2String);

                    resultado.setText("" + servicio.restar(operando1, operando2));
                }
                else
                {
                    resultado.setText("Rellena los dos campos de operacion");
                }
            }
        }

    }
    public void multiplicar(View view)
    {
        if (mBound)
        {
            EditText operando1Text = (EditText) findViewById(R.id.operando1);
            EditText operando2Text = (EditText) findViewById(R.id.operando2);
            TextView resultado = (TextView) findViewById(R.id.resultado);

            float operando1;
            float operando2;

            //System.out.println("El operando1 es "+operando1Text.getText().toString()+" y el operando 2 es "+operando2Text.getText().toString());

            if (operando1Text != null && operando2Text != null)
            {
                if(operando1Text.length() != 0 && operando2Text.length() != 0) {
                    String operando1String = operando1Text.getText().toString();
                    String operando2String = operando2Text.getText().toString();

                    operando1 = Float.parseFloat(operando1String);
                    operando2 = Float.parseFloat(operando2String);


                    resultado.setText("" + servicio.multiplicar(operando1, operando2));
                }
                else
                {
                    resultado.setText("Rellena los dos campos de operacion");
                }
            }
        }
    }
    public void dividir(View view)
    {

        if (mBound)
        {
            EditText operando1Text = (EditText) findViewById(R.id.operando1);
            EditText operando2Text = (EditText) findViewById(R.id.operando2);
            TextView resultado = (TextView) findViewById(R.id.resultado);

            float operando1;
            float operando2;

            //System.out.println("El operando1 es "+operando1Text.getText().toString()+" y el operando 2 es "+operando2Text.getText().toString());

            if (operando1Text != null && operando2Text != null)
            {
                if(operando1Text.length() != 0 && operando2Text.length() != 0) {
                    String operando1String = operando1Text.getText().toString();
                    String operando2String = operando2Text.getText().toString();

                    operando1 = Float.parseFloat(operando1String);
                    operando2 = Float.parseFloat(operando2String);


                    if(operando2!=0) {
                        resultado.setText("" + servicio.dividir(operando1, operando2));
                    }
                    else
                    {
                        resultado.setText("No se puede dividir por 0");
                    }
                }
                else
                {
                    resultado.setText("Rellena los dos campos de operacion");
                }
            }
        }

    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

    }

    @Override
    protected void onStop() {
        super.onStop();
        // Unbind from the service
        if (mBound)
        {
            unbindService(serviceConnection);
            mBound = false;
        }
    }




}
