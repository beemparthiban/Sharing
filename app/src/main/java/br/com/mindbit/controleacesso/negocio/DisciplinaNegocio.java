/*package br.com.mindbit.controleacesso.negocio;

import android.content.Context;

import java.util.List;

import br.com.mindbit.controleacesso.dominio.Disciplina;
import br.com.mindbit.controleacesso.persistencia.DisciplinaDao;
import br.com.mindbit.infra.gui.MindbitException;


public class DisciplinaNegocio {
    private static DisciplinaDao disciplinaDao;

    private static DisciplinaNegocio instancia = new DisciplinaNegocio();

    private DisciplinaNegocio(){}


    // singleton /
    public static DisciplinaNegocio getInstancia(Context context){
        disciplinaDao = disciplinaDao.getInstancia(context);
        return instancia;
    }



    public void validarCadastroDisciplina(Disciplina disciplina) throws MindbitException {
        Disciplina disciplinaBusca = disciplinaDao.buscarDisciplinaNome(disciplina.getNome());
        if (disciplinaBusca != null){
            throw new MindbitException("Disciplina já cadastrada");
        }
        disciplinaDao.cadastrarDisciplina(disciplina);
    }

}
*/