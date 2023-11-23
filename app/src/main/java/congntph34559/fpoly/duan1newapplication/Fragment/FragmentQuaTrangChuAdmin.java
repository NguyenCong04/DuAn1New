package congntph34559.fpoly.duan1newapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import congntph34559.fpoly.duan1newapplication.Adapter.AdapterFoodAdmin;
import congntph34559.fpoly.duan1newapplication.DTO.FoodTrangChuAdmin;
import congntph34559.fpoly.duan1newapplication.R;

public class FragmentQuaTrangChuAdmin extends Fragment {

    private RecyclerView recyclerViewQuaAdmin;
    private FloatingActionButton fltAddQuaAdmin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_qua_trang_chu_admin, container, false);

        recyclerViewQuaAdmin = view.findViewById(R.id.recyclerQuaAdmin);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewQuaAdmin.setLayoutManager(gridLayoutManager);

        AdapterFoodAdmin adapterFoodAdmin = new AdapterFoodAdmin(getFoodQuaAdmin());
        recyclerViewQuaAdmin.setAdapter(adapterFoodAdmin);
        return view;
    }

    private List<FoodTrangChuAdmin> getFoodQuaAdmin() {
        List<FoodTrangChuAdmin> list = new ArrayList<>();
        list.add(new FoodTrangChuAdmin(R.drawable.img_cai_chip_trang_chu, "Cải chíp", "21.000 VND"));
        list.add(new FoodTrangChuAdmin(R.drawable.img_cai_chip_trang_chu, "Cải chíp", "21.000 VND"));
        list.add(new FoodTrangChuAdmin(R.drawable.img_cai_chip_trang_chu, "Cải chíp", "21.000 VND"));
        list.add(new FoodTrangChuAdmin(R.drawable.img_cai_chip_trang_chu, "Cải chíp", "21.000 VND"));
        list.add(new FoodTrangChuAdmin(R.drawable.img_cai_chip_trang_chu, "Cải chíp", "21.000 VND"));
        list.add(new FoodTrangChuAdmin(R.drawable.img_cai_chip_trang_chu, "Cải chíp", "21.000 VND"));
        return list;
    }
}
