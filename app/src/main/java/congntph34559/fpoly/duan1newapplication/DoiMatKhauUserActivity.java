package congntph34559.fpoly.duan1newapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

import congntph34559.fpoly.duan1newapplication.DAO.TaiKhoanDAO;
import congntph34559.fpoly.duan1newapplication.DTO.TaiKhoanDTO;

public class DoiMatKhauUserActivity extends AppCompatActivity {

    EditText edtOldPass, edtNewPass, edtNewPassAgain;
    AppCompatButton btnDoiPass;
    private TaiKhoanDAO taiKhoanDAO;
    private List<TaiKhoanDTO> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_mat_khau_user);


        edtOldPass = findViewById(R.id.edt_pass_old);
        edtNewPass = findViewById(R.id.edt_pass_new);
        edtNewPassAgain = findViewById(R.id.edt_pass_new_agin);
        btnDoiPass = findViewById(R.id.btn_doi_pass);
        ImageView imgBackDoiMatKhau = findViewById(R.id.imgBackDoiMatKhau);

        imgBackDoiMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        taiKhoanDAO = new TaiKhoanDAO(this);
        list = taiKhoanDAO.getAll();
        btnDoiPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validate()){
                    TaiKhoanDTO idTaiKhoan = null;



                    for (int i = 0; i < list.size(); i++) {

                        idTaiKhoan = list.get(i);
                        String oldPass = edtOldPass.getText().toString();
//                        if (!idTaiKhoan.getMatKhau().equals(oldPass)){
//                            Toast.makeText(DoiMatKhauUserActivity.this, "Mật khẩu cũ không khớp", Toast.LENGTH_SHORT).show();
//                            return;
//                        }else {
//                            String newPass = edtNewPass.getText().toString();
//                            idTaiKhoan.setMatKhau(newPass);
//                            taiKhoanDAO.updateRow(idTaiKhoan);
//                            Toast.makeText(DoiMatKhauUserActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
//                        }

                        Toast.makeText(DoiMatKhauUserActivity.this, ""+idTaiKhoan.getMatKhau(), Toast.LENGTH_SHORT).show();

                    }

                    String PassNew = edtNewPass.getText().toString();
                    idTaiKhoan.setMatKhau(PassNew);

                    int kq = taiKhoanDAO.updateRow(idTaiKhoan);
                    if (kq > 0){
                        Toast.makeText(DoiMatKhauUserActivity.this, "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                        list.clear();
                        list.addAll(taiKhoanDAO.getAll());
                        startActivity(new Intent(DoiMatKhauUserActivity.this, LoginSigUpActivity.class));
                        finish();
                    }else {
                        Toast.makeText(DoiMatKhauUserActivity.this, "Đổi mật khảu thất bại", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


    }

    private boolean validate() {

        if (edtOldPass.getText().length() == 0 || edtNewPass.getText().length() == 0 || edtNewPassAgain.getText().length() == 0){
            Toast.makeText(this, "Mời nhập thông tin", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!edtNewPass.getText().toString().equals(edtNewPassAgain.getText().toString())){
            Toast.makeText(this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {

            String pass = edtOldPass.getText().toString();
            String newPass = edtNewPass.getText().toString();
            String rePass = edtNewPassAgain.getText().toString();
            Boolean check = taiKhoanDAO.checkPass(pass);
            if (!check){
                Toast.makeText(this, "Mật khẩu cũ sai", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (newPass.length() < 5){
                Toast.makeText(this, "mật khẩu mới phải trên 5 ký tự", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (!newPass.equals(rePass)){
                Toast.makeText(this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }
}