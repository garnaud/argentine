import com.google.appengine.api.datastore.Entity

Entity transfer=new Entity("Transfer")

transfer['person1']=request.getParameter('person1')
transfer['person2']=request.getParameter('person2')
transfer['comment']=request.getParameter('comment')
def date=new Date().parse("d/M/yyyy H:m",request.getParameter('day')+" "+request.getParameter('hour')+":"+request.getParameter('minute'))
transfer['date']=date
transfer['where']=request.getParameter('where')
transfer.save()

redirect '/'