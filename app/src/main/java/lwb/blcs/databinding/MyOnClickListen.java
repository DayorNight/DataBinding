package lwb.blcs.databinding;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

public class MyOnClickListen {
    private Activity mainActivity;
    public MyOnClickListen(Activity mainActivity) {
        this.mainActivity = mainActivity;
    }

    //方法引用
    public void onClickName(String name){
        Toast.makeText(mainActivity,name,Toast.LENGTH_SHORT).show();
    }
    //方法引用
    public void onClickPhone(String phone){
        Toast.makeText(mainActivity,phone,Toast.LENGTH_SHORT).show();
    }
    //监听器绑定
    public void onClickImage(View view){
        Toast.makeText(mainActivity,"图片",Toast.LENGTH_SHORT).show();
    }
}