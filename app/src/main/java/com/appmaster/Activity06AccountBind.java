package com.appmaster;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class Activity06AccountBind extends AppCompatActivity {

    View phoneNBView;
    View emailView;
    View fbView;
    View gplusView;

    Activity mAct;
    ViewBar viewBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAct = this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        setView();
    }

    void setView() {
        viewBar = new ViewBar(mAct);
        viewBar.setTitleStringView(true, "帳號綁定");
        viewBar.setTitleLeftButton(true, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        viewBar.getView();

        viewBar.newLinearLayout3();

        viewBar.newLinearLayoutPortait2();

        viewBar.setScreenChange(viewBar.linearLayout3L);

        viewBar.setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "請儘速綁定帳號，避免遊戲資料遺失！"));


        setScreenChange();

        viewBar.setLinearLayout3AddView(phoneNBView);
        viewBar.setLinearLayout3AddView(emailView);

        viewBar.setLinearLayout3AddView(fbView);
        viewBar.setLinearLayout3AddView(gplusView);


        viewBar.getLinearLayoutPortait2Have3();
        setContentView(viewBar.bgReLayout);
    }


    void setScreenChange() {
        int iScreenOrientation = ViewFactory.getScreenOrientation(mAct);
        if (iScreenOrientation == 0 || iScreenOrientation == 8) {
            phoneNBView = ViewFactory.createNewImageView(mAct, "手機號碼", "5", null);
            emailView = ViewFactory.createNewImageView(mAct, "E-Mail", "6", null);
            fbView = ViewFactory.createNewImageView(mAct, "Facebook", "3", null);
            gplusView = ViewFactory.createNewImageView(mAct, "Google", "4", null);
        } else {
            phoneNBView = ViewFactory.createNewImageView(mAct, "手機號碼", "5", null, LinearLayout.HORIZONTAL);
            emailView = ViewFactory.createNewImageView(mAct, "E-Mail", "6", null, LinearLayout.HORIZONTAL);
            fbView = ViewFactory.createNewImageView(mAct, "Facebook", "3", null, LinearLayout.HORIZONTAL);
            gplusView = ViewFactory.createNewImageView(mAct, "Google", "4", null, LinearLayout.HORIZONTAL);

        }
    }

}
