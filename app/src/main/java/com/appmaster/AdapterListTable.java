package com.appmaster;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Gianni on 2016/8/18.
 */

public class AdapterListTable extends BaseAdapter {
    private Context mContext;
    private List<PurchaseHistoryInfo> mList;

    public AdapterListTable(Context c, List<PurchaseHistoryInfo> list) {
        mContext = c;
        mList = list;
    }

    public int getCount() {
        return mList.size();
    }

    public Object getItem(int position) {
        return mList.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        TableLayoutPurchaseHistory tableLayoutPurchaseHistory = null;
        TableLayout tableLayout;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            tableLayoutPurchaseHistory = new TableLayoutPurchaseHistory(mContext);
            tableLayoutPurchaseHistory.init();
            tableLayout = tableLayoutPurchaseHistory.getTableLayout();
        } else {
            tableLayout = (TableLayout) convertView;

        }


        if(tableLayoutPurchaseHistory != null) {
            tableLayoutPurchaseHistory.setDataInfo(mList.get(position));    
        }
        
                
        return tableLayout;
    }



}