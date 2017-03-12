package br.com.mindbit.controleacesso.gui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.mindbit.R;
import br.com.mindbit.controleacesso.dominio.Objeto;

public class EventoAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private List<Objeto> objetos;
        private Objeto objeto;

        public EventoAdapter(Context context, List<Objeto> objetos){
            this.objetos = objetos;

            mInflater = LayoutInflater.from(context);
        }

        public int getCount(){
            if (objetos != null) {
                return objetos.size();
            } else {
                return 0;
            }
        }

        public Objeto getItem(int posicao)
        {
            return objetos.get(posicao);
        }

        public long getItemId(int posicao)
        {
            return posicao;
        }

        public View getView(int posicao,View view, ViewGroup parent){

            objeto = objetos.get(posicao);

            view = mInflater.inflate(R.layout.list_item_pesquisar_evento, null);

            ((TextView) view.findViewById(R.id.txtitem_nome_evento)).setText(objeto.getNome());
            ((TextView) view.findViewById(R.id.txtitem_descricao_evento)).setText(objeto.getDescricao());

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            //String inicio = simpleDateFormat.format(addOneMonth(objeto.getDataInicio()));
            //((TextView) view.findViewById(R.id.txtitem_data_evento)).setText(inicio);

            //setIconePrioridade(view);

            return view;
        }

    public static Date addOneMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        return cal.getTime();
    }
/*
    public View setIconePrioridade(View view){
        int nivelPrioridade = objeto.getNivelPrioridadeEnum().ordinal();

        if (nivelPrioridade == 0 ) {
            ((ImageView) view.findViewById(R.id.img_evento)).setImageResource(R.drawable.bola_verde);
            return view;
        }else if (nivelPrioridade == 1) {
            ((ImageView) view.findViewById(R.id.img_evento)).setImageResource(R.drawable.bola_amarela);
            return view;
        }else if (nivelPrioridade == 2) {
            ((ImageView) view.findViewById(R.id.img_evento)).setImageResource(R.drawable.bola_vermelha);
            return view;
        }return view;
    }*/

}
