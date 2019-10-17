package com.agasmochfauzan.aplikasilatihanstorage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

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

    void buatFile(){
        String isiFile = "Coba isi data file text";
        File file = new File(getFilesDir(),FILENAME);

        FileOutputStream outputStream = null;
        try{
            file.createNewFile();
            outputStream = new FileOutputStream(file,true);//
            outputStream.write(isiFile.getBytes());//Input text dengan Konversi Tipe Data(String ke Byte)
            outputStream.flush();//Bersihkan Text Yang Diisi
            outputStream.close();//Tutup text yang diisi
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    void ubahFile(){
        String ubah = "Update Isi Data File Text";
        File file = new File(getFilesDir(),FILENAME);

        FileOutputStream outputStream =null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file,false);
            outputStream.write(ubah.getBytes());//Input text dengan Konversi Tipe Data(String ke Byte)
            outputStream.flush();//Bersihkan Text Yang Diisi
            outputStream.close();//Tutup text yang diisi

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void bacaFile(){
        File sdcard = getFilesDir();
        File file = new File(sdcard,FILENAME);

        if(file.exists()){ //Mengecek Isi File
            StringBuilder text = new StringBuilder();//Penampung dan memibikin object "StringBuilder"

            try {
                BufferedReader br = new BufferedReader(new FileReader(file));

                String line=br.readLine();

                while (line != null) //Line mengunalang jika tidak null
                {
                    text.append(line);
                    line=br.readLine();//Melakukan Pembacaan
                }
                br.close();//Tutup text yang diisi
            }catch (IOException e)
            {
                System.out.println("Error"+e.getMessage());
            }
            textbaca.setText(text.toString());
        }
    }

    void deleteFile(){
//        File sdcard = getFilesDir();
        File file = new File(getFilesDir(),FILENAME);

        if (file.exists())//Jika file ada
        {
            file.delete();//{Perintah Hapus
        }
    }

    public void jalakanPerintah(int id)//Membutuhkan varibel id yang mana yang dijalakan
    {switch (id){
        case R.id.buttonBuatFile:
            buatFile();
            break;
        case R.id.buttonBacaFile:
            bacaFile();
            break;
        case R.id.buttonHapusFile:
            deleteFile();
            break;
        case R.id.buttonUbahFile:
            ubahFile();
            break;
    }

    }
    @Override
    public void onClick(View view) {
        jalakanPerintah (view.getId());

    }
}
