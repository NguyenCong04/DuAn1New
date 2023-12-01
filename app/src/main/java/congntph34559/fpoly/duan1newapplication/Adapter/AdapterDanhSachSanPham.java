package congntph34559.fpoly.duan1newapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import congntph34559.fpoly.duan1newapplication.DTO.DanhSachSanPhamDTO;
import congntph34559.fpoly.duan1newapplication.R;

public class AdapterDanhSachSanPham extends RecyclerView.Adapter<AdapterDanhSachSanPham.ViewHolder> {

    ArrayList<DanhSachSanPhamDTO> list;
    private Context context;

    public AdapterDanhSachSanPham(ArrayList<DanhSachSanPhamDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_rau_danh_sach_san_pham_use,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String nameImg = list.get(position).getImg_url();
        int resourceImg = ((Activity)context).getResources().getIdentifier(nameImg, "drawable",((Activity)context).getPackageName());

        holder.imgdanhsachsp.setImageResource(resourceImg);
        holder.tvtendanhsachsanpham.setText(list.get(position).getTen_san_pham());
        holder.tvgiadanhsachsanpham.setText(list.get(position).getDon_gia()+" VND / 1kg");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgdanhsachsp;
        TextView tvtendanhsachsanpham, tvgiadanhsachsanpham;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgdanhsachsp = itemView.findViewById(R.id.imgDanhSachSanPham);
            tvtendanhsachsanpham = itemView.findViewById(R.id.tvTenDanhSachSanPham);
            tvgiadanhsachsanpham = itemView.findViewById(R.id.tvGiaSanPhamDanhSachSanPham);
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
