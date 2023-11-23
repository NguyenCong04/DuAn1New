package congntph34559.fpoly.duan1newapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import congntph34559.fpoly.duan1newapplication.R;

public class FragCuDanhSachSanPhamUse extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_cu_danh_sach_san_pham_user, container, false);
        return view;
    }
}
