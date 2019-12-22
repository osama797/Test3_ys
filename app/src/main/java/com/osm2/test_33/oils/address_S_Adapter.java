package com.osm2.test_33.oils;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.osm2.test_33.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 11/02/2019.
 */

public class address_S_Adapter extends RecyclerView.Adapter<address_S_Adapter.ExampleViewHolder> {
    private ArrayList<oil_address_M> mExampleList ;

    private address_S_Adapter.OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int posistion,View view);

    }

    public void setOnItemClickListener(address_S_Adapter.OnItemClickListener listener) {
        mListener = listener;
    }

    public address_S_Adapter(ArrayList<oil_address_M> exampleList) {
        mExampleList = exampleList;
    }



    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
       // public TextView id_address;
        public TextView name_address;
        public ImageView img_S;

        //  private final Context context;
        public ExampleViewHolder(@NonNull View itemView, final address_S_Adapter.OnItemClickListener listener) {
            super(itemView);
            name_address = itemView.findViewById(R.id.name_address);
            //id_address = itemView.findViewById(R.id.id_address);
            img_S=itemView.findViewById(R.id.imageView_S);

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



    @NonNull
    @Override
    public address_S_Adapter.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_oils_adress, parent, false);

        //call custom item and connect it with holder
        address_S_Adapter.ExampleViewHolder evh = new address_S_Adapter.ExampleViewHolder(v, mListener);//
        return evh;
    }

    @Override
    public void onBindViewHolder(address_S_Adapter.ExampleViewHolder holder, int position) {
        oil_address_M currentItem = mExampleList.get(position);


        //holder.id_address.setText(currentItem.getId_single());
        holder.name_address.setText(currentItem.getName_single());
        holder.img_S.setImageResource(currentItem.getImg_address_Single());

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


}
