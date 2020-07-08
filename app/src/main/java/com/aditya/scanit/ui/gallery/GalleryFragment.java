package com.aditya.scanit.ui.gallery;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.scanit.DataBaseHelper;
import com.aditya.scanit.HistoryAdaptor;
import com.aditya.scanit.HistoryModel;
import com.aditya.scanit.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.aditya.scanit.ResultActivity.BRAZIL;
import static com.aditya.scanit.ResultActivity.China;
import static com.aditya.scanit.ResultActivity.DENMARK;
import static com.aditya.scanit.ResultActivity.FINLAND;
import static com.aditya.scanit.ResultActivity.FRANCE;
import static com.aditya.scanit.ResultActivity.GERMANY;
import static com.aditya.scanit.ResultActivity.ITLAY;
import static com.aditya.scanit.ResultActivity.India;
import static com.aditya.scanit.ResultActivity.JAPAN;
import static com.aditya.scanit.ResultActivity.OTHERS;
import static com.aditya.scanit.ResultActivity.PHILLIPINES;
import static com.aditya.scanit.ResultActivity.SAUDIARABIA;
import static com.aditya.scanit.ResultActivity.SWITERLAND;
import static com.aditya.scanit.ResultActivity.Tiwan;
import static com.aditya.scanit.ResultActivity.UAE;
import static com.aditya.scanit.ResultActivity.UK;
import static com.aditya.scanit.ResultActivity.US;

public class GalleryFragment extends Fragment {

    private Button viewDBBTN;
    DataBaseHelper myDB;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);


        recyclerView=root.findViewById(R.id.HistoryRV);
        myDB=new DataBaseHelper(getContext());
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        Cursor res =myDB.getAllData();
        if (res.getCount() ==0){
            //show message
            Log.v("das","No data");
        }

        List<HistoryModel> historyModelList=new ArrayList<>();
        while(res.moveToNext()){
            String IDTEXT=res.getString(0);
            String BarNUM=res.getString(1);
            String Country=res.getString(2);
            byte[] countryIMG=res.getBlob(3);
            historyModelList.add(new HistoryModel(IDTEXT,BarNUM,Country,countryIMG));
        }
        HistoryAdaptor historyAdaptor=new HistoryAdaptor(historyModelList);
        recyclerView.setAdapter(historyAdaptor);
        historyAdaptor.notifyDataSetChanged();

        setChart(root);


        return root;
    }


    private void setChart(View root){

        PieChart pieChart=root.findViewById(R.id.pieChart);
        pieChart.setUsePercentValues(true);

//        Description description=new Description();
//        description.setText("This is a product vs country pie chart");
//        description.setTextSize(20f);
//        pieChart.setDescription(description);

        pieChart.setDescription(null);


        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleRadius(25f);

        List<PieEntry> value=new ArrayList<>();
        value.add(new PieEntry(India,"India"));
        value.add(new PieEntry(China,"China"));
        value.add(new PieEntry(OTHERS,"Others"));
//        value.add(new PieEntry(JAPAN,"Japan"));
//        value.add(new PieEntry(US,"US"));
//        value.add(new PieEntry(ITLAY,"Itlay"));
//        value.add(new PieEntry(FRANCE,"France"));
//        value.add(new PieEntry(UAE,"UAE"));
//        value.add(new PieEntry(SAUDIARABIA,"Saudi Arabia"));
//        value.add(new PieEntry(Tiwan,"Tiwan"));
//        value.add(new PieEntry(GERMANY,"Germany"));
//        value.add(new PieEntry(UK,"UK"));
//        value.add(new PieEntry(DENMARK,"Denmark"));
//        value.add(new PieEntry(FINLAND,"Finland"));
//        value.add(new PieEntry(PHILLIPINES,"PHILLIPINES"));
//        value.add(new PieEntry(SWITERLAND,"Switzerland"));
        PieDataSet pieDataSet=new PieDataSet(value,"");
        PieData pieData=new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS );


    }
}