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
import br.com.mindbit.controleacesso.persistencia.ObjetoDao;
import br.com.mindbit.infra.gui.GuiUtil;

public class ObjetoAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private List<Objeto> objetos;
        private Objeto objeto;

        public ObjetoAdapter(Context context, List<Objeto> objetos){
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
            ((TextView) view.findViewById(R.id.txtitem_categoria_objeto)).setText(objeto.getCategoriaEnum().toString());
            if (objeto.getEstadoEnum().toString() == "0"){
                ((TextView) view.findViewById(R.id.txtitem_estado_objeto)).setText("Disponível");
            }
            else{
                ((TextView) view.findViewById(R.id.txtitem_estado_objeto)).setText("Alugado");
            }

            if (objeto.getFoto() != null){
                ((ImageView) view.findViewById(R.id.img_objeto)).setImageURI(objeto.getFoto());
            }else{
                ((ImageView) view.findViewById(R.id.img_objeto)).setImageURI(AddObjetoActivity.FOTO_PADRAO);
            }

            return view;
        }

    public static Date addOneMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        return cal.getTime();
    }


}
