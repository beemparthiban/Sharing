package br.com.mindbit.controleacesso.negocio;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.com.mindbit.controleacesso.dominio.Objeto;
import br.com.mindbit.controleacesso.dominio.Pessoa;
import br.com.mindbit.controleacesso.persistencia.ObjetoDao;
import br.com.mindbit.infra.gui.MindbitException;

public class ObjetoNegocio {

    private SessaoUsuario sessaoUsuario = SessaoUsuario.getInstancia();
    private Pessoa pessoaLogada = sessaoUsuario.getPessoaLogada();

    private static ObjetoDao objetoDao;

    private static ObjetoNegocio instancia = new ObjetoNegocio();

    private ObjetoNegocio(){}

    /* singleton */
    public static ObjetoNegocio getInstancia(Context context){
        objetoDao = ObjetoDao.getInstancia(context);
        return instancia;
    }
    public static ObjetoNegocio getInstancia(){
        return instancia;
    }



    public List<Objeto> consultarNomeDescricaoParcial(int id, String nome) throws MindbitException {
        return objetoDao.buscarNomeDescricaoParcial(id, nome);
    }



    public Objeto pesquisarPorNome(String nome) throws MindbitException {
        Objeto objeto = objetoDao.buscarEventoNome(nome);
        return objeto;
    }



    public void validarCadastroObjeto(Objeto objeto) throws MindbitException {
        Objeto objetoBusca = objetoDao.buscarObjetoNomeEDono(pessoaLogada.getId(),objeto.getNome());
        if (objetoBusca != null){
            throw new MindbitException("Objeto já cadastrado");
        }
        objetoDao.cadastrarObjeto(objeto);
    }

    public ArrayList<Objeto> listarObjetos( ) throws MindbitException{
        return objetoDao.listarObjetos();
    }


    /*
    public ArrayList<Objeto> listarEventosProximo(int idPessoaCriadora) throws MindbitException {
        return objetoDao.listarEventoProximo(idPessoaCriadora);
    }*/


    /*
    public ArrayList<Objeto> listarEventosDia(String data, int idPessoaCriadora) throws MindbitException{
        return objetoDao.listarEventoData(data,idPessoaCriadora);
    }*/
}
