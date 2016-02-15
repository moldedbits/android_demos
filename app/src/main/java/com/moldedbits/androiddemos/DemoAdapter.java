package com.moldedbits.androiddemos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.DemoViewHolder>
        implements View.OnClickListener {

    public interface DemoClickListener {
        void onDemoClicked(MainActivity.Demo demo);
    }

    private ArrayList<MainActivity.Demo> mItems;

    private DemoClickListener mListener;

    public DemoAdapter(DemoClickListener listener) {
        mItems = new ArrayList<>();
        mListener = listener;
    }

    public void addItems(List<MainActivity.Demo> items) {
        for (MainActivity.Demo demo : items) {
            mItems.add(demo);
        }
    }

    @Override
    public DemoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_demo, parent, false);
        return new DemoViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(DemoViewHolder holder, int position) {
        holder.bind(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onClick(View v) {
        mListener.onDemoClicked((MainActivity.Demo) v.getTag());
    }

    public static class DemoViewHolder extends RecyclerView.ViewHolder {
        ImageView mIconView;
        TextView mTitleView;

        View.OnClickListener mListener;

        public DemoViewHolder(View itemView, View.OnClickListener listener) {
            super(itemView);
            mListener = listener;
            mIconView = (ImageView) itemView.findViewById(R.id.icon);
            mTitleView = (TextView) itemView.findViewById(R.id.title);
        }

        public void bind(MainActivity.Demo demo) {
            itemView.setTag(demo);
            itemView.setOnClickListener(mListener);
            mIconView.setImageResource(demo.resId);
            mTitleView.setText(demo.title);
        }
    }
}
