package br.edu.unifebe.cinema.model;

/**
 * Produto principal do Sistema Cinema.
 *
 * Para a Parte 1, os campos mais importantes são id e titulo, pois a busca
 * exigida no enunciado deve funcionar por código (ID) ou nome.
 */
public class Filme {

    private Long id;
    private String titulo;
    private String genero;
    private String classificacaoEtaria;
    private Double nota;
    private String sinopse;
    private boolean emCartaz;

    public Filme() {
    }

    public Filme(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClassificacaoEtaria() {
        return classificacaoEtaria;
    }

    public void setClassificacaoEtaria(String classificacaoEtaria) {
        this.classificacaoEtaria = classificacaoEtaria;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public boolean isEmCartaz() {
        return emCartaz;
    }

    public void setEmCartaz(boolean emCartaz) {
        this.emCartaz = emCartaz;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", classificacaoEtaria='" + classificacaoEtaria + '\'' +
                '}';
    }
}
