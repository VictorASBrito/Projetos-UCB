import java.util.ArrayList;
import java.util.List;

public class SneakerDAO {
    private List<Sneaker> sneakers;

    public SneakerDAO() {
        sneakers = new ArrayList<>();
    }

    public void adicionarSneaker(Sneaker sneaker) {
        sneakers.add(sneaker);
    }

    public List<Sneaker> getSneakers() {
        return sneakers;
    }
}
