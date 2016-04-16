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

        criaSpinner(R.id.spinner_UF, R.array.uf_array);
    }

    public void avancaTelaInfoPessoais(View view){
        //vem depois das instruções
        //setContentView(R.layout.informacoes_pessoais_1);
    }

    public void avancaTelaInfoEstudos(View view){
        //Pega os campos e coloca no objeto
        //vai pra próxima tela
        setContentView(R.layout.informacoes_educacionais_2);
        //Coloca o conteúdo no spinner
        criaSpinner(R.id.spinner_formacao,R.array.formacao_array);
    }

    public void avancaTelaInfoTrabalhos(View view){
        setContentView(R.layout.informacoes_trabalhos_3);
    }

    public void avancaTelaObservacoes(View view){
        //seta a view
        setContentView(R.layout.informacoes_observacoes_4);
        //seta o spinner
        criaSpinner(R.id.spinner_cnh, R.array.cnh_array);
    }

    public void avancaTelaEscolheLayout(View view) {

    }

    public void compartilha(View view){

    }

    /**
     * Método que cria o spinner para as telas
     * @param spinner_id
     * @param spinner_array
     */
    private void criaSpinner(int spinner_id, int spinner_array){
        Spinner spinner = (Spinner) findViewById(spinner_id);
        // Cria um ArrayAdapter com o array criado em strings
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                spinner_array, android.R.layout.simple_spinner_item);
        // Especifica o layout quando a lista for aberta
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Aplica o Adapter no Spinner
        spinner.setAdapter(adapter);
    }
}
