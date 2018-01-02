package com.example.sharoyu.fianl_app;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class cart extends AppCompatActivity {
SQLiteDatabase sq;
    int all;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        TextView c_title = (TextView)findViewById(R.id.cart_title);
        TextView c_count = (TextView)findViewById(R.id.cart_count);
        TextView c_sum = (TextView)findViewById(R.id.cart_sum);
        TextView c_other = (TextView)findViewById(R.id.cart_other);
        Button confirm = (Button)findViewById(R.id.cart_confirm);
        Button delete = (Button)findViewById(R.id.cart_delete);


        order_helper oh = new order_helper(this);
        sq = oh.getWritableDatabase();

        String index = "", title = "品項\n", count = "數量\n", sum = "小計\n", other = "備註\n";
        final String[] col = {"title", "count", "sum", "other"};
        Cursor c;
        c = sq.query("orderTable", col, null, null, null, null, null);
        if (c.getCount() > 0) {
            String s;
            int m=0;
            c.moveToFirst();
            for (int i = 0; i < c.getCount(); i++) {
                title += c.getString(0) + "\n";
                count += c.getString(1) + "\n";
                sum += c.getString(2) + "\n";
                other += c.getString(3) + "\n";
                s = c.getString(2).toString();
                m = Integer.parseInt(s);
                all = all+m;
                c.moveToNext();
            }
            c_title.setText(title);
            c_count.setText(count);
            c_sum.setText(sum);
            c_other.setText(other);
        }

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(cart.this);
                dialog.setTitle("總額:"+all);
                dialog.setPositiveButton("確認", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(cart.this, "已送出", Toast.LENGTH_SHORT).show();
                        all = 0;
                        sq.delete("orderTable1",null,null);
                        String title, count, sum, other;
                        final String[] col = {"title", "count", "sum", "other"};
                        Cursor c;
                        ContentValues cv = new ContentValues();
                        c = sq.query("orderTable", col, null, null, null, null, null);
                        if (c.getCount() > 0) {
                            c.moveToFirst();
                            for (int q = 0; q < c.getCount(); q++) {
                                title = c.getString(0) + "\n";
                                count = c.getString(1) + "\n";
                                sum = c.getString(2) + "\n";
                                other = c.getString(3) + "\n";

                                cv.put("title",title);
                                cv.put("count",count);
                                cv.put("sum",sum);
                                cv.put("other",other);
                                sq.insert("orderTable1",null,cv);
                                c.moveToNext();
                            }
                            sq.delete("orderTable",null,null);
                        }
                        Intent k = new Intent();
                        k.setClass(cart.this,home.class);
                        startActivity(k);
                        finish();
                    }
                });

                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(cart.this);
                dialog.setTitle("刪除品項:");
                final EditText editText = new EditText(cart.this);
                dialog.setView(editText);
                dialog.setPositiveButton("確認", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                           if(editText.getText().toString().equals(""))
                           {
                               Toast.makeText(cart.this, "未輸入", Toast.LENGTH_SHORT).show();
                           }
                           else
                           {
                               sq.delete("orderTable","title="+"'"+editText.getText().toString()+"'",null);
                               Toast.makeText(cart.this, "刪除完成", Toast.LENGTH_SHORT).show();
                           }
                    }
                });

                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
            }
        });
    }
}
