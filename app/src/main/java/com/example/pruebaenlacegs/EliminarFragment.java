package com.example.pruebaenlacegs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pruebaenlacegs.clases.Cliente;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EliminarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EliminarFragment extends Fragment {

    Button aceptar;

    EditText buscar;
    Button aceptarBuscar;

    EditText nombres;
    EditText apellidos;
    EditText DUI;
    EditText NIT;
    EditText direccion;
    EditText telefono;
    EditText correo;
    ClientesDatabase db;
    Cliente cliente;


    public EliminarFragment() {
        // Required empty public constructor
    }

    public static EliminarFragment newInstance(String param1, String param2) {
        EliminarFragment fragment = new EliminarFragment();
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
        View vista=inflater.inflate(R.layout.fragment_eliminar,container,false);
        aceptarBuscar=vista.findViewById(R.id.button_eliminar);
        buscar=vista.findViewById(R.id.edit_buscardui);

        nombres=vista.findViewById(R.id.edit_editarnombres);
        apellidos=vista.findViewById(R.id.edit_editarapellidos);
        DUI=vista.findViewById(R.id.edit_editardui);
        NIT=vista.findViewById(R.id.edit_editarnit);
        direccion=vista.findViewById(R.id.editd_editardireccion);
        telefono=vista.findViewById(R.id.edit_editartelefono);
        correo=vista.findViewById(R.id.edit_editarcorreo);
        aceptar=vista.findViewById(R.id.button_aceptar_eliminarCliente);
        //limpiar=vista.findViewById(R.id.button_limpiar_eliminarCliente);

        aceptarBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dui=buscar.getText().toString();
                cliente=db.clienteDao().getCliente(dui);
                if(null == cliente){
                    Toast.makeText(requireActivity(),"no se encontro cliente",Toast.LENGTH_LONG).show();
                }else {

                    nombres.setText(cliente.getNombres());
                    apellidos.setText(cliente.getApellidos());
                    DUI.setText(cliente.getDUI()+"");
                    NIT.setText(cliente.getNIT());
                    direccion.setText(cliente.getDireccion());
                    telefono.setText(cliente.getTelefono());
                    correo.setText(cliente.getCorreo());
                }
            }
        });

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cliente clienteEditado=new Cliente(Integer.parseInt(DUI.getText().toString()),nombres.getText().toString(),
                        apellidos.getText().toString(),NIT.getText().toString(),direccion.getText().toString()
                        ,telefono.getText().toString(),correo.getText().toString());
                db.clienteDao().deleteCliente(clienteEditado);
                Toast.makeText(requireActivity(),"Cliente eliminado",Toast.LENGTH_LONG).show();
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