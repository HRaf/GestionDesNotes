package com.example.gestionotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ModulesAdapter extends ArrayAdapter<Module> {
    public ModulesAdapter(Context context, ArrayList<Module> modules) {
        super(context, 0, modules);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Module module = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.modules_notes, parent, false);
        }
        // Lookup view for data population
        TextView moduleName = (TextView) convertView.findViewById(R.id.moduleName);
        TextView moduleNote = (TextView) convertView.findViewById(R.id.moduleNote);
        // Populate the data into the template view using the data object
        moduleName.setText(module.getModuleName());
        moduleNote.setText(""+module.getModuleNote());
        // Return the completed view to render on screen
        return convertView;
    }
}