package com.aditya.scanit;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.aditya.scanit.DbBitmapUtility.getImage;

public class HistoryAdaptor extends RecyclerView.Adapter<HistoryAdaptor.ViewHolder> {
    private List<HistoryModel> historyModelList;

    public HistoryAdaptor(List<HistoryModel> historyModelList) {
        this.historyModelList = historyModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.historycomponent,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String id=historyModelList.get(position).getID();
        String barcode=historyModelList.get(position).getBarNUM();
        String country=historyModelList.get(position).getCountry();
        byte[] image=historyModelList.get(position).getImage();
        Log.v("Image",image.toString());
        holder.setData(id,barcode,country,image);


    }

    @Override
    public int getItemCount() {
        return historyModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView idTXT;
        private TextView barTXT;
        private TextView countryTXT;
        private ImageView countryIMG;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idTXT=itemView.findViewById(R.id.idTXT);
            barTXT=itemView.findViewById(R.id.barnumTXT);
            countryTXT=itemView.findViewById(R.id.countryTXT);
            countryIMG=itemView.findViewById(R.id.Countryimg);
        }
        private  void setData(String id, String bar, String coun,byte[] image){
            idTXT.setText(id);
            barTXT.setText(bar);
            countryTXT.setText(coun);
           Bitmap v= getImage(image);
            countryIMG.setImageBitmap(v);
        }
    }
}
