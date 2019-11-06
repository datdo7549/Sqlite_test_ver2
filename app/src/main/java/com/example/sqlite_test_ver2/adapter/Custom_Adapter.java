package com.example.sqlite_test_ver2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sqlite_test_ver2.R;
import com.example.sqlite_test_ver2.model.Student;

import java.util.ArrayList;

public class Custom_Adapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private ArrayList<Student> studentArrayList;
    private ViewHolder viewHolder;
    public Custom_Adapter(Context context, int resource, ArrayList<Student> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.studentArrayList=objects;
    }
    public class ViewHolder
    {
        TextView id;
        TextView name;
        TextView email;
        TextView address;
        TextView phone;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder=new ViewHolder();
        if(convertView==null)
        {
            convertView=LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item, parent, false);
            viewHolder.id=convertView.findViewById(R.id.id);
            viewHolder.name=convertView.findViewById(R.id.name);
            viewHolder.email=convertView.findViewById(R.id.email);
            viewHolder.address=convertView.findViewById(R.id.address);
            viewHolder.phone=convertView.findViewById(R.id.phone);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        viewHolder.id.setText(studentArrayList.get(position).getmId()+"");
        viewHolder.name.setText(studentArrayList.get(position).getmName());
        viewHolder.email.setText(studentArrayList.get(position).getmEmail());
        viewHolder.address.setText(studentArrayList.get(position).getmAddress());
        viewHolder.phone.setText(studentArrayList.get(position).getmPhone());
        return convertView;
    }
}
