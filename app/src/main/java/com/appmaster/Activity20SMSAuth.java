package com.appmaster;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.appmaster.layout.AuthView;
import com.appmaster.tools.ActivityGViewBar;
import com.appmaster.tools.ViewFactory;

public class Activity20SMSAuth extends ActivityGViewBar {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setView();

    }


    void setView() {
        setTitleStringView(true, "簡訊認證");
        setTitleLeftButton(true, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setTitleRightButton(true, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getView();

        setScrollEnable(true);
        newLinearLayout3();

        newLinearLayoutPortait2();


        setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "註冊簡訊已發送至您的手機，請於10分鐘內輸入認證簡訊中的認証碼", Color.BLACK));
        AuthView authView = new AuthView(mAct, "p");
        authView.getTextView().setText("0911-111-111");
        setLinearLayout2PAddView(authView);
        setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "認証碼", Color.BLACK));
        setLinearLayout2PAddView(ViewFactory.createNewEditText(mAct, "請輸入認証碼"));
        setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "如果沒有收到認證簡訊，請於10分鐘後重新操作", Color.BLACK));
        setLinearLayout2PAddView(ViewFactory.createNewButton(mAct, "確認", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));


        getLinearLayoutPortait2();
        setContentView(bgReLayout);
    }
}
