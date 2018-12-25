package lwb.blcs.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import lwb.blcs.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding bind;
    private List<User> list=new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //关联布局
        bind= DataBindingUtil.setContentView(this,R.layout.activity_main);
        //设置点击事件
        bind.setClick(this);
        //recycler适配
        LinearLayoutManager manager = new LinearLayoutManager(this);
        bind.recycler.setLayoutManager(manager);
        myAdapter = new MyAdapter(this,list);
        bind.recycler.setAdapter(myAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                User user = new User();
                user.setName(bind.etName.getText().toString());
                user.setPhone(bind.etPhone.getText().toString());
                user.setImgUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545725899676&di=f875404bfb91dc586cf14030097b7a35&imgtype=0&src=http%3A%2F%2Fimg1.gtimg.com%2Fzj%2Fpics%2Fhv1%2F112%2F112%2F2259%2F146920147.jpg");
                list.add(user);
                myAdapter.notifyItemInserted(list.size());
                break;
        }
    }
}
