/*package br.com.mindbit.controleacesso.gui;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.com.mindbit.R;
import br.com.mindbit.controleacesso.dominio.Objeto;
import br.com.mindbit.controleacesso.dominio.Pessoa;
import br.com.mindbit.controleacesso.negocio.ObjetoNegocio;
import br.com.mindbit.controleacesso.negocio.SessaoUsuario;
import br.com.mindbit.infra.gui.MindbitException;


public class ContadorFragment extends Fragment {
    private TextView txtTimerDay;
    private TextView txtDias;
    private TextView txtNomeEvento;

    private Handler handler;
    private Runnable runnable;
    private View view;

    private ArrayList<Objeto> eventosProximo;
    private ObjetoNegocio objetoNegocio;
    private SessaoUsuario sessao;
    private Pessoa pessoaLogada;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        sessao = SessaoUsuario.getInstancia();
        pessoaLogada = sessao.getPessoaLogada();

        objetoNegocio = ObjetoNegocio.getInstancia(getActivity().getApplicationContext());
        view =inflater.inflate(R.layout.contador_fragment_layout, container, false);

        txtTimerDay = (TextView)view.findViewById(R.id.txtTimerDay);
        txtNomeEvento = (TextView)view.findViewById(R.id.txtNome_evento);
        txtDias = (TextView)view.findViewById(R.id.txtDias);

        countDownStart();
        return view;
    }

    public Objeto getProximoEvento() throws MindbitException{
        eventosProximo = objetoNegocio.listarEventosProximo(pessoaLogada.getId());
        if (eventosProximo.isEmpty()){
            return null;

        }else {
            Date hoje = new Date();
            for (Objeto objeto :eventosProximo) {
                if ((objeto.getDataInicio().getDate()-hoje.getDate())>=0){
                    return objeto;
                }
            }
            return null;
        }

    }


    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                Objeto proximoObjeto = null;
                try {
                    proximoObjeto = getProximoEvento();
                } catch (MindbitException e) {
                    Log.e("Contador Fragment","contador error");
                }

                Date futureDate = null;
                if (proximoObjeto !=null) {
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String diaEvento = dateFormat.format(proximoObjeto.getDataInicio());
                        futureDate = (dateFormat.parse(diaEvento));
                        Date currentDate = new Date();
                        if (currentDate.after(futureDate)) {
                            long diff = futureDate.getTime() - currentDate.getTime();
                            long days = futureDate.getDate() - currentDate.getDate();
                            long hours = futureDate.getHours() - currentDate.getHours();
                            long minutes = futureDate.getMinutes() - currentDate.getMinutes();
                            long seconds = futureDate.getSeconds() - futureDate.getSeconds();

                            String timer = "" + days;
                            if (days!=0){
                                txtTimerDay.setText("" + (days));
                                txtDias.setText(R.string.contador_dias);
                                txtNomeEvento.setText(getProximoEvento().getNome());
                            }else {
                                txtTimerDay.setText(R.string.contador_hoje);
                                txtDias.setText("");
                                txtNomeEvento.setText(getProximoEvento().getNome());

                            }
                        }
                    } catch (Exception e) {
                        Log.e("Contador Fragment", "contador error ", e);
                    }


                } else {
                    txtTimerDay.setText(R.string.contador_vazio);
                    txtDias.setText("");
                    txtNomeEvento.setText("");
                }
            }
        };
        handler.postDelayed(runnable, 1 * 1000);
    }
}
*/