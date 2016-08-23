package com.appmaster;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.appmaster.tools.ActivityGViewBar;
import com.appmaster.tools.ViewFactory;

public class Activity07PhoneNBBind extends ActivityGViewBar {

    EditText accountEdt;
    EditText pwdEdt;
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
        setTitleStringView(true, "手機號碼綁定");
        setTitleLeftButton(true, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getView();

        newLinearLayout3();

        newLinearLayoutPortait2();

        setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "帳號"));
        accountEdt = ViewFactory.createNewEditText(mAct, "請輸入手機號碼");
        setLinearLayout2PAddView(accountEdt);

        setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "密碼"));
        pwdEdt =  ViewFactory.createNewEditText(mAct, "請輸入密碼");
        setLinearLayout2PAddView(pwdEdt);

        setScreenChange(linearLayout3L);

        setLinearLayout3AddView(ViewFactory.createNewButton(mAct, "忘記密碼", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));

        setLinearLayout3AddView(ViewFactory.createNewButton(mAct, "綁定", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewFactory.createNewConfirmDialog(mAct,accountEdt.getText().toString(),null,null);
            }
        }));

        getLinearLayoutPortait2Have3();
        setContentView(bgReLayout);
    }
}
