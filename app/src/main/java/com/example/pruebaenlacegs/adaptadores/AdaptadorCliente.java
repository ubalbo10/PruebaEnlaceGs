package com.example.pruebaenlacegs.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebaenlacegs.R;
import com.example.pruebaenlacegs.clases.Cliente;

import java.util.ArrayList;


public class AdaptadorCliente extends RecyclerView.Adapter<AdaptadorCliente.MyViewHolder> {
    private ArrayList<Cliente> mDataset;


    //manipulamos cada boton del item
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView nombres;
        public TextView apellidos;
        public TextView dui;
        public TextView nit;
        public TextView correo;
        public TextView telefono;



        public MyViewHolder(View v) {
            super(v);
            this.nombres=v.findViewById(R.id.item_nombre);
            this.apellidos=v.findViewById(R.id.item_apellidos);
            this.dui=v.findViewById(R.id.item_dui);
            this.nit=v.findViewById(R.id.item_nit);
            this.correo=v.findViewById(R.id.item_correo);
            this.telefono=v.findViewById(R.id.item_telefono);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdaptadorCliente(ArrayList<Cliente> myDataset) {
        //this.listenerproductos=listener;
        mDataset = myDataset;

    }


    // Create new views (invoked by the layout manager)
    @Override
    public AdaptadorCliente.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_clientes, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.nombres.setText("nombres:"+mDataset.get(position).getNombres());
        holder.apellidos.setText("apellidos:"+mDataset.get(position).getApellidos());
        holder.correo.setText("correo:"+mDataset.get(position).getCorreo());
        holder.telefono.setText("telefono:"+mDataset.get(position).getTelefono());
        holder.dui.setText("DUI:"+mDataset.get(position).getDUI());
        holder.nit.setText("NIT:"+mDataset.get(position).getNIT());




    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
