import java.util.ArrayList;
import java.util.List;

class FabricanteDAO {
    private List<Fabricante> fabricantes;

    public FabricanteDAO() {
        fabricantes = new ArrayList<>();
    }

    public void adicionarFabricante(Fabricante fabricante) {
        fabricantes.add(fabricante);
    }

    public List<Fabricante> getFabricantes() {
        return fabricantes;
    }
}