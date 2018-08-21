<html>
<head>
<title>multiple-choice quiz form</title>
</head>
<body bgcolor=#42f4b3>


<% String user = (String)session.getAttribute("name"); 
  out.print("Welcome "+user);
  user = (String)session.getAttribute("email"); 
  session.setAttribute("email", user);
  %>  
    
<h3>Vocabulary Quiz I</h3>


<form action="question" name ="form" method="post"> 
Check the answer to each multiple-coice question, and click on the "Send Form" button to submit the information.

<P>Q1.From which region does monsoon arrive in Assam?<BR>
<input type="radio" name="ans1" value="Arabian Sea">Arabian Sea<BR>
<input type="radio" name="ans1" value="quatre plains">quatre<BR>
<input type="radio" name="ans1" value="Islands">Islands<BR>
<input type="radio" name="ans1" value="Bay of Bengal">Bay of Bengal<BR>
</p>

<P>Q2.Where does the Arabian Sea and Bay of Bengal branch of the monsoon merge?<BR>
<input type="radio" name="ans2" value="Himalayas">Himalayas<BR>
<input type="radio" name="ans2" value="Ganga plains">Ganga plains<BR>
<input type="radio" name="ans2" value="Delhi">Delhi<BR>
<input type="radio" name="ans2" value="Deccan Plateau">Deccan Plateau<BR>
</p>

<P>Q3.When does Delhi receive monsoon showers?<BR>
<input type="radio" name="ans3" value="Start of June">Start of June<BR>
<input type="radio" name="ans3" value="Mid of July"> Mid of July<BR>
<input type="radio" name="ans3" value="End of June">End of June<BR>
<input type="radio" name="ans3" value="Mid of August">End of June<BR>
</p>

<P>Q4.From which region does Delhi receive monsoon showers?<BR>
<input type="radio" name="ans4" value="Bay of Bengal">Bay of Bengal<BR>
<input type="radio" name="ans4" value="Arabian Sea">Arabian Sea<BR>
<input type="radio" name="ans4" value="Islands">Islands<BR>
<input type="radio" name="ans4" value="Central Highlands">Central Highlands<BR>
</p>
<P>Q5.In which month does monsoon withdraws completely from the northern half of the Peninsula?<BR>
<input type="radio" name="ans5" value="First week of June">First week of June<BR>
<input type="radio" name="ans5" value="Mid-October">Mid-October<BR>
<input type="radio" name="ans5" value="December">December<BR>
<input type="radio" name="ans5" value="Mid-August">Mid-August<BR>
</p>
<br>
<br>
<br>
<br>
<input type="submit" value="submit">
<input type="reset" value="Clear Form">
</form>
</body>
</html>