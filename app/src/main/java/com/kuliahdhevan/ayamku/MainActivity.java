package com.kuliahdhevan.ayamku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Food> mSportsData;
    private FoodAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mSportsData = new ArrayList<>();
        mAdapter = new FoodAdapter(this, mSportsData, findViewById(R.id.totalPrice));
        mRecyclerView.setAdapter(mAdapter);
        initializeData();
    }

    private void initializeData() {
        String[] foodsName = getResources().getStringArray(R.array.foods_name);
        String[] foodsPrice = getResources().getStringArray(R.array.foods_price);
        TypedArray foodImagesResources =
                getResources().obtainTypedArray(R.array.foods_images);
        mSportsData.clear();
        for(int i=0;i<foodsName.length;i++){
            mSportsData.add(new Food(foodsName[i], Integer.parseInt(foodsPrice[i]), foodImagesResources.getResourceId(i, 0)));
        }
        foodImagesResources.recycle();
        mAdapter.notifyDataSetChanged();
    }
}