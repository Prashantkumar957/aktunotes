package com.prashantkumar957.aktunotes.Recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prashantkumar957.aktunotes.DetailsActivity;
import com.prashantkumar957.aktunotes.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {

    Context context;
    ArrayList <Model> subjectList;

    public Adapter(Context context, ArrayList<Model> subjectList) {
        this.context = context;
        this.subjectList = subjectList;
    }

    @NonNull
    @Override
    public Adapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.viewHolder holder, int position) {

        Model model =subjectList.get(position);
        holder.subject.setText(model.getSubject());

        holder.itemView.setOnClickListener(v->{
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("subject",model.getSubject());
            intent.putExtra("pdfLink",model.getPdfLink());
            context.startActivity(intent);


        });

    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView subject;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            subject = itemView.findViewById(R.id.subject);
        }
    }
}
