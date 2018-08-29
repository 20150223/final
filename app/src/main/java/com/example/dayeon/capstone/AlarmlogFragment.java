package com.example.dayeon.capstone;

import android.app.ListFragment;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AlarmlogFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AlarmlogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlarmlogFragment extends ListFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ListAdapter adapter;

    public AlarmlogFragment() {
        // Required empty public constructor
    }


    public static AlarmlogFragment newInstance(String param1, String param2) {
        AlarmlogFragment fragment = new AlarmlogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

//          listView = (ListView)getView().findViewById(R.id.listView);
//        alarmList = new ArrayList<Alarm>();
//
//        alarmList.add(new Alarm("2018.06.03.SUN","22:03:04","Abnormal heart rate","90bpm"));
//        alarmList.add(new Alarm("2018.06.03.SUN","22:03:04","Fall down detection",""));
//        alarmList.add(new Alarm("2018.06.03.SUN","22:03:04","Abnormal temperature","39"));
//        alarmList.add(new Alarm("2018.06.03.SUN","22:03:04","not moving detection",""));
//
//        adapter = new ListAdapter(getActivity().getApplicationContext(),alarmList);
//        listView.setAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        List<Alarm> alarmList;

        alarmList = new ArrayList<Alarm>();

        alarmList.add(new Alarm("2018.06.03.SUN","22:03:04","Abnormal heart rate","90bpm",getResources().getDrawable(R.drawable.alarmheart)));
        alarmList.add(new Alarm("2018.06.03.SUN","22:03:04","Fall down detection","",getResources().getDrawable(R.drawable.alarmfall)));
        alarmList.add(new Alarm("2018.06.03.SUN","22:03:04","Abnormal temperature","39",getResources().getDrawable(R.drawable.alarmtemp)));
        alarmList.add(new Alarm("2018.06.03.SUN","22:03:04","not moving detection","",getResources().getDrawable(R.drawable.alarmnot)));
        alarmList.add(new Alarm("2018.06.03.SUN","22:03:04","Abnormal heart rate","90bpm",getResources().getDrawable(R.drawable.alarmheart)));
        alarmList.add(new Alarm("2018.06.03.SUN","22:03:04","not moving detection","",getResources().getDrawable(R.drawable.alarmnot)));
        alarmList.add(new Alarm("2018.06.03.SUN","22:03:04","not moving detection","",getResources().getDrawable(R.drawable.alarmnot)));
        alarmList.add(new Alarm("2018.06.03.SUN","22:03:04","Fall down detection","",getResources().getDrawable(R.drawable.alarmfall)));
        alarmList.add(new Alarm("2018.06.03.SUN","22:03:04","Fall down detection","",getResources().getDrawable(R.drawable.alarmfall)));
        alarmList.add(new Alarm("2018.06.03.SUN","22:03:04","Fall down detection","",getResources().getDrawable(R.drawable.alarmfall)));
        alarmList.add(new Alarm("2018.06.03.SUN","22:03:04","not moving detection","",getResources().getDrawable(R.drawable.alarmnot)));
        alarmList.add(new Alarm("2018.06.03.SUN","22:03:04","Fall down detection","",getResources().getDrawable(R.drawable.alarmfall)));
        alarmList.add(new Alarm("2018.06.03.SUN","22:03:04","Fall down detection","",getResources().getDrawable(R.drawable.alarmfall)));
        alarmList.add(new Alarm("2018.06.03.SUN","22:03:04","Abnormal temperature","39",getResources().getDrawable(R.drawable.alarmtemp)));


        adapter = new ListAdapter(getActivity().getApplicationContext(),alarmList);
        setListAdapter(adapter);

        return super.onCreateView(inflater,container,savedInstanceState);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
