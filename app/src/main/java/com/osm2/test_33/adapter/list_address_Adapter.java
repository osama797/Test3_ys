package com.osm2.test_33.adapter;

/**
 * Created by Administrator on 10/18/2019.
 */


import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.widget.ImageView;
        import android.widget.TextView;

import com.osm2.test_33.R;
import com.osm2.test_33.model.List_Address;

import java.util.ArrayList;


public class list_address_Adapter extends RecyclerView.Adapter<list_address_Adapter.ExampleViewHolder> {
    private ArrayList<List_Address> mExampleList ;

    private OnItemClickListener mListener;
    Context contexts;

    public interface OnItemClickListener {
        void onItemClick(int posistion,View view);

    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public list_address_Adapter(ArrayList<List_Address> exampleList) {
        mExampleList = exampleList;
}



    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView name_address;

      //  private final Context context;
        public ExampleViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView2);
            name_address = itemView.findViewById(R.id.name_address);

            // context = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position,v);
                        }
                    }
                }
            });


        }
    }



    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_product_adress, parent, false);

        //call custom item and connect it with holder
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);//
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        List_Address currentItem = mExampleList.get(position);

        holder.mImageView.setImageResource(currentItem.getImg_address());
        holder.name_address.setText(currentItem.getName_address());


    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


}
