package br.com.sharing.controleacesso.gui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import br.com.sharing.R;
import br.com.sharing.controleacesso.negocio.SessaoUsuario;

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
