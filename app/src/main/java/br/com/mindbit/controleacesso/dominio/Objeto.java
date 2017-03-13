package br.com.mindbit.controleacesso.dominio;

import android.net.Uri;

import java.util.Date;

public class Objeto {
    private int id;
    private int idDono;
    private int idAlugador;
    private String nome;
    private String descricao;
    //private Date dataInicio;
    //private Date dataFim;
    //private Enum<PrioridadeEvento> nivelPrioridadeEnum;
    private Enum<Categoria> categoriaEnum;
    private Enum<Estado> estadoEnum;
    private Uri foto;

    public Objeto(){
        //this.dataInicio=null;
        //this.dataFim=null;
        //this.nivelPrioridadeEnum=null;
        //this.idAlugador = 0;
        this.nome = null;
        this.categoriaEnum = null;
        this.estadoEnum = Estado.DISPONIVEL;
        this.categoriaEnum = null;
        this.descricao = null;
        this.foto = null;

    }

    public int getId() {return  id;}
    public void setId(int id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    /*public Date getDataInicio() {return dataInicio;}
    public void setDataInicio(Date dataInicio) {this.dataInicio = dataInicio;}

    public Date getDataFim() {return dataFim;}
    public void setDataFim(Date dataFim) {this.dataFim = dataFim;}

    public Enum<PrioridadeEvento> getNivelPrioridadeEnum() {return nivelPrioridadeEnum;}
    public void setNivelPrioridadeEnum(Enum<PrioridadeEvento> nivelPrioridadeEnum) {this.nivelPrioridadeEnum = nivelPrioridadeEnum;}
    */

    public int getIdDono(){return idDono;}
    public void setIdDono(int idDono){this.idDono = idDono;}

    public int getIdAlugador() {return idAlugador;}
    public void setIdAlugador(int idAlugador) {this.idAlugador = idAlugador;}

    public Enum<Categoria> getCategoriaEnum() {return categoriaEnum;}
    public void setCategoriaEnum(Enum<Categoria> categoriaEnum) {this.categoriaEnum = categoriaEnum;}

    public Enum<Estado> getEstadoEnum() {return estadoEnum;}
    public void setEstadoEnum(Enum<Estado> estadoEnum) {this.estadoEnum = estadoEnum;}

    public Uri getFoto() {return foto;}
    public void setFoto(Uri foto) {
        this.foto = foto;
    }

    }
