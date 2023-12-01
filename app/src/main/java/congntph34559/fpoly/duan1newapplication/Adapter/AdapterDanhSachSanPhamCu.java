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

import congntph34559.fpoly.duan1newapplication.DTO.DanhSachSanPhamDTO;
import congntph34559.fpoly.duan1newapplication.R;

public class AdapterDanhSachSanPhamCu extends RecyclerView.Adapter<AdapterDanhSachSanPhamCu.ViewHolder> {

    ArrayList<DanhSachSanPhamDTO> list;
    private Context context;

    public AdapterDanhSachSanPhamCu(ArrayList<DanhSachSanPhamDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_cu_danh_sach_san_pham_use, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String nameImg = list.get(position).getImg_url();
        int resourceImg = ((Activity)context).getResources().getIdentifier(nameImg, "drawable",((Activity)context).getPackageName());

        holder.imgDanhSachSanPhamCu.setImageResource(resourceImg);
        holder.tvTenDanhSachSanPhamCu.setText(list.get(position).getTen_san_pham());
        holder.tvGiaSanPhamDanhSachSanPhamCu.setText(list.get(position).getDon_gia() +" VND / 1kg");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgDanhSachSanPhamCu;
        TextView tvTenDanhSachSanPhamCu, tvGiaSanPhamDanhSachSanPhamCu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgDanhSachSanPhamCu = itemView.findViewById(R.id.imgDanhSachSanPhamCu);
            tvTenDanhSachSanPhamCu = itemView.findViewById(R.id.tvTenDanhSachSanPhamCu);
            tvGiaSanPhamDanhSachSanPhamCu = itemView.findViewById(R.id.tvGiaSanPhamDanhSachSanPhamCu);


        }
    }
}
