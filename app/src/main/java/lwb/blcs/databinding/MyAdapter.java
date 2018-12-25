package lwb.blcs.databinding;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;
import lwb.blcs.databinding.databinding.AdapterMainBinding;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private MainActivity mainActivity;
    private List<User> list;
    private final LayoutInflater inflater;

    public MyAdapter(MainActivity mainActivity, List<User> list) {
        this.mainActivity = mainActivity;
        this.list = list;
        inflater = LayoutInflater.from(mainActivity);
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //MyAdapter适配器绑定布局
        AdapterMainBinding bind = DataBindingUtil.inflate(inflater, R.layout.adapter_main, viewGroup, false);
        return new MyViewHolder(bind);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        //绑定数据
        holder.bind.setUser(list.get(i));
        //设置点击事件
        holder.bind.setClick(new MyOnClickListen(mainActivity));
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        //ViewHolder 构造函数修改
        AdapterMainBinding bind;
        public MyViewHolder(@NonNull AdapterMainBinding itemView) {
            //itemView.getRoot()获取View
            super(itemView.getRoot());
            this.bind=itemView;
        }
    }
}
