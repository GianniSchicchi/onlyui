package com.appmaster;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.appmaster.adapter.AdapterListViewReportHistory;
import com.appmaster.data.InfoReport;
import com.appmaster.dummy.DummyContent.DummyItem;
import com.appmaster.tools.ViewFactory;
import com.appmaster.tools.ViewLayoutFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class Fragment13ReportHistory extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "5column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    List<InfoReport> mList =  Collections.synchronizedList(new ArrayList<InfoReport>());
    private Activity mAct;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public Fragment13ReportHistory() {

    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static Fragment13ReportHistory newInstance(int columnCount) {
        Fragment13ReportHistory fragment = new Fragment13ReportHistory();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

        mAct = getActivity();
        addFalseInfo();
    }

    void addFalseInfo() {
        if(mList != null) {
            for (int i = 0; i < 30; i++) {
                if(i%2 == 0) {
                    mList.add(new InfoReport());
                }else {
                    mList.add(new InfoReport(true));
                }


            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ListView listView = new ListView(mAct);


        listView.setAdapter(new AdapterListViewReportHistory(mAct,mList));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(mAct, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });


        ViewLayoutFactory.setListViewHeightBasedOnChildren(listView);


        LinearLayout layout = ViewLayoutFactory.createNewLinearLayoutVERTICAL(mAct);



        layout.addView(ViewFactory.createNewTextView(mAct, "僅供查詢近三個月內的回報記錄"));
        layout.addView(listView);


        return layout;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
