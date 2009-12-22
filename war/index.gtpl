<% include 'js/argentine.js' %>

<script type="text/javascript">
<!--
function editComment(id,comment){
  elem=document.getElementById('c'+id);
  elem.innerHTML="<form action='/addComment.groovy' type='POST'><input type='hidden' name='id' value='"+id+"'/><input name='comment' type='text' value='"+comment+"'/><input type='submit'></form>";
}

function editDiner(id,diner){
  elem=document.getElementById(id);
  elem.innerHTML="<form action='/addDiner.groovy' type='POST'><input type='hidden' name='id' value='"+id+"'/><input name='diner' type='text' value='"+diner+"'/><input type='submit'></form>";
}


//-->
</script>
<%
import com.google.appengine.api.datastore.*
import static com.google.appengine.api.datastore.FetchOptions.Builder.*

def query = new Query("Comment")
query.addSort("day", Query.SortDirection.DESCENDING)
PreparedQuery preparedQuery = datastore.prepare(query)
def comments= preparedQuery.asList( withLimit(20) )

query = new Query("Diner")
query.addSort("type", Query.SortDirection.DESCENDING)
preparedQuery = datastore.prepare(query)
def diners= preparedQuery.asList( withLimit(20) )
%>

<h1>En route pour l'Argentine!</h1>

<table style="font-size:14px;">
<tr><td>
<div>
<table style="font-size:14px;">
<tr><td colspan="2">jour</td><td style="width:150px;">en france</td><td>commentaire</td><td>en argentine</td></tr>
<tr><td>samedi</td><td>26/12</td><td style="width:150px;">Catherine & Philippe</td><td id="c1"><%=comments[0]['text']%> <div onClick="editComment('1','<%=comments[0]['text']%>');">edit</div></td></tr>
<tr><td>dimanche</td><td>27/12</td><td style="width:150px;">Catherine & Philippe</td><td id="c2"></td></tr>
<tr><td>lundi</td><td>28/12</td><td style="width:150px;">Catherine & Philippe</td></tr>
<tr><td>mardi</td><td>29/12</td><td style="width:150px;">Catherine & Philippe<br>Edith & Jean-Luc</td></tr>
<tr><td>mercredi</td><td>30/12</td><td style="width:150px;">Edith & Jean-Luc</td></tr>
<tr><td>jeudi</td><td>31/12</td><td style="width:150px;">Edith & Jean-Luc</td></tr>
<tr><td>vendredi</td><td>01/01</td><td style="width:150px;">Edith & Jean-Luc</td></tr>
<tr><td>samedi</td><td>02/01</td><td style="width:150px;">Edith & Jean-Luc</td></tr>
<tr><td>dimanche</td><td>03/01</td><td style="width:150px;">Edith & Jean-Luc</td></tr>
<tr><td>lundi</td><td>04/01</td><td style="width:150px;">Edith & Jean-Luc</td></tr>
<tr><td>mardi</td><td>05/01</td><td style="width:150px;">Edith & Jean-Luc</td></tr>
<tr><td>mercredi</td><td>06/01</td><td style="width:150px;">Edith & Jean-Luc : amène à la crèche le matin<br>Sarah la ramène à la maison<br>Delphine la garde à la maison</td></tr>
<tr><td>jeudi</td><td>07/01</td><td style="width:150px;">Delphine la garde jusqu'en fin d'après-midi<br>Catherine & Philippe viennent la chercher</td></tr>
<tr><td>vendredi</td><td>08/01</td><td style="width:150px;">Catherine & Philippe</td></tr>
<tr><td>samedi</td><td>09/01</td><td style="width:150px;">Catherine & Philippe</td></tr>
<tr><td>dimanche</td><td>10/01</td><td style="width:150px;">Catherine & Philippe</td></tr>
<tr><td>lundi</td><td>11/01</td><td style="width:150px;">Catherine & Philippe</td></tr>
</table>
</div>
</td>
<td>
<div>
<h2>Repas</h2>

<h3>Petit Déjeuner</h3>
<ul>
<li>biberon: 240ml d'eau, 8 cuillères de lait, 2 cuillères de vanille
</ul>
<h3>Déjeuner</h3>
<div id="dejeuner"><%=(diners[0]!=null?diners[0]['text']:'')%></div>
<div onClick="editDiner('dejeuner','<%=(diners[0]!=null?diners[0]['text']:'')%>');">edit</div>
<h3>Diner</h3>
</td>
</div>
<tr>
</table>
