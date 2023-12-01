package congntph34559.fpoly.duan1newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import congntph34559.fpoly.duan1newapplication.Adapter.CategoRySpinnerAdapter;
import congntph34559.fpoly.duan1newapplication.DAO.TrangChuAdminDAO;
import congntph34559.fpoly.duan1newapplication.DBHelper.MyDBHelper;
import congntph34559.fpoly.duan1newapplication.DTO.Category;
import congntph34559.fpoly.duan1newapplication.DTO.SanPhamRauAdminDTO;

public class SuaSanPhamAdmin extends AppCompatActivity {
    EditText edtSuatensp, edtSuaGiasp, edtSuaNhaCungCap, edtSuaMoTa;

    Button btnSuasp;
    Spinner spnCategorySuaSp;

    private SanPhamRauAdminDTO dto;

    private TrangChuAdminDAO dao;

    private MyDBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_san_pham_admin);

        edtSuatensp = findViewById(R.id.edtSuaTenSp);
        edtSuaGiasp = findViewById(R.id.edtSuaGiaSp);
        btnSuasp = findViewById(R.id.btnSuaSp);
        edtSuaNhaCungCap = findViewById(R.id.edtSuaNhaCungCap);
        edtSuaMoTa = findViewById(R.id.edtSuaMoTa);
        spnCategorySuaSp = findViewById(R.id.spnCategorySuaSp);

        dbHelper = new MyDBHelper(SuaSanPhamAdmin.this);
        dao = new TrangChuAdminDAO(SuaSanPhamAdmin.this);

        getDataIntent();


        btnSuasp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newName = edtSuatensp.getText().toString().trim();
                String newPrice = edtSuaGiasp.getText().toString().trim();

                if(newName.equals("") || String.valueOf(newPrice).equals("")){
                    Toast.makeText(SuaSanPhamAdmin.this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    boolean result = dao.SuaSanPham(dto.getId_san_pham(), newName, Integer.parseInt(newPrice));
                    if (result){
                        Toast.makeText(SuaSanPhamAdmin.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    }
                }


            }
        });



    }

    private void getDataIntent() {
        Intent intent = getIntent();
        if (intent != null){
            dto = (SanPhamRauAdminDTO) intent.getSerializableExtra("dto");
            edtSuatensp.setText(dto.getTen_san_pham());
            edtSuaGiasp.setText(String.valueOf(dto.getDon_gia()));
            edtSuaNhaCungCap.setText(dto.getNhacungcap());
            edtSuaMoTa.setText(dto.getMo_ta());

        }
    }

}