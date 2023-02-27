package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


class MyAdapter extends BaseAdapter{
    ArrayList<String> arr;
    LayoutInflater layoutInflater;


    MyAdapter(Activity act)
    {
        arr = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            arr.add("My Item list " + i + " value");

        layoutInflater = act.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int i) {
        return arr.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    class ViewHolder{
        TextView textView;
        ImageView imageView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vi = view;
        ViewHolder viewHolder;
        if(vi == null)
        {
            // create  viewholder object for list_rowcell View.
            // inflate list_rowcell for each row
            viewHolder = new ViewHolder();
            vi = layoutInflater.inflate(R.layout.list_row_item,null);
            viewHolder.textView = (TextView) vi.findViewById(R.id.my_row_text_view);
            viewHolder.imageView = (ImageView)vi.findViewById(R.id.my_image_view);
            /*We can use setTag() and getTag() to set and get custom objects as per our requirement.
            The setTag() method takes an argument of type Object, and getTag() returns an Object.*/
            vi.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) vi.getTag();
        }

        viewHolder.textView.setText(arr.get(i));
        viewHolder.imageView.setImageResource(R.drawable.birthcertificate);

        return vi;
    }
}
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> arr = new ArrayList<String>();
        for(int i = 0; i < 20; i++)
        {
            arr.add("Item of adapter");
        }

        MyAdapter adapter = new MyAdapter(this);
        ListView listView = (ListView) findViewById(R.id.my_list_view);
        listView.setAdapter(adapter);
    }
}