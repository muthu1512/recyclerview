package com.example.requestpermission;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Adapter;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    Toolbar toolbar;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //toolBar
        toolbar=findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        //Drawer layout
        drawerLayout=findViewById(R.id.draw);
        ActionBarDrawerToggle Abt=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(Abt);
        Abt.syncState();

        TabLayout t1=findViewById(R.id.tab);
        viewPager=findViewById(R.id.vp);

        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());

        adapter.add(new frag1(),"tab1");
        adapter.add(new frag2(),"tab2");
        adapter.add(new recycle1(),"tab3");
        adapter.add(new gridview(),"tab4");
        adapter.add(new retro(),"tab5");

        viewPager.setAdapter(adapter);

        t1.setupWithViewPager(viewPager);
        NavigationView navigationView;


        navigationView=findViewById(R.id.navy);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.START);
                int items=item.getItemId();
                if(items==R.id.menu1)
                {
                 viewPager.setCurrentItem(0);
                }
                else if(items==R.id.menu2)
                {
                    viewPager.setCurrentItem(1);
                }
                else if(items==R.id.menu3)
                {
                    viewPager.setCurrentItem(2);
                }
                else if(items==R.id.menu4)
                {
                    viewPager.setCurrentItem(3);
                }

                return true;
            }


        });

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
       return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int items1=item.getItemId();
        if(items1==R.id.menu1)
        {
            viewPager.setCurrentItem(0);
        }
        else if(items1==R.id.menu2)
        {
            viewPager.setCurrentItem(1);
        }
        else if(items1==R.id.menu3)
        {
            viewPager.setCurrentItem(2);
        }
        else if(items1==R.id.menu4)
        {
            viewPager.setCurrentItem(3);
        }

        return true;

    }


    class ViewPagerAdapter extends FragmentPagerAdapter{

        private final List<Fragment> FragmentList=new ArrayList<>();  //10fragments  i need 4th frag
        private final List<String> title=new ArrayList<>();


        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            return FragmentList.get(position);
        }

        @Override
        public int getCount() {
            return title.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return title.get(position);
        }

        public void add(Fragment frag, String t1)
        {
        FragmentList.add(frag);
        title.add(t1);
        }
    }


}



