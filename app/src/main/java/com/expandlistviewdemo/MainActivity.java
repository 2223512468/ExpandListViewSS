package com.expandlistviewdemo;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {


    int tempPosition = 0;
    private ExpandableListView extListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_body);
        intiView();
    }


    private void intiView() {
        // TODO Auto-generated method stub

        extListView = (ExpandableListView) findViewById(R.id.category_new_expandList);
        extListView.setGroupIndicator(null);
        List<MyModel> models = new ArrayList<MyModel>();

        MyModel model1 = new MyModel();
        models.add(model1);
        MyExpandableListAdapter adapter = new MyExpandableListAdapter(this, models);
        extListView.setAdapter(adapter);


        extListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                // TODO Auto-generated method stub
                if (tempPosition != groupPosition) {
                    extListView.collapseGroup(tempPosition);
                    tempPosition = groupPosition;
                }

            }
        });


        extListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                // TODO Auto-generated method stub
                //extListView.getSelectedView().setBackgroundResource(R.drawable.category_expandlv_itemone_bg_select);
            }
        });


        extListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this, "dd", 1).show();

                v.setBackgroundResource(R.drawable.category_expandlv_itemone_bg_select);
                v.invalidate();
                v.postInvalidate();
                return false;
            }
        });
    }


}
