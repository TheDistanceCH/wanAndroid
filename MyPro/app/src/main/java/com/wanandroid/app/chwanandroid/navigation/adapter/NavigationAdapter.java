package com.wanandroid.app.chwanandroid.navigation.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.navigation.bean.NavigationBean;
import com.wanandroid.app.chwanandroid.navigation.listener.OnNavigationListener;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * create time on  2019/7/31
 * function:
 */
public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.MyViewHolder> {


    private List<NavigationBean.DataBean.ArticlesBean> datas;
    private Context context;
    private OnNavigationListener listener;

    public NavigationAdapter(List<NavigationBean.DataBean.ArticlesBean> datas, Context context,
                             OnNavigationListener listener) {
        this.datas = datas;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_navigation,
                viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        if (datas == null || datas.size() == 0) return;

        final int pos = myViewHolder.getAdapterPosition();

        if (listener != null) {
            myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(pos);
                }
            });
        }

        myViewHolder.tvItemTitleNavigation.setText(datas.get(pos).getTitle());
        myViewHolder.tvItemPartnameNavigation.setText(datas.get(pos).getChapterName());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_item_title_navigation)
        TextView tvItemTitleNavigation;
        @Bind(R.id.tv_item_partname_navigation)
        TextView tvItemPartnameNavigation;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
