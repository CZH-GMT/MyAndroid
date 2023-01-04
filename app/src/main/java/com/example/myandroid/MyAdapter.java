package com.example.myandroid;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * recyclerview任意位置插入view
 */
public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private boolean isAddView = true;
    private View addView = null;
    private int addIndex;
    private ArrayList<String> arrayList;


    public MyAdapter(ArrayList<String> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (addView != null && addIndex == position) {
            return 2;
        } else
            return 1;

    }

    public void rcyAddView(int position, View addView) {
        this.addView = addView;
        addIndex = position;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 2 && addView != null) {
            return new ViewHolder1(addView);
        } else if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_rcyitem, parent, false);
            return new ViewHolder(inflate);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        Log.e("position", "onBindViewHolder: position" + position);
        if (itemViewType != 2) {
            if (holder instanceof ViewHolder) {
                ViewHolder viewHolder = (ViewHolder) holder;
                if (position > addIndex && addView != null) {
                    viewHolder.mText.setText(arrayList.get(position - 1));
                } else {
                    viewHolder.mText.setText(arrayList.get(position));
                }

            }

        }

    }

    @Override
    public int getItemCount() {
        if (addView != null) {
            return arrayList.size() + 1;
        } else
            return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mText;

        public ViewHolder(View itemView) {
            super(itemView);
            this.mText = itemView.findViewById(R.id.text);
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {

        public ViewHolder1(View itemView) {
            super(itemView);
            if (addView == null) {
                return;
            }
        }
    }
}
