package com.appmaster;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.appmaster.tools.ActivityGViewBar;
import com.appmaster.tools.ViewFactory;

public class Activity04ForgetPassword extends ActivityGViewBar {
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
        setTitleStringView(true, "登入 / 註冊");
        setTitleLeftButton(true, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getView();
        newLinearLayoutPortait2();
        setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "請輸入帳號"));
        accountEdt = ViewFactory.createNewEditText(mAct, "Ｅ-MAIL或手機號碼");
        setLinearLayout2PAddView(accountEdt);
        setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "※確認送出後，系統將自動發送臨時密碼至您的信箱或手機，請於三小時內登入並重新設定新密碼。", Color.RED));
        setLinearLayout2PAddView(ViewFactory.createNewButton(mAct, "確認送出", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
        getLinearLayoutPortait2();
        setContentView(bgReLayout);
    }
}
