package br.com.mindbit.controleacesso.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.mindbit.R;
import br.com.mindbit.controleacesso.dominio.Categoria;
import br.com.mindbit.controleacesso.dominio.Objeto;
import br.com.mindbit.controleacesso.dominio.Pessoa;
import br.com.mindbit.controleacesso.negocio.ObjetoNegocio;
import br.com.mindbit.controleacesso.negocio.SessaoUsuario;
import br.com.mindbit.controleacesso.negocio.UsuarioNegocio;
import br.com.mindbit.infra.gui.GuiUtil;
import br.com.mindbit.infra.gui.MindbitException;

public class MeuObjetoActivity extends AppCompatActivity {
    private SessaoUsuario sessaoUsuario;
    private Pessoa pessoaLogada;
    private ObjetoNegocio objetoNegocio;
    private UsuarioNegocio usuarioNegocio;

    private ImageView imageView;
    private TextView textViewNome;
    private TextView textViewDescricao;
    private TextView textViewCategoria;
    private TextView textViewEstado;
    private TextView textViewAlugador;

    private int idObjeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_meu_objeto);

        Bundle bundle = getIntent().getExtras();
        idObjeto = bundle.getInt("selected-item");

        imageView = (ImageView) findViewById(R.id.meu_objeto_imagem_principal);
        textViewNome = (TextView) findViewById(R.id.nome_meu_objeto_show);
        textViewDescricao = (TextView) findViewById(R.id.descricao_meu_objeto_show);
        textViewCategoria = (TextView) findViewById(R.id.categoria_meu_objeto_show);
        textViewEstado = (TextView) findViewById(R.id.estado_meu_objeto_show);
        textViewAlugador = (TextView) findViewById(R.id.alugador_meu_objeto_show);

        sessaoUsuario = SessaoUsuario.getInstancia();
        usuarioNegocio = UsuarioNegocio.getInstancia(this);
        pessoaLogada = sessaoUsuario.getPessoaLogada();
        objetoNegocio = ObjetoNegocio.getInstancia(this);

        Objeto objeto = getObjeto(idObjeto);
        String informacoesAlugador;
        if (objeto.getIdAlugador()!=0){
            Pessoa objetoAlugador = getPessoa(objeto.getIdAlugador());
            informacoesAlugador = objetoAlugador.getNome()+"\n"+objetoAlugador.getEmail();
        }else {
            informacoesAlugador = "  - - -";
        }

        textViewNome.setText(objeto.getNome());
        textViewDescricao.setText(objeto.getDescricao());
        textViewCategoria.setText(objeto.getCategoriaEnum().toString());
        textViewEstado.setText(objeto.getEstadoEnum().toString());
        textViewAlugador.setText(informacoesAlugador);
    }


    public Objeto getObjeto(int idObjeto) {
        Objeto objeto = new Objeto();

        try {
            objeto = objetoNegocio.pesquisarPorId(idObjeto);
        } catch (MindbitException e) {
            Log.d("MeuObjetoActivity", e.getMessage());
        }

        return objeto;
    }

    public Pessoa getPessoa(int idDono){
        Pessoa pessoa = new Pessoa();
        try{
            pessoa = usuarioNegocio.pesquisarPorId(idDono);
        }catch (MindbitException e){
            Log.d("MeuObjetoActivity",e.getMessage());
        }
        return pessoa;
    }

    public void onButtonClickMeuObjeto(View v){

        if (v.getId() == R.id.meu_objeto_imagem_principal){
            Intent intent= new Intent(this, ListaImagensObjetoActivity.class);
            intent.putExtra("imagem", (getObjeto(idObjeto).getId()));
            startActivity(intent);
        }
    }

}