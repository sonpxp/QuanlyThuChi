package com.example.dell.quanly.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.quanly.R;

import java.util.List;

public class XuLyAdapter extends BaseAdapter {
    private Context context;
    int layout;
    List<Xuly> xulyList;

    @Override
    public int getCount() {
        return xulyList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layout,null);

            viewHolder.tvten=convertView.findViewById(R.id.tvten);
            viewHolder.imgghi=convertView.findViewById(R.id.ghi);
            viewHolder.imgxoa=convertView.findViewById(R.id.xoa);

            convertView.setTag(viewHolder);

        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }

        Xuly xuly=xulyList.get(position);
        viewHolder.tvten.setText(xuly.getTen());

        return null;
    }

   private class ViewHolder{
        TextView tvten;
        ImageView imgxoa,imgghi;

   }
}
