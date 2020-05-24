package lt.vu.services;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.Future;

@ApplicationScoped

public class GroupNumberGenerator implements Serializable {

    public Integer generateGroupNumber() {
        try {
            Thread.sleep(3000); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        Integer generatedGroupNumber = new Random().nextInt(100);
        return generatedGroupNumber;

    }
}
