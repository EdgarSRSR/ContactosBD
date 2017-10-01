package com.solrom.edgar.contactosbd.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.solrom.edgar.contactosbd.R;
import com.solrom.edgar.contactosbd.adapter.ContactoAdaptador;
import com.solrom.edgar.contactosbd.pojo.Contacto;
import com.solrom.edgar.contactosbd.presentador.IRecyclerViewFragmentPresenter;
import com.solrom.edgar.contactosbd.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by edgarsr on 30/09/17.
 */

public class RecyclerViewFragment extends android.support.v4.app.Fragment implements  IRecyclerViewFragmentView{
    private ArrayList<Contacto> contactos;
    private RecyclerView rvContactos;
    private IRecyclerViewFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvContactos = (RecyclerView) v.findViewById(R.id.rvContactos);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this, 2);

        //listaContactos.setLayoutManager(llm);


        return v;
    }

    /*
    public ContactoAdaptador adaptador;
        public void inicializarAdaptador(){
            adaptador = new ContactoAdaptador(contactos, getActivity());
            listaContactos.setAdapter(adaptador);
        }*/


    /*
    public void inicializarListaContactos(){

        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.kazakhstan,"Edgar Solis", "77779999", "edgar@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.kyrgyzstan, "Don Barredora","44445555", "plowking@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.tajikistan, "Perro Perrovich", "22223333", "bobs_burgerz@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.uzbekistan, "Boaty McBoatface", "77776666", "2dank4life@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.turkmenistan, "Super Hans", "33331111", "big_beatz@gmail.com", likes));

    }*/

    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvContactos.setLayoutManager(llm);

    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());

        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        rvContactos.setAdapter(adaptador);

    }
}