package com.aroman.taqwa;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Catatan extends AppCompatActivity {
    SQLiteDatabase myDB = null;
    String TableName = "Catatan";
    String dID = "", dJudul = "", dIsi = "";
    TextView DataID, DataJudul, DataIsi;
    Button btnEdit, btnSimpan, btnHapus;
    EditText ID, Judul, Isi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catatan);

        DataID = findViewById(R.id.DataID);
        DataJudul = findViewById(R.id.DataJudul);
        DataIsi = findViewById(R.id.DataIsi);

        btnSimpan = findViewById(R.id.btnSimpan);
        btnEdit = findViewById(R.id.btnEdit);
        btnHapus = findViewById(R.id.btnHapus);

        ID = findViewById(R.id.ID);
        Judul = findViewById(R.id.Judul);
        Isi = findViewById(R.id.Isi);

        createDB();
        tampilData();

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpan();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit();
            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hapus();
            }
        });
    }

    public void clearField(){
        ID.setText("");
        Judul.setText("");
        Isi.setText("");
    }

    private void createDB(){
        try {
            myDB = this.openOrCreateDatabase("CATATAN",MODE_PRIVATE,null);
            myDB.execSQL("CREATE TABLE IF NOT EXISTS " + TableName + "(ID VARCHAR PRIMARY KEY, JUDUL VARCHAR, ISI VARCHAR);");
        }
        catch (Exception e) {
        }
    }

    public void tampilData(){
        try {
            dID = "";
            dJudul = "";
            dIsi = "";
            clearField();
            Cursor c = myDB.rawQuery("SELECT * FROM " + TableName, null);
            int col1 = c.getColumnIndex("ID");
            int col2 = c.getColumnIndex("JUDUL");
            int col3 = c.getColumnIndex("ISI");
            c.moveToFirst();

            if (c != null){
                do {
                    String ID = c.getString(col1);
                    String Judul = c.getString(col2);
                    String Isi = c.getString(col3);
                    dID = dID + ID + "\n";
                    dJudul = dJudul + Judul + "\n";
                    dIsi = dIsi + Isi + "\n";
                }
                while (c.moveToNext());
            }
            DataID.setText(dID);
            DataJudul.setText(dJudul);
            DataIsi.setText(dIsi);
        }
        catch (Exception e){
            DataID.setText(dID);
            DataJudul.setText(dJudul);
            DataIsi.setText(dIsi);
        }
    }

    private void simpan() {
        myDB.execSQL("INSERT INTO " + TableName + " Values('" + ID.getText() + "','" + Judul.getText() + "','" + Isi.getText() + "');");
        tampilData();
    }

    private void edit() {
        myDB.execSQL("UPDATE " + TableName + " Set NAMA = '"+ ID.getText() +"', ALAMAT = '"+ Judul.getText() +"' Where NIM = '"+ Isi.getText() +"';");
        tampilData();
    }

    private void hapus() {
        myDB.execSQL("DELETE FROM " + TableName + " Where ID = '" + ID.getText() + "';");
        tampilData();

    }

}