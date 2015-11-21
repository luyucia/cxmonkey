package com.example.luyu.demo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;

import cat.framework.requestqueue.CatRequestQueue;

/**
 * Created by luyu on 2015/11/18.
 */
public class MyListAdapter extends BaseAdapter {

    public final class ViewHolder{
        public TextView name;
    }

    private LayoutInflater inflater;

    private ArrayList itemList = null;

    public MyListAdapter(Context context)
    {
        this.inflater = LayoutInflater.from(context);

        RequestQueue rq= CatRequestQueue.getInstance(context.getApplicationContext()).getRequestQueue();
        Request req = new StringRequest("http://admin.510wifi.com/dim/province", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                System.out.println(s);
                Log.d("demo", s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("demo",volleyError.getMessage());
            }
        });
        rq.add(req);
    }



    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView==null){
            convertView =   inflater.inflate(R.layout.main_list,null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();

        }
        holder.name.setText("Asdfsdf");
        return convertView;
    }
}


