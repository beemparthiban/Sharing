package br.com.sharing.controleacesso.gui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.sharing.R;
import br.com.sharing.controleacesso.dominio.Estado;
import br.com.sharing.controleacesso.dominio.Objeto;
import br.com.sharing.controleacesso.dominio.Pessoa;
import br.com.sharing.controleacesso.negocio.EmprestimoNegocio;
import br.com.sharing.controleacesso.negocio.ObjetoNegocio;
import br.com.sharing.controleacesso.negocio.SessaoUsuario;
import br.com.sharing.controleacesso.negocio.UsuarioNegocio;
import br.com.sharing.controleacesso.persistencia.ObjetoDao;
import br.com.sharing.infra.gui.GuiUtil;
import br.com.sharing.infra.gui.SharingException;

public class ObjetoActivity extends AppCompatActivity {
    private SessaoUsuario sessaoUsuario;
    private Pessoa pessoaLogada;
    private ObjetoNegocio objetoNegocio;
    private UsuarioNegocio usuarioNegocio;

    private EmprestimoNegocio emprestimoNegocio;

    private int idObjeto;
    private int idDonoObjeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objeto);

        Bundle bundle = getIntent().getExtras();
        idObjeto = bundle.getInt("selected");


        ImageView imageView = (ImageView) findViewById(R.id.objeto_imagem_principal);
        TextView textViewNome = (TextView) findViewById(R.id.nome_objeto_show);
        TextView textViewDescricao = (TextView) findViewById(R.id.descricao_objeto_show);
        TextView textViewPlataforma = (TextView) findViewById(R.id.categoria_objeto_show);
        TextView textViewAplicacao = (TextView) findViewById(R.id.dono_objeto_show);
        Button solicitarEmprestimo = (Button) findViewById(R.id.pedir_emprestimo) ;

        sessaoUsuario = SessaoUsuario.getInstancia();
        usuarioNegocio = UsuarioNegocio.getInstancia(this);
        pessoaLogada = sessaoUsuario.getPessoaLogada();
        objetoNegocio = ObjetoNegocio.getInstancia(this);

        emprestimoNegocio = EmprestimoNegocio.getInstancia(this);

        Objeto objeto = getObjeto(idObjeto);
        String nomeDono;
        Pessoa objetoDono = getPessoa(objeto.getIdDono());
        nomeDono = objetoDono.getNome();
        String emailDono = objetoDono.getEmail();
        String informacoesDono = nomeDono + "\n" + emailDono;

        textViewNome.setText(objeto.getNome());
        textViewDescricao.setText(objeto.getDescricao());
        textViewPlataforma.setText(objeto.getCategoriaEnum().toString());
        textViewAplicacao.setText(informacoesDono);
        imageView.setImageURI(objeto.getFoto());

        idDonoObjeto = objeto.getIdDono();

        solicitarEmprestimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emprestar();
            }
        });
    }

    public Objeto getObjeto(int idObjeto) {
        Objeto objeto = new Objeto();

        try {
            objeto = objetoNegocio.pesquisarPorId(idObjeto);
        } catch (SharingException e) {
            Log.d("ObjetoActivity", e.getMessage());
        }

        return objeto;
    }

    public Pessoa getPessoa(int idDono){
        Pessoa pessoa = new Pessoa();

        try {
            pessoa = usuarioNegocio.pesquisarPorId(idDono);
        }catch (SharingException e){
            Log.d("ObjetoActivity",e.getMessage());
        }

        return pessoa;
    }

    public void onButtonClickProjeto(View v){
    /*
        if (v.getId() == R.id.objeto_imagem_principal){
            Intent intent= new Intent(this, ListaImagensObjetoActivity.class);
            intent.putExtra("imagem", (getObjeto(idObjeto).getId()));
            startActivity(intent);

        }*/
    }

    public void emprestar(){

        ObjetoDao objetoDao = new ObjetoDao();
        Objeto objeto = getObjeto(idObjeto);
        if (pessoaLogada.getPontuacao()>5) {
            try {
                objeto.setIdAlugador(pessoaLogada.getId());
                objeto.setEstadoEnum(Estado.ALUGADO);
                emprestimoNegocio.Emprestimo(pessoaLogada.getId(), idObjeto, idDonoObjeto);
                objetoDao.alugarObjeto(idObjeto, pessoaLogada.getId());
                pessoaLogada.dimPontuacao(5);
                GuiUtil.exibirMsg(this, "Objeto alugado com sucesso");
            } catch (SharingException e) {
                GuiUtil.exibirMsg(this, e.getMessage());
            }
        }else {
            GuiUtil.exibirMsg(this,"Você não tem pontuação suficiente!\n Cadastre mais objetos");
        }

    }

}
