package id.sch.smktelkom_mlg.tugas01.xirpl2028.pendaftarananggotasci;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    EditText etNama;
    EditText etNoReg;
    RadioGroup rgPendidikan;
    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    Button bDaftar;
    TextView tvHasil1;
    TextView tvHasil2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etNoReg = (EditText) findViewById(R.id.editTextNoReg);
        rgPendidikan = (RadioGroup) findViewById(R.id.radioGroupPendidikan);
        cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        bDaftar = (Button) findViewById(R.id.buttonDaftar);
        bDaftar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view)
            {
                String nama = etNama.getText().toString();
                String noreg = etNoReg.getText().toString();
                tvHasil1.setText("Identitas: " + nama + " dengan no. reg. " +noreg);
                doClick();

            }
        });
        tvHasil1 = (TextView) findViewById(R.id.textViewHasil1);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
    }

    private void doClick()
    {
        String hasil = null;

        if(rgPendidikan.getCheckedRadioButtonId()!=-1)
        {
            RadioButton rb = (RadioButton)
                    findViewById(rgPendidikan.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }
        if (hasil == null)
        {
            tvHasil2.setText("Belum memilih pendidikan terakhir");
        }
        else
        {
            tvHasil2.setText("Pendidikan terakhir: " + hasil);
        }
    }

}
