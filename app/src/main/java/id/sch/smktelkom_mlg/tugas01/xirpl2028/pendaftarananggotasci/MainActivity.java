package id.sch.smktelkom_mlg.tugas01.xirpl2028.pendaftarananggotasci;

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

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{
    EditText etNama;
    EditText etNoReg;
    RadioGroup rgPendidikan;
    Spinner spKorwil;
    CheckBox cb1, cb2, cb3;
    Button bDaftar;
    TextView tvHasil1, tvHasil2, tvHasil3, tvHasil4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etNoReg = (EditText) findViewById(R.id.editTextNoReg);
        rgPendidikan = (RadioGroup) findViewById(R.id.radioGroupPendidikan);
        spKorwil = (Spinner) findViewById(R.id.spinnerKorwil);
        cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        bDaftar = (Button) findViewById(R.id.buttonDaftar);
        bDaftar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view)
            {
                if(isValid())
                {
                    String nama = etNama.getText().toString();
                    String noreg = etNoReg.getText().toString();
                    tvHasil1.setText("Identitas: " + nama + " dengan no. reg. " + noreg);
                    doClick();
                }
            }
        });
        tvHasil1 = (TextView) findViewById(R.id.textViewHasil1);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);
        tvHasil4 = (TextView) findViewById(R.id.textViewHasil4);
    }

    private boolean isValid()
    {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String noreg = etNoReg.getText().toString();

        if(nama.isEmpty())
        {
            etNama.setError("Nama lengkap belum diisi");
            valid = false;
        }
        else if(nama.length()<6)
        {
            etNama.setError("Nama lengkap minimal 6 karakter");
            valid = false;
        }
        else
        {
            etNama.setError(null);
        }

        if(noreg.isEmpty())
        {
            etNoReg.setError("No. registrasi belum diisi");
            valid = false;
        }
        else
        {
            etNoReg.setError(null);
        }

        return valid;
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

        tvHasil3.setText("Korwil: " + spKorwil.getSelectedItem().toString());

        String hasil2 = "Peraturan yang dipatuhi:\n";
        int startlen = hasil2.length();
        if(cb1.isChecked()) hasil2+=cb1.getText()+"\n";
        if(cb2.isChecked()) hasil2+=cb2.getText()+"\n";
        if(cb3.isChecked()) hasil2+=cb3.getText()+"\n";

        if(hasil2.length()==startlen) hasil2+="Belum mematuhi aturan satu pun";

        tvHasil4.setText(hasil2);
    }

}
