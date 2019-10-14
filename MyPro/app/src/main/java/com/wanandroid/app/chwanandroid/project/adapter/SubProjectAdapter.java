package com.wanandroid.app.chwanandroid.project.adapter;

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
import com.wanandroid.app.chwanandroid.project.bean.ProjectListBean;
import com.wanandroid.app.chwanandroid.project.listener.OnProjectListener;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * create time on  2019/8/1
 * function:
 */
public class SubProjectAdapter extends RecyclerView.Adapter<SubProjectAdapter.MyViewHolder> {


    private Context context;
    private List<ProjectListBean.DataBean.DatasBean> datas;
    private OnProjectListener listener;

    public SubProjectAdapter(Context context, List<ProjectListBean.DataBean.DatasBean> datas,
                             OnProjectListener listener) {
        this.context = context;
        this.datas = datas;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_project, viewGroup, false);

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

        //图片
        Glide.with(context)
                .load(datas.get(pos).getEnvelopePic())
                .placeholder(R.drawable.ic_img_loadding)
                .error(R.drawable.ic_img_error_img)
                .into(myViewHolder.imgItemProject);

        //标题
        myViewHolder.tvItemTitleProject.setText(datas.get(pos).getTitle());

        //内容
        myViewHolder.tvItemConProject.setText(datas.get(pos).getDesc());

        //收藏
        myViewHolder.imgItemCollectProject.setImageResource((datas.get(pos).isCollect()) ?
                R.drawable.ic_img_collect_sel : R.drawable.ic_img_collect_nor);

        //时间
        myViewHolder.tvItemTimeProject.setText(datas.get(pos).getNiceDate());

        //作者
        myViewHolder.tvItemNameProject.setText(datas.get(pos).getAuthor());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.img_item_project)
        ImageView imgItemProject;
        @Bind(R.id.tv_item_title_project)
        TextView tvItemTitleProject;
        @Bind(R.id.tv_item_con_project)
        TextView tvItemConProject;
        @Bind(R.id.tv_item_time_project)
        TextView tvItemTimeProject;
        @Bind(R.id.tv_item_name_project)
        TextView tvItemNameProject;
        @Bind(R.id.img_item_collect_project)
        ImageView imgItemCollectProject;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
