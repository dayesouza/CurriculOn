package studyjam.com.br.java;

import android.app.DialogFragment;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import studyjam.com.br.fragments.DatePickerFragment;

public class MainActivity extends AppCompatActivity {
    //Para contar as telas de instrucao
    int view_instrucao = 2;

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

    public void avancaTelaInfoPessoais(View view){
        //Seta a view de informações pessoais
        setContentView(R.layout.informacoes_pessoais_1);

        criaSpinner(R.id.spinner_UF, R.array.uf_array);
    }

    /**
     * Gera o pdf
     * @param view
     */
    public void gerarPDF(View view){
        GeneratorPDF pdf = new GeneratorPDF();
        pdf.criar();

        setContentView(R.layout.sucesso);
    }

    public void avancaTelaInfoEstudos(View view){
        //Pega os campos e coloca nos valores

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

    public void tela_instrucao(View view){
        setContentView(R.layout.instrucoes);
    }

    /**
     * Muda a tela de instrução conforme é clicado na tela
     * @param view
     */
    public void avancaInstrucao(View view){
        //Pega a imagem de demonstração
        ImageView img_instrucao = (ImageView) findViewById(R.id.img_tela);
        //Pega o texto
        TextView texto_instrucao = (TextView) findViewById(R.id.texto_instrucao);
        //Apaga o texto de descrição do app
        TextView texto_descricao = (TextView) findViewById(R.id.texto_descricao);
        texto_descricao.setText("");

        //Seta a imagem e o texto de acordo com a quantidade de instruções lidas
        int r_img = 0;
        String msg = "";
        int contador_instr = 0;
        switch(view_instrucao){
            case 2:
                r_img = R.drawable.tela_2;
                msg = "Depois, você informa sua escolaridade, seus cursos...";
                contador_instr = R.id.instr_2;
                break;
            case 3:
                r_img = R.drawable.tela_3;
                msg = "Aqui você coloca suas experiências...";
                contador_instr = R.id.instr_3;
                break;
            case 4:
                r_img = R.drawable.tela_4;
                msg = "E aqui as informações adicionais! Pode colocar coisas sobre você, seus conhecimentos e o que você" +
                        " acha que o entrevistados deve saber.";
                contador_instr = R.id.instr_4;
                break;
            case 5:
                r_img = R.drawable.compartilhamento;
                msg = "Daí é só sair compartilhando e boa sorte!";
                contador_instr = R.id.instr_5;
                break;
        }
        img_instrucao.setImageResource(r_img);
        texto_instrucao.setText(msg);

        //Pega o contador das telas de instrução e colore como concluído
        TextView cont_instrucao = (TextView) findViewById(contador_instr);
        cont_instrucao.setBackgroundColor(getResources().getColor(R.color.colorAccent));

        if (view_instrucao == 5){
            //Se a view for 5, acabaram as instruçoes e sera disponibilizado um botao para ir para a tela de edição
            Button botao_start = (Button) findViewById(R.id.botao_comecar);
            botao_start.setVisibility(View.VISIBLE);
            botao_start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    avancaTelaInfoPessoais(v);
                }
            });
            LinearLayout linear = (LinearLayout) findViewById(R.id.layout_intrucao);
            //Tira o onclick do layout inteiro
            linear.setOnClickListener(null);
        }

        view_instrucao++;
    }
}
