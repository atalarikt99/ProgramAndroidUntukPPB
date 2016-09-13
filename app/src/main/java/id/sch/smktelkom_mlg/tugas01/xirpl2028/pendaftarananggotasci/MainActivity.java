package id.sch.smktelkom_mlg.tugas01.xirpl2028.pendaftarananggotasci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    EditText etNama;
    EditText etNoReg;
    Button bDaftar;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etNoReg = (EditText) findViewById(R.id.editTextNoReg);
        bDaftar = (Button) findViewById(R.id.buttonDaftar);
        bDaftar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view)
            {
                etNama.setText("Nama asli");
                etNoReg.setText("No. registrasi yg tercantum pd form");
                tvHasil.setText("Data telah dikirim, silahkan tunggu konfirmasi");
            }
        });
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
    }
}
