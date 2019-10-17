package com.agasmochfauzan.aplikasilatihanstorage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    public static  final String FILENAME= "namefile.txt";
    Button buatFile, ubahFile, bacaFile, deleteFile;
    TextView textbaca;

    @Override
    protected void onCreate(Bundle savedInstanteState) {
        super.onCreate(savedInstanteState);
        setContentView(R.layout.activity_internal);
        buatFile=findViewById(R.id.buttonBuatFile);
        ubahFile=findViewById(R.id.buttonUbahFile);
        bacaFile=findViewById(R.id.buttonBacaFile);
        deleteFile=findViewById(R.id.buttonHapusFile);
        textbaca=findViewById(R.id.textBaca);

        buatFile.setOnClickListener(this);
        ubahFile.setOnClickListener(this);
        bacaFile.setOnClickListener(this);
        deleteFile.setOnClickListener(this);
    }

    void buatfile(){
        String isiFile = "Coba isi data file text";
        File file = new File(getFilesDir(),FILENAME);

        FileOutputStream outputStream = null;
        try{
            file.createNewFile();
            outputStream = new FileOutputStream(file,true);//
            outputStream.write(isiFile.getBytes());//Input text dengan Tipe data Byte(Tadinya String)
            outputStream.flush();//Bersihkan Text Yang Diisi
            outputStream.close();//Tutup text yang diisi
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void onClick(View view) {

    }
}
