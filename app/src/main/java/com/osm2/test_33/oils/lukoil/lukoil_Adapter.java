package com.osm2.test_33.oils.lukoil;

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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.osm2.test_33.R;
import com.osm2.test_33.model.Foods;
import com.osm2.test_33.oils.oil_M;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 11/05/2019.
 */

public class lukoil_Adapter  extends RecyclerView.Adapter<lukoil_Adapter.ProductViewHolder> implements Filterable {


    private Context mCtx;
    private List<oil_M> productList;
    private List<oil_M> mDataFiltered;
    // private ArrayList<Foods> xproductList;
    boolean isDark = false;

    public lukoil_Adapter(Context mContext, List<oil_M> productList, boolean isDark) {
        this.mCtx = mContext;
        this.productList = productList;
        this.isDark = isDark;
        mDataFiltered = new ArrayList<>(productList);
        // this.mDataFiltered = productList;
    }

    // public Food_Adapter(Context mCtx, List<Foods> productList,boolean isDark) {
    //  this.mCtx = mCtx;
    //  this.productList = productList;
    //this.mDataFiltered = productList;
    // }

    @NonNull
    @Override
    public lukoil_Adapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_item_oils, null);
        return new lukoil_Adapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(lukoil_Adapter.ProductViewHolder holder, int position) {
        oil_M oilss = productList.get(position);

        //loading the image
        Glide.with(mCtx)
                .load(oilss.getImg_oils())
                .into(holder.img_userss);

        holder.img_userss.setAnimation(AnimationUtils.loadAnimation(mCtx, R.anim.fade_transition_animation));

        holder.containerss.setAnimation(AnimationUtils.loadAnimation(mCtx, R.anim.fade_scale_animation));
        // holder.textViewTitle.setText(foods.getName_food());
        //  holder.textViewTitle.setText(foods.getName_food());
        //  holder.textViewShortDesc.setText(foods.getMark_food());
        //  holder.textViewRating.setText(foods.getSize_food());
        //  holder.textViewPrice.setText(foods.getBar_code());
        //holder.textViewid.setText(foods.getId());
       // holder.tv_active_inactive.setText(productList.get(position).getActive_inactive());
        holder.tv_title.setText(productList.get(position).getName_oil());
        holder.tv_sae.setText(productList.get(position).getSae_oil());
        holder.tv_api.setText(productList.get(position).getApi_oil());
        holder.tv_datess.setText(productList.get(position).getP_oil());

        holder.tv_patch.setText(productList.get(position).getPatch_oil());
        holder.tv_customer.setText(productList.get(position).getCustomer_oil());
        holder.tv_madein.setText(productList.get(position).getMadein_oil());
        holder.tv_size.setText(productList.get(position).getSize_oil());



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
            List<oil_M> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mDataFiltered);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (oil_M item : mDataFiltered) {
                    if (item.getName_oil().toLowerCase().contains(filterPattern)) {
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
        TextView tv_title, tv_sae, tv_api, tv_madein,tv_size,tv_datess,tv_patch,tv_customer;
        ImageView img_userss;
        RelativeLayout containerss;

        public ProductViewHolder(View itemView) {
            super(itemView);

            // textViewTitle = itemView.findViewById(R.id.textViewTitle);
            //  textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            //  textViewRating = itemView.findViewById(R.id.textViewRating);
            //  textViewPrice = itemView.findViewById(R.id.textViewPrice);
            //    textViewid = itemView.findViewById(R.id.textViewid);
            // imageView = itemView.findViewById(R.id.imageView);

            containerss = itemView.findViewById(R.id.ly_count);
            //tv_active_inactive = itemView.findViewById(R.id.txt_active_inactive);
            tv_title = itemView.findViewById(R.id.txt_mark_oil);
            tv_sae = itemView.findViewById(R.id.txt_sae);
            tv_api = itemView.findViewById(R.id.txt_api);
            tv_datess = itemView.findViewById(R.id.txt_date_oil);
            tv_patch = itemView.findViewById(R.id.txt_patch);
            tv_customer = itemView.findViewById(R.id.txt_customer);
            tv_madein = itemView.findViewById(R.id.txt_madein);
            tv_size = itemView.findViewById(R.id.txt_size_oil);
            img_userss = itemView.findViewById(R.id.imageView_oilss);


            if (isDark) {
                setDarkTheme();
            }
        }

        private void setDarkTheme() {

            containerss.setBackgroundResource(R.drawable.card_bg_dark);

        }
    }


}