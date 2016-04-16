package studyjam.com.br.java;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import studyjam.com.br.fragments.DatePickerFragment;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     * Fragmento com DatePicker é chamado pelo campo de data de nascimento
     */
    public void chamaDatePicker(View view){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "DatePicker");
    }
    public void editar(View view){
        //Seta a view de informações pessoais
        setContentView(R.layout.informacoes_pessoais_1);
        //Pega o xml Spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner_UF);
        // Cria um ArrayAdapter com o array criado em strings
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        R.array.uf_array, android.R.layout.simple_spinner_item);
        // Especifica o layout quando a lista for aberta
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Aplica o Adapter no Spinner
        spinner.setAdapter(adapter);
    }

    public void avancaTelaInfoPessoais(View view){
        //vem depois das instruções
        //setContentView(R.layout.informacoes_pessoais_1);
    }

    public void avancaTelaInfoEstudos(View view){
        //Pega os campos e coloca no objeto
        //vai pra próxima tela
        setContentView(R.layout.informacoes_educacionais_2);
        Spinner spinner = (Spinner) findViewById(R.id.spinner_formacao);
        // Cria um ArrayAdapter com o array criado em strings
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.formacao_array, android.R.layout.simple_spinner_item);
        // Especifica o layout quando a lista for aberta
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Aplica o Adapter no Spinner
        spinner.setAdapter(adapter);
    }

    public void avancaTelaInfoTrabalhos(View view){
        setContentView(R.layout.informacoes_trabalhos_3);
    }

    public void avancaTelaObservacoes(View view){
        setContentView(R.layout.informacoes_observacoes_4);
    }

    public void avancaTelaEscolheLayout(View view) {

    }

    public void compartilha(View view){

    }
}
