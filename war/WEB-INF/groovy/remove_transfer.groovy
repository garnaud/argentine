import com.google.appengine.api.datastore.*
import static com.google.appengine.api.datastore.FetchOptions.Builder.*

Entity transfer=new Entity("Transfer")

def allTransferQuery= new Query("Transfer")
PreparedQuery pAllTransferQuery=datastore.prepare(allTransferQuery)
def transfers=pAllTransferQuery.asList(withLimit(1))

transfers[0].delete()

redirect '/'