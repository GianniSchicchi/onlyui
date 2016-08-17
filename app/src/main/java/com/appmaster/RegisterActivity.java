package com.appmaster;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

public class RegisterActivity extends AppCompatActivity {

    Activity mAct;
    ViewBar viewBar;

    LinearLayout linearLayout2;
    LinearLayout linearLayout3;

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

        linearLayout2 = new LinearLayout(mAct);
        linearLayout3 = new LinearLayout(mAct);

        LinearLayout.LayoutParams setting = new LinearLayout.LayoutParams(viewBar.getScreenWidth(mAct)*3/4,
                viewBar.getScreenHeight(mAct)*3/4);


        linearLayout2.setLayoutParams(setting);

        linearLayout2.setOrientation(LinearLayout.VERTICAL);
        linearLayout2.addView(viewBar.setTextView(mAct, "請輸入帳號及密碼，完成會員註冊或會員登入"));
        accountEdt = viewBar.setEditText(mAct, "輸入Ｅ-MAIL或手機號碼");
        pwdEdt =  viewBar.setEditText(mAct, "6-20半形英數字組合");

        linearLayout2.addView(accountEdt);
        linearLayout2.addView(pwdEdt);
        linearLayout2.addView(viewBar.setCheckBox(mAct, "我已閱讀並同意使用者合約及個人資料保護暨隱私權政策", new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        }));

        int iScreenOrientation = viewBar.getScreenOrientation(mAct);
        if (iScreenOrientation == 0 || iScreenOrientation == 8) {
            setViewLayoutLandscape();
        } else {
            setViewLayoutPortait();
        }

        linearLayout3.addView(viewBar.setButton(mAct, "忘記密碼", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));

        linearLayout3.addView(viewBar.setButton(mAct, "確認送出", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                         viewBar.setConfirmDialog(mAct,accountEdt.getText().toString(),null,null);
            }
        }));


        linearLayout2.addView(linearLayout3);

        viewBar.setViewPadding(linearLayout2, 20, 0);
        viewBar.relativeLayout.addView(linearLayout2);

        viewBar.linearLayout1.addView(viewBar.relativeLayout);


        viewBar.bgReLayout.addView(viewBar.linearLayout1);

        setContentView(viewBar.bgReLayout);
    }


    private void setViewLayoutPortait() {

        linearLayout3.setOrientation(LinearLayout.VERTICAL);


    }

    private void setViewLayoutLandscape() {
        linearLayout3.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams setting = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        linearLayout3.setLayoutParams(setting);
    }

}
