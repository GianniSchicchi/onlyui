package com.appmaster;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.appmaster.tools.ActivityGViewBar;
import com.appmaster.tools.ViewFactory;

public class Activity05ReLogin extends ActivityGViewBar {



    EditText accountEdt;

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
        setTitleImgView(true, "logo");
        getView();
        newLinearLayoutPortait2();
        accountEdt = ViewFactory.createNewEditText(mAct, "Ｅ-MAIL或手機號碼");
        setLinearLayout2PAddView(accountEdt);
        setLinearLayout2PAddView(ViewFactory.createNewButton(mAct, "登入", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
        setLinearLayout2PAddView(ViewFactory.createNewButton(mAct, "綁定（成為正式會員）", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
        setLinearLayout2PAddView(ViewFactory.createNewButton(mAct, "其他帳號登入", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
        getLinearLayoutPortait2();
        setContentView(bgReLayout);
    }
}
