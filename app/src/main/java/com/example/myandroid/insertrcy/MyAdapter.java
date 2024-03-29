package com.example.myandroid.insertrcy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myandroid.R;

import java.util.ArrayList;

/**
 * recyclerview任意位置插入view
 */
public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private View addView = null;
    private int addIndex;
    private ArrayList<String> arrayList;
    int positions;


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
        addIndex = position - 1;
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

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (position > addIndex && addView != null) {
            positions = position - 1;
        } else {
            positions = position;
        }
        Log.e("position", "onBindViewHolder: positions" + positions);
        if (itemViewType != 2) {
            if (holder instanceof ViewHolder) {
                ViewHolder viewHolder = (ViewHolder) holder;
                viewHolder.mText.setText(arrayList.get(positions));
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
