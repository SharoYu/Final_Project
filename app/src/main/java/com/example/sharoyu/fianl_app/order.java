package com.example.sharoyu.fianl_app;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class order extends AppCompatActivity {
int n,m;
    String l;
    int h;
    SQLiteDatabase oh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Bundle g = this.getIntent().getExtras();
        n=g.getInt("num");
        m=g.getInt("grid");

        final Data[] hamdata = new Data[9];

        for(int i=0;i<hamdata.length;i++)
        {
            hamdata[i] = new Data();
        }
        hamdata[0].name="豬肉堡";
        hamdata[0].photo=R.drawable.pork_ham;
        hamdata[0].price = "30";
        hamdata[1].name="香雞堡";
        hamdata[1].photo=R.drawable.chicken_ham;
        hamdata[1].price = "30";
        hamdata[2].name="鱈魚堡";
        hamdata[2].price = "40";
        hamdata[2].photo=R.drawable.fish_ham;
        hamdata[3].name="鮮蝦堡";
        hamdata[3].photo=R.drawable.shrimp_ham;
        hamdata[3].price = "45";
        hamdata[4].name="牛肉堡";
        hamdata[4].photo=R.drawable.beef_ham;
        hamdata[4].price = "40";
        hamdata[5].name="卡啦雞腿堡";
        hamdata[5].photo=R.drawable.friedchk_ham;
        hamdata[5].price = "45";
        hamdata[6].name="培根蛋堡";
        hamdata[6].photo=R.drawable.baconegg_ham;
        hamdata[6].price = "25";
        hamdata[7].name="鮪魚蛋堡";
        hamdata[7].price = "35";
        hamdata[7].photo=R.drawable.tuna_ham;
        hamdata[8].name="火腿蛋堡";
        hamdata[8].photo=R.drawable.ham_ham;
        hamdata[8].price = "25";

        Data[] thickdata = new Data[5];
        for(int i=0;i<thickdata.length;i++)
        {
            thickdata[i] = new Data();
        }
        thickdata[0].name="巧克力厚片";
        thickdata[0].photo=R.drawable.choco_toast;
        thickdata[0].price="20";
        thickdata[1].name="花生厚片";
        thickdata[1].photo=R.drawable.pinut_toast;
        thickdata[1].price="20";
        thickdata[2].name="草莓厚片";
        thickdata[2].photo=R.drawable.strawberry_toast;
        thickdata[2].price="20";
        thickdata[3].name="奶酥厚片";
        thickdata[3].photo=R.drawable.milk_toast;
        thickdata[3].price="20";
        thickdata[4].name="香蒜厚片";
        thickdata[4].photo=R.drawable.garlic_toast;
        thickdata[4].price="20";

        Data[] toastdata = new Data[7];
        for(int i=0;i<toastdata.length;i++)
        {
            toastdata[i] = new Data();
        }
        toastdata[0].name="綜合吐司";
        toastdata[0].photo=R.drawable.t1;
        toastdata[0].price="55";
        toastdata[1].name="里肌吐司";
        toastdata[1].photo=R.drawable.t2;
        toastdata[1].price="45";
        toastdata[2].name="火腿吐司";
        toastdata[2].photo=R.drawable.t3;
        toastdata[2].price="30";
        toastdata[3].name="培根吐司";
        toastdata[3].photo=R.drawable.t4;
        toastdata[3].price="30";
        toastdata[4].name="鮪魚吐司";
        toastdata[4].photo=R.drawable.t5;
        toastdata[4].price="35";
        toastdata[5].name="總匯吐司";
        toastdata[5].photo=R.drawable.t6;
        toastdata[5].price="50";
        toastdata[6].name="果醬吐司";
        toastdata[6].photo=R.drawable.t7;
        toastdata[6].price="15";

        Data[] pastrydata = new Data[10];
        for(int i=0;i<pastrydata.length;i++)
        {
            pastrydata[i] = new Data();
        }
        pastrydata[0].name="玉米蛋餅";
        pastrydata[0].photo=R.drawable.p1;
        pastrydata[0].price = "30";
        pastrydata[1].name="火腿蛋餅";
        pastrydata[1].photo=R.drawable.p2;
        pastrydata[1].price = "30";
        pastrydata[2].name="肉鬆蛋餅";
        pastrydata[2].photo=R.drawable.p3;
        pastrydata[2].price = "30";
        pastrydata[3].name="里肌蛋餅";
        pastrydata[3].photo=R.drawable.p4;
        pastrydata[3].price = "40";
        pastrydata[4].name="美生菜絲蛋餅";
        pastrydata[4].photo=R.drawable.p5;
        pastrydata[4].price = "25";
        pastrydata[5].name="起司蛋餅";
        pastrydata[5].photo=R.drawable.p6;
        pastrydata[5].price = "30";
        pastrydata[6].name="培根蛋餅";
        pastrydata[6].photo=R.drawable.p7;
        pastrydata[6].price = "30";
        pastrydata[7].name="熱狗蛋餅";
        pastrydata[7].photo=R.drawable.p8;
        pastrydata[7].price = "30";
        pastrydata[8].name="鮪魚蛋餅";
        pastrydata[8].photo=R.drawable.p9;
        pastrydata[8].price = "35";
        pastrydata[9].name="燻雞蛋餅";
        pastrydata[9].photo=R.drawable.p10;
        pastrydata[9].price = "40";

        Data[] drinkdata = new Data[7];
        for(int i=0;i<drinkdata.length;i++)
        {
            drinkdata[i] = new Data();
        }
        drinkdata[0].name="紅茶";
        drinkdata[0].photo=R.drawable.d1;
        drinkdata[0].price="20";
        drinkdata[1].name="奶茶";
        drinkdata[1].photo=R.drawable.d2;
        drinkdata[1].price="20";
        drinkdata[2].name="柳橙汁";
        drinkdata[2].photo=R.drawable.d3;
        drinkdata[2].price="30";
        drinkdata[3].name="可樂";
        drinkdata[3].photo=R.drawable.d4;
        drinkdata[3].price="15";
        drinkdata[4].name="綠茶";
        drinkdata[4].photo=R.drawable.d5;
        drinkdata[4].price="20";
        drinkdata[5].name="豆漿";
        drinkdata[5].photo=R.drawable.d6;
        drinkdata[5].price="20";
        drinkdata[6].name="米漿";
        drinkdata[6].photo=R.drawable.d7;
        drinkdata[6].price="20";

        final Data[] complexdata = new Data[8];
        for(int i=0;i<complexdata.length;i++)
        {
            complexdata[i] = new Data();
        }
        complexdata[0].name = "熱狗";
        complexdata[0].photo = R.drawable.c1;
        complexdata[0].price= "20";
        complexdata[1].name = "煎餃";
        complexdata[1].photo = R.drawable.c2;
        complexdata[1].price= "25";
        complexdata[2].name = "蔥抓餅";
        complexdata[2].photo = R.drawable.c3;
        complexdata[2].price= "25";
        complexdata[3].name = "薯條";
        complexdata[3].photo = R.drawable.c4;
        complexdata[3].price= "20";
        complexdata[4].name = "薯餅";
        complexdata[4].photo = R.drawable.c5;
        complexdata[4].price= "25";
        complexdata[5].name = "雞塊";
        complexdata[5].photo = R.drawable.c6;
        complexdata[5].price= "30";
        complexdata[6].name = "蘿蔔糕";
        complexdata[6].photo = R.drawable.c7;
        complexdata[6].price= "30";
        complexdata[7].name = "鐵板麵";
        complexdata[7].photo = R.drawable.c8;
        complexdata[7].price= "45";

        Data[] packdata = new Data[5];
        for(int i=0;i<packdata.length;i++)
        {
            packdata[i] = new Data();
        }
        packdata[0].name ="雙層豬肉起士堡套餐";
        packdata[0].photo = R.drawable.pa1;
        packdata[0].price = "79";
        packdata[1].name ="美式脆雞堡套餐";
        packdata[1].photo = R.drawable.pa2;
        packdata[1].price = "69";
        packdata[2].name ="美式奔牛堡套餐";
        packdata[2].photo = R.drawable.pa3;
        packdata[2].price = "79";
        packdata[3].name ="歡樂兒童餐";
        packdata[3].photo = R.drawable.pa4;
        packdata[3].price = "59";
        packdata[4].name ="法式香蒜帕瑪森套餐";
        packdata[4].photo = R.drawable.pa5;
        packdata[4].price = "89";

        ImageView view = (ImageView)findViewById(R.id.order_view);
        final TextView text = (TextView)findViewById(R.id.or_name);
        final TextView price = (TextView)findViewById(R.id.or_price);
        final EditText count = (EditText)findViewById(R.id.or_num);
        final EditText memory = (EditText)findViewById(R.id.or_m);
        final TextView sum_m= (TextView)findViewById(R.id.or_sum);
        switch(m)
        {
            case 1:
                view.setImageResource(hamdata[n].photo);
                text.setText(hamdata[n].name);
                price.setText(hamdata[n].price);
                break;
            case 2:
                view.setImageResource(thickdata[n].photo);
                text.setText(thickdata[n].name);
                price.setText(thickdata[n].price);
                break;
            case 3:
                view.setImageResource(toastdata[n].photo);
                text.setText(toastdata[n].name);
                price.setText(toastdata[n].price);
                break;
            case 4:
                view.setImageResource(pastrydata[n].photo);
                text.setText(pastrydata[n].name);
                price.setText(pastrydata[n].price);
                break;
            case 5:
                view.setImageResource(packdata[n].photo);
                text.setText(packdata[n].name);
                price.setText(packdata[n].price);
                break;
            case 6:
                view.setImageResource(complexdata[n].photo);
                text.setText(complexdata[n].name);
                price.setText(complexdata[n].price);
                break;
            case 7:
                view.setImageResource(drinkdata[n].photo);
                text.setText(drinkdata[n].name);
                price.setText(drinkdata[n].price);
                break;
        }

      count.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

          }

          @Override
          public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

          }

          @Override
          public void afterTextChanged(Editable editable) {
              if(count.getText().length()>0)
              {String n;
                  int k,sum;
                  n=count.getText().toString();
                  k=Integer.parseInt(n);
                  l = price.getText().toString();
                  h=Integer.parseInt(l);
                  sum = k*h;
                  sum_m.setText(""+sum);}
              else
              {
                  sum_m.setText(""+0); }
              }
      });

        order_helper o = new order_helper(this);
        oh = o.getWritableDatabase();

        Button send = (Button)findViewById(R.id.or_send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count.getText().toString().equals("")||count.getText().toString().equals(""+0))
                {
                    Toast.makeText(order.this,"輸入錯誤", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    ContentValues cv = new ContentValues();
                    cv.put("title",text.getText().toString());
                    cv.put("count",count.getText().toString());
                    cv.put("sum",sum_m.getText().toString());
                    cv.put("other",memory.getText().toString());
                    oh.insert("orderTable",null,cv);
                    Intent i = new Intent();
                    i.setClass(order.this,food_list.class);
                    startActivity(i);
                    finish();
                }
            }
        });

    }
    class Data
    {
        int photo;
        String name;
        String price;
    }
}
