package Menu;

import java.util.ArrayList;

public class SalirController implements Controller {
    @Override
    public void execute(ArrayList<Permission> permissions) {
        System.exit(0);
    }
}