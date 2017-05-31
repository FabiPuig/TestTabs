package com.example.fabian.testtabs;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabHost=(TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

        View tabview1 = createTabView( tabHost.getContext(), "10", "Tab 1");
        TabHost.TabSpec spec1= tabHost.newTabSpec("Tab 1");
        spec1.setIndicator( tabview1 );
        spec1.setContent(R.id.tab1);

        View tabview2 = createTabView( tabHost.getContext(), "20", "Tab 2");
        TabHost.TabSpec spec2=tabHost.newTabSpec("Tab 2");
        spec2.setIndicator( tabview2 );
        spec2.setContent(R.id.tab2);

        View tabview3 = createTabView( tabHost.getContext(), "30", "Tab 3");
        TabHost.TabSpec spec3=tabHost.newTabSpec("Tab 3");
        spec3.setIndicator( tabview3 );
        spec3.setContent(R.id.tab3);

        View tabview4 = createTabView( tabHost.getContext(), "40", "Tab 4");
        TabHost.TabSpec spec4=tabHost.newTabSpec("Tab 4");
        spec4.setIndicator( tabview4 );
        spec4.setContent(R.id.tab4);

        tabHost.addTab(spec1);
        tabHost.addTab(spec2);
        tabHost.addTab(spec3);
        tabHost.addTab(spec4);
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

    /** Crea el view que ira en un tab
     *
     * @param context
     * @param text1
     * @param text2
     * @return
     */
    private View createTabView(final Context context, final String text1, final String text2) {

        final View view = LayoutInflater.from(context).inflate(R.layout.tabs_bg, null);

        final TextView tv1 = (TextView) view.findViewById(R.id.tabsTv1);
        final TextView tv2 = (TextView) view.findViewById(R.id.tabsTv2);

        tv1.setText( text1 );
        tv2.setText( text2 );

        return view;
    }
}
