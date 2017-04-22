package com.example.android.takehomeassignment11_lindsayb;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by cmltdstudent on 4/17/17.
 */

public class CollegeViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView collegeNameView;
    private TextView collegeInfoView;
    private ImageView collegePhotoView;
    private Context context;

    //activity inherits from context
    public CollegeViewHolder(View itemView, final Context context) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        collegeNameView = (TextView) itemView.findViewById(R.id.college_name);
        collegeInfoView = (TextView) itemView.findViewById(R.id.college_info);
        collegePhotoView = (ImageView) itemView.findViewById(R.id.college_photo);
        this.context = context;
    }

    //swaps out the images, similar to rotator
    public void bind(final College college) {
        collegeNameView.setText(college.name);
        collegeInfoView.setText(college.info);
        collegePhotoView.setImageResource(college.photoId);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                College m = new College(college.name, college.info, college.photoId);
                Intent collegeIntent = new Intent(context, CollegeInfo.class);
                collegeIntent.putExtra(KEYS.COLLEGE, m);
                context.startActivity(collegeIntent);

                Toast.makeText(context, collegeNameView.getText(), Toast.LENGTH_SHORT).show();


            }
        });
    }
}