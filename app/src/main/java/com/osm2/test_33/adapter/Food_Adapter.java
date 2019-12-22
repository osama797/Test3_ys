package com.osm2.test_33.adapter;

/**
 * Created by Administrator on 10/15/2019.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.osm2.test_33.R;
import com.osm2.test_33.model.Foods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Belal on 10/18/2017.
 */

public class Food_Adapter extends RecyclerView.Adapter<Food_Adapter.ProductViewHolder> implements Filterable {


    private Context mCtx;
    private List<Foods> productList;
    private List<Foods> mDataFiltered ;
   // private ArrayList<Foods> xproductList;


    public Food_Adapter(Context mContext, List<Foods> productList) {
        this.mCtx = mContext;
        this.productList = productList;
        mDataFiltered= new ArrayList<>(productList);
       // this.mDataFiltered = productList;
    }

   // public Food_Adapter(Context mCtx, List<Foods> productList,boolean isDark) {
      //  this.mCtx = mCtx;
      //  this.productList = productList;
        //this.mDataFiltered = productList;
   // }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.row_pro, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Foods foods = productList.get(position);

        //loading the image
        Glide.with(mCtx)
               .load(foods.getImg_food())
               .into(holder.img_user);

       holder.img_user.setAnimation(AnimationUtils.loadAnimation(mCtx,R.anim.fade_transition_animation));

        holder.container.setAnimation(AnimationUtils.loadAnimation(mCtx,R.anim.fade_scale_animation));
       // holder.textViewTitle.setText(foods.getName_food());
      //  holder.textViewTitle.setText(foods.getName_food());
      //  holder.textViewShortDesc.setText(foods.getMark_food());
      //  holder.textViewRating.setText(foods.getSize_food());
      //  holder.textViewPrice.setText(foods.getBar_code());
        //holder.textViewid.setText(foods.getId());
        holder.tv_title.setText(productList.get(position).getName_food());
        holder.tv_content.setText(productList.get(position).getMark_food());
        holder.tv_date.setText(productList.get(position).getSize_food());
        holder.tv_country.setText(productList.get(position).getBar_code());
        holder.tv_number.setText(productList.get(position).getId());

        //holder.img_user.setImageResource(productList.get(position).getImg_food());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Foods> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mDataFiltered);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Foods item : mDataFiltered) {
                    if (item.getMark_food().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            productList.clear();
            productList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };




        class ProductViewHolder extends RecyclerView.ViewHolder {

       // TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice ;
       // ImageView imageView;
       // RelativeLayout container;
       TextView tv_title,tv_content,tv_date,tv_country,tv_number;
        ImageView img_user;
       // RelativeLayout container;
       RelativeLayout container;

        public ProductViewHolder(View itemView) {
            super(itemView);

            // textViewTitle = itemView.findViewById(R.id.textViewTitle);
            //  textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            //  textViewRating = itemView.findViewById(R.id.textViewRating);
            //  textViewPrice = itemView.findViewById(R.id.textViewPrice);
            //    textViewid = itemView.findViewById(R.id.textViewid);
            // imageView = itemView.findViewById(R.id.imageView);

            container = itemView.findViewById(R.id.container);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_content = itemView.findViewById(R.id.tv_description);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_country = itemView.findViewById(R.id.tv_country);
            tv_number = itemView.findViewById(R.id.num);
            img_user = itemView.findViewById(R.id.thumbnail);


        }}


}