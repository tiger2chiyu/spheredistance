import com.intercom.hometest.model.CustomerRecord;
import com.intercom.hometest.model.Location;
import com.intercom.hometest.provider.CustomerRecordProvider;
import com.intercom.hometest.util.SphereDistanceUtil;

import java.util.List;

/**
 * THE TEST
 * Customer Records
 * We have some customer records in a text file (customers.txt) -- one customer per line, JSON lines formatted. We want to invite any customer within 100km of our Dublin office for some food and drinks on us.
 * Write a program that will read the full list of customers and output the names and user ids of matching customers (within 100km), sorted by User ID (ascending).
 *
 * You can use the first formula from this Wikipedia article to calculate distance. Don't forget, you'll need to convert degrees to radians.
 * The GPS coordinates for our Dublin office are 53.339428, -6.257664.
 * You can find the Customer list here.
 * We're looking for you to produce working code, with enough room to demonstrate how to structure components in a small program.
 *
 *
 * - Poor answers will be in the form of one big function. It’s impossible to test anything smaller than the entire operation of the program, including reading from the input file. Errors are caught and ignored.
 *
 * - Good answers are well composed. Calculating distances and reading from a file are separate concerns. Classes or functions have clearly defined responsibilities. Test cases cover likely problems with input data.
 *
 * - It’s an excellent answer if we've learned something from reading the code.
 *
 * We recommend you use whatever language you feel strongest in. It doesn't have to be one we use!

*/

public class IntercomHomeTest {
    public static void main(String[] args) {
        List<CustomerRecord> records = CustomerRecordProvider.loadData("https://s3.amazonaws.com/intercom-take-home-test/customers.txt");

        Location intercomDublinOffice = new Location(53.339428, -6.257664);
        records.stream().filter(rec -> SphereDistanceUtil.isWithinRange(100, rec.getLocation(), intercomDublinOffice))
               .map();
    }
}
