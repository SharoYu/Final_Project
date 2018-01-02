package com.example.sharoyu.fianl_app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class order_list extends AppCompatActivity {
SQLiteDatabase sl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        TextView d_title = (TextView)findViewById(R.id.d_title);
        TextView d_count = (TextView)findViewById(R.id.d_count);
        TextView d_sum = (TextView)findViewById(R.id.d_sum);
        TextView d_other = (TextView)findViewById(R.id.d_other);

        order_helper ol = new order_helper(this);
        sl = ol.getWritableDatabase();

        String index = "", title = "品項\n", count = "數量\n", sum = "小計\n", other = "備註\n";
        String[] col = {"title", "count", "sum", "other"};
        Cursor c;
        c = sl.query("orderTable1", col, null, null, null, null, null);
        if (c.getCount() > 0) {
            c.moveToFirst();
            for (int i = 0; i < c.getCount(); i++) {
                title += c.getString(0) + "\n";
                count += c.getString(1) + "\n";
                sum += c.getString(2) + "\n";
                other += c.getString(3) + "\n";
                c.moveToNext();
            }
            d_title.setText(title);
            d_count.setText(count);
            d_sum.setText(sum);
            d_other.setText(other);
        }
    }
}
