package br.com.mindbit.controleacesso.gui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import br.com.mindbit.R;
import br.com.mindbit.controleacesso.negocio.SessaoUsuario;
import br.com.mindbit.infra.gui.GuiUtil;

public class ListaImagensObjetoActivity extends AppCompatActivity{
    private SessaoUsuario sessao = SessaoUsuario.getInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_imagens_objeto);

        Bundle bundle = getIntent().getExtras();
        int idObjeto = bundle.getInt("imagem");


        ObjetoImagemAdapter projetoImagemAdapter;
        ListView listView = (ListView) findViewById(R.id.listaImagensProjeto);
        //projetoImagemAdapter = new ObjetoImagemAdapter(this, 0, sessao.getProjeto().getImagens());
        //listView.setAdapter(projetoImagemAdapter);
    }
}
