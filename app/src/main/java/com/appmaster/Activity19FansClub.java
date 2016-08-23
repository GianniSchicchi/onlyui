package com.appmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.appmaster.adapter.AdapterListFansClub;
import com.appmaster.adapter.AdapterListMission;
import com.appmaster.data.FansClubStatus;
import com.appmaster.data.InfoFansClub;
import com.appmaster.data.InfoMission;
import com.appmaster.data.MissiongPrizeStatus;
import com.appmaster.tools.ActivityGViewBar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Activity19FansClub extends ActivityGViewBar {

    List<InfoFansClub> list =  Collections.synchronizedList(new ArrayList<InfoFansClub>());



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addFalseAnnInfo();
    }
    @Override
    protected void onResume() {
        super.onResume();
        setView();
    }

    void addFalseAnnInfo() {
        if(list != null) {
            list.add(new InfoFansClub(0,"粉絲團名稱 \n" +
                    "成為粉絲，獲得獎勵XXX", FansClubStatus.Like));
            list.add(new InfoFansClub(1,"粉絲團名稱 \n" +
                    "成為粉絲，獲得獎勵XXX", FansClubStatus.NotYet));
            list.add(new InfoFansClub(2,"粉絲團名稱 \n" +
                    "成為粉絲，獲得獎勵XXX", FansClubStatus.Liked));

        }
    }

    void setView() {
        setTitleStringView(true, "粉絲團按讚");
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

        newLinearLayout3();

        newLinearLayoutPortait2();




        ListView listView = new ListView(mAct);





        listView.setAdapter(new AdapterListFansClub(this, list));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(mAct, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        setLinearLayout2PAddView(listView);

        getLinearLayoutPortait2();
        setContentView(bgReLayout);
    }
}
