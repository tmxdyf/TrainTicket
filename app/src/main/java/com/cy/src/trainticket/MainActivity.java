package com.cy.src.trainticket;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.cy.src.trainticket.data.api.RequestHelper;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;

/**
 * @author CY
 * @since 2016-9-23
 */
public class MainActivity extends AppCompatActivity {
//    BlockingQueue<Object> mQueue = new ArrayBlockingQueue<>(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
//                ApiTest.queryNextTicket("2016-9-30", getApplication());


//                try {
                    Log.e("MainActivity", "BlockingQueue pre。。。。");
//                    mQueue.offer(view,5000, TimeUnit.MILLISECONDS);
                    Log.e("MainActivity", "BlockingQueue post。。。。");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }


                Observable.timer(10000, TimeUnit.MILLISECONDS).subscribe(new Subscriber<Long>() {

                    @Override
                    public void onStart() {
                        super.onStart();   Log.e("MainActivity","onStart");
                    }

                    @Override
                    public void onCompleted() {
                        Log.e("MainActivity","onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("MainActivity","onError");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.e("MainActivity","onNext");
                    }
                });
            }
        });

//    // Example of a call to a native method
//    TextView tv = (TextView) findViewById(R.id.sample_text);
//    tv.setText(stringFromJNI());

    }

    private void test() {
        RequestHelper.getApiService().getTicket("2016-9-30", "SZQ", "WHN");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    /**
//     * A native method that is implemented by the 'native-lib' native library,
//     * which is packaged with this application.
//     */
//    public native String stringFromJNI();
//
//    // Used to load the 'native-lib' library on application startup.
//    static {
//        System.loadLibrary("native-lib");
//    }
}
