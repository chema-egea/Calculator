package chema.egea.canales.calculadora;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created by chema on 11/10/2015.
 */
public class MiServicioBind extends Service
{

    private final IBinder binder = new MiBinder();

    @Override
    public IBinder onBind(Intent intent)
    {
        return binder;
    }

    public class MiBinder extends Binder
    {
        MiServicioBind getService()
        {
            return MiServicioBind.this;
        }
    }
    //Operaciones
    public float sumar(float op1, float op2)
    {
        return (op1+op2);
    }
    public float restar(float op1, float op2)
    {
        return (op1-op2);
    }
    public float multiplicar(float op1, float op2)
    {
        return (op1*op2);
    }
    public float dividir(float op1, float op2)
    {
        return (op1/op2);
    }



}
