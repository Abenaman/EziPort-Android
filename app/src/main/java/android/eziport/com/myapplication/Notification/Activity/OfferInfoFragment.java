package android.eziport.com.myapplication.Notification.Activity;

import android.eziport.com.myapplication.R;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

import NonActivity.Classes.CustomOfferAdapter;
import NonActivity.Classes.CustomRequestAdapter;
import NonActivity.Classes.OfferDataModel;
import NonActivity.Classes.RequestDataModel;

/**
 * Use the {@link OfferInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OfferInfoFragment extends ListFragment implements AdapterView.OnItemClickListener {


    ArrayList<OfferDataModel> dataModels;
    private static CustomOfferAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_offer_info, container, true);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);




        //---------------------------------------------------


        dataModels= new ArrayList<>();

        dataModels.add(new OfferDataModel("Watches", "5"));
        dataModels.add(new OfferDataModel("Bag", "7"));
        dataModels.add(new OfferDataModel("Book", "3"));
        dataModels.add(new OfferDataModel("Documents", "1"));
        dataModels.add(new OfferDataModel("Watches", "5"));
        dataModels.add(new OfferDataModel("Bag", "7"));
        dataModels.add(new OfferDataModel("Book", "3"));
        dataModels.add(new OfferDataModel("Documents", "1"));
        dataModels.add(new OfferDataModel("Watches", "5"));
        dataModels.add(new OfferDataModel("Bag", "7"));
        dataModels.add(new OfferDataModel("Book", "3"));
        dataModels.add(new OfferDataModel("Documents", "1"));






        adapter= new CustomOfferAdapter(dataModels,getContext());

        setListAdapter(adapter);

        getListView().setOnItemClickListener(this);



        //---------------------------------------------------
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }

    public static OfferInfoFragment newInstance(String text) {

        OfferInfoFragment f = new OfferInfoFragment();
//        Bundle b = new Bundle();
//        b.putString("msg", text);
//
//        f.setArguments(b);

        return f;
    }
}
