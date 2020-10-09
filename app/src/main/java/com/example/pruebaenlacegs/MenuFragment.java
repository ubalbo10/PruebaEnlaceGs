package com.example.pruebaenlacegs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import static androidx.navigation.Navigation.findNavController;


public class MenuFragment extends Fragment {


    Button agregar;
    Button listar;
    Button editar;
    Button eliminar;


    public MenuFragment() {
        // Required empty public constructor
    }
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_menu, container, false);
        agregar=vista.findViewById(R.id.button_AgregarCliente);
        editar=vista.findViewById(R.id.button_EditarCliente);
        eliminar=vista.findViewById(R.id.button_EliminarCliente);
        listar=vista.findViewById(R.id.button_ListarClientes);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.action_menuFragment_hacia_agregarFragment);
            }
        });

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.action_menuFragment_hacia_listarClienteFragment);
            }
        });

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.action_menuFragment_hacia_editarFragment);

            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.action_menuFragment_hacia_eliminarFragment);
            }
        });

        //Navigation.findNavController(v).navigate(R.id.mapsFragment);
        return vista;
    }
}