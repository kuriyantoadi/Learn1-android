package melon.kuning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    //Deklarasi
    private EditText edtAngka1, edtAngka2;
    private Button btnTambah, btnMove, btnShare;
    private TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisiasi
        edtAngka1 = findViewById(R.id.edtAngka1);
        edtAngka2 = findViewById(R.id.edtAngka2);
        btnTambah = findViewById(R.id.btnTambah);
        txtHasil = findViewById(R.id.txtHasil);
        btnMove = findViewById(R.id.btnMove);
        btnShare = findViewById(R.id.btnShare);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String angka1 = edtAngka1.getText().toString().trim();
                String angka2 = edtAngka2.getText().toString().trim();

                int hasil = Integer.parseInt(angka1) + Integer.parseInt(angka2);

                txtHasil.setText("Hasilnya adalah = "+ hasil);
            }
        });

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( MainActivity.this, ResultActivity.class);
                startActivity(i);
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Selamat Datang Bos");
                sendIntent.setType("text/plan");
                startActivity(sendIntent);
            }
        });
    }
}