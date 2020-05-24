package lt.vu.decorators;

import lt.vu.persistence.GroupsDAO;
import lt.vu.services.ProgramName;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class ProgramNameDecorator implements ProgramName {
    @Inject
    @Delegate
    @Any
    ProgramName programName;

    public String getProgramName() {
        return programName.getProgramName() + ", version 2.0";
    }
}