package Cruds;

import Modelo.Grupo;

import java.util.List;

public class GrupoCrud {
    public static List<Grupo> grupos;

    public GrupoCrud(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public Grupo obtenerGrupoPorId(int idGrupo) {
        for (Grupo grupo : grupos) {
            if (grupo.getIdGrupo() == idGrupo) {
                return grupo;
            }
        }
        return null; // Si no se encuentra el grupo
    }
}
