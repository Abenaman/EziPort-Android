package NonActivity.Classes;

import android.content.Context;
import android.content.Intent;
import android.eziport.com.myapplication.Home;
import android.eziport.com.myapplication.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mahir Gulzar on 2/8/2018.
 */

public class CustomOfferAdapter extends ArrayAdapter<OfferDataModel> {

//    public static String ChoosenDate;
    private ArrayList<OfferDataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtTitle;
        TextView txtWeight;
        Button btnAction;

    }

    public CustomOfferAdapter(ArrayList<OfferDataModel> data, Context context) {
        super(context, R.layout.requests_row_item, data);
        this.dataSet = data;
        this.mContext=context;

    }



    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        OfferDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        CustomOfferAdapter.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new CustomOfferAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.offer_row_item, parent, false);
            viewHolder.txtTitle = (TextView) convertView.findViewById(R.id.TitleOfRequest);
            viewHolder.txtWeight = (TextView) convertView.findViewById(R.id.WeightOfRequest);
            viewHolder.btnAction= (Button) convertView.findViewById(R.id.accept);


            viewHolder.txtTitle.setText(this.dataSet.get(position).getTitle());
            viewHolder.txtWeight.setText(this.dataSet.get(position).getWeight());


            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CustomOfferAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }
        final int pos =position;
        viewHolder.btnAction = (Button) convertView.findViewById(R.id.accept);
        viewHolder.btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Object object= getItem(pos);
                OfferDataModel dataModel=(OfferDataModel)object;

//             Log.d("Yooo","yr hora ha................."+CustomSearchAdapter.ChoosenDate);

                Intent intent = new Intent(mContext, Home.class);
                mContext.startActivity(intent);

            }
        });

        return convertView;
    }
}