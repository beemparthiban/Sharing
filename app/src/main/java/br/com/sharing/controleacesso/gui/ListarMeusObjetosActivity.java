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
import br.com.sharing.controleacesso.dominio.Objeto;
import br.com.sharing.controleacesso.dominio.Pessoa;
import br.com.sharing.controleacesso.negocio.ObjetoNegocio;
import br.com.sharing.controleacesso.negocio.SessaoUsuario;
import br.com.sharing.infra.gui.GuiUtil;
import br.com.sharing.infra.gui.SharingException;

public class ListarMeusObjetosActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ArrayList<Objeto> objetosPessoa;
    private ArrayList<Objeto> objetosEncontrados;
    private ArrayList<Objeto> listItems = new ArrayList<>();

    private ListView listView;
    private EditText campoPesquisa;

    private ObjetoNegocio objetoNegocio;
    private SessaoUsuario sessao;
    private Pessoa pessoaLogada;
    private ObjetoAdapter adapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sessao = SessaoUsuario.getInstancia();
        pessoaLogada = sessao.getPessoaLogada();

        objetoNegocio = ObjetoNegocio.getInstancia(this);
        setContentView(R.layout.activity_listar_objetos);
        listView = (ListView)findViewById(R.id.listview_eventos);
        listView.setOnItemClickListener(this);
        campoPesquisa = (EditText)findViewById(R.id.edtsearch);
        try {
            initList();
        } catch (SharingException e) {
            GuiUtil.exibirMsg(ListarMeusObjetosActivity.this, e.getMessage());
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
                    GuiUtil.exibirMsg(ListarMeusObjetosActivity.this, e.getMessage());
                }

            }
        });
    }

    public void searchItem(String textToSearch) throws SharingException {

        int id = pessoaLogada.getId();
        objetosEncontrados = (ArrayList<Objeto>) objetoNegocio.consultarNomeDescricaoParcialPessoa(id, textToSearch);

        adapter = new ObjetoAdapter(this, objetosEncontrados);
        listView.setAdapter(adapter);
    }

    public void initList() throws SharingException {
        objetosPessoa = objetoNegocio.listarObjetosPessoa(pessoaLogada.getId());

        adapter = new ObjetoAdapter(this, objetosPessoa);

        listView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

            Objeto objeto = (Objeto) listView.getAdapter().getItem(position);

            Intent intent = new Intent(ListarMeusObjetosActivity.this, MeuObjetoActivity.class);
            intent.putExtra("selected-item", (objeto.getId()));
            startActivity(intent);
        }
    }