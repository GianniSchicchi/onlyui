package com.appmaster;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.appmaster.adapter.AdapterGridViewImgTxt;
import com.appmaster.tools.ActivityGViewBar;
import com.appmaster.tools.ViewFactory;

public class Activity08MainMenu extends ActivityGViewBar {


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
        setTitleRightButton(true, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getView();

        newLinearLayout3();

        newLinearLayoutPortait2();

        String acc = "123456789";
        String acc2 = "123456@facebook";
        String accType = "Facebook";

        setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "會員帳戶：" + acc));
        setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "會員帳號：" + acc2));
        setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "帳號類型：" + accType));
        setLinearLayout2PAddView(ViewFactory.createNewLineImageView(mAct));

        GridView gridview = new GridView(mAct);

        gridview.setNumColumns(GridView.AUTO_FIT);
        gridview.setGravity(Gravity.CENTER);


        int iScreenOrientation = ViewFactory.getScreenOrientation(mAct);
        if (iScreenOrientation == 0 || iScreenOrientation == 8) {
            gridview.setNumColumns(4);
        } else {
            gridview.setNumColumns(3);

        }

        gridview.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);

        gridview.setAdapter(new AdapterGridViewImgTxt(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(mAct, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        setLinearLayout2PAddView(gridview);

        getLinearLayoutPortait2();
        setContentView(bgReLayout);
    }


}
