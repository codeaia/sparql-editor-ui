package main;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;

public class OntologyHelper {
	public static Model friends = null;

	public void myFriends(String query, Model model) {
		runQuery(query, model);
	}

	public void mySelf(String query, Model model) {
		runQuery(query, model);
	}

	public void runQuery(String queryRequest, Model model) {
		int b = 0;
		int a = 0;
		int counter1 = 0;
		boolean hasElement = true;
		while(hasElement) {
			
			StringBuffer queryStr = new StringBuffer();
			queryStr.append(queryRequest);
			Query query = QueryFactory.create(queryStr.toString());
			QueryExecution qexec = QueryExecutionFactory.create(query,model);
			try {
				
				ResultSet response = qexec.execSelect();
				String query3 = queryRequest;
				String query2;
				int intIndex = query3.indexOf("where");
				query2 = query3.substring(0,intIndex);
				a = query2.indexOf('?', counter1);
				if(a != -1) {
					
					b = query2.indexOf(" ", a);
					counter1 = b;
					String x = query2.substring(a,b);
					while(response.hasNext()){
						
						QuerySolution soln = response.nextSolution();
						RDFNode name = soln.get(x);
						System.out.println(name);
						PHome.textFinal.append(x + ": " + name.toString() + "\n");
					}
					
					System.out.println();
				} else {
					
					hasElement = false;
				}
			}finally{qexec.close();}}
	}

	public void populateFoafFriends(String URL) {
		friends = ModelFactory.createOntologyModel();
		friends.read(URL);
	}
	
	

}
