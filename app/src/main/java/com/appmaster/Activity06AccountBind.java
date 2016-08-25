package com.appmaster;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.appmaster.tools.ActivityGViewBar;
import com.appmaster.tools.ViewFactory;

public class Activity06AccountBind extends ActivityGViewBar {

    View phoneNBView;
    View emailView;
    View fbView;
    View gplusView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setView();
    }

    void setView() {
        setTitleStringView(true, "帳號綁定");
        setTitleLeftButton(true, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getView();

        newLinearLayout3();

        newLinearLayoutPortait2();

        setScreenChange(linearLayout3L);

        setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "請儘速綁定帳號，避免遊戲資料遺失！"));


        setScreenChange();

        setLinearLayout3AddView(phoneNBView);
        setLinearLayout3AddView(emailView);

        setLinearLayout3AddView(fbView);
        setLinearLayout3AddView(gplusView);


        getLinearLayoutPortait2Have3();
        setContentView(bgReLayout);
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
