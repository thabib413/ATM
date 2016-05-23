package BANKACCOUNT;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by taiseerhabib on 5/19/16.
 */
public class Investment extends Account {

    public Investment(int acctId, String name, float amount) {
        super(name);
    }

    public Investment(String name) {
        super(name);
    }
}
