<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="/struts-tags" prefix="s" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    
	
	<!-- core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
   
    <link href="css/comment.css" rel="stylesheet">
    <link href="css/responsive.css" rel="stylesheet">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    
  


   <body>

  <div class="container">
        <ul class="nav nav-tabs">
        </ul>
        <div class="tab-content">
        </div>
    </div>

    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/jquery.isotope.min.js"></script>
    <script src="js/main.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/newsletter.js"></script>

     <script>  
    $.ajax({
        type: "POST",
        url: "./QuizServlet",
        success: function (responseText) {
            var jsonData = JSON.parse(responseText);
            var uniueTabs = getUniqueLists(jsonData);
	       
	  for (var i = 0; i < uniueTabs.length; i++) {
	       $('.nav-tabs').append('<li ><a href="#tab-content-' + i + '">' + uniueTabs[i].area + '</a></li>');
            var div = '<div id="tab-content-' + i + '" class="tab-pane fade">';

            for (var j = 0; j < uniueTabs[i].tabContent.length; j++) {
                var obj = uniueTabs[i].tabContent[j];
                div += '<p>' + obj.projectName + '</p>'+ '<p>' + obj.projectDescription + '</p>'+ '<p>' + obj.currentStatus + '</p>'
	}

	$('.tab-content').append(div);
            $('#tab-content-0').addClass('in active');
	       }
	       
	        $('.nav-tabs li').eq(0).addClass('active');
        setListner();
        
   

    function getUniqueLists(responseText) {
        var resArr = [];
        responseText.filter(function (x, i) {
            if (resArr.indexOf(x.area) === -1) {
                resArr.push(x.area);
            }
        })
        //console.log(resArr);
        return mergeDataAreaWise(resArr, responseText);
    }

    function mergeDataAreaWise(area, responseText) {
        var tabList = [];
        for (var i = 0; i < area.length; i++) {
            tabList.push({
                area: area[i],
                tabContent: []
            });
        }
        for (var i = 0; i < tabList.length; i++) {
            for (var j = 0; j < responseText.length; j++) {
             
                var Obj = {
                    
                    projectName: responseText[j].projectName,
                  
                    projectDescription: responseText[j].projectDescription,
                   
                    currentStatus: responseText[j].currentStatus
                }
                var currentArea = responseText[j].area;
                if (tabList[i].area === currentArea) {
                    tabList[i].tabContent.push(Obj);
                }
            }
        }
        console.log(tabList);
        return tabList;
    }
    
    
    
    }
    
    });
    function setListner () {
        $(".nav-tabs a").click(function () {
            $(this).tab('show');
        });
    }
    
</script>
	
  



</head><!--/head-->


            
  
   
    
   
    
  </body>


</html>