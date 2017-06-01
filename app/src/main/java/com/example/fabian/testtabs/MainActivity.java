package com.example.fabian.testtabs;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabHost=(FragmentTabHost) findViewById(R.id.tabHost);
        tabHost.setup( this, getSupportFragmentManager(), android.R.id.tabcontent );
        //tabHost.getTabWidget().setShowDividers( TabWidget.SHOW_DIVIDER_MIDDLE );
        tabHost.getTabWidget().setDividerDrawable( R.drawable.tab_div );

        View tabview1 = createTabView( tabHost.getContext(), "10", "Tab 1");
        TabHost.TabSpec spec1= tabHost.newTabSpec("Tab 1");
        spec1.setIndicator( tabview1 );
        //spec1.setIndicator("TAB 01");
        tabHost.addTab( spec1, FirstFragment.class, null);

        View tabview2 = createTabView( tabHost.getContext(), "20", "Tab 2");
        TabHost.TabSpec spec2=tabHost.newTabSpec("Tab 2");
        spec2.setIndicator( tabview2 );
        //spec2.setIndicator( "TAB 02");
        tabHost.addTab( spec2, SecondFragment.class, null);

        View tabview3 = createTabView( tabHost.getContext(), "30", "Tab 3");
        TabHost.TabSpec spec3=tabHost.newTabSpec("Tab 3");
        spec3.setIndicator( tabview3 );
        tabHost.addTab( spec3, ThirdFragment.class, null);

        View tabview4 = createTabView( tabHost.getContext(), "40", "Tab 4");
        TabHost.TabSpec spec4=tabHost.newTabSpec("Tab 4");
        spec4.setIndicator( tabview4 );
        tabHost.addTab( spec4, FourthFragment.class, null);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                formatTabHost();
            }
        });
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

    @Override
    protected void onResume() {
        super.onResume();
        //detecta el tab seleccionado por defecto para darle el formato deseado
        formatTabHost();
    }

    /** Cambio de color en los titulos del tabhost en funcion de si estan seleccionados o no
     *  Tambien elimina la negrita y cambia el tamaño de letra
     */
    private void formatTabHost(){

        View v;

        for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
        {

            TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById( R.id.tabsTv1 );
            TextView tv2 = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById( R.id.tabsTv2 );

            //pone color a los tabs dependiendo si esta seleccionado o no
            if( i == tabHost.getCurrentTab() ){
                tv.setTextColor( ContextCompat.getColor( getApplicationContext(), R.color.th_text_selected));
                tv2.setTextColor( ContextCompat.getColor( getApplicationContext(), R.color.th_text_selected));
            }else{
                tv.setTextColor( ContextCompat.getColor( getApplicationContext(), R.color.th_text_unselected));
                tv2.setTextColor( ContextCompat.getColor( getApplicationContext(), R.color.th_text_unselected));
            }
        }
    }
}
