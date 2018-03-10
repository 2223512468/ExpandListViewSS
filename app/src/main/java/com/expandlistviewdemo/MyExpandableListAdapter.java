package com.expandlistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MyExpandableListAdapter extends BaseExpandableListAdapter {

    Context context;
    List<MyModel> models;

    List<ParentViewHolder> parentItems = new ArrayList<ParentViewHolder>();
    List<View> views = new ArrayList<View>();

    public MyExpandableListAdapter(Context context, List<MyModel> models) {
        super();
        this.context = context;
        this.models = models;
        parentItems = getParentViewHolders(20);
    }

    @Override
    public Object getChild(int arg0, int arg1) {
        // TODO Auto-generated method stub
        //return models.get(arg0);
        return 20;
    }

    @Override
    public long getChildId(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return 0;
    }

    View tempView;
    View tempView2;

    @Override
    public View getChildView(int arg0, int arg1, boolean arg2, View convertView,
                             ViewGroup parent) {
        // TODO Auto-generated method stub


        convertView = LayoutInflater.from(context).inflate(R.layout.category_expandlv_itemtwo, parent, false);

        final LinearLayout layout = (LinearLayout) convertView.findViewById(R.id.category_llyt_itemtwo_three);
        TextView tv1 = (TextView) convertView.findViewById(R.id.category_tvone_itemtwo);
        TextView tv2 = (TextView) convertView.findViewById(R.id.category_tvtwo_itemtwo);
        TextView tv3 = (TextView) convertView.findViewById(R.id.category_tvthree_itemtwo);
        TextView tv4 = (TextView) convertView.findViewById(R.id.category_tvfour_itemtwo);

        if (tempView == null) {
            tempView = tv1;
        }
        if (tempView2 == null) {
            tempView2 = layout;
        }


        tv1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                tempView.setBackgroundResource(R.drawable.categroy_tv_itemtwo_bg_normal);
                tempView2.setVisibility(View.GONE);
                tempView = v;
                tempView2 = layout;
                layout.setVisibility(View.VISIBLE);
                v.setBackgroundResource(R.drawable.categroy_tv_itemtwo_bg_select);
            }
        });


        tv2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                tempView.setBackgroundResource(R.drawable.categroy_tv_itemtwo_bg_normal);
                tempView2.setVisibility(View.GONE);
                tempView = v;
                tempView2 = layout;
                layout.setVisibility(View.VISIBLE);
                v.setBackgroundResource(R.drawable.categroy_tv_itemtwo_bg_select);
            }
        });


        tv3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                tempView.setBackgroundResource(R.drawable.categroy_tv_itemtwo_bg_normal);
                tempView2.setVisibility(View.GONE);
                tempView = v;
                tempView2 = layout;
                layout.setVisibility(View.VISIBLE);
                v.setBackgroundResource(R.drawable.categroy_tv_itemtwo_bg_select);
            }
        });


        tv4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                tempView.setBackgroundResource(R.drawable.categroy_tv_itemtwo_bg_normal);
                tempView2.setVisibility(View.GONE);
                tempView = v;
                tempView2 = layout;
                layout.setVisibility(View.VISIBLE);
                v.setBackgroundResource(R.drawable.categroy_tv_itemtwo_bg_select);
            }
        });
        //getChild(arg0, 0);

        return convertView;
    }

    @Override
    public int getChildrenCount(int arg0) {
        // TODO Auto-generated method stub
        return (int) (Math.random() * 5) + 1;
    }

    @Override
    public Object getGroup(int arg0) {
        // TODO Auto-generated method stub
        //return models.get(arg0);
        return 20;
    }

    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub
        //return models.size();
        return 20;
    }

    @Override
    public long getGroupId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getGroupView(final int arg0, boolean arg1, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        return views.get(arg0);

        //	getGroup(arg0);
    }

    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isChildSelectable(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        // TODO Auto-generated method stub
        System.out.println(groupPosition + "CollapsedCollapsedCollapsed");
        parentItems.get(groupPosition).parentItem.setBackgroundResource(R.drawable.category_expandlv_itemone_bg_normal);
        parentItems.get(groupPosition).arrow.setBackgroundResource(R.drawable.category_iv_oneitem_arrow_down);
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        System.out.println(groupPosition + "ExpandedExpandedExpandedExpanded--" + parentItems.size());
        // TODO Auto-generated method stub
        parentItems.get(groupPosition).parentItem.setBackgroundResource(R.drawable.category_expandlv_itemone_bg_select);
        parentItems.get(groupPosition).arrow.setBackgroundResource(R.drawable.category_iv_oneitem_arrow_up);
    }

    @Override
    public int getChildType(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return super.getChildType(groupPosition, childPosition);
    }

    @Override
    public int getGroupType(int groupPosition) {
        // TODO Auto-generated method stub
        return super.getGroupType(groupPosition);
    }


    List<ParentViewHolder> getParentViewHolders(int count) {

        List<ParentViewHolder> holders = new ArrayList<ParentViewHolder>();
        for (int i = 0; i < count; i++) {
            ParentViewHolder holder = new ParentViewHolder();
            View convertView = LayoutInflater.from(context).inflate(R.layout.category_expandlv_itemone, null, false);
            views.add(convertView);
            RelativeLayout parentItem = (RelativeLayout) convertView.findViewById(R.id.category_rlyt_oneitem);


            TextView title = (TextView) convertView.findViewById(R.id.category_tv_oneitem);
            ImageView arrow = (ImageView) convertView.findViewById(R.id.category_iv_itemone_arrow);

            holder.parentItem = parentItem;
            holder.title = title;
            holder.arrow = arrow;

            holders.add(holder);
        }
        return holders;

    }


    class ParentViewHolder {
        RelativeLayout parentItem;
        TextView title;
        ImageView arrow;
    }

    class ChildViewHolder {

    }


}
