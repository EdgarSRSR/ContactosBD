package com.solrom.edgar.contactosbd.fragment;

import com.solrom.edgar.contactosbd.adapter.ContactoAdaptador;
import com.solrom.edgar.contactosbd.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by edgarsr on 30/09/17.
 */

public interface IRecyclerViewFragmentView {
    public void generarLinearLayoutVertical();

    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);

    void inicializarAdaptadorRV(ContactoAdaptador adaptador);
}
