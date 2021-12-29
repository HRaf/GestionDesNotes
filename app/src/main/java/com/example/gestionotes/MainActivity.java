package com.example.gestionotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    EditText note;
    Button saisir;
    TextView moyenne;
    double sum = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner);
        note=findViewById(R.id.note_entry);
        saisir=findViewById(R.id.saisir);
        moyenne=findViewById(R.id.moyenne);
        //handle spinner
        String[] modules = { "Maths", "Chemistry", "Physics", "English", "Computer science"};
        spinner.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,modules);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner.setAdapter(aa);
        ArrayList<Module> arrayOfModules = new ArrayList<>();
        ModulesAdapter adapter = new ModulesAdapter(getApplicationContext(),arrayOfModules);
        saisir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String Note=note.getText().toString();
                String ModuleName=spinner.getSelectedItem().toString();
                // Construct the data source
                if(!TextUtils.isEmpty(Note)) {
                    Module newModule = new Module(ModuleName, Double.parseDouble(Note));
                    adapter.add(newModule);
                    ArrayList<Double> notes = new ArrayList<>();
                    notes.add(Double.parseDouble(Note));

                    for (int i = 0; i < notes.size(); i++)
                        sum = sum + notes.get(i);

                    // Attach the adapter to a ListView
                    ListView listView = (ListView) findViewById(R.id.list);
                    listView.setAdapter(adapter);
                    //adapter.notifyDataSetChanged();
                    Integer ModuleCount = adapter.getCount();
                    Double Moyenne = sum / ModuleCount;
                    moyenne.setText("La Moyenne : " + Moyenne);
                }else{
                    Toast.makeText(MainActivity.this, "Vous devez inserer une note pour ce module !", Toast.LENGTH_SHORT).show();
                }


            }
        });






    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}