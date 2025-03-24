package repositories;

import models.AreaVerde;
import java.util.ArrayList;
import java.util.List;

public class AreaVerdeRepository {
    private static List<AreaVerde> AREAS_VERDES = new ArrayList<>();
    private static int nextId = 1;

    public static AreaVerde adicionar(AreaVerde areaVerde) {
        areaVerde.setId(nextId++);
        AREAS_VERDES.add(areaVerde);
        return areaVerde;
    }

    public static List<AreaVerde> listarTodos() {
        return new ArrayList<>(AREAS_VERDES);
    }

    public static AreaVerde buscarPorId(int id) {
        for (AreaVerde areaVerde : AREAS_VERDES) {
            if (areaVerde.getId() == id) {
                return areaVerde;
            }
        }
        return null;
    }

    public static boolean atualizar(AreaVerde areaVerde) {
        for (int i = 0; i < AREAS_VERDES.size(); i++) {
            if (AREAS_VERDES.get(i).getId() == areaVerde.getId()) {
                AREAS_VERDES.set(i, areaVerde);
                return true;
            }
        }
        return false;
    }

    public static boolean remover(int id) {
        return AREAS_VERDES.removeIf(areaVerde -> areaVerde.getId() == id);
    }
}