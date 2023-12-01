package congntph34559.fpoly.duan1newapplication.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import congntph34559.fpoly.duan1newapplication.DTO.FoodTrangChuAdmin;
import congntph34559.fpoly.duan1newapplication.DTO.SanPhamRauAdminDTO;
import congntph34559.fpoly.duan1newapplication.R;

public class AdapterFoodAdmin extends RecyclerView.Adapter<AdapterFoodAdmin.FoodViewHolder> {

    ArrayList<SanPhamRauAdminDTO> list;
    Context context;
    private AdapterSanPhamRauAdmin.SanPhamAdminInterface listener;

    public AdapterFoodAdmin(ArrayList<SanPhamRauAdminDTO> list, Context context, AdapterSanPhamRauAdmin.SanPhamAdminInterface listener) {
        this.list = list;
        this.context = context;
        this.listener = listener;
    }
    public interface SanPhamAdminInterface{
        void updateSanPham(SanPhamRauAdminDTO dto);
    }


    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rau_danh_sach_san_pham_admin, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder,@SuppressLint("RecyclerView") int position) {
        String base64 = list.get(position).getImg_url();
        try {
            byte[] imageBytes = android.util.Base64.decode(base64, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0 , imageBytes.length);

            if(bitmap != null){
                holder.imgDanhSachSanPhamAdmin.setImageBitmap(bitmap);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        holder.tvGiaSanPhamDanhSachSanPhamAdmin.setText(list.get(position).getDon_gia()+" VND / 1kg");
        holder.tvTenDanhSachSanPhamAdmin.setText(list.get(position).getTen_san_pham());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
//                Intent intent = new Intent(context, SuaSanPhamAdmin.class);
//                context.startActivity(intent);
                listener.updateSanPham(list.get(position));

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{

        ImageView imgDanhSachSanPhamAdmin;
        TextView tvTenDanhSachSanPhamAdmin,tvGiaSanPhamDanhSachSanPhamAdmin;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            imgDanhSachSanPhamAdmin = itemView.findViewById(R.id.imgDanhSachSanPhamAdmin);
            tvTenDanhSachSanPhamAdmin = itemView.findViewById(R.id.tvTenDanhSachSanPhamAdmin);
            tvGiaSanPhamDanhSachSanPhamAdmin = itemView.findViewById(R.id.tvGiaSanPhamDanhSachSanPhamAdmin);


        }
    }
}
