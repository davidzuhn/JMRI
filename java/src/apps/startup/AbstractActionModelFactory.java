package apps.startup;

import apps.AbstractActionModel;
import apps.StartupModel;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * Provide an abstract StartupModelFactory with common methods for factories
 * that manipulate models that extend {@link apps.AbstractActionModel}.
 *
 * @author Randall Wood
 */
abstract public class AbstractActionModelFactory implements StartupModelFactory {

    @Override
    public String getDescription() {
        return Bundle.getMessage(this.getModelClass().getCanonicalName());
    }

    @Override
    public String getActionText() {
        return Bundle.getMessage("EditableStartupAction", this.getDescription());
    }

    @Override
    public void editModel(StartupModel model, Component parent) {
        if (this.getModelClass().isInstance(model)) {
            String name = (String) JOptionPane.showInputDialog(parent,
                    "Adding " + this.getDescription(),
                    "Add " + this.getDescription(),
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    AbstractActionModel.nameList(),
                    model.getName());
            if (name != null && !name.equals(model.getName())) {
                model.setName(name);
            }
        }
    }
}