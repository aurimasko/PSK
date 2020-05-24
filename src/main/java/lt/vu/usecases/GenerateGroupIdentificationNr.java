package lt.vu.usecases;

import lt.vu.interceptors.LoggedInvocation;
import lt.vu.services.GroupNumberGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SessionScoped
@Named
public class GenerateGroupIdentificationNr implements Serializable {
    @Inject
    GroupNumberGenerator groupNumberGenerator;

    private Future<Integer> groupNumberGeneratorTask = null;

    @LoggedInvocation
    public String generateGroupNumber() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        groupNumberGeneratorTask = CompletableFuture.supplyAsync(() -> groupNumberGenerator.generateGroupNumber());
        return "/groupInfo.xhtml?faces-redirect=true&groupId=" + requestParameters.get("groupId");
    }

    public boolean isGenerationInProgress() {
        return groupNumberGeneratorTask != null && !groupNumberGeneratorTask.isDone();
    }

    public String getGeneratorStatus() throws ExecutionException, InterruptedException {
        if (groupNumberGeneratorTask == null) {
            return null;
        } else if (isGenerationInProgress()) {
            return "Generation in progress";
        }
        return "Suggested number: " + groupNumberGeneratorTask.get();
    }
}