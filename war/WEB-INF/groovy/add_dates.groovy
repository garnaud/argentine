import com.google.appengine.api.datastore.*
import static com.google.appengine.api.datastore.FetchOptions.Builder.*

def allQuery=new Query("Day")
PreparedQuery pdays=datastore.prepare(allQuery)
def days=pdays.asList(withLimit(10))
days.each{
  it.delete()
}

allQuery=new Query("Nurse")
PreparedQuery pnurses=datastore.prepare(allQuery)
def nurses=pnurses.asList(withLimit(10))
nurses.each{
  it.delete()
}

def firstDay=new Date().parse("d/M/yyyy","26/12/2009")

for(int i=1;i<17;i++){
	Entity day=new Entity("Day")
	day['id']=i
	day['date']=firstDay
	day.save()
	firstDay=firstDay+1
}

Entity nurse=new Entity("Nurse")
nurse['day']=1
nurse['person']='Catherine & Philippe'
nurse['hourStart']=new Date().parse("d/M/yyyy HH:mm","26/12/2009 17:00")
nurse['hourEnd']=new Date().parse("d/M/yyyy HH:mm","26/12/2009 23:59")
nurse.save()

nurse=new Entity("Nurse")
nurse['day']=2
nurse['person']='Catherine & Philippe'
nurse['hourStart']=new Date().parse("d/M/yyyy HH:mm","27/12/2009 00:00")
nurse['hourEnd']=new Date().parse("d/M/yyyy HH:mm","27/12/2009 23:59")
nurse.save()

nurse=new Entity("Nurse")
nurse['day']=3
nurse['person']='Catherine & Philippe'
nurse['hourStart']=new Date().parse("d/M/yyyy HH:mm","28/12/2009 00:00")
nurse['hourEnd']=new Date().parse("d/M/yyyy HH:mm","28/12/2009 23:59")
nurse.save()

nurse=new Entity("Nurse")
nurse['day']=4
nurse['person']='Catherine & Philippe'
nurse['hourStart']=new Date().parse("d/M/yyyy HH:mm","29/12/2009 00:00")
nurse['hourEnd']=new Date().parse("d/M/yyyy HH:mm","29/12/2009 12:00")
nurse.save()

nurse=new Entity("Nurse")
nurse['day']=4
nurse['person']='Edith & Jean-Luc'
nurse['hourStart']=new Date().parse("d/M/yyyy HH:mm","29/12/2009 12:00")
nurse['hourEnd']=new Date().parse("d/M/yyyy HH:mm","29/12/2009 23:59")
nurse.save()

redirect '/'
