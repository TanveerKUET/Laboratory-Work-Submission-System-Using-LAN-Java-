/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.ui.ChatFrame;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;

/**
 *
 * @author Tanveer
 */
public class ProgressBarClass extends SwingWorker< Integer, Integer >{
   
    private final Random generator = new Random();
     private final boolean[] values; // boolean array for finding primes

 // constructor
 public ProgressBarClass( int max)
 {
 
 values = new boolean[ max ];

 // initialize all prime array values to true
 Arrays.fill( values, true );
 }
    @Override
    protected Integer doInBackground() throws Exception {

	 int count = 0; // the number of primes found
	 
	 // starting at the third value, cycle through the array and put
	 // false as the value of any greater number that is a multiple
	  for ( int i = 2; i < values.length; i++ )
	  {
	 if ( isCancelled() ) // if calculation has been canceled
	  return count;
	  else
	 {
		  setProgress( 100 * ( i + 1 ) / values.length );
		  try
		  {
		  Thread.sleep( generator.nextInt( 5 ) );
		  } // end try
		  catch ( InterruptedException ex )
		  {
		  
		 return count;
		  } // end catch
		  
		 if ( values[ i ] ) // i is prime
		  {
			 publish( i ); // make i available for display in prime list
			 ++count;
			
			  for ( int j = i + i; j < values.length; j += i )
			 values[ j ] = false; // i is not prime
			  } // end if
			 } // end else
			} // end for
			
			 return count;
    }
    @Override
     protected void done()
{
 int num;


            try {
            try {
                num = get(); // retrieve doInBackground return value
            } catch (InterruptedException ex) {
                Logger.getLogger(ProgressBarClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            } catch (ExecutionException ex) {
                Logger.getLogger(ProgressBarClass.class.getName()).log(Level.SEVERE, null, ex);
            }


ChatFrame chat = new ChatFrame();
chat.setVisible(true);


}
}
