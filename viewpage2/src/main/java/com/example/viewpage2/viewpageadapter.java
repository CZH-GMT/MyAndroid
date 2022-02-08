package com.example.viewpage2;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class viewpageadapter extends RecyclerView.Adapter<viewpageadapter.ViewpageHodler> {

    private List<String> title=new ArrayList<>();

    private List<Integer> colors=new ArrayList<>();

    public viewpageadapter(){
        title.add("1");
        title.add("2");
        title.add("3");
        title.add("4");
        title.add("5");
        title.add("6");
        title.add("7");
        title.add("8");

        colors.add(R.color.white);
        colors.add(R.color.black);
        colors.add(R.color.teal_700);
        colors.add(R.color.teal_200);
        colors.add(R.color.purple_700);
        colors.add(R.color.purple_200);
        colors.add(R.color.white);
        colors.add(R.color.white);
    }



    @NonNull
    @Override
    public ViewpageHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewpageHodler(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpage_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewpageHodler holder, int position) {
        holder.text.setText(title.get(position));
        holder.relativeLayout.setBackgroundResource(colors.get(position));

    }


    @Override
    public int getItemCount() {
        return 8;
    }

    class ViewpageHodler extends RecyclerView.ViewHolder {

        private TextView text;
        private RelativeLayout relativeLayout;
        public ViewpageHodler(@NonNull View itemView) {
            super(itemView);

            relativeLayout=itemView.findViewById(R.id.relativelayout);
            text = itemView.findViewById(R.id.text);
        }
    }
}
