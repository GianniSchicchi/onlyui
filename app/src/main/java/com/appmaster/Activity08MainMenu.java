package com.appmaster;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Activity08MainMenu extends AppCompatActivity {

    Activity mAct;
    ViewBar viewBar;

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
        viewBar.setTitleRightButton(true, "", null);
        viewBar.getView();

        viewBar.newLinearLayout3();

        viewBar.newLinearLayoutPortait2();

        String acc = "123456789";
        String acc2 = "123456@facebook";
        String accType = "Facebook";

        viewBar.setLinearLayout2PAddView(viewBar.setTextView(mAct, "會員帳戶：" + acc));
        viewBar.setLinearLayout2PAddView(viewBar.setTextView(mAct, "會員帳號：" + acc2));
        viewBar.setLinearLayout2PAddView(viewBar.setTextView(mAct, "帳號類型：" + accType));
        viewBar.setLinearLayout2PAddView(viewBar.newLineImageView());

        GridView gridview = new GridView(mAct);

        gridview.setNumColumns(GridView.AUTO_FIT);
        gridview.setGravity(Gravity.CENTER);


        int iScreenOrientation = viewBar.getScreenOrientation(mAct);
        if (iScreenOrientation == 0 || iScreenOrientation == 8) {
            gridview.setNumColumns(4);
        } else {
            gridview.setNumColumns(3);

        }

        gridview.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);

        gridview.setAdapter(new GridViewImgTxtAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(mAct, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        viewBar.setLinearLayout2PAddView(gridview);

        viewBar.getLinearLayoutPortait2();
        setContentView(viewBar.bgReLayout);
    }


}
