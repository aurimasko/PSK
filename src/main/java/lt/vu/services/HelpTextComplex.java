package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;

@Specializes
@ApplicationScoped
public class HelpTextComplex extends HelpText {
    public String getHelpText() { return "Contact help@help.com for more information"; }
}
