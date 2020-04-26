<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width,initial-scale=1">
        
        <link rel="stylesheet" type="text/css" href="<c:url value="css/inscription_prof.css"></c:url>">
        <link href="https://fonts.googleapis.com/css?family=Lobster&display=swap" 
        rel="stylesheet">
        <script src="https://kit.fontawesome.com/a81368914c.js"></script>
       <c:url value="chosen/chosen.css"></c:url>
        <link rel="stylesheet" href="<c:url value="chosen/chosen.css"></c:url>">
       
        
    </head>
    <body>
        <div class="container">
        
            <div class="img">
             	
                <img src="<c:url value="photo/phone.png"></c:url>">
            </div>
            <div class="login-content">
                <form id="inscription" action="./Inscription">
                
                    <img class="profil" src="<c:url value="photo/profil.png"></c:url>">
                    <h2>Inscription</h2>
                    <div class="input-div">
                        <h5>Etudiant</h5>
                        <input class="input c" onchange="zigzag()" name="choix" type="radio" value="etudiant">
                    </div>
                    <div class="input-div">
                        <h5>professeur</h5>
                        <input class="input c" onchange="zigzag()" name="choix" type="radio" value="professeur">
                    </div>
                    <div class="input-div one " >
                        <div class="i">
                            <i class="fas fa-user"></i>
                        </div>
                        <div>
                            <h5>Nom</h5>
                            <input class="input" type="text" name="nom" id="nom">
                        </div>
                    </div>
                    <div class="input-div two">
                        <div class="i">
                            <i class="fas fa-user"></i>    
                        </div>
                        <div>
                            <h5>Prenom</h5>
                            <input class="input" type="text" name="prenom" id="prenom">
                        </div>
                    </div>
                    <div id="CINProf" class="input-div tree">
                        <div class="i">
                            <i class="fas fa-user"></i>
                        </div>
                        <div>
                            <h5>CIN</h5>
                            <input class="input" type="text" name="CIN" id="cin">
                        </div>
                    </div>
                        <div id="CNEEtud" class="input-div tree">
                        <div class="i">
                            <i class="fas fa-user"></i>
                        </div>
                        <div>
                            <h5>CNE</h5>
                            <input class="input" type="text" name="CNE" id="cne">
                        </div>
                    </div>
                    <div class="input-div five">
                        <div class="i">
                            <i class="fas fa-envelope"></i>                          
                        </div>
                        <div>
                            <h5>Email</h5>
                            <input class="input" type="email" name="email" id="email">
                        </div>
                    </div>
                    <div class="input-div five">
                        <div class="i">
                            <i class="fas fa-lock"></i>
                        </div>
                        <div>
                            <h5>Password</h5>
                            <input class="input" type="password" name="MotDePasse" id="password">
                        </div>
                    </div>
                    <div class="input-div six">
                        <div class="i">
                            <i class="fas fa-lock"></i>
                        </div>
                        <div>
                            <h5>confirmation password</h5>
                            <input class="input" type="password" id="passwordconfirmer">
                        </div>
                    </div>
                     <div class="input-div six prof">
                        <div class="i">
                                    <i class="fas fa-lock"></i>
                        </div>
                        <div>
                                <select multiple class="input" name="FilieresProf" id="selectM" data-placeholder="veuillez chisir une filiere">
                                     <c:forEach items="${filieres}" var="f">
                                    	 <option value="${f.getIdFil()}">${f.getNomF()}</option>
                                    </c:forEach>
                                </select>
                        </div>
                    </div>
                    <div class="input-div six etudi">
                        <div class="i">
                                    <i class="fas fa-lock"></i>
                        </div>
                        <div>
                                <select style="text-align: left;" name="selectM1" class="input" id="selectM1" data-placeholder="veuillez choisir une filiere">
                                    <c:forEach items="${filieres}" var="f">
                                    	 <option value="${f.getIdFil()}">${f.getNomF()}</option>
                                    </c:forEach>
                                </select>
                        </div>
                    </div>
                    
                    <a href="a">Forget Password</a>
                     
                    <p style="color: red;" id="erreur"><c:out value="${MESSAGE_ERROR}"></c:out> </p>
                    <input type="submit" class="btn" value="Inscription">
                </form>
            </div>
            
        </div>
         
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script type="text/javascript" src="<c:url value="javascipt/inscription_prof.js"></c:url>"></script>
        <script src="<c:url value="chosen/chosen.jquery.js"></c:url>"></script>
        <script>
            $(document).ready(function(){
                $('#selectM').chosen();
                $('#selectM1').chosen({allow_single_deselect: true});
				$('#CINProf').hide();
                $('.prof').hide();
                $('input[name=choix]').filter('[value=etudiant]').prop('checked', true);
            
            });
            function zigzag(){
                    if($('input[name=choix]:checked').val()=='etudiant'){
                        $('.etudi').show();
                        $('.prof').hide();
                        $('#CNEEtud').show();
                        $('#CINProf').hide();
                        
                    }
                    if($('input[name=choix]:checked').val()=='professeur'){
                        $('.prof').show();
                        $('#CINProf').show();
                        $('#CNEEtud').hide();
                        $('.etudi').hide();
                    }
        	    }
        </script>
    </body>
</html>