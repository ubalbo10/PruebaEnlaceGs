package com.example.pruebaenlacegs;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.pruebaenlacegs.clases.Cliente;


public class AgregarFragment extends Fragment {


    Button aceptar;
    Button limpiar;
    EditText nombres;
    EditText apellidos;
    EditText DUI;
    EditText NIT;
    EditText direccion;
    EditText telefono;
    EditText correo;
    ClientesDatabase db;

    public AgregarFragment() {
        // Required empty public constructor
    }

    public static AgregarFragment newInstance(String param1, String param2) {
        AgregarFragment fragment = new AgregarFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
        db = Room.databaseBuilder(requireActivity(),
                ClientesDatabase.class, "database-clientes1").
                allowMainThreadQueries().build();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View vista=inflater.inflate(R.layout.fragment_agregar, container, false);
        nombres=vista.findViewById(R.id.editnombres);
        apellidos=vista.findViewById(R.id.editapellidos);
        DUI=vista.findViewById(R.id.editdui);
        NIT=vista.findViewById(R.id.editnit);
        direccion=vista.findViewById(R.id.editdireccion);
        telefono=vista.findViewById(R.id.edittelefono);
        correo=vista.findViewById(R.id.editcorreo);
        aceptar=vista.findViewById(R.id.button_aceptar_editarCliente);
        limpiar=vista.findViewById(R.id.button_limpiar_editarCliente);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String dui=DUI.getText().toString();
                 String nombre=nombres.getText().toString();
                 String apellido=apellidos.getText().toString();
                 String nit=NIT.getText().toString();
                 String direc=direccion.getText().toString();
                 String corre=correo.getText().toString();
                 String tel=telefono.getText().toString();
                Log.i("estoy","aquiantes");

                if(nombre.equals("")|| apellido.equals("")|| dui.equals("")|| direc.equals("")
                        || nit.equals("")|| corre.equals("")|| tel.equals("")){


                    Toast.makeText(requireActivity(),"Existen campos vacios verifique",Toast.LENGTH_SHORT).show();

                }else if(dui.toCharArray().length<8|| telefono.getText().toString().toCharArray().length<8) {
                    Toast.makeText(requireActivity(),"verifique su Numero de dui o su numero de telefono ",Toast.LENGTH_LONG).show();
                    }else{

                        Cliente cliente=new Cliente(Integer.parseInt(dui),nombre,apellido,nit,direc,tel,corre);
                        try {
                            //  Block of code to try
                            db.clienteDao().insertCliente(cliente);
                            Toast.makeText(requireActivity(),"Cliente agregado",Toast.LENGTH_SHORT).show();
                            Limpiar();

                        }
                        catch(Exception e) {
                            //  Block of code to handle errors
                            Toast.makeText(requireActivity(),"Cliente duplicado",Toast.LENGTH_LONG).show();
                        }



                    }
                }


        });
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Limpiar();


            }
        });

        return vista;
    }

    void Limpiar(){
        nombres.setText("");
        apellidos.setText("");
        DUI.setText("");
        NIT.setText("");
        direccion.setText("");
        telefono.setText("");
        correo.setText("");
    }


}