package com.example.finaldamb.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.finaldamb.R;
import com.example.lib.Model.ListenModel;

public class ListenAdapter extends ArrayAdapter<ListenModel.Data> {
    Activity context;
    int resource;

    public ListenAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = (Activity) context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View view = layoutInflater.inflate(this.resource,null);


        TextView txtName = view.findViewById(R.id.Name);

        ListenModel.Data listenModel = getItem(position);
        txtName.setText(listenModel.getName());
        return view;
    }
}
