package com.example.wishlistapp2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<WishItem> items;
    private TextView txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycler = findViewById(R.id.recycler);
        txtTotal = findViewById(R.id.txtTotal);

        // элементы создаются программно
        items = new ArrayList<>();
        items.add(new WishItem(R.mipmap.ic_launcher, "PlayStation 5", 19999));
        items.add(new WishItem(R.mipmap.ic_launcher, "Навушники Sony", 4999));
        items.add(new WishItem(R.mipmap.ic_launcher, "Мишка Logitech", 1999));
        items.add(new WishItem(R.mipmap.ic_launcher, "Павербанк", 1299));
        items.add(new WishItem(R.mipmap.ic_launcher, "LEGO набір", 2799));

        WishAdapter adapter = new WishAdapter(items, this::updateTotal);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);

        updateTotal();
    }

    private void updateTotal() {
        int sum = 0;
        for (WishItem item : items) {
            sum += item.price;   // общая стоимость всех подарков
        }
        txtTotal.setText("Загальна вартість: " + sum + " грн");
    }
}
