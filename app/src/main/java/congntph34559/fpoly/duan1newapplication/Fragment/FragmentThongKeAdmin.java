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
import congntph34559.fpoly.duan1newapplication.DAO.ThongKeDAO;
import congntph34559.fpoly.duan1newapplication.DTO.ChiTietHoaDonAdminDTO;
import congntph34559.fpoly.duan1newapplication.DTO.DanhSachSanPhamDTO;
import congntph34559.fpoly.duan1newapplication.DTO.ThongKeAdmin;
import congntph34559.fpoly.duan1newapplication.R;

public class FragmentThongKeAdmin extends Fragment {
    private RecyclerView recyclerViewThongKe;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_thong_ke_admin, container, false);
        recyclerViewThongKe = view.findViewById(R.id.recyclerThongKe);

        ThongKeDAO thongKeDAO = new ThongKeDAO(getContext());
        ArrayList<ChiTietHoaDonAdminDTO> list = thongKeDAO.getTop10();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewThongKe.setLayoutManager(linearLayoutManager);
        AdapterThongKeAdmin adapterThongKeAdmin = new AdapterThongKeAdmin(getContext(), list);
        recyclerViewThongKe.setAdapter(adapterThongKeAdmin);

        return view;
    }


}
