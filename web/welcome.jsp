<%-- 
    Document   : welcome
    Created on : Dec 26, 2016, 3:18:33 PM
    Author     : sachin vashistha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to the site</title>
        <script type="text/javascript">
           var check_it='<%=(String)request.getAttribute("bool_crediter")%>';
           var itistrue="true";
           if(check_it == itistrue)
              {
                  validate_credits_true();
              }
           function validate_credits_true(){
              document.location.href="/logapp/payforward";
                if(check_it!=itistrue)
                  {
                      validate_credits_false();
                  }
              }    
          function validate_credits_false(){  
                     alert("You have 0 credits. Buy some credits by choosing one of our plans and enjoy service.");
              }
            </script>          
    </head>
    <body>
          <%@include file="payment.html" %>
    </body>
</html>