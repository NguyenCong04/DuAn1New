package congntph34559.fpoly.duan1newapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import congntph34559.fpoly.duan1newapplication.Adapter.AdapterThongKeAdmin;
import congntph34559.fpoly.duan1newapplication.DTO.ThongKeAdmin;
import congntph34559.fpoly.duan1newapplication.R;

public class FragmentThongKeAdmin extends Fragment {
    private RecyclerView recyclerViewThongKe;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_thong_ke_admin, container, false);
        recyclerViewThongKe = view.findViewById(R.id.recyclerThongKe);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        AdapterThongKeAdmin adapterThongKeAdmin = new AdapterThongKeAdmin(getThongKeAdmin());
        recyclerViewThongKe.setLayoutManager(layoutManager);
        recyclerViewThongKe.setAdapter(adapterThongKeAdmin);
        return view;
    }

    private List<ThongKeAdmin> getThongKeAdmin() {
        List<ThongKeAdmin> list = new ArrayList<>();
        list.add(new ThongKeAdmin(R.drawable.img_cai_thao_trang_chu, "Tên sản phẩm; Cải Thảo", "Số lượn mua: 50 lượt"));
        list.add(new ThongKeAdmin(R.drawable.img_bong_cai_xanh_trang_chu, "Tên sản phẩm; Bông cai xanh", "Số lượn mua: 50 lượt"));
        list.add(new ThongKeAdmin(R.drawable.img_bong_cai_trang_trang_chu, "Tên sản phẩm; Bông cải trắng", "Số lượn mua: 50 lượt"));

        return list;
    }
}
