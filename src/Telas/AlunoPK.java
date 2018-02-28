/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author RG 295
 */
@Embeddable
public class AlunoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idaluno")
    private int idaluno;
    @Basic(optional = false)
    @Column(name = "turma_nome")
    private String turmaNome;
    @Basic(optional = false)
    @Column(name = "turma_escola_nome")
    private String turmaEscolaNome;

    public AlunoPK() {
    }

    public AlunoPK(int idaluno, String turmaNome, String turmaEscolaNome) {
        this.idaluno = idaluno;
        this.turmaNome = turmaNome;
        this.turmaEscolaNome = turmaEscolaNome;
    }

    public int getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(int idaluno) {
        this.idaluno = idaluno;
    }

    public String getTurmaNome() {
        return turmaNome;
    }

    public void setTurmaNome(String turmaNome) {
        this.turmaNome = turmaNome;
    }

    public String getTurmaEscolaNome() {
        return turmaEscolaNome;
    }

    public void setTurmaEscolaNome(String turmaEscolaNome) {
        this.turmaEscolaNome = turmaEscolaNome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idaluno;
        hash += (turmaNome != null ? turmaNome.hashCode() : 0);
        hash += (turmaEscolaNome != null ? turmaEscolaNome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoPK)) {
            return false;
        }
        AlunoPK other = (AlunoPK) object;
        if (this.idaluno != other.idaluno) {
            return false;
        }
        if ((this.turmaNome == null && other.turmaNome != null) || (this.turmaNome != null && !this.turmaNome.equals(other.turmaNome))) {
            return false;
        }
        if ((this.turmaEscolaNome == null && other.turmaEscolaNome != null) || (this.turmaEscolaNome != null && !this.turmaEscolaNome.equals(other.turmaEscolaNome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Telas.AlunoPK[ idaluno=" + idaluno + ", turmaNome=" + turmaNome + ", turmaEscolaNome=" + turmaEscolaNome + " ]";
    }
    
}
