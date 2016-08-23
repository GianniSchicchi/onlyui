package com.appmaster;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.appmaster.tools.ViewBar;
import com.appmaster.tools.ViewFactory;

public class Activity16Tasks extends AppCompatActivity {

    Activity mAct;
    ViewBar viewBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAct = this;

        setView();

    }


    void setView() {
        viewBar = new ViewBar(mAct);
        viewBar.setTitleStringView(true, "聯繫客服");
        viewBar.setTitleLeftButton(true, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        viewBar.setTitleRightButton(true, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        viewBar.getView();

        viewBar.setScrollEnable(true);
        viewBar.newLinearLayout3();

        viewBar.newLinearLayoutPortait2();




        viewBar.setLinearLayout2PAddView(ViewFactory.createNewImageButton(mAct, "領獎中心", "1", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mAct, "" + "1",
                        Toast.LENGTH_SHORT).show();
            }
        }));
        viewBar.setLinearLayout2PAddView(ViewFactory.createNewImageButton(mAct,"粉絲團按讚","2",null));
        viewBar.setLinearLayout2PAddView(ViewFactory.createNewImageButton(mAct,"前往五星評價任務","3",null));
        viewBar.setLinearLayout2PAddView(ViewFactory.createNewImageButton(mAct,"分享遊戲","4",null));
        viewBar.setLinearLayout2PAddView(ViewFactory.createNewImageButton(mAct,"邀請好友","5",null));

        viewBar.getLinearLayoutPortait2();
        setContentView(viewBar.bgReLayout);
    }
}
