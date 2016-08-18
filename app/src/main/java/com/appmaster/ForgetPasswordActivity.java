package com.appmaster;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

public class ForgetPasswordActivity extends AppCompatActivity {

    Activity mAct;
    ViewBar viewBar;

    LinearLayout linearLayout2;

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

        linearLayout2 = new LinearLayout(mAct);

        LinearLayout.LayoutParams setting2 = new LinearLayout.LayoutParams(viewBar.getScreenWidth(mAct)*3/4,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        setting2.setMargins(20,20,20,20);

        linearLayout2.setLayoutParams(setting2);

        linearLayout2.setOrientation(LinearLayout.VERTICAL);
        linearLayout2.addView(viewBar.setTextView(mAct, "請輸入帳號"));
        accountEdt = viewBar.setEditText(mAct, "Ｅ-MAIL或手機號碼");

        linearLayout2.addView(accountEdt);
        linearLayout2.addView(viewBar.setTextView(mAct, "※確認送出後，系統將自動發送臨時密碼至您的信箱或手機，請於三小時內登入並重新設定新密碼。", Color.RED));




        linearLayout2.addView(viewBar.setButton(mAct, "確認送出", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));

        viewBar.contentRelaLayout.addView(linearLayout2);
        viewBar.linearLayout1.addView(viewBar.contentRelaLayout);

        viewBar.bgReLayout.addView(viewBar.linearLayout1);

        setContentView(viewBar.bgReLayout);
    }



}
