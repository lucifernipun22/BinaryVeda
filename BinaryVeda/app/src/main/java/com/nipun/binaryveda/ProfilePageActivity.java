package com.nipun.binaryveda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.nipun.binaryveda.adapter.GridImageAdapter;
import com.nipun.binaryveda.adapter.MyAdapter;
import com.nipun.binaryveda.data.GridModel;

import java.util.ArrayList;

public class ProfilePageActivity extends AppCompatActivity {

    RecyclerView gridRecyclerView;
    private GridImageAdapter gridImageAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        initValue();

    }

    /**
     * Initialize th variable here
     */
    public void initValue(){
        //initialize recyclerView here
        gridRecyclerView = findViewById(R.id.gridRecyclerView);

        //create a object of arraylist
        ArrayList<GridModel> gridModelArrayList = new ArrayList<GridModel>();

        // add the item into the list of images.
        gridModelArrayList.add(new GridModel(R.drawable.painting3));
        gridModelArrayList.add(new GridModel(R.drawable.painting4));
        gridModelArrayList.add(new GridModel(R.drawable.painting5));
        gridModelArrayList.add(new GridModel(R.drawable.painting6));
        gridModelArrayList.add(new GridModel(R.drawable.painting7));
        gridModelArrayList.add(new GridModel(R.drawable.painting8));
        gridModelArrayList.add(new GridModel(R.drawable.painting1));
        gridModelArrayList.add(new GridModel(R.drawable.painting2));

        gridImageAdapter = new GridImageAdapter(gridModelArrayList,ProfilePageActivity.this);

        //set gridLayout here
        GridLayoutManager glm = new GridLayoutManager(ProfilePageActivity.this,2);
        gridRecyclerView.setLayoutManager(glm);

        //set adapter here
        gridRecyclerView.setAdapter(gridImageAdapter);
        gridImageAdapter.notifyDataSetChanged();
    }
}