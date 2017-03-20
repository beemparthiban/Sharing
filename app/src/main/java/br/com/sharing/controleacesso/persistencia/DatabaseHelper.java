package br.com.sharing.controleacesso.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String NOME_DB = "banco";
    private static final int VERSAO_DB = 2;

    /* singleton */
    public DatabaseHelper (Context context) {
        super(context.getApplicationContext(),NOME_DB,null,VERSAO_DB);
    }

    //TABELA PESSOA
    public static final String TABELA_PESSOA= "tabela_pessoa";
    public static final String PESSOA_ID = "_id_pessoa";
    public static final String PESSOA_NOME = "nome_pessoa";
    public static final String PESSOA_EMAIL = "email_pessoa";
    public static final String PESSOA_ENDERECO = "endereco_pessoa";
    public static final String PESSOA_CPF = "cpf_pessoa";
    public static final String PESSOA_FOTO = "foto_pessoa";
    public static final String PESSOA_PONTUACAO = "pontuacao_pessoa";

    //TABELA USUARIO
    public static final String TABELA_USUARIO = "tabela_usuario";
    public static final String USUARIO_ID = "_id_usuario";
    public static final String USUARIO_LOGIN = "login_usuario";
    public static final String USUARIO_SENHA = "senha_usuario";
    public static final String USUARIO_PESSOA_ID = "id_pessoa_usuario";

    //TABELA OBJETO
    public static final String TABELA_OBJETO = "tabela_objeto";
    public static final String OBJETO_ID = "_id_objeto";
    public static final String OBJETO_NOME = "nome_objeto";
    public static final String OBJETO_CATEGORIA = "categoria_objeto";
    public static final String OBJETO_ESTADO = "estado_objeto";
    public static final String OBJETO_DESCRICAO = "descricao_objeto";
    public static final String OBJETO_FOTO = "foto_objeto";
    public static final String OBJETO_DONO_ID = "id_dono_objeto";
    public static final String OBJETO_ALUGADOR_ID = "id_alugador_objeto";

    //TABELA EMPRESTIMO
    public static final String TABELA_EMPRESTIMO = "tabela_emprestimo";
    public static final String EMPRESTIMO_ID = "_id_emprestimo";
    public static final String EMPRESTIMO_DONO_OBJETO_ID = "id_dono_objeto";
    public static final String EMPRESTIMO_OBJETO_ID = "id_objeto";
    public static final String EMPRESTIMO_ID_USUARIO = "id_pessoa_usuario";


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ScriptTableSQL.getTabelaPessoa());
        db.execSQL(ScriptTableSQL.getTabelaUsuario());
        db.execSQL(ScriptTableSQL.getTabelaObjeto());
        db.execSQL(ScriptTableSQL.getTabelaEmprestimo());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABELA_USUARIO);
        db.execSQL("drop table if exists " + TABELA_PESSOA);
        db.execSQL("drop table if exists " + TABELA_OBJETO);
        db.execSQL("drop table if exists " + TABELA_EMPRESTIMO);
        onCreate(db);
    }

}