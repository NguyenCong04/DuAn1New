package congntph34559.fpoly.duan1newapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import congntph34559.fpoly.duan1newapplication.DTO.DanhSachSanPhamDTO;
import congntph34559.fpoly.duan1newapplication.R;

public class AdapterDanhSachSanPhamQua extends RecyclerView.Adapter<AdapterDanhSachSanPhamQua.ViewHolderQua>{

    ArrayList<DanhSachSanPhamDTO> list;
    Context context;

    public AdapterDanhSachSanPhamQua(ArrayList<DanhSachSanPhamDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderQua onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_qua_danh_sach_san_pham_admin, parent, false);

        return new ViewHolderQua(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderQua holder, int position) {

//        String nameImg = list.get(position).getImg_url();
//        int resourceImg = ((Activity)context).getResources().getIdentifier(nameImg, "drawable",((Activity)context).getPackageName());
//
//        holder.imgDanhSachSanPhamquaAdmin.setImageResource(resourceImg);
        String base64 = list.get(position).getImg_url();
        try {
            byte[] imageBytes = android.util.Base64.decode(base64, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0 , imageBytes.length);

            if(bitmap != null){
                holder.imgDanhSachSanPhamquaAdmin.setImageBitmap(bitmap);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


//        Glide.with(context).load(list.get(position).getImg_url()).into(holder.imgDanhSachSanPhamquaAdmin);

        holder.tvTenDanhSachSanPhamquaAdmin.setText(list.get(position).getTen_san_pham());
        holder.tvGiaSanPhamDanhSachSanPhamquaAdmin.setText(list.get(position).getDon_gia()+"VND / 1kg");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderQua extends RecyclerView.ViewHolder{
        TextView tvTenDanhSachSanPhamquaAdmin, tvGiaSanPhamDanhSachSanPhamquaAdmin;
        ImageView imgDanhSachSanPhamquaAdmin;


        public ViewHolderQua(@NonNull View itemView) {
            super(itemView);

            tvGiaSanPhamDanhSachSanPhamquaAdmin = itemView.findViewById(R.id.tvGiaSanPhamDanhSachSanPhamquaAdmin);
            tvTenDanhSachSanPhamquaAdmin = itemView.findViewById(R.id.tvTenDanhSachSanPhamquaAdmin);
            imgDanhSachSanPhamquaAdmin = itemView.findViewById(R.id.imgDanhSachSanPhamquaAdmin);
        }
    }
}
