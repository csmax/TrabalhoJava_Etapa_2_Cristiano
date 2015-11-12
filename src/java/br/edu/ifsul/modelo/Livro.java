
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
public class Livro implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_artigo", sequenceName = "seq_artigo_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_artigo",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotEmpty(message = "O titulo deve ser informado")
    @Length(max = 50, message = "O titulo não pode ter mais {max} letras")
    @Column(name = "titulo", nullable = false,length = 50)
    private String titulo;
    
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valor", nullable = false, columnDefinition = "decimal(12,2)")
    private Double valor;
    
    @NotNull(message = "O quantidade deve ser informado")
    @Column(name = "quantidade", nullable = false, columnDefinition = "decimal")
    private int quantidade;
    
    @Column(name = "disopnibilidade", nullable = false)
    private Boolean disopnibilidade;
    
    @NotEmpty(message = "O autor deve ser informado")
    @Length(max = 50, message = "O autor não pode ter mais {max} letras")
    @Column(name = "autor", nullable = false,length = 50)
    private String autor; 

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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Boolean getDisopnibilidade() {
        return disopnibilidade;
    }

    public void setDisopnibilidade(Boolean disopnibilidade) {
        this.disopnibilidade = disopnibilidade;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Livro() {
    }

    @Override
    public String toString() {
        return "Livro{" + "id=" + id + ", titulo=" + titulo + ", valor=" + valor + ", quantidade=" + quantidade + ", disopnibilidade=" + disopnibilidade + ", autor=" + autor + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Livro other = (Livro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    

}