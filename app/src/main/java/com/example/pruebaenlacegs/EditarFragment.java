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


public class EditarFragment extends Fragment {


    Button aceptar;
    Button limpiar;

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


    public EditarFragment() {
        // Required empty public constructor
    }

    public static EditarFragment newInstance(String param1, String param2) {
        EditarFragment fragment = new EditarFragment();
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
        View vista=inflater.inflate(R.layout.fragment_editar, container, false);
        aceptarBuscar=vista.findViewById(R.id.button_buscar);
        buscar=vista.findViewById(R.id.edit_buscardui);

        nombres=vista.findViewById(R.id.edit_editarnombres);
        apellidos=vista.findViewById(R.id.edit_editarapellidos);
        DUI=vista.findViewById(R.id.edit_editardui);
        NIT=vista.findViewById(R.id.edit_editarnit);
        direccion=vista.findViewById(R.id.editd_editardireccion);
        telefono=vista.findViewById(R.id.edit_editartelefono);
        correo=vista.findViewById(R.id.edit_editarcorreo);
        aceptar=vista.findViewById(R.id.button_aceptar_editarCliente);
        limpiar=vista.findViewById(R.id.button_limpiar_editarCliente);

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
                //validaciones de campos vacios
                if(nombres.getText().toString().equals("")|| apellidos.getText().toString().equals("")||
                        DUI.getText().toString().equals("")|| direccion.getText().toString().equals("")
                        || NIT.getText().toString().equals("")|| correo.getText().toString().equals("")
                        || telefono.getText().toString().equals("")){


                    Toast.makeText(requireActivity(),"Existen campos vacios verifique",Toast.LENGTH_SHORT).show();
                    //validacion de longitud de los duis
                }else if(DUI.getText().toString().toCharArray().length<9 || telefono.getText().toString().toCharArray().length<8) {
                    Toast.makeText(requireActivity(),"Verifique su numero de dui o su numero de telefono  ",Toast.LENGTH_LONG).show();
                }else {
                    Cliente clienteEditado = new Cliente(Integer.parseInt(DUI.getText().toString()), nombres.getText().toString(),
                            apellidos.getText().toString(), NIT.getText().toString(), direccion.getText().toString()
                            , telefono.getText().toString(), correo.getText().toString());
                    db.clienteDao().updateCliente(clienteEditado);
                    Toast.makeText(requireActivity(), "Cliente actualizado", Toast.LENGTH_LONG).show();
                    Limpiar();
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