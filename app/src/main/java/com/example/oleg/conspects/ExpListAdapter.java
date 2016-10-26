package com.example.oleg.conspects;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by root on 26.10.16.
 */
public class ExpListAdapter extends BaseExpandableListAdapter {

    private ArrayList<ArrayList<String>> mGroups;
    private Context mContext;

    public ExpListAdapter(Context context, ArrayList<ArrayList<String>> groups) {
        mGroups = groups;
        mContext = context;
    }

    @Override
    public int getGroupCount() {
        return mGroups.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return mGroups.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return mGroups.get(i);
    }

    @Override
    public Object getChild(int i, int j) {
        return mGroups.get(i).get(j);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int j) {
        return j;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_group_view, null);
        }
        //if b == 1 theme is expanded
        TextView text = (TextView)view.findViewById(R.id.theme_group_text);
        text.setText("Group" + Integer.toString(i));
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.subtheme_layout, null);
        }
        TextView text = (TextView)view.findViewById(R.id.subtheme);
        text.setText(mGroups.get(i).get(i1));
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
