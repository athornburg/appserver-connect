/**
 * User: alexthornburg
 * Date: 3/6/14
 * Time: 11:31 PM
 */

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.javaproxy.Connection;
import com.thorntech.Round;
import com.thorntech.RoundTrip;

import java.io.IOException;

public class Main {


    public static void main(String[] args)
    {

        Connection connection = new Connection("AppServerDC://192.168.1.18:2950","","");
        try {
            Round round = new Round(connection);
            RoundTrip roundTrip = round.createPO_RoundTrip();
            System.out.println(roundTrip.getProPath());
            System.out.println(roundTrip.getWorkingDirectory());
            if (roundTrip != null)
                try
                {
                    roundTrip._release();
                    round._release();
                }
                catch (Exception e)
                {

                    System.out.println(e);
                    e.printStackTrace();
                }
            System.exit(0);
        } catch (Open4GLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }

}
