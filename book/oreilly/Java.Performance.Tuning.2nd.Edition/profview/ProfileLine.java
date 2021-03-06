
package tuning.profview;

/**
 * This class was generated by a SmartGuide.
 * 
 */
public class ProfileLine
{
	String line;
	int time;
	int count;
	ProfileMethod callee;
	ProfileMethod caller;
	

/**
 * This method was created by a SmartGuide.
 * @param line java.lang.String
 */
public ProfileLine(String line)
{
	this.line = line;
	int idx = line.indexOf((int) ' ');
	count = Integer.parseInt(line.substring(0,idx));
	callee = new ProfileMethod(line.substring(idx + 1,(idx = line.indexOf((int) ' ',idx+1))));
	caller = new ProfileMethod(line.substring(idx + 1,(idx = line.lastIndexOf((int) ' '))));
	time = Integer.parseInt(line.substring(idx+1));
}
/**
 * This method was created by a SmartGuide.
 * @param s java.lang.StringBuffer
 */
public void appendTo(StringBuffer s, boolean timeFirst)
{
	
	s.append(timeFirst ? time : count).append("\t").append(timeFirst ? count : time).append("\t");
	callee.appendTo(s);
	s.append(' ');
	caller.appendTo(s);
}
}