package com.appmaster;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;

public class Activity02Register extends AppCompatActivity {

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
        viewBar.setTitleStringView(true, "登入 / 註冊");
        viewBar.setTitleLeftButton(true, "", null);
        viewBar.getView();

       viewBar.newLinearLayout3();

        viewBar.newLinearLayoutPortait2();
        viewBar.setLinearLayout2PAddView(viewBar.setTextView(mAct, "請輸入帳號及密碼，完成會員註冊或會員登入"));
        accountEdt = viewBar.setEditText(mAct, "輸入Ｅ-MAIL或手機號碼");
        pwdEdt =  viewBar.setEditText(mAct, "6-20半形英數字組合");
        viewBar.setLinearLayout2PAddView(accountEdt);
        viewBar.setLinearLayout2PAddView(pwdEdt);
        viewBar.setLinearLayout2PAddView(viewBar.setCheckBox(mAct, "我已閱讀並同意使用者合約及個人資料保護暨隱私權政策", new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        }));

        viewBar.setScreenChange(viewBar.linearLayout3L);

        viewBar.setLinearLayout3AddView(viewBar.setButton(mAct, "忘記密碼", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));

        viewBar.setLinearLayout3AddView(viewBar.setButton(mAct, "確認送出", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                         viewBar.setConfirmDialog(mAct,accountEdt.getText().toString(),null,null);
            }
        }));

        viewBar.getLinearLayoutPortait2Have3();
        setContentView(viewBar.bgReLayout);
    }


}
