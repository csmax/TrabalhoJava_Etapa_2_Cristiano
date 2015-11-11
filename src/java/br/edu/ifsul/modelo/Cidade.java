
package br.edu.ifsul.modelo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "cidade")
public class Cidade implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_cidade", sequenceName = "seq_cidade_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_cidade",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotEmpty(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não pode ter mais {max} letras")
    @Column(name = "nome", nullable = false,length = 50)
    private String nome;
    
    @NotEmpty(message = "A UF deve ser informado")
    @Length(max = 2, message = "A UF não pode ter mais {max} letras")
    @Column(name = "uf", nullable = false,length = 2)
    private String uf;

    public Cidade() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Cidade{" + "id=" + id + ", nome=" + nome + ", uf=" + uf + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
