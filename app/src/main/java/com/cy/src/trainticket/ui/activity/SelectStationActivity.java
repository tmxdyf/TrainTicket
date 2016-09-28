package com.cy.src.trainticket.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.cy.src.trainticket.R;
import com.cy.src.trainticket.data.info.Station;

import static com.cy.src.trainticket.StationUtils.loadStation;

public class SelectStationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_station);
        init();
    }

    private void init() {
        loadStation(getApplication()).subscribe(stations -> {
            Station[] s = new Station[stations.size()];
            stations.toArray(s);
            ArrayAdapter<Station> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, s);
            AbsListView lv = (AbsListView) findViewById(android.R.id.list);
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


}
