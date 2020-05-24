package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.services.HelpText;
import lt.vu.services.ProgramName;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;

@Model
public class GeneralInfo implements Serializable {

    @Inject
    private ProgramName programNameService;

    @Inject
    private HelpText helpTextService;

    @Getter
    private String ProgramName;

    @Getter
    private String HelpText;

    @PostConstruct
    public void init() {
        ProgramName = programNameService.getProgramName();
        HelpText = helpTextService.getHelpText();
    }
}