package NonActivity.Classes;

import android.content.Context;
import android.content.Intent;
import android.eziport.com.myapplication.R;
import android.eziport.com.myapplication.SenderFormActivity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mahir Gulzar on 2/8/2018.
 */

public class CustomRequestAdapter extends ArrayAdapter<RequestDataModel> {

//    public static String ChoosenDate;
    private ArrayList<RequestDataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtTitle;
        TextView txtWeight;
        TextView txtTo;
        TextView txtState;

    }

    public CustomRequestAdapter(ArrayList<RequestDataModel> data, Context context) {
        super(context, R.layout.requests_row_item, data);
        this.dataSet = data;
        this.mContext=context;

    }



    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        RequestDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        CustomRequestAdapter.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new CustomRequestAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.requests_row_item, parent, false);
            viewHolder.txtTitle = (TextView) convertView.findViewById(R.id.TitleOfRequest);
            viewHolder.txtWeight = (TextView) convertView.findViewById(R.id.WeightOfRequest);
            viewHolder.txtTo = (TextView) convertView.findViewById(R.id.ToOfRequest);
            viewHolder.txtState = (TextView) convertView.findViewById(R.id.StatusOfRequest);


            viewHolder.txtTitle.setText(this.dataSet.get(position).getTitle());
            viewHolder.txtWeight.setText(this.dataSet.get(position).getWeight());
            viewHolder.txtTo.setText(this.dataSet.get(position).getTo());
            viewHolder.txtState.setText(this.dataSet.get(position).getState());

            if(this.dataSet.get(position).getState()=="Approved")
            {
                viewHolder.txtState.setBackgroundColor(Color.parseColor("#21DA21"));
            }
            else if(this.dataSet.get(position).getState()=="Rejected")
            {
                viewHolder.txtState.setBackgroundColor(Color.parseColor("#FF3B3B"));
            }
            else
            {
                viewHolder.txtState.setBackgroundColor(Color.parseColor("#C4C920"));
            }


            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CustomRequestAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }
//        final int pos =position;
//        viewHolder.btnProceed = (Button) convertView.findViewById(R.id.proceed);
//        viewHolder.btnProceed.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//
//                Object object= getItem(pos);
//                SearchDataModel dataModel=(SearchDataModel)object;
//
//                CustomSearchAdapter.ChoosenDate=dataModel.getWeight();
//
////             Log.d("Yooo","yr hora ha................."+CustomSearchAdapter.ChoosenDate);
//                LayoutInflater li = LayoutInflater.from(getContext());
//                View view1 = li.inflate(R.layout.activity_sender_form, null); //
//                EditText edt= (EditText)view1.findViewById(R.id.weightBox);
//                edt.setText(CustomSearchAdapter.ChoosenDate);
//                Intent intent = new Intent(mContext, SenderFormActivity.class);
//                mContext.startActivity(intent);
//
//            }
//        });

        return convertView;
    }
}