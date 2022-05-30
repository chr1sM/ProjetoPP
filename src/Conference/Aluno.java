/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conference;

/**
 *
 * @author Christopher
 */
public class Aluno extends Participants{
    
    private String curso, anoLetivo;

    public Aluno(String curso, String anoLetivo, String nameParticipants, String bio) {
        super(nameParticipants, bio);
        this.curso = curso;
        this.anoLetivo = anoLetivo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(String anoLetivo) {
        this.anoLetivo = anoLetivo;
    }
    
    
}
