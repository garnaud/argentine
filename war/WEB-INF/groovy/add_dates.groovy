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

Entity day=new Entity("Day")
day['id']=1
day['date']=new Date().parse("d/M/yyyy","26/12/2009")
day.save()

Entity nurse=new Entity("Nurse")
nurse['day']=1
nurse['person']='Catherine & Philippe'
nurse['hourStart']=new Date().parse("d/M/yyyy","26/12/2009 17:00")
nurse['hourEnd']=new Date().parse("d/M/yyyy","26/12/2009 23:59")
nurse.save()

redirect '/'
