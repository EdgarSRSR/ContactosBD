package com.solrom.edgar.contactosbd.db;

import android.content.ContentValues;
import android.content.Context;

import com.solrom.edgar.contactosbd.R;
import com.solrom.edgar.contactosbd.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by edgarsr on 30/09/17.
 */

public class ConstructorContactos {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorContactos(Context context) {

        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos(){



            /*ArrayList<Contacto> contactos = new ArrayList<>();

            contactos.add(new Contacto(R.drawable.kazakhstan,"Edgar Solis", "77779999", "edgar@gmail.com", 5));
            contactos.add(new Contacto(R.drawable.kyrgyzstan, "Don Barredora","44445555", "plowking@gmail.com", 3));
            contactos.add(new Contacto(R.drawable.tajikistan, "Perro Perrovich", "22223333", "bobs_burgerz@gmail.com", 8));
            contactos.add(new Contacto(R.drawable.uzbekistan, "Boaty McBoatface", "77776666", "2dank4life@gmail.com", 9));
            contactos.add(new Contacto(R.drawable.turkmenistan, "Super Hans", "33331111", "big_beatz@gmail.com", 2));

            return contactos;*/
        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return db.obtenerTodosLosContactos();
    }

    public void insertarTresContactos(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Don Barredora");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "44445555");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "plowking@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.kyrgyzstan);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Edgar Solis");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "77779999");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "edgarsolis@lofihiphop.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.kazakhstan);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Super Hans");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "33331111");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "big_beatz@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.turkmenistan);

        db.insertarContacto(contentValues);

    }

    public void darLikeContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }
}
