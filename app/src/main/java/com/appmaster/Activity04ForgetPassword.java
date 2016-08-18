package com.appmaster;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Activity04ForgetPassword extends AppCompatActivity {
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
        viewBar.setTitleStringView(true, "登入 / 註冊");
        viewBar.setTitleLeftButton(true, "", null);
        viewBar.getView();
        viewBar.newLinearLayoutPortait2();
        viewBar.setLinearLayout2PAddView(viewBar.setTextView(mAct, "請輸入帳號"));
        accountEdt = viewBar.setEditText(mAct, "Ｅ-MAIL或手機號碼");
        viewBar.setLinearLayout2PAddView(accountEdt);
        viewBar.setLinearLayout2PAddView(viewBar.setTextView(mAct, "※確認送出後，系統將自動發送臨時密碼至您的信箱或手機，請於三小時內登入並重新設定新密碼。", Color.RED));
        viewBar.setLinearLayout2PAddView(viewBar.setButton(mAct, "確認送出", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
        viewBar.getLinearLayoutPortait2();
        setContentView(viewBar.bgReLayout);
    }
}
