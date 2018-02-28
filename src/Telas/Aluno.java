/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author RG 295
 */
@Entity
@Table(name = "aluno", catalog = "coalabd", schema = "")
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a")
    , @NamedQuery(name = "Aluno.findByIdaluno", query = "SELECT a FROM Aluno a WHERE a.alunoPK.idaluno = :idaluno")
    , @NamedQuery(name = "Aluno.findByNome", query = "SELECT a FROM Aluno a WHERE a.nome = :nome")
    , @NamedQuery(name = "Aluno.findByTurmaNome", query = "SELECT a FROM Aluno a WHERE a.alunoPK.turmaNome = :turmaNome")
    , @NamedQuery(name = "Aluno.findByTurmaEscolaNome", query = "SELECT a FROM Aluno a WHERE a.alunoPK.turmaEscolaNome = :turmaEscolaNome")})
public class Aluno implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlunoPK alunoPK;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;

    public Aluno() {
    }

    public Aluno(AlunoPK alunoPK) {
        this.alunoPK = alunoPK;
    }

    public Aluno(AlunoPK alunoPK, String nome) {
        this.alunoPK = alunoPK;
        this.nome = nome;
    }

    public Aluno(int idaluno, String turmaNome, String turmaEscolaNome) {
        this.alunoPK = new AlunoPK(idaluno, turmaNome, turmaEscolaNome);
    }

    public AlunoPK getAlunoPK() {
        return alunoPK;
    }

    public void setAlunoPK(AlunoPK alunoPK) {
        this.alunoPK = alunoPK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alunoPK != null ? alunoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.alunoPK == null && other.alunoPK != null) || (this.alunoPK != null && !this.alunoPK.equals(other.alunoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Telas.Aluno[ alunoPK=" + alunoPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
