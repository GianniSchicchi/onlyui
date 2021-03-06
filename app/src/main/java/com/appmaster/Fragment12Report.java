package com.appmaster;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.appmaster.tools.ViewFactory;
import com.appmaster.tools.ViewLayoutFactory;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment12Report.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment12Report#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment12Report extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Activity mAct;
    private OnFragmentInteractionListener mListener;

    public Fragment12Report() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment12Report.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment12Report newInstance(String param1, String param2) {
        Fragment12Report fragment = new Fragment12Report();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        mAct = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LinearLayout layout = ViewLayoutFactory.createNewLinearLayoutVERTICAL(mAct);
        layout.setGravity(Gravity.CENTER);

        layout.addView(ViewFactory.createNewTextView(mAct, "若您遇到任何問題，請隨時與我們聯繫！\n我們會儘快回覆您的問題，回覆內容請至「回報記錄」查看。"));
        layout.addView(ViewFactory.createNewTextView(mAct, "\n聯絡電話"));
        layout.addView(ViewFactory.createNewEditText(mAct, "請填入市話或手機號碼"));
        layout.addView(ViewFactory.createNewTextView(mAct, "E-mail"));
        layout.addView(ViewFactory.createNewEditText(mAct, "請填入電子郵件"));
        layout.addView(ViewFactory.createNewTextView(mAct, "問題類型"));


        ArrayList<String> spinnerArray = new ArrayList<String>();
        spinnerArray.add("請選擇問題類型");
        spinnerArray.add("問題類型1");
        spinnerArray.add("問題類型2");
        spinnerArray.add("問題類型3");
        spinnerArray.add("問題類型4");

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(mAct, android.R.layout.simple_spinner_dropdown_item, spinnerArray);


        Spinner spinner = ViewFactory.createNewSpinner(mAct, "");
        spinner.setAdapter(spinnerArrayAdapter);

        layout.addView(spinner);


        layout.addView(ViewFactory.createNewTextView(mAct, "問題描述"));
        layout.addView(ViewFactory.createNewEditText(mAct, "請清楚的簡述您的問題"));
        layout.addView(ViewFactory.createNewButton(mAct, "確認送出", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));


        return layout;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
