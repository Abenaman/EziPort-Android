package android.eziport.com.myapplication.Notification.Activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.eziport.com.myapplication.R;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

import NonActivity.Classes.RequestDataModel;
import NonActivity.Classes.CustomRequestAdapter;

/**
 * Use the {@link RequestInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RequestInfoFragment extends ListFragment implements AdapterView.OnItemClickListener {


    ArrayList<RequestDataModel> dataModels;
    private static CustomRequestAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_request_info, container, true);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);




        //---------------------------------------------------


        dataModels= new ArrayList<>();

        dataModels.add(new RequestDataModel("Watches", "5","Pakistan","Approved"));
        dataModels.add(new RequestDataModel("Bags", "8","India","Pending"));
        dataModels.add(new RequestDataModel("Books", "5","Nigeria","Approved"));
        dataModels.add(new RequestDataModel("Watches", "5","Pakistan","Approved"));
        dataModels.add(new RequestDataModel("Bags", "8","India","Pending"));
        dataModels.add(new RequestDataModel("Books", "5","Nigeria","Approved"));
        dataModels.add(new RequestDataModel("Watches", "5","Pakistan","Approved"));
        dataModels.add(new RequestDataModel("Bags", "8","India","Pending"));
        dataModels.add(new RequestDataModel("Books", "5","Nigeria","Approved"));
        dataModels.add(new RequestDataModel("Watches", "5","Pakistan","Approved"));
        dataModels.add(new RequestDataModel("Bags", "8","India","Pending"));
        dataModels.add(new RequestDataModel("Books", "5","Nigeria","Approved"));
        dataModels.add(new RequestDataModel("Watches", "5","Pakistan","Approved"));
        dataModels.add(new RequestDataModel("Bags", "8","India","Pending"));
        dataModels.add(new RequestDataModel("Books", "5","Nigeria","Approved"));





        adapter= new CustomRequestAdapter(dataModels,getContext());

        setListAdapter(adapter);

        getListView().setOnItemClickListener(this);



        //---------------------------------------------------
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }

    public static RequestInfoFragment newInstance(String text) {

        RequestInfoFragment f = new RequestInfoFragment();
//        Bundle b = new Bundle();
//        b.putString("msg", text);
//
//        f.setArguments(b);

        return f;
    }
}
