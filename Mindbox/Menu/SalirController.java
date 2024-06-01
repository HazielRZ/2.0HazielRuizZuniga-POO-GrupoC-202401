package Menu;

public class SalirController implements Controller {
    @Override
    public void execute() {
        System.exit(0);
    }
}