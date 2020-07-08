package com.aditya.scanit.ui.home;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainer;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.aditya.scanit.R;
import com.aditya.scanit.ResultActivity;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private EditText barcodeTXT;
    private Button scanBTN;
    private Button searchBTN;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        barcodeTXT=root.findViewById(R.id.barcodeTXT);
        searchBTN = root.findViewById(R.id.SearchBTN);
        scanBTN=root.findViewById(R.id.scanBTN);
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, PackageManager.PERMISSION_GRANTED);


        searchBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String BarcodeURL=barcodeTXT.getText().toString();
                Intent intent=new Intent(getActivity(), ResultActivity.class);
                intent.putExtra("BarcodeURL",BarcodeURL);
                startActivity(intent);
            }
        });

        scanBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                     ScanButton(view);
            }
        });
        return root;
    }
    public void ScanButton(View view){
        //-----------------------for activity---------------------------------------------------/
        //        IntentIntegrator intentIntegrator = new IntentIntegrator(getActivity());
        //        intentIntegrator.initiateScan();
        //-----------------------for fragment-------------------------------------------------/
        IntentIntegrator.forSupportFragment(this).initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null){
            if (intentResult.getContents() == null){
                String url="Invalid Barcode";
                Intent intent=new Intent(getContext(),ResultActivity.class);
                intent.putExtra("BarcodeURL",url);
                startActivity(intent);
            }
            else {
                String url =intentResult.getContents();
                Intent intent=new Intent(getContext(),ResultActivity.class);
                intent.putExtra("BarcodeURL",url);
                startActivity(intent);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}