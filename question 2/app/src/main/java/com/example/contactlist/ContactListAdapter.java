package com.example.contactlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ContactViewHolder> {

    private String[] data;
    private int[] images;
    private int pos;
    public ContactListAdapter(String[] data,int[]images)
    {
        this.data = data;
        this.images = images;
    }
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.contact,parent,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
      String title = data[position];
      holder.textView.setText(title);
      this.pos = position;
      holder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView ;
        TextView textView;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.image);
            textView = (TextView) itemView.findViewById(R.id.name);
            itemView.setOnClickListener(this);
        }


        public void onClick(View v) {

            Intent intent = new Intent(v.getContext(),ContactDetails.class);
            Bundle bundle=new Bundle();
            bundle.putInt("image",images[pos]);
            bundle.putString("name",data[pos]);
            intent.putExtras(bundle);
            v.getContext().startActivity(intent);
        }
    }
}
