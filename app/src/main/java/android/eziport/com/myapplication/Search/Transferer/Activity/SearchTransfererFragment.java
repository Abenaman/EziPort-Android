package android.eziport.com.myapplication.Search.Transferer.Activity;

import android.eziport.com.myapplication.R;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

import NonActivity.Classes.CustomSearchAdapter;
import NonActivity.Classes.SearchDataModel;


/**
 * A placeholder fragment containing a simple view.
 */
public class SearchTransfererFragment extends ListFragment implements AdapterView.OnItemClickListener{

    ArrayList<SearchDataModel> dataModels;
    private static CustomSearchAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_search_transferer, container, true);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);




        //---------------------------------------------------


        dataModels= new ArrayList<>();

        dataModels.add(new SearchDataModel("11/2/2018", "5"));
        dataModels.add(new SearchDataModel("11/2/2018", "6"));
        dataModels.add(new SearchDataModel("11/2/2018", "7"));
        dataModels.add(new SearchDataModel("11/2/2018", "8"));
        dataModels.add(new SearchDataModel("11/2/2018", "9"));
        dataModels.add(new SearchDataModel("11/2/2018", "10"));
        dataModels.add(new SearchDataModel("11/2/2018", "11"));




        adapter= new CustomSearchAdapter(dataModels,getContext());

        setListAdapter(adapter);

        getListView().setOnItemClickListener(this);



        //---------------------------------------------------
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }
}
