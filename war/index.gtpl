
<%
import com.google.appengine.api.datastore.*
import static com.google.appengine.api.datastore.FetchOptions.Builder.*
%>

<h1>En route pour l'Argentine!</h1>


<%
def allTransferQuery= new Query("Transfer")
allTransferQuery.addSort("date", Query.SortDirection.ASCENDING)
PreparedQuery pAllTransferQuery=datastore.prepare(allTransferQuery)
def transfers=pAllTransferQuery.asList(withLimit(10))
%>
<table style="background-color:red">
<tr>
<td>
<h3>Les Rendez-vous</h3>
<table>
<%
if(transfers!=null){
transfers.each{
%>
<tr><td> Le <%=String.format('%td/%<tm/%<tY ',it.date)%>, </td><td><%=it.person2%></td><td>doit venir chercher Apolline chez <i><%=it.where%></i></td><td> où <%=it.person1%> l'y attendra</td><td> à <b><%=String.format('%tH:%<tM ',it.date)%></b></td><td> (à noter: <%=it.comment%>)</td><td><form action="/remove_transfer/<%=it.key.id%>" type="get"><input type="submit" value="supprimer"></form></td></td></tr>
<%
}}
%>
</table>
<div style="background-color:lightgray">
<h3>Un nouveau rendez-vous</h3><br>
<form action="/new_transfer.groovy" type="POST">
  Personne qui s'occupe d'Apolline <select name="person1"><options><option>Catherine ou Philippe</option><option>Edith ou Jean-Luc</option><option>Delphine</option><option>Sarah</option><option>Samuel</option><option>Gabriel</option><options></select><br>
  Personne qui doit venir chercher Apolline <select name="person2"><options><option>Catherine ou Philippe</option><option>Edith ou Jean-Luc</option><option>Delphine</option><option>Sarah</option><option>Samuel</option><option>Gabriel</option><options></select><br>
  Quand ? Le jour=<select name="day">
  <%
  def cal=Calendar.getInstance()
  cal.set(Calendar.YEAR,2009)
  cal.set(Calendar.MONTH,Calendar.DECEMBER)
  cal.set(Calendar.DAY_OF_MONTH,26)
  def d=cal.getTime()
  for(int i=0;i<17;i++){
  %>
    <option value="<%=String.format('%td/%<tm/%<tY',d)%>"><%=String.format('%td/%<tm/%<tY',d)%></option>
  <%
    d=d+1
  }
  %>
  </select>
  à <select name="hour">
  <%
  for(int i=0;i<24;i++){
  %>
    <option value="<%=i%>"><%=i%></option>
  <%
  }
  %>
  </select> heure
  <select name="minute">
  <%
  for(int i=0;i<60;i++){
  %>
    <option value="<%=i%>"><%=i%></option>
  <%
  }
  %>
  </select> minute<br>
  Où:<select name="where"><options><option>Raphaëlle et Guillaume</option><option>Edith et Jean-Luc</option><option>Catherine et Philippe</option><option>Delphine</option><option>A la crêche</option></options></select>
  Commentaire <input name="comment" type="text"><br>
  <input name="submit" type="submit" value="Ajouter un transfert">
</form>
</div>
</td>
<td>
<h2>Repas</h2>
<h3>Petit Déjeuner</h3>
<h3>Déjeuner</h3>
<h3>Diner</h3>
</td>
<tr>
</table>