package com.appmaster;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.appmaster.tools.ViewBar;
import com.appmaster.tools.ViewFactory;

public class Activity05ReLogin extends AppCompatActivity {

    Activity mAct;
    ViewBar viewBar;


    EditText accountEdt;

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
        viewBar.setTitleImgView(true, "logo");
        viewBar.getView();
        viewBar.newLinearLayoutPortait2();
        accountEdt = ViewFactory.createNewEditText(mAct, "Ｅ-MAIL或手機號碼");
        viewBar.setLinearLayout2PAddView(accountEdt);
        viewBar.setLinearLayout2PAddView(ViewFactory.createNewButton(mAct, "登入", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
        viewBar.setLinearLayout2PAddView(ViewFactory.createNewButton(mAct, "綁定（成為正式會員）", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
        viewBar.setLinearLayout2PAddView(ViewFactory.createNewButton(mAct, "其他帳號登入", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
        viewBar.getLinearLayoutPortait2();
        setContentView(viewBar.bgReLayout);
    }
}
