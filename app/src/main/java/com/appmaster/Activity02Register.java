package com.appmaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.appmaster.tools.ActivityGViewBar;
import com.appmaster.tools.ViewFactory;

public class Activity02Register extends ActivityGViewBar {

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
         setTitleStringView(true, "登入 / 註冊");
         setTitleLeftButton(true, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
         getView();

        newLinearLayout3();

         newLinearLayoutPortait2();
         setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "請輸入帳號及密碼，完成會員註冊或會員登入"));
        accountEdt = ViewFactory.createNewEditText(mAct, "輸入Ｅ-MAIL或手機號碼");
        pwdEdt =  ViewFactory.createNewEditText(mAct, "6-20半形英數字組合");
         setLinearLayout2PAddView(accountEdt);
         setLinearLayout2PAddView(pwdEdt);
         setLinearLayout2PAddView(ViewFactory.createNewCheckBox(mAct, "我已閱讀並同意使用者合約及個人資料保護暨隱私權政策", new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        }));

         setScreenChange( linearLayout3L);

         setLinearLayout3AddView(ViewFactory.createNewButton(mAct, "忘記密碼", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mAct,Activity04ForgetPassword.class);
                startActivity(intent);
            }
        }));

         setLinearLayout3AddView(ViewFactory.createNewButton(mAct, "確認送出", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewFactory.createNewConfirmDialog(mAct,accountEdt.getText().toString(),null,null);
            }
        }));

         getLinearLayoutPortait2Have3();
        setContentView( bgReLayout);
    }


}
