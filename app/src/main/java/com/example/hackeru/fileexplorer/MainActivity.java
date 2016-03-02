package com.example.hackeru.fileexplorer;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File rootExternal = Environment.getExternalStorageDirectory();
        ListView listView = (ListView) findViewById(R.id.listView);

        File[] files = rootExternal.listFiles();
        ArrayList<File> filesArrayList = new ArrayList<>(files.length);
        for (int i = 0; i < files.length; i++)
            filesArrayList.add(files[i]);


//        ArrayAdapter<File> adapter = new ArrayAdapter<File>(this,android.R.layout.simple_list_item_1,files);
        FilesAdapter adapter = new FilesAdapter(this, filesArrayList);
        listView.setAdapter(adapter);
    }
}
