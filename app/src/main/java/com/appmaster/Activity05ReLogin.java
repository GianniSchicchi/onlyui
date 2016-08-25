package com.appmaster;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.appmaster.adapter.AdapterReLogin;
import com.appmaster.data.AccountType;
import com.appmaster.data.InfoAcconut;
import com.appmaster.layout.ReloginView;
import com.appmaster.tools.ActivityGViewBar;
import com.appmaster.tools.ViewFactory;

import java.util.ArrayList;

public class Activity05ReLogin extends ActivityGViewBar {



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
        setTitleImgView(true, "logo");
        getView();
        newLinearLayoutPortait2();


        ArrayList<InfoAcconut> spinnerArray = new ArrayList<InfoAcconut>();
        spinnerArray.add(new InfoAcconut());
        spinnerArray.add(new InfoAcconut(AccountType.TYPE1,"1111111"));
        spinnerArray.add(new InfoAcconut(AccountType.TYPE2,"2222222"));
        spinnerArray.add(new InfoAcconut(AccountType.TYPE3,"3333333"));
        spinnerArray.add(new InfoAcconut(AccountType.TYPE4,"4444444h"));





        AdapterReLogin spinnerArrayAdapter = new AdapterReLogin(mAct, spinnerArray);

        Spinner spinner = ViewFactory.createNewSpinner(mAct,"");
        spinner.setAdapter(spinnerArrayAdapter);

        setLinearLayout2PAddView(spinner);


        accountEdt = ViewFactory.createNewEditText(mAct, "Ｅ-MAIL或手機號碼");
        setLinearLayout2PAddView(accountEdt);
        setLinearLayout2PAddView(ViewFactory.createNewButton(mAct, "登入", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
        setLinearLayout2PAddView(ViewFactory.createNewButton(mAct, "綁定（成為正式會員）", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
        setLinearLayout2PAddView(ViewFactory.createNewButton(mAct, "其他帳號登入", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
        getLinearLayoutPortait2();
        setContentView(bgReLayout);
    }
}
