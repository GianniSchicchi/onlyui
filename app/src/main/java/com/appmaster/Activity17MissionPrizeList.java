package com.appmaster;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.appmaster.adapter.AdapterListMission;
import com.appmaster.data.InfoMission;
import com.appmaster.data.MissiongPrizeStatus;
import com.appmaster.tools.ActivityGViewBar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Activity17MissionPrizeList extends ActivityGViewBar {

    List<InfoMission> list = Collections.synchronizedList(new ArrayList<InfoMission>());


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
        if (list != null) {
            list.add(new InfoMission(0, "邀請好友達5人，獎勵XXXXXX \n" +
                    "【5/5】", MissiongPrizeStatus.Complete));
            list.add(new InfoMission(1, "邀請好友達10人，獎勵XXXXXX \n" +
                    "【10/10】", MissiongPrizeStatus.NotYet));
            list.add(new InfoMission(2, "邀請好友達15人，獎勵XXXXXX \n" +
                    "【15/15】", MissiongPrizeStatus.Geted));
            list.add(new InfoMission(3, "11111", MissiongPrizeStatus.Error));

        }
    }

    void setView() {
        setTitleStringView(true, "領獎中心");
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


        listView.setAdapter(new AdapterListMission(this, list));

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
