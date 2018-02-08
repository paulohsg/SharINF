package com.example.sharinf;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Anny Karolline on 08/02/2018.
 */

public class AlunoAdapter extends ArrayAdapter<Aluno> {

    Context context;
    int layoutResourceId;
    Aluno data[] = null;

    public AlunoAdapter(Context context, int layoutResourceId, Aluno[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        AlunoHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new AlunoHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);

            row.setTag(holder);
        }
        else
        {
            holder = (AlunoHolder)row.getTag();
        }

        Aluno weather = data[position];
        holder.txtTitle.setText(weather.getTitle());
        holder.imgIcon.setImageResource(weather.getIcon());

        return row;
    }

    static class AlunoHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
    }

}
