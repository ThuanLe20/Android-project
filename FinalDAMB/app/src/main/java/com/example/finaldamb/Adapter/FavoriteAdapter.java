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
import com.example.lib.Model.FavoriteModel;


public class FavoriteAdapter extends ArrayAdapter<FavoriteModel.Data> {
    Activity context;
    int resource;

    public FavoriteAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = (Activity) context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View view = layoutInflater.inflate(this.resource,null);

        TextView txtWord = view.findViewById(R.id.txtword);
        TextView txtWord2 = view.findViewById(R.id.txtword2);

        FavoriteModel.Data fwModel = getItem(position);

        txtWord.setText(fwModel.getWord());
        txtWord2.setText(fwModel.getWord2());
        return view;
    }
}
