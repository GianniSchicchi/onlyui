package com.appmaster;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;

public class Activity07PhoneNBBind extends AppCompatActivity {

    Activity mAct;
    ViewBar viewBar;
    EditText accountEdt;
    EditText pwdEdt;
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
        viewBar.setTitleStringView(true, "手機號碼綁定");
        viewBar.setTitleLeftButton(true, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        viewBar.getView();

        viewBar.newLinearLayout3();

        viewBar.newLinearLayoutPortait2();

        viewBar.setLinearLayout2PAddView(viewBar.setTextView(mAct, "帳號"));
        accountEdt = viewBar.setEditText(mAct, "請輸入手機號碼");
        viewBar.setLinearLayout2PAddView(accountEdt);

        viewBar.setLinearLayout2PAddView(viewBar.setTextView(mAct, "密碼"));
        pwdEdt =  viewBar.setEditText(mAct, "請輸入密碼");
        viewBar.setLinearLayout2PAddView(pwdEdt);

        viewBar.setScreenChange(viewBar.linearLayout3L);

        viewBar.setLinearLayout3AddView(viewBar.setButton(mAct, "忘記密碼", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));

        viewBar.setLinearLayout3AddView(viewBar.setButton(mAct, "綁定", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewBar.setConfirmDialog(mAct,accountEdt.getText().toString(),null,null);
            }
        }));

        viewBar.getLinearLayoutPortait2Have3();
        setContentView(viewBar.bgReLayout);
    }
}
