package br.com.mindbit.controleacesso.negocio;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.com.mindbit.controleacesso.dominio.Categoria;
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



    public List<Objeto> consultarNomeDescricaoParcialPessoa(int id, String nome) throws MindbitException {
        return objetoDao.buscarNomeDescricaoParcialPessoa(id, nome);
    }

    public List<Objeto> consultarNomeDescricaoParcialCategoria(int id, String nome, Categoria categoria) throws MindbitException {
        ArrayList<Objeto> pesquisa = new ArrayList<>();
        if (categoria.ordinal() == 0){
        pesquisa =  objetoDao.buscarNomeDescricaoParcialCategoria(id, nome,0);
        }else if (categoria.ordinal() == 1){
            pesquisa = objetoDao.buscarNomeDescricaoParcialCategoria(id,nome,1);
        }else if (categoria.ordinal() ==2){
            pesquisa = objetoDao.buscarNomeDescricaoParcialCategoria(id,nome,2);
        }else if (categoria.ordinal() == 3){
            pesquisa = objetoDao.buscarNomeDescricaoParcialCategoria(id,nome,3);
        }else if (categoria.ordinal() == 4){
            pesquisa = objetoDao.buscarNomeDescricaoParcialCategoria(id,nome,4);
        }else if (categoria.ordinal() == 5){
            pesquisa = objetoDao.buscarNomeDescricaoParcialCategoria(id,nome,5);
        }
        return pesquisa;
    }

    public List<Objeto> consultarNomeDescricaoParcial( int id,String nome) throws MindbitException {
        return objetoDao.buscarNomeDescricaoParcial(id,nome);
    }

    public ArrayList<Objeto> listarObjetosCategorias( int id, Categoria categoria) throws MindbitException {
        ArrayList<Objeto> objetos = new ArrayList<>();
        if (categoria.ordinal() == 0){
            objetos = objetoDao.listarObjetosCategorias(id,0);
        }else if(categoria.ordinal() == 1){
            objetos = objetoDao.listarObjetosCategorias(id,1);
        }else if(categoria.ordinal() == 2) {
            objetos = objetoDao.listarObjetosCategorias(id, 2);
        }else if(categoria.ordinal() == 3) {
            objetos = objetoDao.listarObjetosCategorias(id, 3);
        }else if(categoria.ordinal() == 4) {
            objetos = objetoDao.listarObjetosCategorias(id, 4);
        }else if(categoria.ordinal() == 5) {
            objetos = objetoDao.listarObjetosCategorias(id, 5);
        }
        return objetos;
    }


    public Objeto pesquisarPorNome(String nome) throws MindbitException {
        Objeto objeto = objetoDao.buscarEventoNome(nome);
        return objeto;
    }

    public Objeto pesquisarPorId(long idObjeto) throws MindbitException{
        Objeto objeto = objetoDao.buscarObjetoId(idObjeto);
        return objeto;
    }


    public void validarCadastroObjeto(Objeto objeto) throws MindbitException {
        Objeto objetoBusca = objetoDao.buscarObjetoNomeEDono(pessoaLogada.getId(),objeto.getNome());
        if (objetoBusca != null){
            throw new MindbitException("Objeto já cadastrado");
        }
        objetoDao.cadastrarObjeto(objeto);
    }

    public ArrayList<Objeto> listarObjetos(int id ) throws MindbitException{
        return objetoDao.listarObjetos(id);
    }

    public ArrayList<Objeto> listarObjetosPessoa(int idDono ) throws MindbitException{
        return objetoDao.listarObjetosPessoa(idDono);
    }

    public void retornarObjeto(int idObjeto) throws MindbitException{
        objetoDao.devolverObjeto(idObjeto);
    }

}
