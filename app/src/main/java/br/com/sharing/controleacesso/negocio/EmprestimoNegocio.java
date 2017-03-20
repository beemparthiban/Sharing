package br.com.sharing.controleacesso.negocio;

import android.content.Context;

import br.com.sharing.controleacesso.gui.ObjetoActivity;
import br.com.sharing.controleacesso.persistencia.EmprestimoDao;
import br.com.sharing.controleacesso.persistencia.ObjetoDao;
import br.com.sharing.infra.gui.GuiUtil;
import br.com.sharing.infra.gui.SharingException;

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

    public void Emprestimo(int id_usuario, int id_objeto, int id_dono) throws SharingException {
        emprestimoDao.cadastrarEmprestimo(id_usuario,id_objeto,id_dono);
    }
}