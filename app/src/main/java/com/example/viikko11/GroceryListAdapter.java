package com.example.viikko11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryViewHolder>{

    private Context context;
    private ArrayList<Grocery> groceries = new ArrayList<>();

    public GroceryListAdapter(Context context, ArrayList<Grocery> groceries) {
        this.context = context;
        this.groceries = groceries;
    }

    @NonNull
    @Override


    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GroceryViewHolder(LayoutInflater.from(context).inflate(R.layout.groceryview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, int position) {
        holder.textGroceryName.setText(groceries.get(position).getName());
        holder.textGroceryNote.setText(groceries.get(position).getNote());
        holder.editTextGroceryNote.setText(groceries.get(position).getNote());

        holder.imageDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getAdapterPosition();
                ListGrocery.getInstance().removeGrocery(groceries.get(pos).getName());
                notifyItemRemoved(pos);
            }
        });
        holder.imageEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getAdapterPosition();
                if(holder.editTextGroceryNote.getVisibility() == View.VISIBLE){
                    Grocery grocery = ListGrocery.getInstance().getGroceryByName(holder.textGroceryName.getText().toString());
                    grocery.setNote(holder.editTextGroceryNote.getText().toString());
                    holder.editTextGroceryNote.setVisibility(View.GONE);
                    notifyDataSetChanged();


                }else{
                    holder.editTextGroceryNote.setVisibility(View.VISIBLE);
                }
            }
        });





    }

    @Override
    public int getItemCount() {
        return groceries.size();
    }
}
