import com.google.appengine.api.datastore.*
import static com.google.appengine.api.datastore.FetchOptions.Builder.*

def diner=request.getParameter('diner')
def id=request.getParameter('id')

def query = new Query("Diner")
 
query.addFilter("type", Query.FilterOperator.EQUAL, id)
PreparedQuery preparedQuery = datastore.prepare(query)
result= preparedQuery.asList( withLimit(1) )

def Entity com

if(result==null || result.size()==0){
  com=new Entity("Diner")
  com['type']=id
} else {
  com=result[0]
}

com['text']=diner
com.save()

redirect '/'
