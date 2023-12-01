package congntph34559.fpoly.duan1newapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import congntph34559.fpoly.duan1newapplication.DTO.ChiTietHoaDonAdminDTO;
import congntph34559.fpoly.duan1newapplication.DTO.DanhSachSanPhamDTO;
import congntph34559.fpoly.duan1newapplication.DTO.ThongKeAdmin;
import congntph34559.fpoly.duan1newapplication.R;

public class AdapterThongKeAdmin extends RecyclerView.Adapter<AdapterThongKeAdmin.ThongKeViewHolder>{
    private Context context;
    private ArrayList<ChiTietHoaDonAdminDTO> list;

    public AdapterThongKeAdmin(Context context, ArrayList<ChiTietHoaDonAdminDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ThongKeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater  inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_recycler_thong_ke, parent, false);
        return new ThongKeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThongKeViewHolder holder, int position) {


//        String nameImg = list.get(position).getImg_url();
//        int resourceImg = ((Activity)context).getResources().getIdentifier(nameImg, "drawable",((Activity)context).getPackageName());
//        holder.imgThongKe.setImageResource(resourceImg);
//        holder.txtTenSpTK.setText("Tên Sản Phẩm:"+list.get(position).getTen_san_pham());
//        holder.txtSoLuongMua.setText("Số lượt mua:"+list.get(position).getSoluotmua());

          holder.txtTenSpTK.setText("Tên sản phẩm:"+list.get(position).getTen_san_pham());
          holder.txtSoLuongMua.setText("Số lượt mua:"+list.get(position).getSo_luong_ban());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ThongKeViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgThongKe;
        private TextView txtTenSpTK;
        private TextView txtSoLuongMua;
        public ThongKeViewHolder(@NonNull View itemView) {
            super(itemView);
            imgThongKe = itemView.findViewById(R.id.imgThongKe);
            txtSoLuongMua = itemView.findViewById(R.id.txtSoLuongMua);
            txtTenSpTK = itemView.findViewById(R.id.txtTenSpThongKe);

        }
    }
}
