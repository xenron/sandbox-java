
package tuning.profview;

/**
 * This class was generated by a SmartGuide.
 * 
 */
public class ProfileCalleeAggregate
{
	int time;
	int diffTime;
	int count;
	ProfileMethod callee;
	java.util.Hashtable callers;
	ProfileCallerAggregate[] aggs;

/**
 * This method was created by a SmartGuide.
 * @param callee jack.profiler.ProfileMethod
 */
public ProfileCalleeAggregate(ProfileLine line)
{
	count = line.count;
	time = line.time;
	callee = line.callee;
	ProfileCallerAggregate caller;
	callers = new java.util.Hashtable();
	caller = new ProfileCallerAggregate(line);
	callers.put(line.caller.method, caller);
}
/**
 * This method was created by a SmartGuide.
 */
public void add(ProfileLine line)
{
	count += line.count;
	time += line.time;
	ProfileCallerAggregate caller;
	if ( (caller = (ProfileCallerAggregate) callers.get(line.caller.method)) == null)
	{
		caller = new ProfileCallerAggregate(line);
		callers.put(line.caller.method, caller);
	}
	else
		caller.add(line);
}
/**
 * This method was created by a SmartGuide.
 */
public void aggregationIsFinished()
{
    diffTime = time;
	aggs = new ProfileCallerAggregate[callers.size()];
	int idx = 0;
	java.util.Enumeration e = callers.elements();
	while (e.hasMoreElements())
	{
		aggs[idx] =  (ProfileCallerAggregate) e.nextElement();
		idx++;
	}
	callers = null;
}
public String toString()
{
    StringBuffer s = new StringBuffer();
    appendTo(s,false);
    return s.toString();
}
/**
 * This method was created by a SmartGuide.
 * @param s java.lang.StringBuffer
 */
public void appendTo(StringBuffer s, boolean timeFirst)
{
	String lf = System.getProperty("line.separator");
	s.append(timeFirst ? time : count).append("\t").append(timeFirst ? count : time).append("\t").append(diffTime).append("\t");
	callee.appendTo(s);
	s.append(lf).append("\tCalled by").append(lf).append("\t%\t");
	s.append(timeFirst ? "time\tcount" : "count\ttime").append("\tcaller");
	for (int i = aggs.length-1; i >= 0 ; i--)
	{
		s.append(lf).append("\t");
		if (timeFirst)
			ProfileStack.appendPercent(s,aggs[i].time,time);
		else
			ProfileStack.appendPercent(s,aggs[i].count,count);
		s.append('\t');
		aggs[i].appendTo(s,timeFirst);
	}
}
/**
 * This method was created by a SmartGuide.
 */
void sortAggOnCount(int lo, int hi)
{
	if( lo >= hi ) 
		return;

	int mid = ( lo + hi ) / 2;
	ProfileCallerAggregate tmp;
	ProfileCallerAggregate middle = aggs[ mid ];

	if( aggs[ lo ].count > middle.count)
	{
		aggs[ mid ] = aggs[ lo ];
		aggs[ lo ] = middle;
		middle = aggs[ mid ];
	}

	if( middle.count > aggs[hi].count)
	{
		aggs[ mid ] = aggs[ hi ];
		aggs[ hi ] = middle;
		middle = aggs[ mid ];

		if( aggs[ lo ].count > middle.count)
		{
			aggs[ mid ] = aggs[ lo ];
			aggs[ lo ] = middle;
			middle = aggs[ mid ];
		}
	}

	int left = lo + 1;
	int right = hi - 1;

	if( left >= right ) 
		return;

	for( ;; ) 
	{
		while( aggs[ right ].count >  middle.count)
		{
			right--;
		}

		while( left < right && aggs[ left ].count <= middle.count)
		{
			left++;
		}

		if( left < right )
		{
			tmp = aggs[ left ];
			aggs[ left ] = aggs[ right ];
			aggs[ right ] = tmp;
			right--;
		}
		else
		{
			break;
		}
	}

	sortAggOnCount(lo, left);
	sortAggOnCount(left + 1, hi);
}
/**
 * This method was created by a SmartGuide.
 */
void sortAggOnTime(int lo, int hi)
{
	if( lo >= hi ) 
		return;

	int mid = ( lo + hi ) / 2;
	ProfileCallerAggregate tmp;
	ProfileCallerAggregate middle = aggs[ mid ];

	if( aggs[ lo ].time > middle.time)
	{
		aggs[ mid ] = aggs[ lo ];
		aggs[ lo ] = middle;
		middle = aggs[ mid ];
	}

	if( middle.time > aggs[hi].time)
	{
		aggs[ mid ] = aggs[ hi ];
		aggs[ hi ] = middle;
		middle = aggs[ mid ];

		if( aggs[ lo ].time > middle.time)
		{
			aggs[ mid ] = aggs[ lo ];
			aggs[ lo ] = middle;
			middle = aggs[ mid ];
		}
	}

	int left = lo + 1;
	int right = hi - 1;

	if( left >= right ) 
		return;

	for( ;; ) 
	{
		while( aggs[ right ].time >  middle.time)
		{
			right--;
		}

		while( left < right && aggs[ left ].time <= middle.time)
		{
			left++;
		}

		if( left < right )
		{
			tmp = aggs[ left ];
			aggs[ left ] = aggs[ right ];
			aggs[ right ] = tmp;
			right--;
		}
		else
		{
			break;
		}
	}

	sortAggOnTime(lo, left);
	sortAggOnTime(left + 1, hi);
}
/**
 * This method was created by a SmartGuide.
 */
public void sortOnCount()
{
	sortAggOnCount(0,aggs.length - 1);
}
/**
 * This method was created by a SmartGuide.
 */
public void sortOnTime()
{
	sortAggOnTime(0,aggs.length - 1);
}
}