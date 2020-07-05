package com.zjn.helloworld.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.zjn.helloworld.R;

public class MyGridViewAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mlayoutInflater;

    public MyGridViewAdapter(Context context){
        this.mContext = context;
        mlayoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView textView;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            view = mlayoutInflater.inflate(R.layout.layout_grid_item,null);
            holder = new ViewHolder();
            holder.imageView = view.findViewById(R.id.iv_grid);
            holder.textView = view.findViewById(R.id.tv_title);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        //赋值
        holder.textView.setText("花花");
        Glide.with(mContext).load("https://5b0988e595225.cdn.sohucs.com/images/20190317/d97d305108c343c79072774f32d7c687.png").into(holder.imageView);
        return view;
    }
}
