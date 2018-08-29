package com.example.dayeon.capstone;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Integer.parseInt;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DashboardFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView textView;

    phpdo task;

    private OnFragmentInteractionListener mListener;

    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }

        task = new phpdo();
        task.execute("a");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        return view;
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
    private  class phpdo extends AsyncTask<String,Void,String> {


        @Override
        protected String doInBackground(String... arg0) {

            String ID=arg0[0];

            try{

                String link = "http://ec2-54-180-8-72.ap-northeast-2.compute.amazonaws.com/test_2.php?ID="+ID;
                URL url = new URL(link);
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(link));
                HttpResponse response = client.execute(request);
                BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                StringBuffer sb = new StringBuffer("");
                String line = "";

                while((line=in.readLine())!=null){
                    sb.append(line);
                    break;
                }
                in.close();
                return sb.toString();

            }catch (Exception e){
                return new String("Exception: "+e.getMessage());
            }

        }
        @Override
        protected void onPostExecute(String result){

            TextView textView1 = (TextView)getView().findViewById(R.id.HeartRate);
            TextView textView2 = (TextView)getView().findViewById(R.id.Temperate);

            textView1.setText("◆  HEART RATE : "+result);

            DrawChart(result);

        }



        public void DrawChart(String result)
        {
            LineChart lineChart = (LineChart)getView().findViewById(R.id.chart);

            ArrayList<Entry> entries = new ArrayList<>();
            entries.add(new Entry(0,0));
            entries.add(new Entry(2,1));
            entries.add(new Entry(parseInt(result),2));
            entries.add(new Entry(3,3));
            entries.add(new Entry(4,4));
            entries.add(new Entry(1,5));

            ArrayList<Entry> entries1 = new ArrayList<>();
            entries1.add(new Entry(1,0));
            entries1.add(new Entry(4,1));
            entries1.add(new Entry(parseInt(result),2));
            entries1.add(new Entry(1,3));
            entries1.add(new Entry(1,4));
            entries1.add(new Entry(2,5));

            ArrayList<String> labels = new ArrayList<String>();
            labels.add("1시");
            labels.add("2시");
            labels.add("3시");
            labels.add("4시");
            labels.add("5시");
            labels.add("6시");

            LineDataSet dataset1 = new LineDataSet(entries, "");
            LineDataSet dataset2 = new LineDataSet(entries1, "");

            dataset1.setLineWidth(3.5f);
            dataset1.setDrawCircles(false);
            dataset1.setColors(Collections.singletonList(Color.parseColor("#FFFA508A")));
            dataset1.setValueTextColor(Color.DKGRAY);
            dataset1.setValueTextSize(10);


            dataset2.setLineWidth(3.5f);
            dataset2.setDrawCircles(false);
            dataset2.setColors(Collections.singletonList(Color.parseColor("#8b8682")));
            dataset2.setValueTextColor(Color.DKGRAY);
            dataset2.setValueTextSize(10);

            LineData data = new LineData(labels,dataset1);
            data.addDataSet(dataset2);
            lineChart.setData(data);


            lineChart.setNoDataTextDescription(null);
            lineChart.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
            lineChart.getRenderer().getPaintRender().setShadowLayer(15,15,15,Color.LTGRAY);
            lineChart.setDrawBorders(false);
            lineChart.setDescription("");
            lineChart.setDrawGridBackground(false);
            lineChart.setTouchEnabled(false);
            lineChart.setDragEnabled(false);
            lineChart.setScaleEnabled(false);
            lineChart.setPinchZoom(false);
            lineChart.getXAxis().setDrawGridLines(false);
            lineChart.getXAxis().setGridColor(Color.TRANSPARENT);
            lineChart.getAxisLeft().setGridColor(Color.WHITE & 0x70FFFFFF);
            lineChart.getXAxis().setAxisLineColor(Color.LTGRAY);// x축 선 색상
            lineChart.getXAxis().setAxisLineWidth(0); // x축 선 굵기
            lineChart.getAxisLeft().setAxisLineColor(Color.LTGRAY);// y축 선 색상
            lineChart.getAxisLeft().setAxisLineWidth(0); //y축 선 굵기
            lineChart.getXAxis().setTextColor(Color.parseColor("#8b8682")); // x축 글씨 색상
            lineChart.getAxisLeft().setTextColor(Color.parseColor("#8b8682")); // y축 글씨 색상
            lineChart.getAxisRight().setEnabled(false);
            Legend mLegend = lineChart.getLegend();
            mLegend.setForm(com.github.mikephil.charting.components.Legend.LegendForm.SQUARE);
            mLegend.setFormSize(6f);

            lineChart.animateY(2000);

        }

    }
}
