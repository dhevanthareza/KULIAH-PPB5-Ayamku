package com.kuliahdhevan.ayamku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    int price = 0;
    private ArrayList<Food> mFoodsData;
    private Context mContext;
    private WeakReference<TextView> mTotalPriceText;
    FoodAdapter(Context context, ArrayList<Food> foodsData, TextView totalPriceText) {
        this.mFoodsData = foodsData;
        this.mContext = context;
        this.mTotalPriceText = new WeakReference<>(totalPriceText);
    }

    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(FoodAdapter.ViewHolder holder, int position) {
        Food currentFood = mFoodsData.get(position);
        holder.bindTo(currentFood);
    }

    @Override
    public int getItemCount() {
        return mFoodsData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mNameText;
        private TextView mPriceText;
        private ImageView mFoodImage;

        ViewHolder(View itemView) {
            super(itemView);
            mNameText = (TextView)itemView.findViewById(R.id.name);
            mPriceText = (TextView)itemView.findViewById(R.id.price);
            mFoodImage = itemView.findViewById(R.id.foodImage);
            itemView.setOnClickListener(this);
        }

        void bindTo(Food currentFood){
            mNameText.setText(currentFood.getName());
            mPriceText.setText(String.valueOf(currentFood.getPrice()));
            Glide.with(mContext).load(currentFood.getImageResource()).into(mFoodImage);
        }

        @Override
        public void onClick(View view) {
            Food currentFood = mFoodsData.get(getAdapterPosition());
            price += currentFood.getPrice();
            mTotalPriceText.get().setText("TOTAL = " + String.valueOf(price));
        }
    }
}
