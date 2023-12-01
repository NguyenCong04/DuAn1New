package congntph34559.fpoly.duan1newapplication.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import congntph34559.fpoly.duan1newapplication.DoiMatKhauUserActivity;
import congntph34559.fpoly.duan1newapplication.R;
import congntph34559.fpoly.duan1newapplication.ThongTinCaNhanActivity;
import congntph34559.fpoly.duan1newapplication.WelcomeActivity;

public class FragTaiKhoanAdmin extends Fragment {
    TextView txtTaiKhoanAdmin;
    Button btnThongTinAdmin, btnDoiMatKhauAdmin, btnDangXuatAdmin;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_tai_khoan_admin, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtTaiKhoanAdmin = view.findViewById(R.id.txtTenTaiKhoanAdmin);
        btnThongTinAdmin = view.findViewById(R.id.btnThongTinAdmin);
        btnDoiMatKhauAdmin = view.findViewById(R.id.btnDoiMatKhauAdmin);
        btnDangXuatAdmin = view.findViewById(R.id.btnDangXuatAdmin);

        //xu ly lấy tên ang nhâp
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("USER_FILE", Context.MODE_PRIVATE);
        String logUserName = sharedPreferences.getString("userName", "");
        txtTaiKhoanAdmin.setText(logUserName);


        btnThongTinAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ThongTinCaNhanActivity.class));
            }
        });

        btnDoiMatKhauAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), DoiMatKhauUserActivity.class));
            }
        });

        btnDangXuatAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), WelcomeActivity.class));
            }
        });

    }
}
