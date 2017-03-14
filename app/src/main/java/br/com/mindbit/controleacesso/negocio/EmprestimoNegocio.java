package br.com.mindbit.controleacesso.negocio;

import android.content.Context;

import br.com.mindbit.controleacesso.dominio.Objeto;
import br.com.mindbit.controleacesso.dominio.Pessoa;
import br.com.mindbit.controleacesso.persistencia.EmprestimoDao;
import br.com.mindbit.controleacesso.persistencia.ObjetoDao;
import br.com.mindbit.controleacesso.persistencia.UsuarioDao;
import br.com.mindbit.infra.gui.MindbitException;

public class EmprestimoNegocio {
    private static EmprestimoDao emprestimoDao;


    private EmprestimoNegocio() {
    }

    public static EmprestimoNegocio instancia = new EmprestimoNegocio();

    public static EmprestimoNegocio getInstancia(Context context) {
        emprestimoDao = EmprestimoDao.getInstancia(context);
        return instancia;
    }

    public static EmprestimoNegocio getInstancia() {
        return instancia;
    }

    public void Emprestimo(int id_usuario, int id_objeto, int id_dono) throws MindbitException {
        emprestimoDao.cadastrarEmprestimo(id_usuario,id_objeto,id_dono);
    }
}