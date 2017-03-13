package br.com.mindbit.controleacesso.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.mindbit.R;
import br.com.mindbit.controleacesso.dominio.Objeto;
import br.com.mindbit.controleacesso.dominio.Pessoa;
import br.com.mindbit.controleacesso.negocio.ObjetoNegocio;
import br.com.mindbit.controleacesso.negocio.SessaoUsuario;
import br.com.mindbit.infra.gui.GuiUtil;
import br.com.mindbit.infra.gui.MindbitException;

public class PerfilActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemClickListener {

    private SessaoUsuario sessaoUsuario;
    private Pessoa pessoaLogada;

    private ArrayList<Objeto> eventosPessoa;
    private ArrayList<Objeto> eventosEncontrados;
    private ArrayList<Objeto> listItems = new ArrayList<>();

    private ListView listView;
    private EditText campoPesquisa;

    private ObjetoNegocio objetoNegocio;
    private ObjetoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        sessaoUsuario = SessaoUsuario.getInstancia();
        pessoaLogada = sessaoUsuario.getPessoaLogada();
        objetoNegocio = ObjetoNegocio.getInstancia(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View view = navigationView.getHeaderView(0);

        listView = (ListView)findViewById(R.id.listview_eventos);
        listView.setOnItemClickListener(this);
        campoPesquisa = (EditText)findViewById(R.id.edtsearch);
        TextView nome = (TextView) view.findViewById(R.id.txtNomePerfil);
        TextView email = (TextView) view.findViewById(R.id.txtEmailPerfil);
        TextView pontuacao = (TextView) view.findViewById(R.id.txtPontuacaoPerfil);
        ImageView fotoPerfil = (ImageView) view.findViewById(R.id.fotoPerfil);

        if (pessoaLogada.getFoto() == null){
            fotoPerfil.setImageURI(pessoaLogada.getFoto());
        }else{
            fotoPerfil.setImageURI(CadastroActivity.FOTO_PADRAO);
            //não tá setando a foto
        }
        nome.setText(pessoaLogada.getNome());
        email.setText(pessoaLogada.getEmail());
        String pontos = String.valueOf(pessoaLogada.getPontuacao())+" pontos";
        pontuacao.setText(pontos);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


        try {
            initList();
        } catch (MindbitException e) {
            GuiUtil.exibirMsg(PerfilActivity.this, e.getMessage());
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
                } catch (MindbitException e) {
                    GuiUtil.exibirMsg(PerfilActivity.this, e.getMessage());
                }

            }
        });
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            deslogar();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void deslogar(){
        sessaoUsuario.invalidarSessao();
        startLoginActivity();
    }

    public void startLoginActivity() {
        Intent i = new Intent(PerfilActivity.this, LoginActivity.class);
        startActivity(i);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_cadastrar_objetos) {
            Intent i = new Intent(this, AddObjetoActivity.class);
            startActivity(i);

        } else if(id == R.id.nav_meus_objetos) {
            Intent i = new Intent(this, ListarMeusObjetosActivity.class);
            startActivity(i);

        }else if(id == R.id.nav_proximas_devolucoes) {
            Intent i = new Intent(this,AddObjetoActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_ferramentas) {
            Intent i = new Intent(this, ListarObjetosFerramentasActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_cozinha) {
           Intent i = new Intent(this,ListarObjetosCozinhaActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_jogos) {
            Intent i = new Intent(this,ListarObjetosJogosActivity.class);
            startActivity(i);
        }else if (id == R.id.nav_livros) {
            Intent i = new Intent(this, ListarObjetosLivrosActivity.class);
            startActivity(i);
        }else if (id == R.id.nav_viagem) {
            Intent i = new Intent(this, ListarObjetosViagemActivity.class);
            startActivity(i);
        }else if (id == R.id.nav_outros) {
            Intent i = new Intent(this, ListarObjetosOutrosActivity.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void searchItem(String textToSearch) throws MindbitException {

        eventosEncontrados = (ArrayList<Objeto>) objetoNegocio.consultarNomeDescricaoParcial(pessoaLogada.getId(),textToSearch);

        adapter = new ObjetoAdapter(this, eventosEncontrados);
        listView.setAdapter(adapter);
    }

    public void initList() throws MindbitException {
        eventosPessoa = objetoNegocio.listarObjetos(pessoaLogada.getId());

        adapter = new ObjetoAdapter(this, eventosPessoa);

        listView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Objeto objeto = (Objeto) listView.getAdapter().getItem(position);

        Intent intent = new Intent(PerfilActivity.this, ObjetoActivity.class);
        intent.putExtra("selected", (objeto.getId()));
        startActivity(intent);
    }
}
