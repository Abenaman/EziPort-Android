package android.eziport.com.myapplication.Notification.Activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.eziport.com.myapplication.R;

/**
 * Use the {@link RequestInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RequestInfoFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_request_info, container, false);
    }

    public static RequestInfoFragment newInstance(String text) {

        RequestInfoFragment f = new RequestInfoFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}
