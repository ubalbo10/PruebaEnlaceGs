package com.example.pruebaenlacegs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pruebaenlacegs.adaptadores.AdaptadorCliente;
import com.example.pruebaenlacegs.clases.Cliente;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListarClienteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListarClienteFragment extends Fragment {

    RecyclerView recycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    ClientesDatabase db;
    ArrayList<Cliente> clientes;

    public ListarClienteFragment() {
        // Required empty public constructor
    }

    public static ListarClienteFragment newInstance(String param1, String param2) {
        ListarClienteFragment fragment = new ListarClienteFragment();
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
        clientes= (ArrayList<Cliente>) db.clienteDao().getAll();
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_listar_cliente, container, false);
        recycler=vista.findViewById(R.id.Recycler_clientes);
        //llamar recyclerview//
        llenarRecyclerView();


        return vista;
    }

    void llenarRecyclerView(){
        recycler.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

        recycler.setLayoutManager(layoutManager);
        mAdapter=new AdaptadorCliente(clientes);
        recycler.setAdapter(mAdapter);

    }
}