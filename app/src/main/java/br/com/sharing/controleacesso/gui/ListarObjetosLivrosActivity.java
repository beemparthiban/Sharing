package br.com.sharing.controleacesso.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.sharing.R;
import br.com.sharing.controleacesso.dominio.Categoria;
import br.com.sharing.controleacesso.dominio.Objeto;
import br.com.sharing.controleacesso.dominio.Pessoa;
import br.com.sharing.controleacesso.negocio.ObjetoNegocio;
import br.com.sharing.controleacesso.negocio.SessaoUsuario;
import br.com.sharing.infra.gui.GuiUtil;
import br.com.sharing.infra.gui.SharingException;

public class ListarObjetosLivrosActivity  extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ArrayList<Objeto> eventos;
    private ArrayList<Objeto> eventosEncontrados;
    private ArrayList<Objeto> listItems = new ArrayList<>();

    private ListView listView;
    private EditText campoPesquisa;

    private ObjetoNegocio objetoNegocio;
    private SessaoUsuario sessao;
    private Pessoa pessoaLogada;
    private ObjetoAdapter adapter;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        sessao = SessaoUsuario.getInstancia();
        pessoaLogada = sessao.getPessoaLogada();

        objetoNegocio = ObjetoNegocio.getInstancia(this);
        setContentView(R.layout.activity_listar_objetos);

        listView = (ListView)findViewById(R.id.listview_eventos);
        //listView.setOnItemClickListener(this);
        campoPesquisa = (EditText)findViewById(R.id.edtsearch);
        try {
            initList();
        } catch (SharingException e) {
            GuiUtil.exibirMsg(ListarObjetosLivrosActivity.this, e.getMessage());
        }
        adapter = new ObjetoAdapter(this,listItems);

        campoPesquisa.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int
                    after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int
                    count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (s.toString().equals("")) {
                        initList();
                    } else {
                        searchItem(s.toString().trim());
                    }
                } catch (SharingException e) {
                    GuiUtil.exibirMsg(ListarObjetosLivrosActivity.this, e.getMessage());
                }

            }
        });
    }

    public void searchItem(String textToSearch) throws SharingException {

        int id = pessoaLogada.getId();
        eventosEncontrados = (ArrayList<Objeto>) objetoNegocio.consultarNomeDescricaoParcialCategoria(id, textToSearch, Categoria.LIVROS);

        adapter = new ObjetoAdapter(this, eventosEncontrados);
        listView.setAdapter(adapter);
    }

    public void initList() throws SharingException {
        eventos = objetoNegocio.listarObjetosCategorias(pessoaLogada.getId(),Categoria.LIVROS);

        adapter = new ObjetoAdapter(this, eventos);

        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Objeto objeto = (Objeto) listView.getAdapter().getItem(position);

        Intent intent = new Intent(ListarObjetosLivrosActivity.this, ObjetoActivity.class);
        intent.putExtra("selected", (objeto.getId()));
        startActivity(intent);
    }

}
