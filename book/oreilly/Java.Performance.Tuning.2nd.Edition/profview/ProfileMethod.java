
package tuning.profview;

/**
 * This class was generated by a SmartGuide.
 * 
 */
public class ProfileMethod
{
	String method;
	String classname;
	String methodname;
	ProfileMethodClass[] args;
	ProfileMethodClass returnclass;

/**
 * This method was created by a SmartGuide.
 * @param method java.lang.String
 */
public ProfileMethod(String method)
{
	this.method= method;
	int idx = method.indexOf('.');
	if (idx == -1)
	{
	    classname = "unknown";
	    methodname = "unkown";
	    args = ProfileMethodClass.getClasses("");
	    returnclass = (ProfileMethodClass.getClasses("V"))[0];
	    return;
	}
	classname = method.substring(0,idx).replace('/','.');
	methodname = method.substring(idx+1, (idx = method.indexOf('(')));
	args = ProfileMethodClass.getClasses(method.substring(idx+1, (idx = method.indexOf(')'))));
	returnclass = (ProfileMethodClass.getClasses(method.substring(idx+1)))[0];
//	classDotMethodname = classname + "." + methodname;
}
/**
 * This method was created by a SmartGuide.
 * @param s java.lang.StringBuffer
 */
public void appendTo(StringBuffer s)
{
	returnclass.appendTo(s);
	s.append(' ').append(classname).append('.').append(methodname).append('(');
	if (args.length > 0)
		args[0].appendTo(s);
	for(int i = 1; i < args.length; i++)
	{
		s.append(", ");
		args[i].appendTo(s);
	}
	s.append(')');
}
}