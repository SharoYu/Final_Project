package com.example.sharoyu.fianl_app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class food_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        ham_list();
        thick_toast();
        toast();
        pastry();
        drink();
        complex();
        pack();
    }

    public  void  pack(){
        Data[] packdata = new Data[5];
        for(int i=0;i<packdata.length;i++)
        {
         packdata[i] = new Data();
        }
        packdata[0].name ="雙層豬肉起士堡套餐";
        packdata[0].photo = R.drawable.pa1;
        packdata[1].name ="美式脆雞堡套餐";
        packdata[1].photo = R.drawable.pa2;
        packdata[2].name ="美式奔牛堡套餐";
        packdata[2].photo = R.drawable.pa3;
        packdata[3].name ="歡樂兒童餐";
        packdata[3].photo = R.drawable.pa4;
        packdata[4].name ="法式香蒜帕瑪森套餐";
        packdata[4].photo = R.drawable.pa5;

        myAdapter foodAdapter = new myAdapter(packdata,R.layout.food_list);
        GridView gridView5 = (GridView)findViewById(R.id.g5);
        gridView5.setNumColumns(5);
        gridView5.setAdapter(foodAdapter);
        gridView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent f = new Intent();
                Bundle g = new Bundle();
                g.putInt("num",i);
                g.putInt("grid",5);
                f.putExtras(g);
                f.setClass(food_list.this,order.class);
                startActivity(f);
                finish();
            }
        });
    }

    public void complex(){
        Data[] complexdata = new Data[8];
        for(int i=0;i<complexdata.length;i++)
        {
            complexdata[i] = new Data();
        }
        complexdata[0].name = "熱狗";
        complexdata[0].photo = R.drawable.c1;
        complexdata[1].name = "煎餃";
        complexdata[1].photo = R.drawable.c2;
        complexdata[2].name = "蔥抓餅";
        complexdata[2].photo = R.drawable.c3;
        complexdata[3].name = "薯條";
        complexdata[3].photo = R.drawable.c4;
        complexdata[4].name = "薯餅";
        complexdata[4].photo = R.drawable.c5;
        complexdata[5].name = "雞塊";
        complexdata[5].photo = R.drawable.c6;
        complexdata[6].name = "蘿蔔糕";
        complexdata[6].photo = R.drawable.c7;
        complexdata[7].name = "鐵板麵";
        complexdata[7].photo = R.drawable.c8;

        myAdapter foodAdapter = new myAdapter(complexdata,R.layout.food_list);
        GridView gridView6 = (GridView)findViewById(R.id.g6);
        gridView6.setNumColumns(8);
        gridView6.setAdapter(foodAdapter);
        gridView6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent f = new Intent();
                Bundle g = new Bundle();
                g.putInt("num",i);
                g.putInt("grid",6);
                f.putExtras(g);
                f.setClass(food_list.this,order.class);
                startActivity(f);
                finish();
            }
        });

    }

    public  void drink(){
        Data[] drinkdata = new Data[7];
        for(int i=0;i<drinkdata.length;i++)
        {
            drinkdata[i] = new Data();
        }
        drinkdata[0].name="紅茶";
        drinkdata[0].photo=R.drawable.d1;
        drinkdata[1].name="奶茶";
        drinkdata[1].photo=R.drawable.d2;
        drinkdata[2].name="柳橙汁";
        drinkdata[2].photo=R.drawable.d3;
        drinkdata[3].name="可樂";
        drinkdata[3].photo=R.drawable.d4;
        drinkdata[4].name="綠茶";
        drinkdata[4].photo=R.drawable.d5;
        drinkdata[5].name="豆漿";
        drinkdata[5].photo=R.drawable.d6;
        drinkdata[6].name="米漿";
        drinkdata[6].photo=R.drawable.d7;

        myAdapter foodAdapter = new myAdapter(drinkdata,R.layout.food_list);
        GridView gridView7 = (GridView)findViewById(R.id.g7);
        gridView7.setNumColumns(7);
        gridView7.setAdapter(foodAdapter);
        gridView7.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent f = new Intent();
                Bundle g = new Bundle();
                g.putInt("num",i);
                g.putInt("grid",7);
                f.putExtras(g);
                f.setClass(food_list.this,order.class);
                startActivity(f);
                finish();
            }
        });
    }

    public  void pastry(){
        Data[] pastrydata = new Data[10];
        for(int i=0;i<pastrydata.length;i++)
        {
            pastrydata[i] = new Data();
        }
        pastrydata[0].name="玉米蛋餅";
        pastrydata[0].photo=R.drawable.p1;
        pastrydata[1].name="火腿蛋餅";
        pastrydata[1].photo=R.drawable.p2;
        pastrydata[2].name="肉鬆蛋餅";
        pastrydata[2].photo=R.drawable.p3;
        pastrydata[3].name="里肌蛋餅";
        pastrydata[3].photo=R.drawable.p4;
        pastrydata[4].name="美生菜絲蛋餅";
        pastrydata[4].photo=R.drawable.p5;
        pastrydata[5].name="起司蛋餅";
        pastrydata[5].photo=R.drawable.p6;
        pastrydata[6].name="培根蛋餅";
        pastrydata[6].photo=R.drawable.p7;
        pastrydata[7].name="熱狗蛋餅";
        pastrydata[7].photo=R.drawable.p8;
        pastrydata[8].name="鮪魚蛋餅";
        pastrydata[8].photo=R.drawable.p9;
        pastrydata[9].name="燻雞蛋餅";
        pastrydata[9].photo=R.drawable.p10;

        myAdapter foodAdapter = new myAdapter(pastrydata,R.layout.food_list);
        GridView gridView4 = (GridView)findViewById(R.id.g4);
        gridView4.setNumColumns(10);
        gridView4.setAdapter(foodAdapter);
        gridView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent f = new Intent();
                Bundle g = new Bundle();
                g.putInt("num",i);
                g.putInt("grid",4);
                f.putExtras(g);
                f.setClass(food_list.this,order.class);
                startActivity(f);
                finish();
            }
        });
    }

    public  void toast(){
        Data[] toastdata = new Data[7];
        for(int i=0;i<toastdata.length;i++)
        {
            toastdata[i] = new Data();
        }
        toastdata[0].name="綜合吐司";
        toastdata[0].photo=R.drawable.t1;
        toastdata[1].name="里肌吐司";
        toastdata[1].photo=R.drawable.t2;
        toastdata[2].name="火腿吐司";
        toastdata[2].photo=R.drawable.t3;
        toastdata[3].name="培根吐司";
        toastdata[3].photo=R.drawable.t4;
        toastdata[4].name="鮪魚吐司";
        toastdata[4].photo=R.drawable.t5;
        toastdata[5].name="總匯吐司";
        toastdata[5].photo=R.drawable.t6;
        toastdata[6].name="果醬吐司";
        toastdata[6].photo=R.drawable.t7;
        myAdapter foodAdapter = new myAdapter(toastdata,R.layout.food_list);
        GridView gridView3 = (GridView)findViewById(R.id.g3);
        gridView3.setNumColumns(7);
        gridView3.setAdapter(foodAdapter);
        gridView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent f = new Intent();
                Bundle g = new Bundle();
                g.putInt("num",i);
                g.putInt("grid",3);
                f.putExtras(g);
                f.setClass(food_list.this,order.class);
                startActivity(f);
                finish();
            }
        });
    }

    public void thick_toast(){
        Data[] thickdata = new Data[5];
        for(int i=0;i<thickdata.length;i++)
        {
            thickdata[i] = new Data();
        }
        thickdata[0].name="巧克力厚片";
        thickdata[0].photo=R.drawable.choco_toast;
        thickdata[1].name="花生厚片";
        thickdata[1].photo=R.drawable.pinut_toast;
        thickdata[2].name="草莓厚片";
        thickdata[2].photo=R.drawable.strawberry_toast;
        thickdata[3].name="奶酥厚片";
        thickdata[3].photo=R.drawable.milk_toast;
        thickdata[4].name="香蒜厚片";
        thickdata[4].photo=R.drawable.garlic_toast;

        myAdapter foodAdapter = new myAdapter(thickdata,R.layout.food_list);
        GridView gridView2 = (GridView)findViewById(R.id.g2);
        gridView2.setNumColumns(5);
        gridView2.setAdapter(foodAdapter);
        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent f = new Intent();
                Bundle g = new Bundle();
                g.putInt("num",i);
                g.putInt("grid",2);
                f.putExtras(g);
                f.setClass(food_list.this,order.class);
                startActivity(f);
                finish();
            }
        });
    }

    public void ham_list(){
        final Data[] hamdata = new Data[9];
        for(int i=0;i<hamdata.length;i++)
        {
            hamdata[i] = new Data();
        }
        hamdata[0].name="豬肉堡";
        hamdata[0].photo=R.drawable.pork_ham;
        hamdata[1].name="香雞堡";
        hamdata[1].photo=R.drawable.chicken_ham;
        hamdata[2].name="鱈魚堡";
        hamdata[2].photo=R.drawable.fish_ham;
        hamdata[3].name="鮮蝦堡";
        hamdata[3].photo=R.drawable.shrimp_ham;
        hamdata[4].name="牛肉堡";
        hamdata[4].photo=R.drawable.beef_ham;
        hamdata[5].name="卡啦雞腿堡";
        hamdata[5].photo=R.drawable.friedchk_ham;
        hamdata[6].name="培根蛋堡";
        hamdata[6].photo=R.drawable.baconegg_ham;
        hamdata[7].name="鮪魚蛋堡";
        hamdata[7].photo=R.drawable.tuna_ham;
        hamdata[8].name="火腿蛋堡";
        hamdata[8].photo=R.drawable.ham_ham;
        myAdapter foodAdapter = new myAdapter(hamdata,R.layout.food_list);
        GridView gridView1 = (GridView)findViewById(R.id.g1);
        gridView1.setNumColumns(9);
        gridView1.setAdapter(foodAdapter);

        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent f = new Intent();
                Bundle g = new Bundle();
                g.putInt("num",i);
                g.putInt("grid",1);
                f.putExtras(g);
                f.setClass(food_list.this,order.class);
                startActivity(f);
                finish();
            }
        });

    }

    class Data{
        int photo;
        String name;
    }

    public class myAdapter extends BaseAdapter {
        private Data[] data;
        private int view;

        public myAdapter(Data[] data, int view) {
            this.data = data;
            this.view = view;
        }

        public int getCount() {
            return data.length;
        }

        public Data getItem(int position) {
            return data[position];
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View rowView, ViewGroup parent) {

            rowView = getLayoutInflater().inflate(view, parent, false);

            TextView name = (TextView) rowView.findViewById(R.id.list_name);

            ImageView imageView = (ImageView) rowView.findViewById(R.id.list_view);
            name.setText(data[position].name);

            imageView.setImageResource(data[position].photo);
            return rowView;
        }
    }
}
