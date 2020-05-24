package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;

@ApplicationScoped
@Default
public class ProgramNameSimple implements ProgramName  {
    public String getProgramName() {
        return "Simple program name";
    }
}
