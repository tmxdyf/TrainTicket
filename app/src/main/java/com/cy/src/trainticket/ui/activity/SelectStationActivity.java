package com.cy.src.trainticket.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cy.src.trainticket.R;
import com.cy.src.trainticket.data.info.Station;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SelectStationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_station);
        init();
    }

    private void init() {
        load().subscribe(stations -> {
            Station[] s = new Station[stations.size()];
            stations.toArray(s);
            ArrayAdapter<Station> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, s);
            ListView lv = (ListView) findViewById(android.R.id.list);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(this::onItemClick);
        }, Throwable::printStackTrace);

    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Station item = (Station) parent.getAdapter().getItem(position);
        Intent intent = new Intent().putExtra("data", item);
        setResult(RESULT_OK, intent);
        finish();
    }

    private Observable<List<Station>> load() {

        Observable<List<Station>> observable = Observable.just("station").map(name -> {
            List<Station> list = new ArrayList<>();
            try {
                InputStream inputStream = getResources().getAssets().open(name);
                String station = IOUtils.toString(inputStream);
                String[] split = station.split(",");
                for (String s : split) {
                    System.out.println(s);
                    String[] sp = s.split("-");
                    list.add(new Station(sp[0], sp[1]));
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return list;
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());

        return observable;
    }
}
