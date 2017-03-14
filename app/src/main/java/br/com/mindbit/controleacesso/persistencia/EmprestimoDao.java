package br.com.mindbit.controleacesso.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.mindbit.controleacesso.negocio.SessaoUsuario;
import br.com.mindbit.infra.gui.MindbitException;

public class EmprestimoDao {
    private static DatabaseHelper databaseHelper;
    private static ObjetoDao objetoDao;
    private static UsuarioDao usuarioDao;
    private static Context contexto;

    private static EmprestimoDao instanciaEmprestimoDao = new EmprestimoDao();
    private EmprestimoDao(){};

    private SessaoUsuario sessaoUsuario = SessaoUsuario.getInstancia();

    public static EmprestimoDao getInstancia(Context contexto) {
        EmprestimoDao.contexto = contexto;
        EmprestimoDao.databaseHelper = new DatabaseHelper(contexto);
        EmprestimoDao.usuarioDao = UsuarioDao.getInstancia(contexto);
        EmprestimoDao.objetoDao = ObjetoDao.getInstancia(contexto);
        return instanciaEmprestimoDao;
    }

    /*
    metodo utilizado para registrar o emprestimo no sistema

    Epessoa - usado para identi
     */
    public void cadastrarEmprestimo(int idUsuario, int idObjeto, int idDono) throws MindbitException{
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DatabaseHelper.EMPRESTIMO_DONO_OBJETO_ID, idDono);
        values.put(DatabaseHelper.EMPRESTIMO_OBJETO_ID, idObjeto);
        values.put(DatabaseHelper.EMPRESTIMO_ID_USUARIO, idUsuario);

        db.insert(DatabaseHelper.TABELA_EMPRESTIMO, null, values);
        objetoDao.alugarObjeto(idObjeto,idUsuario);
        db.close();
    }



}