package NonActivity.Classes;

import android.content.Context;
import android.content.Intent;
import android.eziport.com.myapplication.R;
import android.eziport.com.myapplication.SenderFormActivity;
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

public class CustomSearchAdapter extends ArrayAdapter<SearchDataModel>{

    public static String ChoosenDate;
    private ArrayList<SearchDataModel> dataSet;
    Context mContext,nextContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtDate;
        TextView txtWeight;
        Button btnProceed;
    }

    public CustomSearchAdapter(ArrayList<SearchDataModel> data, Context context) {
        super(context, R.layout.search_row_item, data);
        this.dataSet = data;
        this.mContext=context;
//        this.nextContext=nextContext;

    }



    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        SearchDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.search_row_item, parent, false);
            viewHolder.txtDate = (TextView) convertView.findViewById(R.id.dateofTransferer);
            viewHolder.txtWeight = (TextView) convertView.findViewById(R.id.weight_allowed);
            viewHolder.btnProceed = (Button) convertView.findViewById(R.id.proceed);
            viewHolder.txtDate.setText(this.dataSet.get(position).getDate());
            viewHolder.txtWeight.setText(this.dataSet.get(position).getWeight());

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }
        final int pos =position;
        viewHolder.btnProceed = (Button) convertView.findViewById(R.id.proceed);
        viewHolder.btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            Object object= getItem(pos);
            SearchDataModel dataModel=(SearchDataModel)object;

            CustomSearchAdapter.ChoosenDate=dataModel.getWeight();

//             Log.d("Yooo","yr hora ha................."+CustomSearchAdapter.ChoosenDate);
                LayoutInflater li = LayoutInflater.from(getContext());
                View view1 = li.inflate(R.layout.activity_sender_form, null); //
                EditText edt= (EditText)view1.findViewById(R.id.weightBox);
                edt.setText(CustomSearchAdapter.ChoosenDate);
                Intent intent = new Intent(mContext, SenderFormActivity.class);
                mContext.startActivity(intent);

            }
        });

        return convertView;
    }
}
