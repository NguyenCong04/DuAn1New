package congntph34559.fpoly.duan1newapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import congntph34559.fpoly.duan1newapplication.DiaChiActivity;
import congntph34559.fpoly.duan1newapplication.LienHeGopYActivity;
import congntph34559.fpoly.duan1newapplication.R;
import congntph34559.fpoly.duan1newapplication.ThongTinCaNhanActivity;
import congntph34559.fpoly.duan1newapplication.ViCuaToiActivity;
import congntph34559.fpoly.duan1newapplication.WelcomeActivity;


public class FragTaiKhoanUser extends Fragment {

    private AppCompatButton btnThongTinCaNhan, btnDiaChiCaNhan, btnViCaNhan, btnLienHeCaNhan, btnDoiMatKhau, btnDangXuat;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_tai_khoan_user, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnThongTinCaNhan = view.findViewById(R.id.btnThongTinCaNhan);
        btnDiaChiCaNhan = view.findViewById(R.id.btnDiaChiCaNhan);
        btnViCaNhan = view.findViewById(R.id.btnViCaNhan);
        btnLienHeCaNhan = view.findViewById(R.id.btnLienHeGopY);
        btnDoiMatKhau = view.findViewById(R.id.btnDoiMatKhau);
        btnDangXuat = view.findViewById(R.id.btnDangXuat);
        btnThongTinCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ThongTinCaNhanActivity.class);
                startActivity(intent);
            }
        });

        btnDiaChiCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DiaChiActivity.class);
                startActivity(intent);
            }
        });

        btnViCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ViCuaToiActivity.class);
                startActivity(intent);
            }
        });

        btnLienHeCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LienHeGopYActivity.class);
                startActivity(intent);
            }
        });

        btnDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), WelcomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
