package com.appmaster;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.appmaster.tools.ActivityGViewBar;
import com.appmaster.tools.ViewFactory;
import com.appmaster.tools.ViewLayoutFactory;

public class Activity12ContactCustomerService extends ActivityGViewBar {



    private static Fragment fragment12;
    private static Fragment fragment13;

    private static final int CONTENT_VIEW_ID = 99;
    private static FrameLayout frame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAct = this;


        frame = new FrameLayout(this);
        frame.setId(CONTENT_VIEW_ID);







        setView();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (savedInstanceState == null) {


            fragment12 = new Fragment12Report();
            fragment13 = new Fragment13ReportHistory();

//            transaction.add(CONTENT_VIEW_ID, fragment12,"f12");
            transaction.add(CONTENT_VIEW_ID, fragment13,"f13");


            transaction.addToBackStack(null);

            transaction.commit();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
//        setView();
    }


    void setView() {
        setTitleStringView(true, "公告訊息");
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


        LinearLayout linearLayout = ViewLayoutFactory.createNewLinearLayoutHORIZONTAL(mAct);

        linearLayout.addView(ViewFactory.createNewButton(mAct, "問題回報", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        transaction.replace(CONTENT_VIEW_ID, fragment12);
                        transaction.addToBackStack(null);
                        transaction.commit();


                    }
                })
        );

        linearLayout.addView(ViewFactory.createNewButton(mAct, "回報記錄", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        transaction.replace(CONTENT_VIEW_ID, fragment13);
                        transaction.addToBackStack(null);
                        transaction.commit();

                    }
                }, Color.RED,Color.WHITE,3,Color.RED)
        );

        linearLayout1.addView(linearLayout);


//        setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "若您遇到任何問題，請隨時與我們聯繫！\n我們會儘快回覆您的問題，回覆內容請至「回報記錄」查看。"));
//        setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "\n聯絡電話"));
//        setLinearLayout2PAddView(ViewFactory.createNewEditText(mAct, "請填入市話或手機號碼"));
//        setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "E-mail"));
//        setLinearLayout2PAddView(ViewFactory.createNewEditText(mAct, "請填入電子郵件"));
//        setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "問題類型"));
//        setLinearLayout2PAddView(ViewFactory.createNewEditText(mAct, "請選擇問題類型"));
//        setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "問題描述"));
//        setLinearLayout2PAddView(ViewFactory.createNewEditText(mAct, "請清楚的簡述您的問題"));
//        setLinearLayout2PAddView(ViewFactory.createNewButton(mAct, "確認送出", new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        }));

        setLinearLayout2PAddView(frame);
        getLinearLayoutPortait2Have3();
        setContentView(bgReLayout);
    }
}
