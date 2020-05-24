package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelpText {
    public String getHelpText()
    {
        return "Help text";
    }
}
