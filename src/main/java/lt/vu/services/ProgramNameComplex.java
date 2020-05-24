package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
public class ProgramNameComplex implements  ProgramName {
    public String getProgramName() {
        return "Complex program name";
    }
}
