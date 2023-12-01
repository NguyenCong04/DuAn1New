package congntph34559.fpoly.duan1newapplication.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import congntph34559.fpoly.duan1newapplication.DBHelper.MyDBHelper;
import congntph34559.fpoly.duan1newapplication.DTO.ChiTietHoaDonAdminDTO;
import congntph34559.fpoly.duan1newapplication.DTO.DanhSachSanPhamDTO;

public class ThongKeDAO {
    MyDBHelper myDBHelper;

    public ThongKeDAO(Context context){
        myDBHelper = new MyDBHelper(context);
    }

    public ArrayList<ChiTietHoaDonAdminDTO> getTop10(){
          ArrayList<ChiTietHoaDonAdminDTO> list = new ArrayList<>();
          SQLiteDatabase sqLiteDatabase = myDBHelper.getReadableDatabase();
          Cursor cursor = sqLiteDatabase.rawQuery("SELECT tb_san_pham.ten_san_pham, tb_san_pham.img_url, COUNT(tb_chi_tiet_hoa_don.id_san_pham) AS so_luong_ban FROM tb_chi_tiet_hoa_don JOIN tb_san_pham ON tb_chi_tiet_hoa_don.id_san_pham = tb_san_pham.id_san_pham GROUP BY tb_san_pham.id_san_pham ORDER BY so_luong_ban DESC LIMIT 10", null);
          if(cursor.getCount()!=0){
              cursor.moveToFirst();
              do {

              }while (cursor.moveToNext());
          }

          return list;
    }
}
