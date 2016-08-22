package com.appmaster;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

/**
 * Created by Gianni on 2016/8/22.
 */

public class ViewLayoutFactory {

    public static LinearLayout createNewLinearLayoutHORIZONTAL(Context context) {
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setGravity(Gravity.CENTER);

        return layout;
    }

    public static LinearLayout createNewLinearLayoutVERTICAL(Context context) {
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);

        return layout;
    }

    public static RelativeLayout createNewRelativeLayout(Context context) {
        RelativeLayout layout = new RelativeLayout(context);
        layout.setGravity(Gravity.CENTER);

        return layout;
    }

    public static ScrollView createNewScrollView(Context context) {
        ScrollView scrollView = new ScrollView(context);

        return scrollView;
    }
}
