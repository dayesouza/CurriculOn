package studyjam.com.br.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import studyjam.com.br.java.R;

/**
 * Created by day on 14/04/16.
 */
public class  DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int ano = c.get(Calendar.YEAR) - 14;
        //int year = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH);
        int dia = c.get(Calendar.DAY_OF_MONTH);

        // Cria uma nova instância do DatePicker e retorna
        return new DatePickerDialog(getActivity(), this, ano, mes, dia);
    }

    //Define o que acontece quando o usuario seleciona a data
    public void onDateSet(DatePicker view, int ano, int mes, int dia) {
        //seta a data escolhida no campo de data de nascimento
        ((EditText) getActivity().findViewById(R.id.data_nascimento)).setText(dia+"/"+mes+"/"+ano);
    }
}