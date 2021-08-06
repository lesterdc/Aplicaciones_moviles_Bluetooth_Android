package com.example.bluetooth_carranza;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_encender;
    private Button btn_apagar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_encender = (Button) findViewById(R.id.btn_encender);
        btn_apagar = (Button) findViewById(R.id.btn_apagar);
        final BluetoothAdapter bAdapter = BluetoothAdapter.getDefaultAdapter();
        btn_encender.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(bAdapter==null){
                    Toast.makeText(getApplicationContext(),"Bluethooth no soportado",Toast.LENGTH_LONG).show();
                }else{
                    if(!bAdapter.isEnabled()){
                        startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE),1);
                        Toast.makeText(getApplicationContext(),"Bluetooth encendido",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        btn_apagar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                bAdapter.disable();
                Toast.makeText(getApplicationContext(),"Bluetooth apagado",Toast.LENGTH_LONG).show();
            }
        });
    }
}