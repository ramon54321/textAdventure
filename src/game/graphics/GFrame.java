package game.graphics;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ramon on 1/18/16.
 */
public class GFrame extends JFrame {

    public Container container;
    public JTextField mainTextField = new JTextField(10);

    public GFrame() {
        container = getContentPane();
        container.add(mainTextField, BorderLayout.SOUTH);
    }
}
