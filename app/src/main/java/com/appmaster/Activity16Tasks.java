package com.appmaster;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.appmaster.tools.ActivityGViewBar;
import com.appmaster.tools.ViewFactory;

public class Activity16Tasks extends ActivityGViewBar {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setView();

    }


    void setView() {
        setTitleStringView(true, "聯繫客服");
        setTitleLeftButton(true, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setTitleRightButton(true, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getView();

        setScrollEnable(true);
        newLinearLayout3();

        newLinearLayoutPortait2();


        setLinearLayout2PAddView(ViewFactory.createNewImageButton(mAct, "領獎中心", "1", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mAct, "" + "1",
                        Toast.LENGTH_SHORT).show();
            }
        }));
        setLinearLayout2PAddView(ViewFactory.createNewImageButton(mAct, "粉絲團按讚", "2", null));
        setLinearLayout2PAddView(ViewFactory.createNewImageButton(mAct, "前往五星評價任務", "3", null));
        setLinearLayout2PAddView(ViewFactory.createNewImageButton(mAct, "分享遊戲", "4", null));
        setLinearLayout2PAddView(ViewFactory.createNewImageButton(mAct, "邀請好友", "5", null));

        getLinearLayoutPortait2();
        setContentView(bgReLayout);
    }
}
