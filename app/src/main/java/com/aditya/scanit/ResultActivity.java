package com.aditya.scanit;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aditya.scanit.ui.gallery.GalleryFragment;

import static com.aditya.scanit.DbBitmapUtility.getBytes;

public class ResultActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView flag;
    private TextView congo;
    private TextView atmBharat;
    private Button viewDB;
    private TextView productText;
    DataBaseHelper myDB;
    public static int India,China,Spain,Tiwan,UAE,SAUDIARABIA,ITLAY,BRAZIL,PHILLIPINES,US,FRANCE,GERMANY,JAPAN,UK,DENMARK,FINLAND,SWITERLAND=0;
    public static int OTHERS=0;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //Back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myDB=new DataBaseHelper(this);
        textView=findViewById(R.id.result);
        flag=findViewById(R.id.flag);
        congo=findViewById(R.id.congo);
        atmBharat=findViewById(R.id.atmBharat);
        viewDB=findViewById(R.id.viewDB);
        productText=findViewById(R.id.textView2);
        Intent intent=getIntent();
        url=intent.getExtras().getString("BarcodeURL");


        String sub=url.substring(0,3);
        String subURL=url.substring(0,2);
        if (sub.equals("890")) {
            textView.setVisibility(View.VISIBLE);
            textView.setText("Made In India");
            India++;
            flag.setVisibility(View.VISIBLE);
            bharat();
            flag.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.india));
            byte[] icon=getBytes(getBitmap(flag));
            Log.v("What",icon.toString());
            boolean isInserted=myDB.insertData(url,"India",icon);
        }
        else if(sub.equals("690") ||sub.equals("691") ||sub.equals("692")||sub.equals("693")||sub.equals("694")||sub.equals("695")){
            textView.setVisibility(View.VISIBLE);
            textView.setText("Made In China");
            flag.setVisibility(View.VISIBLE);
            videshi();
            China++;
            flag.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.china));
            byte[] icon=getBytes(getBitmap(flag));
            boolean isInserted=myDB.insertData(url,"China",icon);
        }
        else if(sub.equals("840") ||sub.equals("841") ||sub.equals("842")||sub.equals("843")||sub.equals("844")||sub.equals("845")||sub.equals("846")||sub.equals("847")||sub.equals("848")||sub.equals("849")){
            textView.setVisibility(View.VISIBLE);
            textView.setText("Made In Spain");
            flag.setVisibility(View.VISIBLE);
            videshi();
            OTHERS++;
            flag.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.spain));
            byte[] icon=getBytes(getBitmap(flag));
            boolean isInserted=myDB.insertData(url,"Spain",icon);
        }
        else if(sub.equals("471")){
            textView.setVisibility(View.VISIBLE);
            textView.setText("Made In Tiwan");
            videshi();
            OTHERS++;
            flag.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.taiwan));
            byte[] icon=getBytes(getBitmap(flag));
            boolean isInserted=myDB.insertData(url,"Tiwan",icon);
        }
        else if(sub.equals("629")){
            textView.setVisibility(View.VISIBLE);
            textView.setText("Made In UAE");
            flag.setVisibility(View.VISIBLE);
            flag.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.unitedarabemirates));
            videshi();
            OTHERS++;
            byte[] icon=getBytes(getBitmap(flag));
            boolean isInserted=myDB.insertData(url,"UAE",icon);
        }
        else if(sub.equals("628")){
            textView.setVisibility(View.VISIBLE);
            textView.setText("Made In Saudi Arabia");
            flag.setVisibility(View.VISIBLE);
            flag.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.saudiarabia));
            videshi();
            OTHERS++;
            byte[] icon=getBytes(getBitmap(flag));
            boolean isInserted=myDB.insertData(url,"Saudi Arabia",icon);
        }
        else if(sub.equals("480")){
            textView.setVisibility(View.VISIBLE);
            textView.setText("Made In Philippines");
            flag.setVisibility(View.VISIBLE);
            videshi();
            OTHERS++;
            flag.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.philippines));
            byte[] icon=getBytes(getBitmap(flag));
            boolean isInserted=myDB.insertData(url,"Philippines",icon);
        }
        else if(sub.equals("800")){
            textView.setVisibility(View.VISIBLE);
            textView.setText("Made In Italy");
            flag.setVisibility(View.VISIBLE);
            videshi();
            OTHERS++;
            flag.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.italy));
            byte[] icon=getBytes(getBitmap(flag));
            boolean isInserted=myDB.insertData(url,"Italy",icon);
        }
        else if(sub.equals("789")||sub.equals("790")){
            textView.setVisibility(View.VISIBLE);
            textView.setText("Made In Brazil");
            flag.setVisibility(View.VISIBLE);
            videshi();
            OTHERS++;
            flag.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.brazil));
            byte[] icon=getBytes(getBitmap(flag));
            boolean isInserted=myDB.insertData(url,"Brazil",icon);
        }
        else if(subURL.equals("00") || subURL.equals("01")|| subURL.equals("02")|| subURL.equals("03")|| subURL.equals("04")|| subURL.equals("05")|| subURL.equals("06")|| subURL.equals("07") ){
            textView.setVisibility(View.VISIBLE);
            textView.setText("Made In Unites States");
            flag.setVisibility(View.VISIBLE);
            flag.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.unitedstates));
            videshi();
            OTHERS++;
            byte[] icon=getBytes(getBitmap(flag));
            boolean isInserted=myDB.insertData(url,"United States",icon);
        }
        else if(subURL.equals("30") || subURL.equals("31")|| subURL.equals("32")|| subURL.equals("33")|| subURL.equals("34")|| subURL.equals("35")|| subURL.equals("36")|| subURL.equals("37") ){
            textView.setVisibility(View.VISIBLE);
            textView.setText("Made In France");
            flag.setVisibility(View.VISIBLE);
            flag.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.france));
            videshi();
            OTHERS++;
            byte[] icon=getBytes(getBitmap(flag));
            boolean isInserted=myDB.insertData(url,"France",icon);
        }

        else if(subURL.equals("40") || subURL.equals("41")|| subURL.equals("42")|| subURL.equals("43")|| subURL.equals("44")){
            textView.setVisibility(View.VISIBLE);
            textView.setText("Made In Germany");
            flag.setVisibility(View.VISIBLE);
            flag.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.germany));
            videshi();
            OTHERS++;
            byte[] icon=getBytes(getBitmap(flag));
            boolean isInserted=myDB.insertData(url,"Germany",icon);
        }


        else if(subURL.equals("45") || subURL.equals("49")){
            textView.setVisibility(View.VISIBLE);
            textView.setText("Made In Japan");
            flag.setVisibility(View.VISIBLE);
            flag.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.japan));
            videshi();
            OTHERS++;
            byte[] icon=getBytes(getBitmap(flag));
            boolean isInserted=myDB.insertData(url,"Japan",icon);
        }

        else if(subURL.equals("50")){
            textView.setVisibility(View.VISIBLE);
            textView.setText("Made In UK");
            flag.setVisibility(View.VISIBLE);
            videshi();OTHERS++;
            flag.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.uk));
            byte[] icon=getBytes(getBitmap(flag));
            boolean isInserted=myDB.insertData(url,"United Kingdom",icon);
        }

        else if(subURL.equals("57")){
            textView.setVisibility(View.VISIBLE);
            textView.setText("Made In Denmark");
            flag.setVisibility(View.VISIBLE);
            flag.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.denmark));
            videshi();OTHERS++;
            byte[] icon=getBytes(getBitmap(flag));
            boolean isInserted=myDB.insertData(url,"Denmark",icon);
        }

        else if(subURL.equals("64")){
            textView.setVisibility(View.VISIBLE);
            textView.setText("Made In Finland");
            flag.setVisibility(View.VISIBLE);
            flag.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.finland));
            videshi();OTHERS++;
            byte[] icon=getBytes(getBitmap(flag));
            boolean isInserted=myDB.insertData(url,"Finland",icon);
        }

        else if(subURL.equals("76")){
            textView.setVisibility(View.VISIBLE);
            textView.setText("Made In SWITZERLAND");
            flag.setVisibility(View.VISIBLE);
            flag.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.switzerland));
            videshi();OTHERS++;
            byte[] icon=getBytes(getBitmap(flag));
            boolean isInserted=myDB.insertData(url,"Switzerland",icon);
        }

        else if(sub.equals("978")){
            textView.setVisibility(View.VISIBLE);
            textView.setText("Product is a Book.");
            flag.setVisibility(View.VISIBLE);
            productText.setVisibility(View.INVISIBLE);
            flag.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.book));
            atmBharat.setVisibility(View.VISIBLE);
            atmBharat.setText("The barcode of a book contains no information about its country of origin.");
        }

        else{
            textView.setText("Inavlid barcode.");
            flag.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.close));
            productText.setVisibility(View.INVISIBLE);
            atmBharat.setVisibility(View.VISIBLE);
            atmBharat.setText("You are trying to search for an invalid barcode,please try again or skip for this product\nNOTE:\nIF you are trying to scan a book,notebook or novel the barcode will be invalid as they don't contain information regarding their country of origin.");
        }

//        viewHistory();
    }

    public  void bharat(){
        congo.setVisibility(View.VISIBLE);
        atmBharat.setVisibility(View.VISIBLE);
        atmBharat.setText("You are contributing towards Aatma-Nirbhar Bharat Initiative.");
    }

    public  void videshi(){
        atmBharat.setVisibility(View.VISIBLE);
        atmBharat.setText("You are  not contributing towards Aatma-Nirbhar Bharat Initiative.Next time be sure to check before you buy");
    }

    //Back button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

public Bitmap getBitmap(ImageView image){
    Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
    return bitmap;
}

}