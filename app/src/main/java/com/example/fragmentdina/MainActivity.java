package com.example.fragmentdina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener,
        Fragmento1.OnFragmentInteractionListener, Fragmento2.OnFragmentInteractionListener, Fragment3.OnFragmentInteractionListener {
    private Button boton1,boton2,boton3 ;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
//WindowManager wm = getWindowManager();
//Display d = wm.getDefaultDisplay();
        boton1 = (Button)findViewById(R.id.btnFragment1);
        boton2 = (Button)findViewById(R.id.btnFragment2);
        boton3 = (Button)findViewById(R.id.btnFragment3);
// Pedimos a los botones responder con el evento Onclick
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnFragment1:
                EditText txtNombre1 = (EditText) findViewById(R.id.txtNombre1);
                String nombre1=txtNombre1.getText().toString();
                Fragmento1 fragment1 = new Fragmento1();
                fragmentTransaction = fragmentManager.beginTransaction();
                Bundle args = new Bundle();
                args.putString("mensaje1", nombre1);
                fragment1.setArguments(args);
                fragmentTransaction.replace(R.id.contenedor, fragment1);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.btnFragment2:
                EditText txtNombre2 = (EditText) findViewById(R.id.txtNombre2);
                String nombre2=txtNombre2.getText().toString();
                Fragmento2 fragment2 = new Fragmento2();
                fragmentTransaction = fragmentManager.beginTransaction();

                Bundle args2 = new Bundle();
                args2.putString("mensaje2", nombre2);
                fragment2.setArguments(args2);
                fragmentTransaction.replace(R.id.contenedor, fragment2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.btnFragment3:
                EditText txtNombre3 = (EditText) findViewById(R.id.txtNombre3);
                EditText txtNombre31 = (EditText) findViewById(R.id.txtNombre31);
                double nombre3=Double.parseDouble(txtNombre3.getText().toString());
                double nombre31=Double.parseDouble(txtNombre31.getText().toString());
                Fragment3 fragment3 = new Fragment3();
                fragmentTransaction = fragmentManager.beginTransaction();

                Bundle args3 = new Bundle();
                args3.putString("mensaje3",  ""+Math.log(nombre3+nombre31));
                fragment3.setArguments(args3);
                fragmentTransaction.replace(R.id.contenedor, fragment3);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;

        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() > 1)
            fragmentManager.popBackStack();
        else{
            finish();
        }
    }


}