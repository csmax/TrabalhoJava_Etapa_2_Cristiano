
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "artigo")
public class Artigo implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_artigo", sequenceName = "seq_artigo_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_artigo",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotEmpty(message = "O titulo deve ser informado")
    @Length(max = 50, message = "O titulo não pode ter mais {max} letras")
    @Column(name = "titulo", nullable = false,length = 50)
    private String titulo;
    
    @NotEmpty(message = "O Assunto deve ser informado")
    @Length(max = 50, message = "O assunto não pode ter mais {max} letras")
    @Column(name = "assunto", nullable = false,length = 50)
    private String assunto;
    
    @NotNull(message = "O Ano da publicação deve ser informado")
    @Temporal(TemporalType.DATE)
    @Column(name = "anoPublicacao",nullable = false)    
    private Calendar anoPublicacao;
    
    @Length(max = 2, message = "O qualis não pode ter mais {max} letras")
    @Column(name = "qualis", nullable = false,length = 50)
    private String qualis;
    
    @NotEmpty(message = "O autor deve ser informado")
    @Length(max = 50, message = "O autor não pode ter mais {max} letras")
    @Column(name = "autor", nullable = false,length = 50)
    private String autor;

    public Artigo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Calendar getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Calendar anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getQualis() {
        return qualis;
    }

    public void setQualis(String qualis) {
        this.qualis = qualis;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Artigo other = (Artigo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Artigo{" + "id=" + id + ", titulo=" + titulo + ", assunto=" + assunto + ", anoPublicacao=" + anoPublicacao + ", qualis=" + qualis + ", autor=" + autor + '}';
    }

  

}