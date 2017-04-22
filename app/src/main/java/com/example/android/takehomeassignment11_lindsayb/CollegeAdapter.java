package com.example.android.takehomeassignment11_lindsayb;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by cmltdstudent on 4/17/17.
 */

public class CollegeAdapter extends RecyclerView.Adapter<CollegeViewHolder> {

    private List<College> colleges;
    private Context context;

    public CollegeAdapter(List<College> colleges, Context context) {
        this.colleges = colleges;
        this.context = context;
    }

    @Override
    public CollegeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_college, parent, false);
        return new CollegeViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(CollegeViewHolder holder, int position) {
        College college = colleges.get(position);
        holder.bind(college);
    }

    @Override
    public int getItemCount() {
        return colleges.size();
    }
}