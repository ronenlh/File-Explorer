package com.example.hackeru.fileexplorer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by hackeru on 29/02/2016.
 */
public class FilesAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<File> files;

    public FilesAdapter(Context context, ArrayList<File> files) {
        this.files = files;
        this.context = context;
    }

    @Override
    public int getCount() {
        return files.size();
    }

    @Override
    public File getItem(int position) {
        return files.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = null;
        Holder holder;

        if(convertView == null) {
            holder = new Holder();
            row = inflater.inflate(R.layout.file_or_folder, null);

            holder.imageView = (ImageView) row.findViewById(R.id.imageView);
            holder.textView = (TextView) row.findViewById(R.id.textView);
            row.setTag(holder);
        } else {
            row = convertView;
            holder = (Holder) row.getTag();
        }

        holder.textView.setText(((File)getItem(position)).getName());
        holder.imageView.setImageResource(R.drawable.foldericon);
        return row;
    }

    private class Holder {
        ImageView imageView;
        TextView textView;
    }
}
