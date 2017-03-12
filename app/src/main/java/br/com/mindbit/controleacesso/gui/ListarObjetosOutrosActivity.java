package br.com.mindbit.controleacesso.gui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.mindbit.R;
import br.com.mindbit.controleacesso.dominio.Categoria;
import br.com.mindbit.controleacesso.dominio.Objeto;
import br.com.mindbit.controleacesso.dominio.Pessoa;
import br.com.mindbit.controleacesso.negocio.ObjetoNegocio;
import br.com.mindbit.controleacesso.negocio.SessaoUsuario;
import br.com.mindbit.infra.gui.GuiUtil;
import br.com.mindbit.infra.gui.MindbitException;

public class ListarObjetosOutrosActivity extends AppCompatActivity{
    private ArrayList<Objeto> eventos;
    private ArrayList<Objeto> eventosEncontrados;
    private ArrayList<Objeto> listItems = new ArrayList<>();

    private ListView listView;
    private EditText campoPesquisa;

    private ObjetoNegocio objetoNegocio;
    private SessaoUsuario sessao;
    private Pessoa pessoaLogada;
    private EventoAdapter adapter;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        sessao = SessaoUsuario.getInstancia();
        pessoaLogada = sessao.getPessoaLogada();

        objetoNegocio = ObjetoNegocio.getInstancia(this);
        setContentView(R.layout.activity_listar_objetos);

        listView = (ListView)findViewById(R.id.listview_eventos);
        campoPesquisa = (EditText)findViewById(R.id.edtsearch);
        try {
            initList();
        } catch (MindbitException e) {
            GuiUtil.exibirMsg(ListarObjetosOutrosActivity.this, e.getMessage());
        }
        adapter = new EventoAdapter(this,listItems);

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
                } catch (MindbitException e) {
                    GuiUtil.exibirMsg(ListarObjetosOutrosActivity.this, e.getMessage());
                }

            }
        });
    }

    public void searchItem(String textToSearch) throws MindbitException {

        int id = pessoaLogada.getId();
        eventosEncontrados = (ArrayList<Objeto>) objetoNegocio.consultarNomeDescricaoParcialCategoria(id, textToSearch, Categoria.OUTROS);

        adapter = new EventoAdapter(this, eventosEncontrados);
        listView.setAdapter(adapter);
    }

    public void initList() throws MindbitException {
        eventos = objetoNegocio.listarObjetosCategorias(pessoaLogada.getId(),Categoria.OUTROS);

        adapter = new EventoAdapter(this, eventos);

        listView.setAdapter(adapter);
    }


}
