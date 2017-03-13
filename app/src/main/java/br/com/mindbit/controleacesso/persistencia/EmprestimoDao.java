package br.com.mindbit.controleacesso.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import br.com.mindbit.controleacesso.dominio.Objeto;
import br.com.mindbit.controleacesso.dominio.Pessoa;
import br.com.mindbit.controleacesso.negocio.SessaoUsuario;

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
    public void cadastrarEmprestimo(Pessoa emprestadorPessoa, Objeto objeto, Pessoa alugadorPessoa){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        long foreing_key_id_objeto = db.insert(DatabaseHelper.TABELA_OBJETO, null, values);
        long foreing_key_id_dono_objeto = db.insert(DatabaseHelper.TABELA_PESSOA, null, values);
        long foreing_key_id_alugador_objeto = db.insert(DatabaseHelper.TABELA_OBJETO, null, values);

        values.put(DatabaseHelper.USUARIO_EMPRESTADOR_ID, foreing_key_id_dono_objeto);
        values.put(DatabaseHelper.USO_OBJETO_ID, foreing_key_id_objeto);
        values.put(DatabaseHelper.USUARIO_ALUGADOR_ID, foreing_key_id_alugador_objeto);

        db.insert(DatabaseHelper.TABELA_EMPRESTIMO, null, values);
        db.close();
    }
}