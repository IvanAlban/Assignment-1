
import model.*;
import view.*;
import controller.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        RentalCompany model = new RentalCompany();
        CarRentalView view = new CarRentalView();
        CarRentalController controller = new CarRentalController(model, view);

        RentalCompany rentalCompany = new RentalCompany();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                view.setVisible(true);
            }
        });
    }
}
