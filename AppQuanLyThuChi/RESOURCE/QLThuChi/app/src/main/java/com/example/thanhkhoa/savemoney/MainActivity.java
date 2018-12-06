package com.example.thanhkhoa.savemoney;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mainNav;
    private FrameLayout mainFrame;
    TongQuanFragment tongQuanFragment;
    TaiKhoanFragment taiKhoanFragment;
    LapPhieuFragment lapPhieuFragment;
    MoreFragment moreFragment;
    TongQuanThuFragment tongQuanThuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tongQuanFragment = new TongQuanFragment();
        taiKhoanFragment  = new TaiKhoanFragment();
        lapPhieuFragment =  new LapPhieuFragment();
        tongQuanThuFragment = new TongQuanThuFragment();
        moreFragment =  new MoreFragment();
        mainFrame = findViewById(R.id.main_frame);
        mainNav = findViewById(R.id.main_nav);

        setFragment(tongQuanFragment);
        mainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        mainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(tongQuanFragment);
                        return  true;
                    case R.id.nav_phieuthu:
                        mainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(tongQuanThuFragment);
                        return  true;
                    case R.id.nav_create:
                        mainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(lapPhieuFragment);
                        return  true;
                    case R.id.nav_acc:
                        mainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(taiKhoanFragment);
                        return  true;
                    case R.id.nav_more:
                        mainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(moreFragment);
                        return  true;

                    default: return false;

                }
            }
        });
    }

    public void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();
    }
}
