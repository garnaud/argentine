import com.google.appengine.api.datastore.*
import static com.google.appengine.api.datastore.FetchOptions.Builder.*

def comment=request.getParameter('comment')
def id=request.getParameter('id')

def query = new Query("Comment")
 
query.addFilter("day", Query.FilterOperator.EQUAL, id)
PreparedQuery preparedQuery = datastore.prepare(query)
result= preparedQuery.asList( withLimit(1) )

def Entity com

if(result==null || result.size()==0){
  com=new Entity("Comment")
  com['day']=id
} else {
  com=result[0]
}

com['text']=comment
com.save()

redirect '/'
