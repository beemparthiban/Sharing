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
            ((TextView) view.findViewById(R.id.txtitem_estado_objeto)).setText(objeto.getEstadoEnum().toString());
            //((ImageView) view.findViewById(R.id.img_objeto)).setImageResource(R.drawable.object_default);
            if (objeto.getFoto() != null){
                ((ImageView) view.findViewById(R.id.img_objeto)).setImageURI(objeto.getFoto());
            }else{
                ((ImageView) view.findViewById(R.id.img_objeto)).setImageURI(AddObjetoActivity.FOTO_PADRAO);
            }





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


}
