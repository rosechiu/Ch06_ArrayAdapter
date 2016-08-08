package tw.com.csie.chiu.ch06_arrayadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner drink,temp;
    TextView txv;
    String[] temp1 = {"冰","去冰","溫"};
    String[] temp2 = {"冰","去冰"};
    String[] drinks = {"珍珠奶茶","紅茶豆漿","仙草凍奶茶","檸檬茶"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv = (TextView)findViewById(R.id.txv);
        drink = (Spinner)findViewById(R.id.drink);
        temp = (Spinner)findViewById(R.id.temp);

        drink.setOnItemSelectedListener(this);

        ArrayAdapter<String> drinkAd = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,drinks);
        drinkAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        drink.setAdapter(drinkAd);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String [] tempSet;
        if (position == 3)
            tempSet = temp2;
        else
            tempSet = temp1;

        ArrayAdapter<String> tempAd = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,tempSet);

        tempAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        temp.setAdapter(tempAd);
        
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    
    public void showOrder(View v){
        //將飲料名稱及溫度選擇組成一個字串
        String msg = drink.getSelectedItem() + ", " + temp.getSelectedItem();
        
        //將訂單內容顯示在TextView中
        txv.setText(msg);
        
    }

}
