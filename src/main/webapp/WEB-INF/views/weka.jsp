<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="weka.classifiers.functions.*" %>
<%@ page import="weka.classifiers.Classifier.*" %>
<%@ page import="weka.core.*" %>
<%@ page import="java.io.*" %>
<%@ page import="weka.core.converters.ConverterUtils.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
var dataFile = getFile("C:/formatted_data.csv");

var fr = new java.io.FileReader(dataFile);

 // get the instances from the data file
var instances = new weka.core.Instances(fr);

// construct a WEKA Apriori associator object
var aprioriObj = new weka.associations.Apriori()

aprioriObj.buildAssociations(instances);

// get the extracted association rules

var aprioriRules = aprioriObj.toString();
  // send the extracted rules to the Console
println ("Extracted rules :  \n\n"+aprioriRules)

//  display them also in a JTextArea
var frame = new JFrame("Apriori Rules");
var rulesArea = new JTextArea(aprioriRules);
console.log(aprioriRules);
frame.add(rulesArea);
frame.setSize(500, 500);
frame.setVisible(true);
</script>
</body>
</html>