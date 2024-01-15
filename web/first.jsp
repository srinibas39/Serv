<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>My first JSP Page</h1>
        
        
        <!--declarative-->
        <%! 
            int a = 10;
            int b = 20;
            String name = "I am a string to be reversed";

            public int sum() {
                return a + b;
            }

            public int multiply() {
                return a * b;
            }

            public int sub() {
                return a - b;
            }

            public String reverseStr() {
                StringBuilder sb = new StringBuilder(name);
                return sb.reverse().toString();
            }
        
        %> 
        
<!--        scriptlet-->
        <%
           
                out.println("<p>Value of a =" + a + "</p>");
                out.println("<p>Sum = " + sum() + "</p>");

            

        %>
        
        <!--expression-->
        <p>Reverse string <%=reverseStr() %></p>

       
        

       
    </body>
</html>
