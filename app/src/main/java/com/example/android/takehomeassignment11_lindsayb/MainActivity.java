package com.example.android.takehomeassignment11_lindsayb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<College> colleges;
    private CollegeAdapter collegeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        collegeAdapter = new CollegeAdapter(colleges, this);
        recyclerView.setAdapter(collegeAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_item_save:
                Toast.makeText(this, "Save Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_item_setting:
                Toast.makeText(this, "Setting Clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addRandomCollege(View view) {
        colleges.add(getRandomCollege());
        collegeAdapter.notifyDataSetChanged();
    }

    private void initialData() {
        colleges = new ArrayList<>();
        colleges.add(new College("The College of New Jersey", "Ewing, NJ", R.drawable.tcnj));
        colleges.add(new College("Columbia University", "New York NY", R.drawable.columbia));
        colleges.add(new College("Montclair University", "Montclair, NJ", R.drawable.montclair));
    }

    private College getRandomCollege() {
        int num = (int) (Math.random() * 3);
        if (num == 0)
            return new College ("The College of New Jersey", "Ewing, NJ", R.drawable.tcnj);
        else if (num == 1)
            return new College("Columbia University", "New York NY", R.drawable.columbia);
        else
            return new College("Montclair University", "Montclair, NJ", R.drawable.montclair);
    }
}