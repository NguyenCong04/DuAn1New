package congntph34559.fpoly.duan1newapplication;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import congntph34559.fpoly.duan1newapplication.Adapter.AdapterDanhSachSanPham;
import congntph34559.fpoly.duan1newapplication.Adapter.MyViewPagerAdapter;
import congntph34559.fpoly.duan1newapplication.DAO.DanhSachSanPhamDAO;
import congntph34559.fpoly.duan1newapplication.DTO.DanhSachSanPhamDTO;

public class DanhSachSanPhamUseActivity extends AppCompatActivity {

    TabLayout mTabLayout;
    ViewPager2 viewPager2;
    MyViewPagerAdapter myViewPagerAdapter;
    EditText edtSearch;
    AdapterDanhSachSanPham danhSachSanPham;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_san_pham_use);

        mTabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_paper);
        edtSearch = findViewById(R.id.edt_search);
        myViewPagerAdapter = new MyViewPagerAdapter(this);
        viewPager2.setAdapter(myViewPagerAdapter);
        DanhSachSanPhamDAO danhSachSanPhamDAO = new DanhSachSanPhamDAO(this);
        ArrayList<DanhSachSanPhamDTO> list = danhSachSanPhamDAO.getDSSanPham();

        danhSachSanPham = new AdapterDanhSachSanPham(list,this);



        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // cố định tab ko cho vuốt
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mTabLayout.getTabAt(position).select();
            }
        });
    }
}