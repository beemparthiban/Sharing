package br.com.sharing.controleacesso.gui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import java.util.ArrayList;

import br.com.sharing.R;
import br.com.sharing.controleacesso.dominio.Objeto;
import br.com.sharing.controleacesso.dominio.Pessoa;
import br.com.sharing.controleacesso.negocio.ObjetoNegocio;
import br.com.sharing.controleacesso.negocio.SessaoUsuario;

public class CalendarActivity extends AppCompatActivity{
    private CalendarView calendar;
    private View view;

    private ArrayList<Objeto> listaEventos;
    private ObjetoNegocio eventoNegocio;
    private SessaoUsuario sessao;
    private Pessoa pessoaLogada;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
    }


}
