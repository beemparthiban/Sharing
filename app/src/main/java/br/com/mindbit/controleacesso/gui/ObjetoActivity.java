package br.com.mindbit.controleacesso.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.mindbit.R;
import br.com.mindbit.controleacesso.dominio.Objeto;
import br.com.mindbit.controleacesso.dominio.Pessoa;
import br.com.mindbit.controleacesso.negocio.ObjetoNegocio;
import br.com.mindbit.controleacesso.negocio.SessaoUsuario;

public class ObjetoActivity extends AppCompatActivity{
    private SessaoUsuario sessaoUsuario;
    private Pessoa pessoaLogada;
    private ObjetoNegocio objetoNegocio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objeto);

        /*
        Objeto objeto = sessaoUsuario.getObjeto();

        ImageView imageView = (ImageView) findViewById(R.id.objeto_imagem_principal);
        TextView textViewNome = (TextView) findViewById(R.id.nome_objeto_show);
        TextView textViewDescricao = (TextView) findViewById(R.id.descricao_objeto_show);
        TextView textViewPlataforma = (TextView) findViewById(R.id.categoria_objeto_show);
        TextView textViewAplicacao = (TextView) findViewById(R.id.dono_objeto_show);

        textViewNome.setText(objeto.getNome());
        textViewDescricao.setText(objeto.getDescricao());
        textViewPlataforma.setText(objeto.getCategoriaEnum().toString());
        textViewAplicacao.setText(objeto.getIdDono());
        //alterar para aparecer informações do dono ao invés do id
        */
    }


}
