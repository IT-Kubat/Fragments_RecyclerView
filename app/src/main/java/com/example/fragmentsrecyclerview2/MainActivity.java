package com.example.fragmentsrecyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CarAdapter.ItemClicked {

    Button btn_car_info, btn_owner_info;
    ImageView ivMake;
    TextView tvModel, tvName, tvTelNumber;
    FragmentManager fragmentManager;
    Fragment listFrag, carInfoFrag, ownerInfoFrag, buttonFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_car_info = findViewById(R.id.btn_car_info);
        btn_owner_info = findViewById(R.id.btn_owner_info);
        ivMake = findViewById(R.id.ivMake);
        tvModel = findViewById(R.id.tvModel);
        tvName = findViewById(R.id.tvName);
        tvTelNumber = findViewById(R.id.tvTelNumber);

        fragmentManager = getSupportFragmentManager();

        listFrag = fragmentManager.findFragmentById(R.id.list_fragment);
        carInfoFrag = fragmentManager.findFragmentById(R.id.carInfoFrag);
        ownerInfoFrag = fragmentManager.findFragmentById(R.id.ownerInfoFrag);
        buttonFrag = fragmentManager.findFragmentById(R.id.buttonFrag);

        fragmentManager.beginTransaction()
                .show(buttonFrag)
                .show(listFrag)
                .show(carInfoFrag)
                .hide(ownerInfoFrag)
                .commit();

        btn_car_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .show(carInfoFrag)
                        .hide(ownerInfoFrag)
                        .commit();

            }
        });

        btn_owner_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .hide(carInfoFrag)
                        .show(ownerInfoFrag)
                        .commit();

            }
        });

        onItemClicked(0);
    }


    @Override
    public void onItemClicked(int index) {

        tvName.setText(ApplicationClass.cars.get(index).getOwnerName());
        tvModel.setText(ApplicationClass.cars.get(index).getModel());
        tvTelNumber.setText(ApplicationClass.cars.get(index).getOwnerTel());

        if (ApplicationClass.cars.get(index).getMake().equals("Toyota"))
        {
            ivMake.setImageResource(R.drawable.toyota1);
        }
        else if (ApplicationClass.cars.get(index).getMake().equals("Mersedez"))
        {
            ivMake.setImageResource(R.drawable.mersedez);
        }
        else
            {
                ivMake.setImageResource(R.drawable.honda);
        }

    }
}
