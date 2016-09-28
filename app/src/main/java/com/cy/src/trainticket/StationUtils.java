package com.cy.src.trainticket;

import android.content.Context;

import com.cy.src.trainticket.data.info.Station;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by CY on 2016/9/28.
 */

public class StationUtils {
    public static Observable<List<Station>> loadStation(Context context) {

        Observable<List<Station>> observable = Observable.just("station").map(name -> {
            List<Station> list = new ArrayList<>();
            try {
                InputStream inputStream = context.getResources().getAssets().open(name);
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
        }).map(stations -> {

            Collections.sort(stations, (o1, o2) -> {
                int value = 0;
                try {
                    String p1 = PinyinHelper.convertToPinyinString(o1.getName(), "", PinyinFormat.WITHOUT_TONE);
                    String p2 = PinyinHelper.convertToPinyinString(o2.getName(), "", PinyinFormat.WITHOUT_TONE);

                    if (p1.length() > 0 && p2.length() > 0) {
                        value = p1.charAt(0) - p2.charAt(0);
                    }
                } catch (PinyinException e) {
                    e.printStackTrace();

                }
                return value;
            });

            return stations;
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());

        return observable;
    }
}
