package congntph34559.fpoly.duan1newapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import congntph34559.fpoly.duan1newapplication.ChiTietSanPhamActivity;
import congntph34559.fpoly.duan1newapplication.DAO.GioHangDAO;
import congntph34559.fpoly.duan1newapplication.DTO.DanhSachSanPhamDTO;
import congntph34559.fpoly.duan1newapplication.DTO.GioHangDTO;
import congntph34559.fpoly.duan1newapplication.R;

public class AdapterDanhSachSanPham extends RecyclerView.Adapter<AdapterDanhSachSanPham.ViewHolder> {

    ArrayList<DanhSachSanPhamDTO> list;
    private Context context;
    DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
    GioHangDAO gioHangDAO;

    public AdapterDanhSachSanPham(ArrayList<DanhSachSanPhamDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_rau_danh_sach_san_pham_use, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DanhSachSanPhamDTO id = list.get(position);
        String nameImg = list.get(position).getImg_url();
        int resourceImg = ((Activity) context).getResources().getIdentifier(nameImg, "drawable", ((Activity) context).getPackageName());

        holder.imgdanhsachsp.setImageResource(resourceImg);
        holder.tvtendanhsachsanpham.setText(list.get(position).getTen_san_pham());
        holder.tvgiadanhsachsanpham.setText(decimalFormat.format(list.get(position).getDon_gia()) + " VND / 1kg");

        gioHangDAO = new GioHangDAO(context);

        String base64 = list.get(position).getImg_url();
        try {
            byte[] imageBytes = android.util.Base64.decode(base64, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
            if (bitmap != null) {
                holder.imgdanhsachsp.setImageBitmap(bitmap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        holder.ivGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tenSp = id.getTen_san_pham();
                int giaSp = id.getDon_gia();
                String tenAnh = id.getImg_url();

                GioHangDTO objGioHang = new GioHangDTO();
                objGioHang.setTenSanPham(tenSp);
                objGioHang.setGiaSanPham(giaSp);
                objGioHang.setImgSanPham(tenAnh);
                objGioHang.setSoLuongSanPham(1);
                objGioHang.setTongTienCuaSp(giaSp);

                long kq = gioHangDAO.addRow(objGioHang);
                if (kq > 0) {

                    Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();


                } else {

                    Toast.makeText(context, "Thêm thất bại", Toast.LENGTH_SHORT).show();

                }


            }
        });


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(((Activity) context), ChiTietSanPhamActivity.class);
//                intent.putExtra("tenSp", id.getTen_san_pham());
//                intent.putExtra("giaSp", id.getDon_gia());
//                intent.putExtra("anhSp", id.getImg_url());
//                intent.putExtra("moTaSp", id.getMo_ta());
                remenBerProduct(id.getTen_san_pham(), id.getDon_gia(), id.getImg_url(), id.getMo_ta());
                ((Activity) context).startActivity(intent);


            }
        });

    }

    private void remenBerProduct(String tenSanPham, int donGia, String imgUrl, String moTa) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("PRODUCT", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("tenSp", tenSanPham);
        editor.putInt("doGia", donGia);
        editor.putString("anhSp", imgUrl);
        editor.putString("moTa", moTa);

        editor.apply();


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgdanhsachsp, ivGioHang;
        TextView tvtendanhsachsanpham, tvgiadanhsachsanpham;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgdanhsachsp = itemView.findViewById(R.id.imgDanhSachSanPham);
            tvtendanhsachsanpham = itemView.findViewById(R.id.tvTenDanhSachSanPham);
            tvgiadanhsachsanpham = itemView.findViewById(R.id.tvGiaSanPhamDanhSachSanPham);
            ivGioHang = itemView.findViewById(R.id.ivIconGioHangItemRau);
        }
    }

//    @Override
//    public Filter getFilter() {
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                String search = constraint.toString();
//                if(search.isEmpty()){
//                    list = listold;
//                }else {
//                    ArrayList<DanhSachSanPhamDTO> listds = new ArrayList<>();
//                    for (DanhSachSanPhamDTO ds : listold){
//                        if(ds.getTen_san_pham().toLowerCase().contains(search.toLowerCase())){
//                            listds.add(ds);
//                        }
//                    }
//                    list = listds;
//                }
//                FilterResults filterResults = new FilterResults();
//                filterResults.values = list;
//
//
//                return filterResults;
//            }
//
//            @Override
//            protected void publishResults(CharSequence constraint, FilterResults results) {
//                    list = (ArrayList<DanhSachSanPhamDTO>) results.values;
//                    notifyDataSetChanged();
//            }
//        };
//    }
}
