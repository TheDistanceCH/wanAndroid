package com.wanandroid.app.chwanandroid.wx_public.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wanandroid.app.chwanandroid.R;
import com.wanandroid.app.chwanandroid.wx_public.bean.PublicListBean;
import com.wanandroid.app.chwanandroid.wx_public.listener.OnSubPublicListener;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * create time on  2019/7/29
 * function: 子public的recyclerView的适配器
 */
public class SubPublicAdapter extends RecyclerView.Adapter<SubPublicAdapter.MyViewHolder> {


    private Context context;
    private List<PublicListBean.DataBean.DatasBean> datas;
    private OnSubPublicListener listener;

    public SubPublicAdapter(Context context, List<PublicListBean.DataBean.DatasBean> datas,
                            OnSubPublicListener listener) {
        this.context = context;
        this.datas = datas;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_top_home,
                viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        if(datas==null || datas.size()==0) return;

        final int pos = myViewHolder.getAdapterPosition();

        if (listener != null) {
            myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(pos);
                }
            });
        }

        //设置置顶按钮不可见
        myViewHolder.tvItemTopHome.setVisibility(View.GONE);
        //设置"新"这个标签是否可见
        myViewHolder.tvItemNewHome.setVisibility(
                (datas.get(pos).getFresh()) ? View.VISIBLE : View.GONE);

        //设置tab标签--tab标签默认不可见
        if (datas.get(pos).getTags().size()>0) {
            myViewHolder.tvItemTagHome.setText(datas.get(pos).getTags().get(0).getName());
            myViewHolder.tvItemTagHome.setVisibility(View.VISIBLE);
        }

        //设置右上角的区分标签
        myViewHolder.tvItemPartHome.setText(datas.get(pos).getChapterName() + "/" +
                datas.get(pos).getSuperChapterName());

        //设置标题
        myViewHolder.tvItemTitleHome.setText(datas.get(pos).getTitle());

        //设置收藏
        if (datas.get(pos).getCollect()) {
            Glide.with(context).load(R.drawable.ic_img_collect_sel).
                    into(myViewHolder.imgItemCollectHome);
        } else {
            Glide.with(context).load(R.drawable.ic_img_collect_nor).
                    into(myViewHolder.imgItemCollectHome);
        }

        //设置时间
        myViewHolder.tvItemTimeHome.setText(datas.get(pos).getNiceDate());

        //设置作者
        myViewHolder.tvItemAuthorHome.setText(datas.get(pos).getAuthor());
    }

    @Override
    public int getItemCount() {
        return (datas==null || datas.size()==0)? 0:datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_item_top_home)
        TextView tvItemTopHome;
        @Bind(R.id.tv_item_new_home)
        TextView tvItemNewHome;
        @Bind(R.id.tv_item_tag_home)
        TextView tvItemTagHome;
        @Bind(R.id.tv_item_part_home)
        TextView tvItemPartHome;
        @Bind(R.id.tv_item_title_home)
        TextView tvItemTitleHome;
        @Bind(R.id.img_item_collect_home)
        ImageView imgItemCollectHome;
        @Bind(R.id.tv_item_author_home)
        TextView tvItemAuthorHome;
        @Bind(R.id.tv_item_time_home)
        TextView tvItemTimeHome;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
