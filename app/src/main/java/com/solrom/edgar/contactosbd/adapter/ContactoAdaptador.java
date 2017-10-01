package com.solrom.edgar.contactosbd.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.solrom.edgar.contactosbd.DetalleContacto;
import com.solrom.edgar.contactosbd.R;
import com.solrom.edgar.contactosbd.db.ConstructorContactos;
import com.solrom.edgar.contactosbd.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by edgarsr on 30/09/17.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;
    Activity activity;

    public  ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){// construye la lista de contactos
        this.contactos = contactos;
        this.activity = activity;

    }


    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);// le da vida al layout asociandolo a nuestro recycler view
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ContactoViewHolder contactoViewHolder, int position) {
        //vamos a pasar la lista de contactos para setear los valores de los objetos de la lista de contactos, va iterando
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombre.setText(contacto.getNombre());
        contactoViewHolder.tvTelefono.setText(contacto.getTelefono());
        contactoViewHolder.tvLikes.setText(String.valueOf(contacto.getLikes()) + " " + activity.getString(R.string.likes));

        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){//mensaje Toast que muestra nombre del contacto al dar click en la foto
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);//colocamos el intent para que nos lleve a la actividad DetalleContacto
                intent.putExtra("nombre", contacto.getNombre());
                intent.putExtra("telefono", contacto.getTelefono());
                intent.putExtra("email", contacto.getEmail());
                activity.startActivity(intent);
            }
        });
        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener(){// al tocar al boton de like va a aparecer un toast
            @Override
            public void onClick(View v){
                Toast.makeText(activity, "Diste like a " + contacto.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorContactos constructorContactos = new ConstructorContactos(activity);
                constructorContactos.darLikeContacto(contacto);
                contactoViewHolder.tvLikes.setText(constructorContactos.obtenerLikesContacto(contacto) + " " + activity.getString(R.string.likes));
            }
        });


    }

    @Override
    public int getItemCount() {//cantidad de elementos que contiene mi lista

        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvTelefono;
        private ImageButton btnLike;
        private TextView tvLikes;


        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefono = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);
        }
    }
}
