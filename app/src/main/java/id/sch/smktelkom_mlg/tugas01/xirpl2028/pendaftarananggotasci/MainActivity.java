package id.sch.smktelkom_mlg.tugas01.xirpl2028.pendaftarananggotasci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    Spinner spKorwil;
    Button bDaftar;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etNoReg = (EditText) findViewById(R.id.editTextNoReg);
        rgPendidikan = (RadioGroup) findViewById(R.id.radioGroupPendidikan);
        spKorwil = (Spinner) findViewById(R.id.spinnerKorwil);
        bDaftar = (Button) findViewById(R.id.buttonDaftar);
        bDaftar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view)
            {
                doProccess();
            }
        });
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
    }


    private void doProccess()
    {
        if(isValid())
        {
            tvHasil.setText("Seluruh data telah terkirim!");
        }
    }

    private boolean isValid()
    {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String noreg = etNoReg.getText().toString();
        String korwil = spKorwil.getSelectedItem().toString();

        if (nama.isEmpty())
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
            etNoReg.setError("No. registrasi belum diisi. Silahkan lihat formulir yang dikirimkan Bang Arkan untuk no. registrasi.");
            valid = false;
        }

        else
        {
            etNoReg.setError(null);
        }

        if(korwil.isEmpty())
        {
            spKorwil.setPrompt();
        }

        return valid;
    }
}
